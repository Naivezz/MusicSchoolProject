package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Administrator extends Osoba{
    public Administrator(int id, String firstName, String lastName, String email) {
        super(id, firstName, lastName, email);
    }

    @Override
    public String toString() {
        return "Administrator{" +
               "id=" + super.getId() +
               ", firstName='" + super.getFirstName() + '\'' +
               ", lastName='" + super.getLastName() + '\'' +
               ", email='" + super.getLastName() + '\'' +
               '}';
    }
}
