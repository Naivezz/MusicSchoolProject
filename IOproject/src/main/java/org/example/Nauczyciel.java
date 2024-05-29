package org.example;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Nauczyciel extends Osoba{

    private Long numerTelefonu;
    private String specjalność;

    public Nauczyciel(int id, String firstName, String lastName, String email , String specjalność , Long numerTelefonu) {
        super(id, firstName, lastName, email);
        this.specjalność = specjalność;
        this.numerTelefonu =  numerTelefonu;
    }

    @Override
    public String toString() {
        return "Nauczyciel{" +
               "id=" + super.getId() +
               ", firstName='" + super.getFirstName() + '\'' +
               ", lastName='" + super.getLastName() + '\'' +
               ", email='" + super.getLastName() + '\'' +
               ", numerTelefonu='" + numerTelefonu + '\'' +
               ", specjalność='" + specjalność + '\'' +
               '}';
    }
}
