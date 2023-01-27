package nl.sogyo.pvsluis.rummikub.domain;

import nl.sogyo.pvsluis.rummikub.domain.Steen.Kleur;

class SteenVergelijkerOpCijfer extends SteenVergelijker {

    int getWaarde(Steen steen) {
        return (steen.getCijfer() * Kleur.values().length)
                + steen.getKleur().ordinal();
    }

}
