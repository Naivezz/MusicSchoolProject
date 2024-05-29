package org.example;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class Ocena {

    private int grade;
    private Uczen uczen;
    private LocalDate date;
    private Przedmiot przedmiot;
    private Nauczyciel nauczyciel;

    public Ocena(int grade, Uczen uczen, LocalDate date, Przedmiot przedmiot, Nauczyciel nauczyciel) {
        this.grade = grade;
        this.uczen = uczen;
        this.date = date;
        this.przedmiot = przedmiot;
        this.nauczyciel = nauczyciel;
    }

    public String toString() {
        return "Grade: " + grade + " for " + uczen.getLastName() + " in " + przedmiot.getName() + " by " + nauczyciel.getFirstName() + " " + nauczyciel.getLastName() + " on " + date;
    }


}
