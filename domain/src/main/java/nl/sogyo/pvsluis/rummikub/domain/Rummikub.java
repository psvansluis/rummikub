package nl.sogyo.pvsluis.rummikub.domain;

import java.util.ArrayList;

public class Rummikub {
    private Tafel tafel;
    private ArrayList<String> spelerNamen;

    public Rummikub(ArrayList<String> spelerNamen) {
        this.spelerNamen = spelerNamen;
        this.tafel = new Tafel(spelerNamen.size());
    }

    public String getNaamSpelerMetBeurt() {
        return spelerNamen.get(0);
    }

}
