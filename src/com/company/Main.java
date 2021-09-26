package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Festmeny f1 = new Festmeny("Jani", "Jani", "román");
        Festmeny f2 = new Festmeny("János", "János", "gótikus");

        Festmeny[] festmenyTomb = new Festmeny[]{f1, f2};
        Festmenyek festmenyek = new Festmenyek(festmenyTomb);

        System.out.println(festmenyek);

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
