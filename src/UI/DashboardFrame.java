package UI;

import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {

    public DashboardFrame(String username) {

        setTitle("Student Management System");
        setSize(500, 400);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //  Welcome Label
        JLabel title = new JLabel("WELCOME" + " " + username);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBounds(140, 30, 300, 30);

        // Buttons
        JButton addBtn = new JButton("Add Student");
        addBtn.setBounds(150, 100, 200, 30);

        JButton viewBtn = new JButton("View Students");
        viewBtn.setBounds(150, 150, 200, 30);

        JButton logoutBtn = new JButton("Logout");
        logoutBtn.setBounds(150, 200, 200, 30);

        // Add components
        add(title);
        add(addBtn);
        add(viewBtn);
        add(logoutBtn);

        // Add Student
        addBtn.addActionListener(e -> {
            dispose();
            new AddStudentFrame(username);
        });

        //  View Students
        viewBtn.addActionListener(e -> {
            dispose();
            new ViewStudentFrame(username);
        });

        // Logout
        logoutBtn.addActionListener(e -> {

            int choice = JOptionPane.showConfirmDialog(
                    this,
                    "Do you want to logout?",
                    "Logout",
                    JOptionPane.YES_NO_OPTION
            );

            if (choice == JOptionPane.YES_OPTION) {
                dispose();
                new LoginFrame();
            }
        });

        setVisible(true);
    }
}