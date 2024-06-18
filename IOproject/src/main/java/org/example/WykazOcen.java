package org.example;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
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


    public double obliczycSredniaOcen() {
        return ocenaList.stream()
                .mapToInt(Ocena::getGrade)
                .average()
                .orElse(0.0);
    }


    @Override
    public String toString() {
        return "Wykaz ocen for  " + uczen.getLastName() + ": " + ocenaList;
    }

}
