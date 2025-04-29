package com.project.hms.gui;

import javax.swing.*;
import java.awt.*;

public class HomepageFrame extends JFrame {
    public HomepageFrame(String username) {
        setTitle("Hospital Management System - Homepage");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI(username);
    }
    
    private void initUI(String username) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel welcomeLabel = new JLabel("Welcome, " + username + "!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(welcomeLabel, BorderLayout.NORTH);
        
        JPanel menuPanel = new JPanel(new FlowLayout());
        JButton btnAppointments = new JButton("Appointments");
        JButton btnPatients = new JButton("Patients");
        JButton btnRecords = new JButton("Records");
        JButton btnLogout = new JButton("Logout");
        
        // Simple actions (for demonstration)
        btnLogout.addActionListener(e -> {
            dispose();
            new LoginFrame().setVisible(true);
        });
        
        menuPanel.add(btnAppointments);
        menuPanel.add(btnPatients);
        menuPanel.add(btnRecords);
        menuPanel.add(btnLogout);
        
        panel.add(menuPanel, BorderLayout.CENTER);
        add(panel);
    }
}