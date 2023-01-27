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

    private void sorteer(SteenVergelijker vergelijker) {
        Collections.sort(this.stenen, vergelijker);
    }

    void sorteerOpCijfer() {
        this.sorteer(new SteenVergelijkerOpCijfer());
    }

    void sorteerOpKleur() {
        this.sorteer(new SteenVergelijkerOpKleur(this.getHoogsteCijfer()));
    }

    private int getHoogsteCijfer() {
        return Collections.max(
                this.stenen,
                new SteenVergelijkerOpCijfer())
                .getCijfer();
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
