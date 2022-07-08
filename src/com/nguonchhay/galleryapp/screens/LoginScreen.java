package com.nguonchhay.galleryapp.screens;

import com.nguonchhay.galleryapp.services.MySQLService;
import com.nguonchhay.galleryapp.services.MySQLServiceSingleton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginScreen extends JFrame {

    private JTextField txtEmail;
    private JPasswordField txtPassword;
    private JButton btnLogin;

    public LoginScreen() {
        super("Login");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(350, 400);
        super.setLayout(null);
        super.setLocationRelativeTo(null);

        initUI();
    }

    private void initUI() {
        int initY = 20;

        // Form label
        JLabel lblFormTitle = new JLabel("Gallery App - Sign In");
        lblFormTitle.setBounds(50, initY, 200, 40);
        lblFormTitle.setForeground(Color.MAGENTA);
        lblFormTitle.setFont(new Font("Times New Roman", Font.BOLD, 20));
        super.add(lblFormTitle);

        // Email field
        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(50, initY + 70, 60, 20);
        super.add(lblEmail);

        txtEmail = new JTextField(150);
        txtEmail.setBounds(120, initY + 70, 150, 30);
        super.add(txtEmail);

        // Password field
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(50, initY + 110, 60, 20);
        super.add(lblPassword);

        txtPassword = new JPasswordField(150);
        txtPassword.setBounds(120, initY + 110, 150, 30);
        super.add(txtPassword);

        JLabel lblForgotPassword = new JLabel("Forgot Password?");
        lblForgotPassword.setBounds(160, initY + 140, 120, 20);
        lblForgotPassword.setForeground(Color.BLUE);
        super.add(lblForgotPassword);

        // Button field
        btnLogin = new JButton("Sign In");
        btnLogin.setBounds(130, initY + 170, 80, 30);
        btnLogin.addActionListener(e -> {
            doLogin();
        });
        super.add(btnLogin);

        // Sign up
        JLabel lblSignUpInfo = new JLabel("Do not have any account?");
        lblSignUpInfo.setBounds(70, initY + 220, 160, 20);
        super.add(lblSignUpInfo);

        JLabel lblSignUp = new JLabel("Sign Up");
        lblSignUp.setBounds(220, initY + 220, 60, 20);
        lblSignUp.setForeground(Color.BLUE);
        lblSignUp.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new RegisterScreen().open();
                close();
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
        super.add(lblSignUp);
    }

    private void doLogin() {
        String email = txtEmail.getText();
        String password = String.valueOf(txtPassword.getPassword());
        if (email.equalsIgnoreCase("") || password.equals("")) {
            JOptionPane.showMessageDialog(this, "All fields are required!");
        } else {
            try {
                Connection connection = MySQLServiceSingleton.getConnection();
                Statement stm = connection.createStatement();
                String queryUserSQL = "SELECT * FROM users WHERE email='" + email + "' AND password='" + password + "' LIMIT 1;";
                ResultSet resultSet = stm.executeQuery(queryUserSQL);
                boolean isUserExist = false;
                while (resultSet.next()) {
                    isUserExist = true;
                    break;
                }

                if (isUserExist) {
                    if (connection != null) {
                        connection.close();
                    }
                    new UsersScreen().open();
                    this.close();
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid credentials!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void open() {
        super.setVisible(true);
    }

    public void close() {
        super.dispose();
    }
}
