package com.company;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.*;

public class Main {

    static List<Festmeny> festmenyLista = new ArrayList<Festmeny>();
    static Scanner sc = new Scanner(System.in);
    static Random rnd = new Random();

    public static void bekerFelhasznalotol() {
        System.out.print("Hány festményt szeretnél felvenni? ");
        int darab = sc.nextInt();
        String cim, festo, stilus;
        for (int i = 0; i < darab; i++) {
            System.out.println((i + 1) + ". FESTMÉNY");
            System.out.print("Cím: ");
            cim = sc.next();
            System.out.print("Festő: ");
            festo = sc.next();
            System.out.print("Stílus: ");
            stilus = sc.next();
            Festmeny p = new Festmeny(cim, festo, stilus);
            festmenyLista.add(p);
        }
    }

    public static void beolvasasFajlbol() {
        try {
            FileReader fReader = new FileReader("festmenyek.csv", Charset.defaultCharset());
            BufferedReader bReader = new BufferedReader(fReader);
            String sor = bReader.readLine();
            while (sor != null) {
                String[] adatok = sor.split(";");
                Festmeny festmeny = new Festmeny(adatok[0], adatok[1], adatok[2]);
                festmenyLista.add(festmeny);
                sor = bReader.readLine();
            }
            bReader.close();
            fReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void randomLicit() {
        int listaHossza = festmenyLista.size();
        for (int i = 0; i < 20; i++) {
            int rndSzam = rnd.nextInt(listaHossza - 0) + 0;
            festmenyLista.get(rndSzam).licit();
        }
    }

    public static void felhasznaloLicit() {
        System.out.print("Adja meg a festmény sorszámát: ");
        int sorszam = sc.nextInt();
        try {
            while ((sorszam < 0 || sorszam >= festmenyLista.size() - 1) && sorszam != 0) {
                System.out.print("Hibás sorszám! Adjon meg létező sorszámot: ");
                sorszam = sc.nextInt();
            }
            while (festmenyLista.get(sorszam - 1).getElkelt() && sorszam != 0) {
                System.out.print("A festmény elkelt! Adjon meg új sorszámot: ");
                sorszam = sc.nextInt();
            }

            int mertek;
            System.out.print("Mekkora mértékkel szeretne licitálni? ");
            try {
                mertek = sc.nextInt();
                if (mertek % 1 == 0) {
                    festmenyLista.get(sorszam - 1).licit(mertek);
                } else {
                    festmenyLista.get(sorszam - 1).licit();
                }
            } catch (Exception e2) {
                System.out.println("Nem számot adott meg!");
            }
        } catch (Exception e) {
            System.out.println("Nem számot adott meg!");
        }

        if (sorszam == 0) {
            System.out.println("Licit vége!");
        }

        for (int i = 0; i < festmenyLista.size(); i++) {
            if (festmenyLista.get(i).getLicitekSzama() != 0) {
                festmenyLista.get(i).setElkelt(true);
            }
        }
    }

    public static void festmenyekKiirasaKonzolra() {
        String s = "";
        for (Festmeny festmeny : festmenyLista) {
            s += festmeny + "\n";
        }
        System.out.println(s);
    }

    public static int legdragabbElkeltFestmenyIndex() {
        int i = 0;
        int maxI = 0;
        while (festmenyLista.get(i).getElkelt()) {
            for (int j = 0; j < festmenyLista.size(); j++) {
                if (festmenyLista.get(maxI).getLegmagasabbLicit() < festmenyLista.get(j).getLegmagasabbLicit()) {
                    maxI = j;
                }
            }
            i++;
        }
        return maxI;
    }

    public static boolean voltETiznelTobbLicit() {
        int i = 0;
        boolean voltE = false;
        while (i < festmenyLista.size()) {
            if (festmenyLista.get(i).getLicitekSzama() >= 10) {
                voltE = true;
            }
            i++;
        }
        return voltE;
    }

    public static int nemElkeltFestménekDarabszama() {
        int db = 0;
        for (int i = 0; i < festmenyLista.size(); i++) {
            if (!festmenyLista.get(i).getElkelt()) {
                db++;
            }
        }
        return db;
    }

    public static void main(String[] args) {
        Festmeny f1 = new Festmeny("Jani", "Jani", "román");
        Festmeny f2 = new Festmeny("János", "János", "gótikus");

        festmenyLista.add(f1);
        festmenyLista.add(f2);

        bekerFelhasznalotol();
        beolvasasFajlbol();
        randomLicit();
        felhasznaloLicit();
        festmenyekKiirasaKonzolra();

        System.out.println("Legdrágább elkelt festmény:\n" + festmenyLista.get(legdragabbElkeltFestmenyIndex()));
        System.out.println((voltETiznelTobbLicit()) ? "Volt olyan festmény, melyre 10-nél több licit érkezett" :
                 "Nem volt olyan festmény, melyre 10-nél több licit érkezett");
        System.out.println("Nem elkelt festmények darabszáma: " + nemElkeltFestménekDarabszama() + " db");
    }
}
