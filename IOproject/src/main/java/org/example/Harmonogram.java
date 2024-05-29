package org.example;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Harmonogram {

    private Przedmiot przedmiot;
    private Gabinet gabinet;
    private Grupa grupa;
    private Nauczyciel nauczyciel;
    private LocalDate date;

    public Harmonogram(Przedmiot przedmiot, Gabinet gabinet, Grupa grupa, Nauczyciel nauczyciel, LocalDate date) {
        this.przedmiot = przedmiot;
        this.gabinet = gabinet;
        this.grupa = grupa;
        this.nauczyciel = nauczyciel;
        this.date = date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void changeGabinet(Gabinet gabinet) {
        this.gabinet = gabinet;
    }

    public void changeTeacher(Nauczyciel nauczyciel) {
        this.nauczyciel = nauczyciel;
    }

    public void setGrupa(Grupa grupa) {
        this.grupa = grupa;
    }

    public String toString() {
        return "Lesson: " + przedmiot.getName() + " in " + gabinet.getRoomNumber() + " for " + grupa + " on " + date + " by " + nauczyciel.getFirstName() + " " + nauczyciel.getLastName();
    }
}
