package nl.sogyo.pvsluis.rummikub.domain;

class Steen extends AbstractSteen {

    Steen(int cijfer, Kleur kleur) {
        super(cijfer, kleur);
    }

    void setWaarde(int cijfer, Kleur kleur) {
    }

    int getWaardeVoorScore() {
        return this.getCijfer();
    }
}
