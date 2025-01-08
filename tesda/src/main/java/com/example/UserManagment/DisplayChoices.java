package com.example.UserManagment;

import java.util.Scanner;

import com.example.DataManagement.DataManagementImplementation;
import com.example.DataManagement.DataManagementInterface;

public class DisplayChoices {
    Scanner input = new Scanner(System.in);

    public void displayChoices() {
        boolean flag = false;
        int choice = 0;
        while (!flag) {
            System.out.println("==== CHOICE DASHBOARD =====");
            System.out.println("1.addNotes");
            System.out.println("2.DeleteNotes");
            System.out.println("3.ViewNotes");
            System.out.println("4.getAllNotes");
            System.out.println("5.Exit");
            System.out.print("Enter 1 - 5: ");
            choice = input.nextInt();
            System.out.println("RESULT");
            clearConsole();
            DisplayOperation display = new DisplayOperation(new DataManagementImplementation(),
                    new UserImplementation(), choice);
            display.execute();

        }
    }

    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
