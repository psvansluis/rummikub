package nl.sogyo.pvsluis.rummikub.domain;

class Steen {
    private int cijfer;
    private Kleur kleur;
    private SteenGedrag steenGedrag;

    enum Kleur {
        ZWART,
        KLEUR1,
        KLEUR2,
        KLEUR3;
    }

    Steen(int cijfer, Kleur kleur) {
        this.cijfer = cijfer;
        this.kleur = kleur;
        this.steenGedrag = new NormaleSteenGedrag(this);
    }

    Steen() {
        this.steenGedrag = new JokerGedrag();
    }

    int getCijfer() {
        return this.cijfer;
    }

    Kleur getKleur() {
        return this.kleur;
    }

    boolean isJoker() {
        return this.steenGedrag.isJoker();
    }

}
