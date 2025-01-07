package com.example.DataManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.UserManagment.User;

public class DataManagementImplementation implements DataManagementInterface {
    private final String URL = "jdbc:mysql://localhost:3306/takingnotes_db";
    private final String USERNAME = "root";
    private final String PASSWORD = "";

    private Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    private boolean isChecked(String date) {
        boolean flag = false;
        String query = "SELECT set_date FROM notes_method WHERE set_date = ?";
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, date);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                flag = true;
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public void addNotes(User user) {

        boolean flag = isChecked(user.getDateOfNotes());

        if (flag) {
            throw new IllegalArgumentException("Date is already added");
        }

        final String query = "INSERT INTO notes_method (add_notes , title_notes , set_date) VALUES (? , ? , ?)";
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getTakeNotes());
            preparedStatement.setString(2, user.getTitleNotes());
            preparedStatement.setString(3, user.getDateOfNotes());

            int rowInserted = preparedStatement.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("INSERTED SUCCESSFULLY");
            } else {
                System.err.println("INSERT OPERATION IS FAILED");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteNotes(User user) {
        boolean flag = isChecked(user.getDateOfNotes());
        if (!flag) {
            throw new IllegalArgumentException("The Date is not Found");
        }

        final String query = "DELETE FROM notes_method WHERE set_date = ?";
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getDateOfNotes());

            int rowInserted = preparedStatement.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("DELETED SUCCESSFULLY");
            } else {
                System.err.println("DELETE OPERATION IS FAILED");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void viewNotes(User user) {
        boolean flag = isChecked(user.getDateOfNotes());

        if (!flag) {
            throw new IllegalArgumentException("The Date is not Found");
        }

        final String query = "SELECT title_notes, add_notes  , set_date FROM notes_method WHERE set_date = ?";
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getDateOfNotes());

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String title = resultSet.getString("title_notes");
                String date = resultSet.getString("set_date");
                String notes = resultSet.getString("add_notes");
                System.out.println("===========");
                System.out.println("DATE: " + date);
                System.out.println("TITLE: " + title);
                System.out.println("NOTES: " + notes);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getNotesList(User user) {
        List<User> notesList = new ArrayList<>();

        final String query = "SELECT add_notes, title_notes, set_date FROM notes_method";

        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User note = new User(
                        resultSet.getString("set_date"),
                        resultSet.getString("title_notes"),
                        resultSet.getString("add_notes"));
                notesList.add(note);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        for (User user2 : notesList) {
            System.out.println("===================");
            System.out.println("DATE: " + user2.getDateOfNotes());
            System.out.println("TITLE: " + user2.getTitleNotes());
            System.out.println("NOTES: " + user2.getTakeNotes());
        }

        return notesList;
    }

}
