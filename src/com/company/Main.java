package com.company;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.*;

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

        String s = "";
        for (Festmeny festmeny: festmenyLista) {
            s += festmeny + "\n";
        }
        System.out.println(s);

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
