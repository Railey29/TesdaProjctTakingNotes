package com.example.UserManagment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class User {
    private String dateOfNotes;
    private String titleNotes;
    private String takeNotes;

    public User(String dateOfNotes) {
        this.dateOfNotes = dateOfNotes;
        this.titleNotes = "";
        this.takeNotes = "";
    }
}
