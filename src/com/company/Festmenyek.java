package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Festmenyek {
    private List<Festmeny> festmenyLista;

    public Festmenyek(List<Festmeny> festmenyLista){
        this.festmenyLista = new ArrayList<>();
        this.festmenyLista.addAll(festmenyLista);
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
