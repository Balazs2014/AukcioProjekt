package com.company;


import java.time.LocalDateTime;

public class Festmeny {
    private String cim;
    private String festo;
    private String stilus;
    private int licitekSzama = 0;
    private int legmagasabbLicit = 0;
    private LocalDateTime legutolsoLicitIdeje;
    private boolean elkelt = false;

    public Festmeny(String cim, String festo, String stilus) {
        this.cim = cim;
        this.festo = festo;
        this.stilus = stilus;
    }

    public String getFesto() {
        return this.festo;
    }

    public String getStilus() {
        return this.stilus;
    }

    public int getLicitekSzama() {
        return licitekSzama;
    }

    public int getLegmagasabbLicit() {
        return legmagasabbLicit;
    }

    public LocalDateTime getLegutolsoLicitIdeje() {
        return legutolsoLicitIdeje;
    }

    public boolean getElkelt() {
        return elkelt;
    }

    public void setElkelt(boolean elkelt) {

    }

    public void licit() {

    }

    public void licit(int mertek) {

    }
}

