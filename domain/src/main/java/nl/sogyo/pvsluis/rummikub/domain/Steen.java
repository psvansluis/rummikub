package nl.sogyo.pvsluis.rummikub.domain;

class Steen {
    private int cijfer;
    private Kleur kleur;

    enum Kleur {
        ZWART,
        KLEUR1,
        KLEUR2,
        KLEUR3;
    }

    Steen(int cijfer, Kleur kleur) {
        this.cijfer = cijfer;
        this.kleur = kleur;
    }

    int getCijfer() {
        return this.cijfer;
    }

    Kleur getKleur() {
        return this.kleur;
    }

}
