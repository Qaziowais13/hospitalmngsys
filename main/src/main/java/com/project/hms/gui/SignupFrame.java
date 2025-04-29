package com.project.hms.gui;

import javax.swing.*;
import java.awt.*;
import com.project.hms.db.DatabaseHelper;

public class SignupFrame extends JFrame {

    public SignupFrame() {
        setTitle("Hospital Management System - Sign Up");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }
    
    private void initUI() {
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        JLabel userLabel = new JLabel("New Username:");
        JTextField userField = new JTextField();
        JLabel passLabel = new JLabel("New Password:");
        JPasswordField passField = new JPasswordField();
        
        JButton signupButton = new JButton("Sign Up");
        signupButton.addActionListener(e -> {
            String username = userField.getText().trim(); // trimmed username
            String password = new String(passField.getPassword()).trim(); // trimmed password
            // Added input validation to avoid empty entries.
            if(username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill out all fields.");
                return;
            }
            if(DatabaseHelper.addUser(username, password)) {
                JOptionPane.showMessageDialog(this, "Sign up successful!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Sign up failed. Username may already exist.");
            }
        }); // Added missing closing braces
        
        panel.add(userLabel);
        panel.add(userField);
        panel.add(passLabel);
        panel.add(passField);
        panel.add(new JLabel()); // spacer
        panel.add(signupButton);
        
        add(panel, BorderLayout.CENTER);
    }
}