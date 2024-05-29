package org.example;

import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Main {
    public static void main(String[] args) {
        MusicSchool school = new MusicSchool();


        Uczen uczen1 = new Uczen(1,"Joe" , "Poe" , "jpoe@gmial.com");
        Uczen uczen2 = new Uczen(2,"Mike" , "Brick" , "jpoe@gmial.com");
        Uczen uczen3 = new Uczen(3,"John" , "Mock" , "jpoe@gmial.com");

        school.addUczen(uczen1);
        school.addUczen(uczen2);
        school.addUczen(uczen3);
        //System.out.println(school.getUczenList());

        System.out.println("Uczeń 1: " + uczen1);
        System.out.println("Uczeń 2: " + uczen2);
        System.out.println("Uczeń 3: " + uczen3);



        Nauczyciel nauczyciel1 = new Nauczyciel(1,"Katy" , "Brown" , "kbrown@gmial.com" , "gitara" ,536318133L);
        Nauczyciel nauczyciel2 = new Nauczyciel(2,"Chloe" , "Yellow" , "cyellow@gmial.com" , "piano" , 351314252L);
        Nauczyciel nauczyciel3 = new Nauczyciel(3,"Sara" , "White" , "swhite@gmial.com" , "klarnet" , 53564131L);

        school.addNauczyiel(nauczyciel1);
        school.addNauczyiel(nauczyciel2);
        school.addNauczyiel(nauczyciel3);

        System.out.println("Nauczyciel 1: " + nauczyciel1);
        System.out.println("Nauczyciel 2: " + nauczyciel2);
        System.out.println("Nauczyciel 3: " + nauczyciel3);
        //System.out.println(school.getNauczycielList());

        System.out.println("----------------------------------");


        Grupa group1 = new Grupa("223B");
        Grupa group2 = new Grupa("222A");
        school.addGrupa(group1);
        school.addGrupa(group2);
        group1.addUczeń(uczen1);
        group1.addUczeń(uczen2);
        System.out.println("Grupa : " + group1.getId() + " lista uczniów " + group1.getUczenList());
        group1.removeUczeń(uczen2);
        System.out.println("Grupa : " + group1.getId() + " lista  uczniów po usunięciu ucznia z grupy " + group1.getUczenList());

        //System.out.println(school.getGrupaList());
        System.out.println("----------------------------------");

        Gabinet gabinet1 = new Gabinet("309");
        Gabinet gabinet2 = new Gabinet("108");
        Gabinet gabinet3 = new Gabinet("21");
        Gabinet gabinet4 = new Gabinet("257");

        school.addGabinet(gabinet1);
        school.addGabinet(gabinet2);
        school.addGabinet(gabinet3);
        school.addGabinet(gabinet4);

        //System.out.println(school.getGabinetList());
        System.out.println("Gabinet : " + gabinet1.getRoomNumber());
        System.out.println("Gabinet : " + gabinet2.getRoomNumber());
        System.out.println("Gabinet : " + gabinet3.getRoomNumber());
        System.out.println("Gabinet : " + gabinet4.getRoomNumber());

        System.out.println("------------------------------------------");

        Przedmiot przedmiot1 = new Przedmiot("Gitara", nauczyciel1);
        Przedmiot przedmiot2 = new Przedmiot("Piano", nauczyciel2);
        Przedmiot przedmiot3 = new Przedmiot("Klarnet", nauczyciel3);

        school.addPzredmiot(przedmiot1);
        school.addPzredmiot(przedmiot2);
        school.addPzredmiot(przedmiot3);

        //System.out.println(school.getPrzedmiotList());
        System.out.println("Nazwa przedmiotu i nauczyciel tego przedmiotu ");
        System.out.println(przedmiot1.getName() + ": " + przedmiot1.getNauczyciel());
        System.out.println(przedmiot2.getName() + ": " + przedmiot2.getNauczyciel());
        System.out.println(przedmiot3.getName() + ": " + przedmiot3.getNauczyciel());

        System.out.println("----------------------------");

        Instrument instrument1 = new Instrument("Gitara", true, "Good", 2020);
        school.addInstrument(instrument1);
        Instrument instrument2 = new Instrument("Piano", true, "Bad", 2018);
        school.addInstrument(instrument2);
        Instrument instrument3 = new Instrument("Klarnet", false, "Good", 2023);
        school.addInstrument(instrument3);
        //System.out.println(school.getInstrumentList());
        List<Instrument> list = List.of(instrument1, instrument2 , instrument3);
        System.out.println("Instrumenty:");
        for (Instrument instrument : list) {
            System.out.println(instrument);
        }

        System.out.println("---------------");

        List<Instrument> availableInstuments = list.stream().filter(instrument -> instrument.getCondition().equals("Good") && instrument.isAvailable()).collect(Collectors.toList());
        System.out.println("Instumenty w dobrym stanie i dostępne  instumenty : " + availableInstuments);
        var dostpenyInstrument = availableInstuments.getFirst();
        System.out.println(dostpenyInstrument);

        System.out.println("--------------");


        System.out.println();
        Wypożyczenie wypożyczenie = new Wypożyczenie(new Date(), dostpenyInstrument  , uczen2, nauczyciel2);
        school.addWypożyczenie(wypożyczenie);
        System.out.println("Wypożyczony instrument : " + dostpenyInstrument.getName() + " , " + "uczniem " + uczen2 + " " + "zatwierdzony przez nauczyciela " + nauczyciel2.getFirstName() + " " + nauczyciel2.getLastName());


        System.out.println("------------------------------");



        Harmonogram harmonogram = new Harmonogram(przedmiot1, gabinet1, group1, nauczyciel1, LocalDate.of(2024,10,1));
        school.addHarmonogram(harmonogram);
        System.out.println("Harmonogram: " + harmonogram);
        Harmonogram harmonogram1 = new Harmonogram(przedmiot2, gabinet2, group1, nauczyciel2, LocalDate.of(2024,10,2));
        school.addHarmonogram(harmonogram1);
        System.out.println("Harmonogram: " + harmonogram1);
        //System.out.println(school.getHarmonogramList());

        System.out.println("--------------------------------");


        HarmonogramKoncert harmonogramKoncert = new HarmonogramKoncert(nauczyciel3, LocalDate.of(2024,12,14));
        harmonogramKoncert.addUczen(uczen2);
        harmonogramKoncert.addUczen(uczen1);
        System.out.println(harmonogramKoncert);
        harmonogramKoncert.removeUczen(uczen1);
        System.out.println("Uczen1 zrezygnował z koncertu więc aktualna informacja dotycząca koncertu:");
        System.out.println(harmonogramKoncert);
        school.addHarmonogramConcert(harmonogramKoncert);

        System.out.println("------------------------------------------------");


        Ocena ocena1 = new Ocena(5, uczen1, LocalDate.of(2020,10,11), przedmiot1, nauczyciel1);
        school.addOcena(uczen1, ocena1);
        //System.out.println(school.getWykazOcenMap());
        System.out.println("Ocena "  + ocena1.getGrade() + ": to " + ocena1.getUczen().getLastName() + " by " + ocena1.getNauczyciel().getLastName() + " on " +  ocena1.getDate());

        System.out.println("-----------------------");


         System.out.println("Date : " + harmonogram.getDate());
         harmonogram.setDate(LocalDate.of(2020,10,28));
         System.out.println("Changed date : " + harmonogram.getDate());

         System.out.println("Teacher: " + harmonogram.getNauczyciel().getLastName());
         harmonogram.changeTeacher(nauczyciel2);
         System.out.println("Changed teacher: " + harmonogram.getNauczyciel().getLastName());

         System.out.println("Gabinet " + harmonogram.getGabinet().getRoomNumber());
         harmonogram.changeGabinet(new Gabinet("203"));
         System.out.println("Changed gabinet " + harmonogram.getGabinet().getRoomNumber());

         System.out.println("--------------------------------");


         System.out.println("Wykaz ocen przed usunięciem " + uczen1.getLastName());
         System.out.println(school.getWykazOcenMap());

         school.removeOcena(uczen1, ocena1);
         System.out.println("Wykaz ocen po usunięciu oceny Ucznia " + uczen1.getLastName());
         System.out.println(school.getWykazOcenMap());


        System.out.println("-----------------------------");

        Ocena ocena2 = new Ocena(5, uczen3, LocalDate.of(2020,10,11), przedmiot1, nauczyciel1);
        school.addOcena(uczen1, ocena1);
        System.out.println(school.getWykazOcenMap());
        Ocena ocena3 = new Ocena(4, uczen3 , LocalDate.of(2024,10,21), przedmiot1, nauczyciel1);
        school.changeOcena(uczen3, ocena2, ocena3);
        System.out.println(school.getWykazOcenMap());

        System.out.println("----------------------------------");



        List<Wypożyczenie> wypożyczenies = school.wypożyczenies(uczen2);
        System.out.println("Wypożyczone instrumenty studentem: " + wypożyczenies);

        System.out.println("----------------------------------------");


        List<Harmonogram> lessons = school.zajeciaPrzezNauczyciela(nauczyciel2);
        System.out.println("Lessons by teacher: " + lessons);


        System.out.println("--------------------------------");

        System.out.println("All information about musicSchool");
        System.out.println(school);



    }
}