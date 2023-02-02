package nl.sogyo.pvsluis.rummikub.api.models;

public class SetJokerDTO {
    private int containerIndex;
    private int steenIndex;
    private int cijfer;
    private int kleur;

    public int getContainerIndex() {
        return containerIndex;
    }

    public void setContainerIndex(int containerIndex) {
        this.containerIndex = containerIndex;
    }

    public int getSteenIndex() {
        return steenIndex;
    }

    public void setSteenIndex(int steenIndex) {
        this.steenIndex = steenIndex;
    }

    public int getCijfer() {
        return cijfer;
    }

    public void setCijfer(int cijfer) {
        this.cijfer = cijfer;
    }

    public int getKleur() {
        return kleur;
    }

    public void setKleur(int kleur) {
        this.kleur = kleur;
    }

}
