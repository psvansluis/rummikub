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
        return this.spelerNamen.get(this.getIndexSpelerMetBeurt());
    }

    private int getIndexSpelerMetBeurt() {
        int out = 0;
        while (this.tafel.getEerstePlankje()
                .getVolgendePlankje(out) != this.tafel.getPlankjeMetBeurt()) {
            out++;
        }
        return out;
    }

    private static ArrayList<Integer> steenNaarArrayList(Steen steen) {
        ArrayList<Integer> out = new ArrayList<Integer>();
        out.add(steen.getCijfer());
        out.add(steen.getKleur().ordinal());
        return out;
    }

    private static ArrayList<ArrayList<Integer>> getStenenVanContainer(
            StenenContainer container) {
        ArrayList<ArrayList<Integer>> out = new ArrayList<ArrayList<Integer>>();
        for (Steen steen : container.getStenen()) {
            out.add(steenNaarArrayList(steen));
        }
        return out;
    }

    public ArrayList<ArrayList<Integer>> getStenenOpPlankjeMetBeurt() {
        return getStenenVanContainer(this.tafel.getPlankjeMetBeurt());
    }

    public int aantalStenenInPot() {
        return this.tafel.getEerstePlankje().getPot().getStenen().size();
    }

    public boolean kanBeurtDoorgeven() {
        return this.tafel.kanBeurtDoorgeven();
    }

    public ArrayList<Boolean> getValiditeitSets() {
        ArrayList<Boolean> out = new ArrayList<Boolean>();
        for (Set set : this.tafel.getSets()) {
            out.add(set.isValide());
        }
        return out;
    }

    public ArrayList<ArrayList<ArrayList<Integer>>> getStenenOpTafel() {
        ArrayList<ArrayList<ArrayList<Integer>>> out;
        out = new ArrayList<ArrayList<ArrayList<Integer>>>();
        for (Set set : this.tafel.getSets()) {
            out.add(getStenenVanContainer(set));
        }
        return out;
    }

}
