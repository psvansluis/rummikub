package nl.sogyo.pvsluis.rummikub.api.models;

public class SpelerInputDTO {
    private String[] spelerNamen;
    private int seed;

    public int getSeed() {
        return this.seed;
    }

    public void setSeed(int seed) {
        this.seed = seed;
    }

    public String[] getSpelerNamen() {
        return spelerNamen;
    }

    public void setSpelerNamen(String[] spelerNamen) {
        this.spelerNamen = spelerNamen;
    }
}
