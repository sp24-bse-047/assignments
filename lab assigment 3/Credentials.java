package com.example.login;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Credentials {

    private File file;

    public Credentials() throws IOException {
        File dir = new File("C://Users//huzai//Desktop//JAVA ASSIGNMENT//login//src//main//resources");
        if (!dir.exists()) {
            dir.mkdir();
        }

        file = new File(dir, "Credentials.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public boolean checkUserExists(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length > 0 && parts[0].equals(username)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return false;
    }

    public boolean checkUserCredentials(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length > 1 && parts[0].equals(username) && parts[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return false;
    }

    public void AddCredentials(String username, String password) {
        if (checkUserExists(username)) {
            System.out.println("User already exists: " + username);
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(username + " " + password);
            writer.newLine();
            System.out.println("Credentials added successfully for: " + username);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
