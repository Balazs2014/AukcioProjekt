package com.company;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Festmeny {
    private String cim;
    private String festo;
    private String stilus;
    private int licitekSzama = 0;
    private int legmagasabbLicit = 0;
    private LocalDateTime legutolsoLicitIdeje;
    private boolean elkelt = false;

    private List<Festmeny> festmenyLista;

    public Festmeny(String cim, String festo, String stilus) {
        this.cim = cim;
        this.festo = festo;
        this.stilus = stilus;
    }

    public Festmeny(Festmeny[] festmenyTomb) {
        this.festmenyLista = new ArrayList<>();
        this.festmenyLista.addAll(Arrays.asList(festmenyTomb));
    }

    public String getFesto() {
        return this.festo;
    }

    public String getStilus() {
        return this.stilus;
    }

    public int getLicitekSzama() {
        return this.licitekSzama;
    }

    public int getLegmagasabbLicit() {
        int hossz = Integer.toString(this.legmagasabbLicit).length() - 2;
        int elsoKetto = Integer.parseInt(Integer.toString(this.legmagasabbLicit).substring(0, 2));
        for (int i = 0; i < hossz; i++) {
            elsoKetto *= 10;
        }
        this.legmagasabbLicit = elsoKetto;
        return this.legmagasabbLicit;
    }

    public LocalDateTime getLegutolsoLicitIdeje() {
        return this.legutolsoLicitIdeje;
    }

    public boolean getElkelt() {
        return this.elkelt;
    }

    public void setElkelt(boolean elkelt) {

    }

    public void licit() {
        if (this.elkelt == true) {
            System.out.println("A festmény elkelt!");
        } else if (this.licitekSzama == 0) {
            this.legmagasabbLicit = 100;
            this.licitekSzama++;
            this.legutolsoLicitIdeje = LocalDateTime.now();
        } else {
            licit(10);
        }
    }

    public void licit(int mertek) {
        if (this.elkelt == true) {
            System.out.println("A festmény elkelt!");
        } else if (mertek < 10 || mertek > 100) {
            System.out.println("A paraméter csak 10 és 100 közötti szám lehet!");
        } else if (this.licitekSzama == 0) {
            this.legmagasabbLicit = 100;
            this.licitekSzama++;
            this.legutolsoLicitIdeje = LocalDateTime.now();
        } else {
            this.legmagasabbLicit += legmagasabbLicit * (double)(mertek) / 100;
            this.licitekSzama++;
            this.legutolsoLicitIdeje = LocalDateTime.now();
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %s (%s)\n%s%d $ - %s (összesen: %d db)", this.festo, this.cim, this.stilus,
                ((this.elkelt) ? "elkelt\n" : ""), this.legmagasabbLicit, this.legutolsoLicitIdeje,
                this.licitekSzama);
    }
}

