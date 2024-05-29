package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Optional;

@Getter
@Setter
public class Wypożyczenie {

    private Date date;
    private Instrument instrument;
    private Uczen uczen;
    private Nauczyciel confirmedBy;

    public Wypożyczenie(Date date, Instrument instrument, Uczen uczen, Nauczyciel confirmedBy) {
        this.date = date;
        this.instrument = instrument;
        this.uczen = uczen;
        this.confirmedBy = confirmedBy;
    }

    public String toString() {
        return instrument.getName() + " rented by " + uczen.getFirstName() + " " + uczen.getLastName() + " on " + date + ", confirmed by " + confirmedBy.getFirstName() + " " + confirmedBy.getLastName();
    }
}
