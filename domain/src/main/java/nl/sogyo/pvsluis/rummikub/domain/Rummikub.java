package nl.sogyo.pvsluis.rummikub.domain;

import java.util.ArrayList;

import nl.sogyo.pvsluis.rummikub.domain.AbstractSteen.Kleur;

public class Rummikub {
    private Tafel tafel;
    private ArrayList<String> spelerNamen;

    public Rummikub(ArrayList<String> spelerNamen, int seed) {
        this.spelerNamen = spelerNamen;
        this.tafel = new Tafel(spelerNamen.size(), seed);
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
        out.add(steen instanceof Joker ? 1 : 0);
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
        return this.tafel.getEerstePlankje().getPot().lengte();
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

    public boolean spelerMetBeurtIsUitgekomen() {
        return this.tafel.getPlankjeMetBeurt().isUitgekomen();
    }

    public boolean spelIsAfgelopen() {
        return this.tafel.getPlankjeMetBeurt().lengte() == 0
                && this.tafel.alleSetsZijnValide();
    }

    // Getters Todo:
    // - Bij afgelopen spel: score (punten op Plankjes en n Stenen in Pot)
    // - Of een Steen een Joker is

    public void speelSteen(
            int bronContainerIndex, int steenIndex, int doelContainerIndex) {
        this.tafel.speelSteen(
                bronContainerIndex, steenIndex, doelContainerIndex);
    }

    public void sluitBeurtAf() {
        this.tafel.geefBeurtDoor();
    }

    public void neemSteenUitPot() {
        this.tafel.eindigBeurtDoorSteenTeNemen();
    }

    public void resetSpelNaarAanvangBeurt() {
        this.tafel.resetSpelNaarAanvangBeurt();
    }

    public void sorteerPlankjeOpCijfer() {
        this.tafel.getPlankjeMetBeurt().sorteerOpCijfer();
    }

    public void sorteerPlankjeOpKleur() {
        this.tafel.getPlankjeMetBeurt().sorteerOpKleur();
    }

    public void veranderJokerWaarde(
            int containerIndex,
            int steenIndex,
            int nieuwCijfer,
            int nieuweKleurIndex) {
        this.tafel
                .getStenenContainerOfMaakAan(containerIndex)
                .getSteen(steenIndex)
                .setWaarde(steenIndex, Kleur.values()[nieuweKleurIndex]);
    }

    // Setters Todo:
    // - Verander waarde Joker

}
