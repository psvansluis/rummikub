package nl.sogyo.pvsluis.rummikub.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

import nl.sogyo.pvsluis.rummikub.domain.Steen.Kleur;

abstract class StenenContainer {
    private ArrayList<Steen> stenen = new ArrayList<Steen>();

    ArrayList<Steen> getStenen() {
        return this.stenen;
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
        this.stenen.sort(Comparator
                .comparing(Steen::getCijfer)
                .thenComparing(Steen::getKleur)
                .thenComparing(Steen::isJoker));
    }

    void sorteerOpKleur() {
        this.stenen.sort(Comparator
                .comparing(Steen::getKleur)
                .thenComparing(Steen::getCijfer)
                .thenComparing(Steen::isJoker));
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

    void setJokerWaarde(int index, int cijfer, Kleur kleur) {
        if (!this.getSteen(index).isJoker()) {
            return;
        }
        Joker joker = (Joker) this.getSteen(index);
        joker.setWaarde(cijfer, kleur);
    }

    int lengte() {
        return this.getStenen().size();
    }

}
