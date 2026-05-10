package UI;

import DAO.StudentDAO;

import javax.swing.*;

public class AddStudentFrame extends JFrame {

    String username;

    public AddStudentFrame(String username) {

        this.username = username;

        setTitle("Add Student");
        setSize(400, 400);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // NAME
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 50, 100, 25);

        JTextField nameField = new JTextField();
        nameField.setBounds(130, 50, 150, 25);

        // COURSE
        JLabel courseLabel = new JLabel("Course:");
        courseLabel.setBounds(30, 100, 100, 25);

        JTextField courseField = new JTextField();
        courseField.setBounds(130, 100, 150, 25);

        // MARKS
        JLabel marksLabel = new JLabel("Marks:");
        marksLabel.setBounds(30, 150, 100, 25);

        JTextField marksField = new JTextField();
        marksField.setBounds(130, 150, 150, 25);

        // ADD BUTTON
        JButton addBtn = new JButton("Add Student");
        addBtn.setBounds(120, 220, 140, 30);

        // BACK BUTTON
        JButton backBtn = new JButton("Back");
        backBtn.setBounds(120, 270, 140, 30);

        // ADD COMPONENTS
        add(nameLabel);
        add(nameField);

        add(courseLabel);
        add(courseField);

        add(marksLabel);
        add(marksField);

        add(addBtn);
        add(backBtn);


        // ADD STUDENT BUTTON

        addBtn.addActionListener(e -> {

            try {

                String name = nameField.getText();

                String course = courseField.getText();

                float marks =
                        Float.parseFloat(marksField.getText());

                StudentDAO dao = new StudentDAO();

                boolean inserted =
                        dao.addStudent(name, course, marks);

                if(inserted) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Student Added Successfully"
                    );

                    // CLEAR FIELDS
                    nameField.setText("");
                    courseField.setText("");
                    marksField.setText("");

                } else {

                    JOptionPane.showMessageDialog(
                            this,
                            "Failed To Add Student"
                    );
                }

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Enter Valid Marks"
                );
            }
        });


        // BACK BUTTON
        backBtn.addActionListener(e -> {

            dispose();

            new DashboardFrame(username).setVisible(true);
        });

        setVisible(true);
    }
}