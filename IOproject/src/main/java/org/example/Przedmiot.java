package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Przedmiot {

    private String name;
    private Nauczyciel nauczyciel;

    public Przedmiot(String name , Nauczyciel nauczyciel) {
        this.name = name;
        this.nauczyciel = nauczyciel;
    }

    @Override
    public String toString() {
        return "Przedmiot{" +
               "name='" + name + '\'' +
               ", nauczyciel=" + nauczyciel +
               '}';
    }
}
