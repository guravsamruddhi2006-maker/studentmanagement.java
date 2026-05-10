package UI;

import DAO.UserDAO;
import javax.swing.*;

public class RegisterFrame extends JFrame {

    public RegisterFrame() {

        setTitle("Register");
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 50, 100, 30);

        JTextField userField = new JTextField();
        userField.setBounds(150, 50, 150, 30);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 100, 100, 30);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(150, 100, 150, 30);

        JButton registerBtn = new JButton("Register");
        registerBtn.setBounds(120, 160, 120, 30);

        add(userLabel);
        add(userField);
        add(passLabel);
        add(passField);
        add(registerBtn);

        // Register Logic
        registerBtn.addActionListener(e -> {

            String username = userField.getText();
            String password = new String(passField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Fields cannot be empty");
                return;
            }

            UserDAO dao = new UserDAO();

            if (dao.register(username, password)) {
                JOptionPane.showMessageDialog(this, "Registered Successfully");

                dispose();
                new LoginFrame().setVisible(true);

            } else {
                JOptionPane.showMessageDialog(this, "Username already exists!");
            }
        });

        setVisible(true);
    }
}