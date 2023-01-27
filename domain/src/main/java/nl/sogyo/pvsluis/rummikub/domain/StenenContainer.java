package nl.sogyo.pvsluis.rummikub.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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

    void verwijderSteen(Steen teVerwijderenSteen) {
        this.stenen.remove(teVerwijderenSteen);
    }

    void verwijderSteen(int index) {
        this.stenen.remove(index);
    }

    void schud(int seed) {
        Random random = new Random(seed);
        Collections.shuffle(this.stenen, random);
    }

    void sorteerOpCijfer() {
        Collections.sort(this.stenen, new SteenVergelijkerOpCijfer());
    }

    void sorteerOpKleur() {
        Collections.sort(
                this.stenen,
                new SteenVergelijkerOpKleur(this.getHoogsteCijfer()));
    }

    private int getHoogsteCijfer() {
        int max = 0;
        for (Steen steen : this.stenen) {
            if (steen.getCijfer() > max) {
                max = steen.getCijfer();
            }
        }
        return max;
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
