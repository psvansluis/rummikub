package nl.sogyo.pvsluis.rummikub.domain;

class Steen implements Comparable<Steen> {
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

    private int waardeInVolgorde() {
        return (this.cijfer * Kleur.values().length) + this.kleur.ordinal();
    }

    public int compareTo(Steen andereSteen) {
        return this.waardeInVolgorde() - andereSteen.waardeInVolgorde();
    }
}
