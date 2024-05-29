package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HarmonogramKoncert {

    private Nauczyciel nauczyciel;
    private List<Uczen> uczenList;

    private LocalDate date;

    public HarmonogramKoncert(Nauczyciel nauczyciel,  LocalDate date) {
        this.nauczyciel = nauczyciel;
        this.uczenList = new ArrayList<>();
        this.date = date;
    }

    public void addUczen(Uczen uczen){
        uczenList.add(uczen);
    }

    public void removeUczen(Uczen uczen){
        uczenList.remove(uczen);
    }

    public void setNauczyciel(Nauczyciel nauczyciel) {
        this.nauczyciel = nauczyciel;
    }

    public String toString() {
        return "Concert on " + date + " led by " + nauczyciel.getFirstName() + " " + nauczyciel.getLastName() + " with students: " + uczenList;
    }
}
