package nl.sogyo.pvsluis.rummikub.api.models;

public class SteenDTO {
    private int cijfer;
    private int kleur;

    public SteenDTO(int cijfer, int kleur) {
        this.cijfer = cijfer;
        this.kleur = kleur;
    }

    public int getCijfer() {
        return cijfer;
    }

    public int getKleur() {
        return kleur;
    }
}
