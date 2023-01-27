package nl.sogyo.pvsluis.rummikub.domain;

import java.util.Comparator;

abstract class SteenVergelijker implements Comparator<Steen> {
    public int compare(Steen steen1, Steen steen2) {
        return getWaarde(steen1) - getWaarde(steen2);
    }

    abstract int getWaarde(Steen steen);
}
