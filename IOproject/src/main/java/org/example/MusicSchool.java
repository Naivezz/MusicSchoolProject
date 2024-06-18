package org.example;

import lombok.Getter;
import lombok.Setter;


import java.util.*;

@Getter
@Setter
public class MusicSchool {

    private List<Nauczyciel> nauczycielList;
    private List<Uczen> uczenList;
    private List<Grupa> grupaList;
    private List<Przedmiot> przedmiotList;
    private List<Gabinet> gabinetList;
    private List<Instrument> instrumentList;
    private List<Wypożyczenie> wypożyczenieList;
    private List<Harmonogram> harmonogramList;
    private List<HarmonogramKoncert> harmonogramKoncertList;
    private Map<Uczen , WykazOcen> wykazOcenMap;
    private List<Ocena> ocenaList;

    public MusicSchool() {
        uczenList = new ArrayList<>();
        nauczycielList = new ArrayList<>();
        grupaList = new ArrayList<>();
        gabinetList = new ArrayList<>();
        przedmiotList = new ArrayList<>();
        instrumentList = new ArrayList<>();
        wypożyczenieList = new ArrayList<>();
        harmonogramList = new ArrayList<>();
        harmonogramKoncertList = new ArrayList<>();
        wykazOcenMap = new HashMap<>();
    }

    public void addUczen(Uczen uczen) {
        uczenList.add(uczen);
        wykazOcenMap.put(uczen, new WykazOcen(uczen));
    }

    public void removeUczen(Uczen uczen) {
        uczenList.remove(uczen);
        wykazOcenMap.remove(uczen);
    }

    public void addNauczyiel(Nauczyciel nauczyciel){
        nauczycielList.add(nauczyciel);
    }

    public void removeNauczyiel(Nauczyciel nauczyciel){
        nauczycielList.remove(nauczyciel);
    }

    public void addGrupa(Grupa grupa) {
        grupaList.add(grupa);
    }

    public void removeGrupa(Grupa grupa) {
        grupaList.remove(grupa);
    }

    public void addGabinet(Gabinet gabinet) {
        gabinetList.add(gabinet);
    }

    public void removeGabinet(Gabinet gabinet) {
        gabinetList.remove(gabinet);
    }

    public void addPzredmiot(Przedmiot przedmiot) {
        przedmiotList.add(przedmiot);
    }

    public void removePrzedmiot(Przedmiot przedmiot) {
        przedmiotList.remove(przedmiot);
    }

    public void addInstrument(Instrument instrument) {
        instrumentList.add(instrument);
    }

    public void removeInstrument(Instrument instrument) {
        instrumentList.remove(instrument);
    }

    public void addWypożyczenie(Wypożyczenie wypożyczenie) {
        wypożyczenieList.add(wypożyczenie);
    }

    public void addHarmonogram(Harmonogram harmonogram) {
        harmonogramList.add(harmonogram);
    }

    public void addHarmonogramConcert(HarmonogramKoncert harmonogramKoncert) {
        harmonogramKoncertList.add(harmonogramKoncert);
    }


    public void addOcena(Uczen uczen, Ocena ocena) {
        WykazOcen wykazOcen = wykazOcenMap.get(uczen);
        if (wykazOcen != null) {
            wykazOcen.addOcena(ocena);
        }
    }

    public void removeOcena(Uczen uczen, Ocena ocena) {
        WykazOcen wykazOcen = wykazOcenMap.get(uczen);
        if (wykazOcen != null) {
            wykazOcen.removeOcena(ocena);
        }
    }

    public void changeOcena(Uczen uczen, Ocena ocena , Ocena nowaOcena) {
        WykazOcen wykazOcen = wykazOcenMap.get(uczen);
        if (wykazOcen != null) {
            wykazOcen.changeOcena(ocena , nowaOcena);
        }
    }

    public List<Wypożyczenie> wypożyczenies(Uczen uczen) {
        List<Wypożyczenie> uczenWypożyczenie = new ArrayList<>();
        for (Wypożyczenie wypożyczenie : wypożyczenieList) {
            if (wypożyczenie.getUczen().equals(uczen)) {
                uczenWypożyczenie.add(wypożyczenie);
            }
        }
        return uczenWypożyczenie;
    }

    public List<Harmonogram> zajeciaPrzezNauczyciela(Nauczyciel nauczyciel) {
        List<Harmonogram> lessons = new ArrayList<>();
        for (Harmonogram harmonogram : harmonogramList) {
            if (harmonogram.getNauczyciel().equals(nauczyciel)) {
                lessons.add(harmonogram);
            }
        }
        return lessons;
    }

    public double sredniaOcen(Uczen uczen) {
        WykazOcen gradeBook = wykazOcenMap.get(uczen);
        if (gradeBook != null) {
            return gradeBook.obliczycSredniaOcen();
        }
        return 0;
    }

    public String postepy(Uczen uczen) {
        WykazOcen wykazOcen = wykazOcenMap.get(uczen);
        if (wykazOcen == null) {
            return "Brak wykazOcen dla ucznia " + uczen.getLastName();
        }

        StringBuilder info = new StringBuilder();
        info.append("Informacja dla ").append(uczen.getLastName()).append("\n");
        info.append("Średnia Ocen: ").append(wykazOcen.obliczycSredniaOcen()).append("\n");

        Map<Przedmiot, List<Ocena>> ocenaPrzedmiot = new HashMap<>();
        for (Ocena ocena : wykazOcen.getOcenaList()) {
            ocenaPrzedmiot.computeIfAbsent(ocena.getPrzedmiot(), x -> new ArrayList<>()).add(ocena);
        }

        for (var entry : ocenaPrzedmiot.entrySet()) {
            Przedmiot przedmiot = entry.getKey();
            List<Ocena> oceny = entry.getValue();
            double average = oceny.stream().mapToInt(Ocena::getGrade).average().orElse(0.0);
            info.append("Predmiot: ").append(przedmiot.getName()).append(", Średnia ocena: ").append(average).append("\n");
        }

        return info.toString();
    }


    @Override
    public String toString() {
        return "MusicSchool{" +
               "nauczycielList=" + nauczycielList +
               ", uczenList=" + uczenList +
               ", grupaList=" + grupaList +
               ", przedmiotList=" + przedmiotList +
               ", gabinetList=" + gabinetList +
               ", instrumentList=" + instrumentList +
               ", wypożyczenieList=" + wypożyczenieList +
               ", harmonogramList=" + harmonogramList +
               ", harmonogramKoncertList=" + harmonogramKoncertList +
               ", wykazOcenMap=" + wykazOcenMap +
               '}';
    }
}
