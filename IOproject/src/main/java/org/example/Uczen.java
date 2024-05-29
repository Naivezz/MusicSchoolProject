package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Uczen extends Osoba{

    private String firstName;

    public Uczen(int id, String firstName, String lastName, String email) {
        super(id, firstName, lastName, email);
    }

    @Override
    public String toString() {
        return "Uczeń{" +
               "id=" + super.getId() +
               ", firstName='" + super.getFirstName() + '\'' +
               ", lastName='" + super.getLastName() + '\'' +
               ", email='" + super.getLastName() + '\'' +
               '}';
    }

}
