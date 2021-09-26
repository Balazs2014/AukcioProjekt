package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Festmenyek {
    private static List<Festmeny> festmenyLista = new ArrayList<>();;

    public Festmenyek(List<Festmeny> festmenyLista){
        this.festmenyLista.addAll(festmenyLista);

    }

    public Festmenyek(String fajlNev) {
        try {
            FileReader fReader = new FileReader(fajlNev, Charset.defaultCharset());
            BufferedReader bReader = new BufferedReader(fReader);
            String sor = bReader.readLine();
            while (sor != null) {
                String[] adatok = sor.split(";");
                Festmeny festmeny = new Festmeny(adatok[0], adatok[1], adatok[2]);
                this.festmenyLista.add(festmeny);
                sor = bReader.readLine();
            }
            bReader.close();
            fReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (Festmeny festmeny: this.festmenyLista) {
            s += festmeny + "\n";
        }
        return s;
    }
}
