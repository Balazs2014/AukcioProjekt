package com.company;

public class Main {

    public static void main(String[] args) {
        Festmeny f1 = new Festmeny("Jani", "Jani", "román");

        f1.licit();
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
        System.out.println(f1.getLegmagasabbLicit());
    }
}
