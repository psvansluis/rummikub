package nl.sogyo.pvsluis.rummikub.domain;

abstract class AbstractSteen {
    private int cijfer;
    private Kleur kleur;

    enum Kleur {
        ZWART,
        KLEUR1,
        KLEUR2,
        KLEUR3;
    }

    AbstractSteen(int cijfer, Kleur kleur) {
        this.cijfer = cijfer;
        this.kleur = kleur;
    }

    int getCijfer() {
        return this.cijfer;
    }

    Kleur getKleur() {
        return this.kleur;
    }

    void setWaarde(int cijfer, Kleur kleur) {
        this.cijfer = cijfer;
        this.kleur = kleur;
    };

    abstract int getWaardeVoorScore();

    boolean isJoker() {
        return this instanceof Joker;
    }
}
