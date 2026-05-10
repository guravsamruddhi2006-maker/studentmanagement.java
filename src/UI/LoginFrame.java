package UI;

import DAO.UserDAO;
import javax.swing.*;

public class LoginFrame extends JFrame {

    JTextField userField;
    JPasswordField passField;

    public LoginFrame() {

        setTitle("Login");
        setSize(350, 300);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Username Label
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(30, 30, 100, 25);

        // Username Field
        userField = new JTextField();
        userField.setBounds(130, 30, 150, 25);

        // Password Label
        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(30, 70, 100, 25);

        // Password Field
        passField = new JPasswordField();
        passField.setBounds(130, 70, 150, 25);

        // Show Password Checkbox
        JCheckBox showPass = new JCheckBox("Show Password");
        showPass.setBounds(130, 100, 150, 25);

        showPass.addActionListener(e -> {

            if (showPass.isSelected()) {

                passField.setEchoChar((char) 0);

            } else {

                passField.setEchoChar('*');
            }
        });

        // Login Button
        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(130, 140, 100, 30);

        // Register Button
        JButton registerBtn = new JButton("Register");
        registerBtn.setBounds(120, 190, 120, 30);

        // Add Components
        add(userLabel);
        add(userField);
        add(passLabel);
        add(passField);
        add(showPass);
        add(loginBtn);
        add(registerBtn);

        // Login Logic
        loginBtn.addActionListener(e -> {

            String user = userField.getText();

            String pass = new String(passField.getPassword());

            UserDAO dao = new UserDAO();

            if (dao.login(user, pass)) {

                JOptionPane.showMessageDialog(this, "Login Success");

                dispose();

                new DashboardFrame(user).setVisible(true);

            } else {

                JOptionPane.showMessageDialog(this, "Invalid login");
            }
        });

        // Register Button Logic
        registerBtn.addActionListener(e -> {

            dispose();

            new RegisterFrame().setVisible(true);
        });

        setVisible(true);
    }
}