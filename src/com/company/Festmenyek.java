package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Festmenyek {
    private List<Festmeny> festmenyLista;

    public Festmenyek(Festmeny[] festmenyTomb){
        this.festmenyLista = new ArrayList<>();
        this.festmenyLista.addAll(Arrays.asList(festmenyTomb));
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
