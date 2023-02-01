package nl.sogyo.pvsluis.rummikub.domain;

import java.util.ArrayList;

import nl.sogyo.pvsluis.rummikub.domain.Steen.Kleur;

class Tafel {
    private static final int MINIMALE_CIJFERSOM_VOOR_UITKOMEN = 30;
    private ArrayList<Set> sets;
    private ArrayList<Set> setsBijAanvangBeurt;
    private Plankje eerstePlankje;

    Tafel(int aantalPlankjes, int seed) {
        sets = new ArrayList<Set>();
        setsBijAanvangBeurt = new ArrayList<Set>();
        eerstePlankje = new Plankje(aantalPlankjes, seed);
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
        return setIndex < this.lengteSets()
                ? this.getSets().get(setIndex)
                : this.maakSetEnKeerDezeUit();
    }

    StenenContainer getStenenContainerOfMaakAan(int containerIndex) {
        return containerIndex < 0
                ? this.getPlankjeMetBeurt()
                : this.getSetOfMaakSetAan(containerIndex);
    }

    private boolean setMagBewerktWorden(int setIndex) {
        if (this.getPlankjeMetBeurt().isUitgekomen()) {
            return true;
        }
        return this.isNieuweSetInBeurt(setIndex);
    }

    void setJokerWaarde(
            int containerIndex, int steenIndex, int cijfer, Kleur kleur) {
        if (!this.setMagBewerktWorden(containerIndex)) {
            return;
        }
        this.getStenenContainerOfMaakAan(containerIndex)
                .setJokerWaarde(steenIndex, cijfer, kleur);
    }

    void speelSteen(
            int bronContainerIndex,
            int steenIndex,
            int doelContainerIndex) {
        if (doelContainerIndex < 0 && !this.steenKomtDezeBeurtVanPlankje(
                bronContainerIndex, steenIndex)) {
            return;
        }
        if (!this.setMagBewerktWorden(doelContainerIndex)
                || !this.setMagBewerktWorden(bronContainerIndex)) {
            return;
        }

        this.getStenenContainerOfMaakAan(bronContainerIndex)
                .verplaatsSteen(steenIndex,
                        this.getStenenContainerOfMaakAan(doelContainerIndex));

        this.verwijderLegeSets();
    }

    boolean steenKomtDezeBeurtVanPlankje(Steen steen) {
        return this.getPlankjeMetBeurt()
                .getStenenBijAanvangBeurt()
                .contains(steen);
    }

    boolean steenKomtDezeBeurtVanPlankje(int setIndex, int steenIndex) {
        if (setIndex < 0) {
            return true;
        }
        return this.steenKomtDezeBeurtVanPlankje(
                this.getSets().get(setIndex).getSteen(steenIndex));
    }

    boolean isNieuweSetInBeurt(int setIndex) {
        if (setIndex < 0) {
            return true;
        }
        return setIndex >= this.getSetsBijAanvangBeurt().size();
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
                && this.kanUitkomenOfHoeftNiet()
                && getStenenInSets(
                        this.getSetsBijAanvangBeurt()) < getStenenInSets(
                                this.getSets());
    }

    boolean kanUitkomenOfHoeftNiet() {
        return this.getPlankjeMetBeurt().isUitgekomen()
                || (getSomCijfers(this.getSets()) >= getSomCijfers(
                        this.getSetsBijAanvangBeurt())
                        + MINIMALE_CIJFERSOM_VOOR_UITKOMEN);
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
        this.geefBeurtDoor(true);
    }

    void geefBeurtDoor(boolean gevalideerd) {
        if (gevalideerd) {
            if (!this.kanBeurtDoorgeven()) {
                return;
            }
            this.getPlankjeMetBeurt().setUitgekomen(true);
        }
        this.getPlankjeMetBeurt().geefBeurtDoor();
        this.setsBijAanvangBeurt = kopieerSets(this.sets);
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

    public void eindigBeurtDoorSteenTeNemen() {
        this.resetSpelNaarAanvangBeurt();
        this.getPlankjeMetBeurt().neemSteenUitPot();
        this.geefBeurtDoor(false);
    }

}
