package com.company;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Festmeny f1 = new Festmeny("Jani", "Jani", "román");
        Festmeny f2 = new Festmeny("János", "János", "gótikus");

        List<Festmeny> festmenyLista = new ArrayList<Festmeny>();
        festmenyLista.add(f1);
        festmenyLista.add(f2);



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
        Festmenyek festmenyekKonzol = new Festmenyek(festmenyLista);
        Festmenyek festmenyekFajl = new Festmenyek("festmenyek.csv");

        /*f1.licit();
        System.out.println(f1.getLegmagasabbLicit());
        f1.licit();
        System.out.println(f1.getLegmagasabbLicit());
        f1.licit(100);
        System.out.println(f1.getLegmagasabbLicit());
        f1.licit(100);
        System.out.println(f1.getLegmagasabbLicit());
        f1.licit(100);
        System.out.println(f1.getLegmagasabbLicit());
        f1.licit(100);
        System.out.println(f1.getLegmagasabbLicit());
        f1.licit(100);
        System.out.println(f1.getLegmagasabbLicit());*/

        //System.out.println(f1);
        //f2.licit(100);
    }
}
