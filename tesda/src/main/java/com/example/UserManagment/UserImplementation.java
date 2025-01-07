package com.example.UserManagment;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.example.DataManagement.DataManagementImplementation;

public class UserImplementation implements UserInterface {
    private Scanner input = new Scanner(System.in);

    @Override
    public List<String> getInputUserAllData() {
        String date = "";
        String title = "";
        String content = "";

        try {
            while (true) {
                System.out.print("Enter Date of Notes (YYYY-MM-DD): ");
                date = input.nextLine();
                if (isValidDate(date)) {
                    break;
                } else {
                    System.out.println("Invalid date. Please enter a valid date in YYYY-MM-DD format.");
                }
            }

            System.out.print("Enter a Title of Your Notes: ");
            title = input.nextLine();
            System.out.print("Enter Content of your Notes: ");
            content = input.nextLine();

        } catch (Exception e) {
            e.printStackTrace();
        }

        List<String> userInput = new ArrayList<>();
        userInput.add(date);
        userInput.add(title);
        userInput.add(content);

        return userInput;
    }

    @Override
    public List<String> getUserByDate() {
        List<String> userList = new ArrayList<>();
        String date = "";

        try {
            while (true) {
                System.out.print("Enter Date of Notes (YYYY-MM-DD): ");
                date = input.nextLine();
                if (isValidDate(date)) {
                    break;
                } else {
                    System.out.println("Invalid date. Please enter a valid date in YYYY-MM-DD format.");
                }
            }
            userList.add(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    // This is for checking if the date format is valid
    private boolean isValidDate(String date) {
        try {
            LocalDate.parse(date); // Checks if the date is in valid format
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
