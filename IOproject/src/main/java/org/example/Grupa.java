package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Grupa {

    private String id;
    private List<Uczen> uczenList;

    public Grupa(String id) {
        this.id = id;
        this.uczenList = new ArrayList<>();
    }

    public void addUczeń(Uczen uczen) {
        uczenList.add(uczen);
    }

    public void removeUczeń(Uczen uczen) {
        uczenList.remove(uczen);
    }

    @Override
    public String toString() {
        return "Grupa{" +
               "id='" + id + '\'' +
               ", uczenList=" + uczenList +
               '}';
    }
}
