package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class  Osoba {

    private int id;
    private String firstName;
    private String lastName;
    private String email;

    public Osoba(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }



}
