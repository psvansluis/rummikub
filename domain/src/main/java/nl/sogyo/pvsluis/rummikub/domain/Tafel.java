package nl.sogyo.pvsluis.rummikub.domain;

import java.util.ArrayList;

class Tafel {
    private ArrayList<Set> sets;
    private ArrayList<Set> setsBijAanvangBeurt;
    private Plankje eerstePlankje;

    Tafel(int aantalPlankjes) {
        sets = new ArrayList<Set>();
        setsBijAanvangBeurt = new ArrayList<Set>();
        eerstePlankje = new Plankje(aantalPlankjes);
    }

    Plankje getEerstePlankje() {
        return eerstePlankje;
    }

    Plankje getPlankjeMetBeurt() {
        return this.getEerstePlankje().getPlankjeMetBeurt();
    }

    ArrayList<Set> getSets() {
        return sets;
    }

    ArrayList<Set> getSetsBijAanvangBeurt() {
        return setsBijAanvangBeurt;
    }

    private Set getSetOfMaakSetAan(int setIndex) {
        if (setIndex < this.getSets().size()) {
            return this.getSets().get(setIndex);
        } else {
            return this.maakSetEnKeerDezeUit();
        }
    }

    void speelSteenVanPlankjeNaarSet(
            int steenIndex, int doelSetIndex) {
        this.getPlankjeMetBeurt().verplaatsSteen(
                steenIndex,
                this.getSetOfMaakSetAan(doelSetIndex));
    }

    void speelSteenVanSetNaarSet(
            int bronSetIndex, int steenIndex, int doelSetIndex) {
        this.getSets().get(bronSetIndex).verplaatsSteen(
                steenIndex,
                this.getSetOfMaakSetAan(doelSetIndex));
        this.verwijderLegeSets();
    }

    boolean alleSetsZijnValide() {
        for (Set set : this.sets) {
            if (!set.isValide()) {
                return false;
            }
        }
        return true;
    }

    private static int stenenInSets(ArrayList<Set> sets) {
        int out = 0;
        for (Set set : sets) {
            out += set.getStenen().size();
        }
        return out;
    }

    boolean kanBeurtDoorgeven() {
        return this.alleSetsZijnValide()
                && stenenInSets(this.getSetsBijAanvangBeurt()) < stenenInSets(
                        this.getSets());
    }

    void geefBeurtDoor() {
        if (!this.kanBeurtDoorgeven()) {
            return;
        }
        this.getPlankjeMetBeurt().geefBeurtDoor();
        this.kopieerSetsNaarSetsBijAanvangBeurt();
    }

    private Set maakSetEnKeerDezeUit() {
        this.getSets().add(new Set());
        return this.getSets().get(this.getSets().size() - 1);
    }

    private void kopieerSetsNaarSetsBijAanvangBeurt() {
        setsBijAanvangBeurt = new ArrayList<Set>();
        for (Set set : this.sets) {
            setsBijAanvangBeurt.add(new Set());
            setsBijAanvangBeurt
                    .get(setsBijAanvangBeurt.size() - 1)
                    .getStenen()
                    .addAll(set.getStenen());
        }
    }

    private void verwijderLegeSets() {
        this.getSets().removeIf((Set set) -> set.getStenen().isEmpty());
    }

}
