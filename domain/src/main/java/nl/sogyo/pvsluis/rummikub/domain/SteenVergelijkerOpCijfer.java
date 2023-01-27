package nl.sogyo.pvsluis.rummikub.domain;

import java.util.Comparator;

import nl.sogyo.pvsluis.rummikub.domain.Steen.Kleur;

class SteenVergelijkerOpCijfer implements Comparator<Steen> {

    public int compare(Steen steen1, Steen steen2) {
        return getWaarde(steen1) - getWaarde(steen2);
    }

    private int getWaarde(Steen steen) {
        return (steen.getCijfer() * Kleur.values().length)
                + steen.getKleur().ordinal();
    }

}
