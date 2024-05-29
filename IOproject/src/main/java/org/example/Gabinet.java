package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Gabinet {

    private String roomNumber;

    public Gabinet(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "Gabinet{" +
               "roomNumber='" + roomNumber + '\'' +
               '}';
    }
}
