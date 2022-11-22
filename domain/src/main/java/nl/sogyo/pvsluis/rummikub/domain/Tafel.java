package nl.sogyo.pvsluis.rummikub.domain;

import java.util.ArrayList;

class Tafel {
    private static final int MINIMALE_CIJFERSOM_VOOR_UITKOMEN = 30;
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

    int lengteSets() {
        return this.getSets().size();
    }

    ArrayList<Set> getSetsBijAanvangBeurt() {
        return setsBijAanvangBeurt;
    }

    private Set getSetOfMaakSetAan(int setIndex) {
        if (setIndex < this.lengteSets()) {
            return this.getSets().get(setIndex);
        } else {
            return this.maakSetEnKeerDezeUit();
        }
    }

    void speelSteenVanPlankjeNaarSet(
            int steenIndex, int doelSetIndex) {
        if (!this.getPlankjeMetBeurt().isUitgekomen()) {
            if (!setIsNieuwInBeurt(doelSetIndex)) {
                return;
            }
        }
        this.getPlankjeMetBeurt().verplaatsSteen(
                steenIndex,
                this.getSetOfMaakSetAan(doelSetIndex));
    }

    void speelSteenVanSetNaarSet(
            int bronSetIndex, int steenIndex, int doelSetIndex) {
        if (!this.getPlankjeMetBeurt().isUitgekomen()) {
            if (!setIsNieuwInBeurt(bronSetIndex)) {
                return;
            }
            if (!setIsNieuwInBeurt(doelSetIndex)) {
                return;
            }
        }
        this.getSets().get(bronSetIndex).verplaatsSteen(
                steenIndex,
                this.getSetOfMaakSetAan(doelSetIndex));
        this.verwijderLegeSets();
    }

    boolean steenKomtDezeBeurtVanPlankje(Steen steen) {
        return this.getPlankjeMetBeurt()
                .getStenenBijAanvangBeurt()
                .contains(steen);
    }

    boolean setIsNieuwInBeurt(int setIndex) {
        return this.getSetsBijAanvangBeurt().size() <= setIndex;
    }

    void speelSteenVanSetNaarPlankje(int bronSetIndex, int steenIndex) {
        if (!this.getPlankjeMetBeurt().isUitgekomen()) {
            if (!setIsNieuwInBeurt(bronSetIndex)) {
                return;
            }
        }
        if (steenKomtDezeBeurtVanPlankje(
                this.getSets().get(bronSetIndex).getSteen(steenIndex))) {
            this.getSets().get(bronSetIndex).verplaatsSteen(
                    steenIndex,
                    this.getPlankjeMetBeurt());
        }
    }

    boolean alleSetsZijnValide() {
        for (Set set : this.sets) {
            if (!set.isValide()) {
                return false;
            }
        }
        return true;
    }

    private static int getStenenInSets(ArrayList<Set> sets) {
        int out = 0;
        for (Set set : sets) {
            out += set.lengte();
        }
        return out;
    }

    boolean kanBeurtDoorgeven() {
        return this.alleSetsZijnValide()
                && getStenenInSets(
                        this.getSetsBijAanvangBeurt()) < getStenenInSets(
                                this.getSets());
    }

    private static int getSomCijfers(ArrayList<Set> sets) {
        // Todo: maak een methode die de som van zijn Stenencijfers telt
        // binnen de abstract class StenenContainer.
        // Deze kan dan ook gebruikt worden bij tellen score aan einde.
        int out = 0;
        for (Set set : sets) {
            for (Steen steen : set.getStenen()) {
                out += steen.getCijfer();
            }
        }
        return out;
    }

    void geefBeurtDoor() {
        if (!this.kanBeurtDoorgeven()) {
            return;
        }
        if (!this.getPlankjeMetBeurt().isUitgekomen()
                && (getSomCijfers(this.getSets()) < getSomCijfers(
                        this.getSetsBijAanvangBeurt())
                        + MINIMALE_CIJFERSOM_VOOR_UITKOMEN)) {
            return;
        }
        this.getPlankjeMetBeurt().setUitgekomen(true);
        this.getPlankjeMetBeurt().geefBeurtDoor();
        this.setsBijAanvangBeurt = kopieerSets(sets);
        this.getPlankjeMetBeurt().kopieerStenenNaarStenenBijAanvangBeurt();
    }

    private Set maakSetEnKeerDezeUit() {
        this.getSets().add(new Set());
        return this.getSets().get(this.lengteSets() - 1);
    }

    private void verwijderLegeSets() {
        this.getSets().removeIf((Set set) -> set.isLeeg());
    }

    private static ArrayList<Set> kopieerSets(
            ArrayList<Set> bronSets) {
        ArrayList<Set> out = new ArrayList<Set>();
        for (Set set : bronSets) {
            Set newSet = new Set();
            newSet.setStenen(Set.kopieerStenen(set.getStenen()));
            out.add(newSet);
        }
        return out;
    }

    public void resetSpelNaarAanvangBeurt() {
        this.sets = kopieerSets(setsBijAanvangBeurt);
        this.getPlankjeMetBeurt().resetStenenNaarAanvangBeurt();
    }

}
