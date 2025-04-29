package com.project.hms.gui;

import javax.swing.*;
import java.awt.*;
import com.project.hms.db.DatabaseHelper;

public class LoginFrame extends JFrame {

    public LoginFrame() {
        setTitle("Hospital Management System - Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }
    
    private void initUI() {
        // Create panel for input fields
        JPanel fieldPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();
        fieldPanel.add(userLabel);
        fieldPanel.add(userField);
        fieldPanel.add(passLabel);
        fieldPanel.add(passField);
        
        // Create panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton loginButton = new JButton("Login");
        JButton signupButton = new JButton("Sign Up");

        loginButton.addActionListener(e -> {
            String username = userField.getText().trim();
            String password = new String(passField.getPassword()).trim();
            if(DatabaseHelper.validateUser(username, password)) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                // Open homepage with the username and close login frame
                new HomepageFrame(username).setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials");
            }
        });
        
        signupButton.addActionListener(e -> {
            new SignupFrame().setVisible(true);
        });
        
        buttonPanel.add(loginButton);
        buttonPanel.add(signupButton);
        
        // Combine panels
        setLayout(new BorderLayout());
        add(fieldPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}