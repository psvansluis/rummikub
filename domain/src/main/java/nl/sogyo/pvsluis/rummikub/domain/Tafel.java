package nl.sogyo.pvsluis.rummikub.domain;

import java.util.ArrayList;

class Tafel {
    private ArrayList<Set> sets;
    private Plankje eerstePlankje;

    Tafel(int aantalPlankjes) {
        sets = new ArrayList<Set>();
        eerstePlankje = new Plankje(aantalPlankjes);
    }

    public Plankje getEerstePlankje() {
        return eerstePlankje;
    }

    ArrayList<Set> getSets() {
        return sets;
    }

    void maakSet() {
        this.sets.add(new Set());
    }

    void verwijderLegeSets() {
        for (Set set : this.sets) {
            if (set.getStenen().size() == 0) {
                this.sets.remove(set);
            }
        }
    }

}
