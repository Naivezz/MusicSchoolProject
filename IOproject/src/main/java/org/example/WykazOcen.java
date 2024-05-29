package org.example;

import java.util.ArrayList;
import java.util.List;

public class WykazOcen {

    private Uczen uczen;
    private List<Ocena> ocenaList;



    public WykazOcen(Uczen uczen) {
        this.uczen = uczen;
        this.ocenaList = new ArrayList<>();
    }

    public void addOcena(Ocena ocena){
        ocenaList.add(ocena);
    }

    public void removeOcena(Ocena ocena){
        ocenaList.remove(ocena);
    }

    public void changeOcena(Ocena ocena, Ocena nowaOcena) {
        int index = ocenaList.indexOf(ocena);
        if (index != -1) {
            ocenaList.set(index, nowaOcena);
        }
    }

    @Override
    public String toString() {
        return "Wykaz ocen for  " + uczen.getLastName() + ": " + ocenaList;
    }

}
