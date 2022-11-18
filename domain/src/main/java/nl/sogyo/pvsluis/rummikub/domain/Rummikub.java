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
        // Todo na implementeren Joker: add 0 bij gewone steen, 1 bij Joker.
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

    // Getters Todo:
    // - Of speler uitgekomen is
    // - Of spel afgelopen is
    // - Bij afgelopen spel:
    // - score (punten op Plankjes van spelers en n Stenen in Pot)
    // - Of een Steen een Joker is

    // Setters Todo:
    // - Verplaats van Plankje naar Set
    // - Verplaats van Set naar Set
    // - Verplaats van Set naar Plankje
    // - Verander waarde Joker
    // - Sluit beurt af
    // - Haal Steen uit Pot
    // - Reset Tafel en Plankje

}
