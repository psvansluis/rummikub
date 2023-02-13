package nl.sogyo.pvsluis.rummikub.domain;

import java.util.ArrayList;

class Plankje extends StenenContainer {
    private static final int AANTAL_STENEN_BIJ_BEGIN = 14;
    private boolean heeftBeurt;
    private boolean uitgekomen;
    private Plankje volgendePlankje;
    private ArrayList<Steen> stenenBijAanvangBeurt;

    private Plankje(Pot pot) {
        for (int i = 0; i < AANTAL_STENEN_BIJ_BEGIN; i++) {
            this.neemSteenUitPot(pot);
        }
        this.stenenBijAanvangBeurt = new ArrayList<Steen>();
        this.kopieerStenenNaarStenenBijAanvangBeurt();
    }

    private Plankje(int aantalPlankjes, Pot pot, Plankje eerstePlankje) {
        this(pot);
        this.heeftBeurt = false;
        if (aantalPlankjes > 1) {
            this.volgendePlankje = new Plankje(
                    aantalPlankjes - 1, pot, eerstePlankje);
        } else {
            this.volgendePlankje = eerstePlankje;
        }
    }

    Plankje(int aantalPlankjes, Pot pot) {
        this(pot);
        this.heeftBeurt = true;
        if (aantalPlankjes > 1) {
            this.volgendePlankje = new Plankje(aantalPlankjes - 1, pot, this);
        } else {
            this.volgendePlankje = this;
        }
    }

    void neemSteenUitPot(Pot pot) {
        pot.verplaatsSteen(0, this);
    }

    boolean isUitgekomen() {
        return this.uitgekomen;
    }

    void setUitgekomen(boolean uitgekomen) {
        this.uitgekomen = uitgekomen;
    }

    ArrayList<Steen> getStenenBijAanvangBeurt() {
        return this.stenenBijAanvangBeurt;
    }

    Plankje getVolgendePlankje() {
        return this.volgendePlankje;
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

    void kopieerStenenNaarStenenBijAanvangBeurt() {
        this.stenenBijAanvangBeurt = kopieerStenen(this.getStenen());
    }

    void resetStenenNaarAanvangBeurt() {
        this.setStenen(kopieerStenen(this.stenenBijAanvangBeurt));
    }
}
