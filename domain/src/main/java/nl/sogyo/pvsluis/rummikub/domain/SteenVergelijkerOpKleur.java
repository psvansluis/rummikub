package nl.sogyo.pvsluis.rummikub.domain;

import java.util.Comparator;

class SteenVergelijkerOpKleur implements Comparator<Steen> {
    private int hoogsteCijferwaarde;

    SteenVergelijkerOpKleur(int hoogsteCijferwaarde) {
        this.hoogsteCijferwaarde = hoogsteCijferwaarde;
    }

    public int compare(Steen steen1, Steen steen2) {
        return getWaarde(steen1) - getWaarde(steen2);
    }

    private int getWaarde(Steen steen) {
        return steen.getCijfer()
                + (steen.getKleur().ordinal() * this.hoogsteCijferwaarde);
    }
}
