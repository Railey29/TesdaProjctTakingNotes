package com.example.UserManagment;

import java.util.List;

import com.example.DataManagement.DataManagementImplementation;

public class DisplayOperation {
    private int choice;
    private User user;
    DataManagementImplementation dataManagementInterface = new DataManagementImplementation();
    UserInterface userInterface = new UserImplementation();

    private void getAllData() {
        List<String> userInputAllData = userInterface.getInputUserAllData();
        user = new User(userInputAllData.get(0), userInputAllData.get(1), userInputAllData.get(2));
    }

    private void getDate() {
        List<String> userGetDate = userInterface.getUserByDate();
        user = new User(userGetDate.get(0));
    }

    public DisplayOperation(int choice) {
        this.choice = choice;
    }

    public void execute() {
        switch (choice) {
            case 1:
                getAllData();
                dataManagementInterface.addNotes(user);
                break;
            case 2:
                getDate();
                dataManagementInterface.deleteNotes(user);
                break;
            case 3:
                getDate();
                dataManagementInterface.viewNotes(user);
                break;
            case 4:
                dataManagementInterface.getNotesList(user);
                break;
            case 5:
                System.out.println("Thanks for Using this System");
                System.exit(1);
                break;
        }
    }
}
