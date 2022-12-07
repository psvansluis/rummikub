package nl.sogyo.pvsluis.rummikub.domain;

import java.util.ArrayList;
import java.util.Collections;

abstract class StenenContainer {
    private ArrayList<Steen> stenen;

    ArrayList<Steen> getStenen() {
        return this.stenen;
    }

    StenenContainer() {
        this.setStenen(new ArrayList<Steen>());
    }

    void setStenen(ArrayList<Steen> stenen) {
        this.stenen = stenen;
    }

    void voegSteenToe(Steen toeTeVoegenSteen) {
        this.stenen.add(toeTeVoegenSteen);
    }

    void verplaatsSteen(Steen teVerplaatsenSteen, StenenContainer doel) {
        this.verwijderSteen(teVerplaatsenSteen);
        doel.voegSteenToe(teVerplaatsenSteen);
    }

    void verplaatsSteen(int index, StenenContainer doel) {
        Steen steenOpIndex = this.stenen.get(index);
        doel.voegSteenToe(steenOpIndex);
        this.verwijderSteen(index);
    }

    private void verwijderSteen(Steen teVerwijderenSteen) {
        this.stenen.remove(teVerwijderenSteen);
    }

    private void verwijderSteen(int index) {
        this.stenen.remove(index);
    }

    void schud() {
        Collections.shuffle(this.stenen);
    }

    void sorteer() {
        Collections.sort(this.stenen);
    }

    @SuppressWarnings("unchecked")
    static ArrayList<Steen> kopieerStenen(ArrayList<Steen> bronStenen) {
        return (ArrayList<Steen>) bronStenen.clone();
    }

    boolean isLeeg() {
        return this.getStenen().isEmpty();
    }

    Steen getSteen(int index) {
        return this.getStenen().get(index);
    }

    int lengte() {
        return this.getStenen().size();
    }

}
