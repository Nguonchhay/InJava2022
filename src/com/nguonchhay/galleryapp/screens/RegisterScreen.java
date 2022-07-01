package com.nguonchhay.galleryapp.screens;

import com.nguonchhay.galleryapp.services.MySQLService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisterScreen extends JFrame {

    private JTextField txtEmail, txtFullName;
    private JPasswordField txtPassword, txtConfirmPassword;
    private JButton btnSignUp;

    private MySQLService mySQLService;

    public RegisterScreen() {
        super("Sign Up");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(350, 400);
        super.setLayout(null);
        super.setLocationRelativeTo(null);

        initUI();
    }

    private void initUI() {
        int initY = 20;

        // Form label
        JLabel lblFormTitle = new JLabel("Gallery App - Sign Up");
        lblFormTitle.setBounds(50, initY, 200, 40);
        lblFormTitle.setForeground(Color.MAGENTA);
        lblFormTitle.setFont(new Font("Times New Roman", Font.BOLD, 20));
        super.add(lblFormTitle);

        // Full Name field
        JLabel lblFullName = new JLabel("Full Name");
        lblFullName.setBounds(50, initY + 70, 60, 20);
        super.add(lblFullName);

        txtFullName = new JTextField(150);
        txtFullName.setBounds(120, initY + 70, 150, 30);
        super.add(txtFullName);

        // Email field
        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(50, initY + 110, 60, 20);
        super.add(lblEmail);

        txtEmail = new JTextField(150);
        txtEmail.setBounds(120, initY + 110, 150, 30);
        super.add(txtEmail);

        // Password field
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(50, initY + 150, 60, 20);
        super.add(lblPassword);

        txtPassword = new JPasswordField(150);
        txtPassword.setBounds(120, initY + 150, 150, 30);
        super.add(txtPassword);

        // Confirm Password field
        JLabel lblConfirmPassword = new JLabel("Re-Password");
        lblConfirmPassword.setBounds(50, initY + 190, 60, 20);
        super.add(lblConfirmPassword);

        txtConfirmPassword = new JPasswordField(150);
        txtConfirmPassword.setBounds(120, initY + 190, 150, 30);
        super.add(txtConfirmPassword);

        // Button field
        btnSignUp = new JButton("Sign Up");
        btnSignUp.setBounds(130, initY + 240, 80, 30);
        btnSignUp.addActionListener(e -> {
            userForm();
        });
        super.add(btnSignUp);

        // Sign in
        JLabel lblSignInInfo = new JLabel("Already has an account?");
        lblSignInInfo.setBounds(70, initY + 290, 160, 20);
        super.add(lblSignInInfo);

        JLabel lblSignIn = new JLabel("Sign In");
        lblSignIn.setBounds(220, initY + 290, 60, 20);
        lblSignIn.setForeground(Color.BLUE);
        lblSignIn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new LoginScreen().open();
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
        super.add(lblSignIn);
    }

    private void userForm() {
        String fullname = txtFullName.getText();
        String email = txtEmail.getText();
        String password = String.valueOf(txtPassword.getPassword());
        String confirmPassword = String.valueOf(txtConfirmPassword.getPassword());
        if (
                fullname.equalsIgnoreCase("") ||
                email.equalsIgnoreCase("") ||
                password.equalsIgnoreCase("") ||
                confirmPassword.equalsIgnoreCase("")
        ) {
            JOptionPane.showMessageDialog(this, "All fields are required!");
        } else {
            if (password.equals(confirmPassword)) {
                // Save data
                mySQLService = new MySQLService();
                try {
                    Statement stm = mySQLService.getConnection();
                    String insertSQL = String.format("INSERT INTO users(fullname,email,password) VALUES('%s','%s','%s')", fullname, email, password);
                    int result = stm.executeUpdate(insertSQL);
                    if (result == 1) {
                        LoginScreen screen = new LoginScreen();
                        screen.open();
                        this.close();
                    } else {
                        JOptionPane.showMessageDialog(this, "Cannot save user information");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Something went wrong!");
                    e.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Password and confirm password must be the same");
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
