package com.project.hms.db;

import java.io.*;
import java.util.*;

public class DatabaseHelper {
    // use a text file as the database
    private static final String TEXT_DB_FILE = "c:/Users/840 G6/Desktop/project/users.txt";

    static {
        // Ensure the text file exists
        File file = new File(TEXT_DB_FILE);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // ...removed getConnection and JDBC code...

    public static boolean validateUser(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(TEXT_DB_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // expecting each line as: username:password
                String[] parts = line.split(":", 2);
                if(parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean addUser(String username, String password) {
        // Check for duplicate username
        try (BufferedReader reader = new BufferedReader(new FileReader(TEXT_DB_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":", 2);
                if(parts.length == 2 && parts[0].equals(username)) {
                    return false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Append new user record
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TEXT_DB_FILE, true))) {
            writer.write(username + ":" + password);
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Added method to handle login flow after successful validation.
    public static void performLogin(String username, String password) {
        if (validateUser(username, password)) {
            System.out.println("Login successful. Redirecting to dashboard...");
            // ...additional post-login processing...
        } else {
            System.out.println("Invalid username or password.");
        }
    }
}
