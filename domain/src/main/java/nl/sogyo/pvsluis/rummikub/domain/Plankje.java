package nl.sogyo.pvsluis.rummikub.domain;

class Plankje extends StenenContainer {
    private static final int AANTAL_STENEN_BIJ_BEGIN = 14;
    private Pot pot;
    private boolean heeftBeurt;
    private Plankje volgendePlankje;

    private Plankje() {
        this(new Pot());
        this.heeftBeurt = true;
    }

    private Plankje(Pot pot) {
        this.heeftBeurt = false;
        this.pot = pot;
        for (int i = 0; i < AANTAL_STENEN_BIJ_BEGIN; i++) {
            this.neemSteenUitPot();
        }
    }

    Plankje(int aantalPlankjes) {
        this();
        int teMakenPlankjes = aantalPlankjes;
        while (teMakenPlankjes > 1) {
            this
                    .getPlankjeZonderVolgendePlankje()
                    .setVolgendePlankje(new Plankje(this.pot));
            teMakenPlankjes--;
        }
        this.getPlankjeZonderVolgendePlankje().setVolgendePlankje(this);
    }

    void neemSteenUitPot() {
        this.getPot().verplaatsSteen(0, this);
    }

    Pot getPot() {
        return pot;
    }

    Plankje getVolgendePlankje() {
        return volgendePlankje;
    }

    Plankje getPlankjeZonderVolgendePlankje() {
        if (this.getVolgendePlankje() == null) {
            return this;
        } else {
            return this.getVolgendePlankje().getPlankjeZonderVolgendePlankje();
        }
    }

    void setVolgendePlankje(Plankje volgendePlankje) {
        this.volgendePlankje = volgendePlankje;
    }

    Plankje getVolgendePlankje(int afstand) {
        if (afstand < 1) {
            return this;
        } else if (afstand == 1) {
            return this.getVolgendePlankje();
        } else {
            return this.getVolgendePlankje().getVolgendePlankje(afstand - 1);
        }
    }

    Plankje getPlankjeMetBeurt() {
        if (this.heeftBeurt) {
            return this;
        } else {
            return this.volgendePlankje.getPlankjeMetBeurt();
        }
    }

    void geefBeurtDoor() {
        this.heeftBeurt = false;
        this.volgendePlankje.heeftBeurt = true;
    }

    boolean getBeurt() {
        return this.heeftBeurt;
    }
}