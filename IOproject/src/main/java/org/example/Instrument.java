package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Instrument {
    private String name;
    private boolean available;
    private String condition;
    private int year;

    public Instrument(String name, boolean available, String condition, int year) {
        this.name = name;
        this.available = available;
        this.condition = condition;
        this.year = year;
    }



    @Override
    public String toString() {
        return name + " (" + condition + ", " + year + ")";
    }
}
