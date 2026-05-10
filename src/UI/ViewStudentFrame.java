package UI;

import DAO.StudentDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.FileWriter;
import java.sql.ResultSet;

public class ViewStudentFrame extends JFrame {

    JTable table;
    DefaultTableModel model;
    String username;

    public ViewStudentFrame(String username) {
        this.username = username;
        setTitle("View Students");
        setSize(700, 450);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // TABLE MODEL
        model = new DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Course");
        model.addColumn("Marks");

        table = new JTable(model);

        JScrollPane sp = new JScrollPane(table);

        add(sp, BorderLayout.CENTER);

        // TOP PANEL
        JPanel topPanel = new JPanel();

        JTextField searchField =
                new JTextField(15);

        JButton searchBtn =
                new JButton("Search");

        JButton showAllBtn =
                new JButton("Show All");

        topPanel.add(new JLabel("Search: "));
        topPanel.add(searchField);
        topPanel.add(searchBtn);
        topPanel.add(showAllBtn);

        add(topPanel, BorderLayout.NORTH);

        // BOTTOM PANEL
        JPanel bottomPanel = new JPanel();

        JButton updateBtn =
                new JButton("Update");

        JButton deleteBtn =
                new JButton("Delete");

        JButton exportBtn =
                new JButton("Export");

        JButton backBtn =
                new JButton("Back");

        bottomPanel.add(updateBtn);
        bottomPanel.add(deleteBtn);
        bottomPanel.add(exportBtn);
        bottomPanel.add(backBtn);

        add(bottomPanel, BorderLayout.SOUTH);

        // LOAD DATA
        loadStudents();

        // SEARCH
        searchBtn.addActionListener(e -> {

            String keyword =
                    searchField.getText();

            StudentDAO dao =
                    new StudentDAO();

            ResultSet rs =
                    dao.searchStudent(keyword);

            model.setRowCount(0);

            try {

                while (rs != null && rs.next()) {

                    model.addRow(new Object[]{

                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("course"),
                            rs.getFloat("marks")
                    });
                }

            } catch (Exception ex) {

                ex.printStackTrace();
            }
        });

        // SHOW ALL
        showAllBtn.addActionListener(e -> {

            model.setRowCount(0);

            loadStudents();
        });

        // DELETE
        deleteBtn.addActionListener(e -> {

            int row = table.getSelectedRow();

            if(row == -1) {

                JOptionPane.showMessageDialog(this,
                        "Select Student");

                return;
            }

            int id =
                    (int) model.getValueAt(row, 0);

            StudentDAO dao =
                    new StudentDAO();

            if(dao.deleteStudent(id)) {

                model.removeRow(row);

                JOptionPane.showMessageDialog(this,
                        "Deleted Successfully");

            } else {

                JOptionPane.showMessageDialog(this,
                        "Delete Failed");
            }
        });

        // UPDATE
        updateBtn.addActionListener(e -> {

            int row = table.getSelectedRow();

            if(row == -1) {

                JOptionPane.showMessageDialog(this,
                        "Select Student");

                return;
            }

            int id =
                    (int) model.getValueAt(row, 0);

            String currentName =
                    model.getValueAt(row, 1).toString();

            String currentCourse =
                    model.getValueAt(row, 2).toString();

            String currentMarks =
                    model.getValueAt(row, 3).toString();

            String newName =
                    JOptionPane.showInputDialog(
                            this,
                            "Enter Name",
                            currentName
                    );

            String newCourse =
                    JOptionPane.showInputDialog(
                            this,
                            "Enter Course",
                            currentCourse
                    );

            String marksText =
                    JOptionPane.showInputDialog(
                            this,
                            "Enter Marks",
                            currentMarks
                    );

            try {

                float marks =
                        Float.parseFloat(marksText);

                StudentDAO dao =
                        new StudentDAO();

                if(dao.updateStudent(id,
                        newName,
                        newCourse,
                        marks)) {

                    model.setValueAt(newName,
                            row, 1);

                    model.setValueAt(newCourse,
                            row, 2);

                    model.setValueAt(marks,
                            row, 3);

                    JOptionPane.showMessageDialog(this,
                            "Updated Successfully");

                } else {

                    JOptionPane.showMessageDialog(this,
                            "Update Failed");
                }

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(this,
                        "Invalid Marks");
            }
        });

        // EXPORT CSV
        exportBtn.addActionListener(e -> {

            try {

                FileWriter csv =
                        new FileWriter("students.csv");

                // COLUMN NAMES
                for(int i = 0;
                    i < table.getColumnCount();
                    i++) {

                    csv.write(
                            table.getColumnName(i)
                                    + ","
                    );
                }

                csv.write("\n");

                // DATA
                for(int i = 0;
                    i < table.getRowCount();
                    i++) {

                    for(int j = 0;
                        j < table.getColumnCount();
                        j++) {

                        Object value =
                                table.getValueAt(i, j);

                        if(value != null) {

                            csv.write(
                                    value.toString()
                                            + ","
                            );

                        } else {

                            csv.write(",");
                        }
                    }

                    csv.write("\n");
                }

                csv.close();

                JOptionPane.showMessageDialog(this,
                        "Exported Successfully");

            } catch (Exception ex) {

                ex.printStackTrace();

                JOptionPane.showMessageDialog(this,
                        "Export Failed");
            }
        });

        // BACK
        backBtn.addActionListener(e -> {

            dispose();
            new DashboardFrame(username).setVisible(true);
        });

        setVisible(true);
    }

    // LOAD STUDENTS
    private void loadStudents() {

        StudentDAO dao =
                new StudentDAO();

        ResultSet rs =
                dao.getStudents();

        try {

            while(rs != null && rs.next()) {

                model.addRow(new Object[]{

                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("course"),
                        rs.getFloat("marks")
                });
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}