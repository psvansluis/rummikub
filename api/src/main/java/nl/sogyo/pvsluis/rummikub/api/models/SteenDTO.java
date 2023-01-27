package nl.sogyo.pvsluis.rummikub.api.models;

public class SteenDTO {
    private int cijfer;
    private int kleur;
    private boolean joker;

    public SteenDTO(int cijfer, int kleur, int joker) {
        this.cijfer = cijfer;
        this.kleur = kleur;
        this.joker = joker == 1;
    }

    public int getCijfer() {
        return cijfer;
    }

    public int getKleur() {
        return kleur;
    }

    public boolean getJoker() {
        return joker;
    }
}
