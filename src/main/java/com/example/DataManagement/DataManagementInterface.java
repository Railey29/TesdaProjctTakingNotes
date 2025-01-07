package com.example.DataManagement;

import java.util.List;

import com.example.UserManagment.User;

public interface DataManagementInterface {
    void addNotes(User user);

    void deleteNotes(User user);

    void viewNotes(User user);

    List<User> getNotesList(User user);
}