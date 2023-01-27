package nl.sogyo.pvsluis.rummikub.domain;

class SteenVergelijkerOpKleur extends SteenVergelijker {
    private int hoogsteCijferwaarde;

    SteenVergelijkerOpKleur(int hoogsteCijferwaarde) {
        this.hoogsteCijferwaarde = hoogsteCijferwaarde;
    }

    int getWaarde(Steen steen) {
        return steen.getCijfer()
                + (steen.getKleur().ordinal() * this.hoogsteCijferwaarde);
    }
}
