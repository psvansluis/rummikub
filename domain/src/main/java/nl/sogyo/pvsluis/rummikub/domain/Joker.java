package nl.sogyo.pvsluis.rummikub.domain;

class Joker extends Steen {
    private static final int WAARDE_JOKER_VOOR_SCORE = 30;
    private Steen steen;

    Joker() {
        super(1, Kleur.ZWART);
        this.steen = this;
    }

    void setWaarde(int cijfer, Kleur kleur) {
        this.steen = new Steen(cijfer, kleur);
    }

    @Override
    int getCijfer() {
        return this.steen.getCijfer();
    }

    @Override
    Kleur getKleur() {
        return this.steen.getKleur();
    }

    @Override
    int getWaardeVoorScore() {
        return WAARDE_JOKER_VOOR_SCORE;
    }

}
