package nl.sogyo.pvsluis.rummikub.domain;

class Plankje extends StenenContainer {
    private static final int AANTAL_STENEN_BIJ_BEGIN = 14;
    private static Pot pot = new Pot();
    private static Tafel tafel = new Tafel();
    private boolean magBeurtAfsluiten;

    Plankje() {
        for (int i = 0; i < AANTAL_STENEN_BIJ_BEGIN; i++) {
            this.neemSteenUitPot();
        }
    }

    void neemSteenUitPot() {
        Plankje.pot.verplaatsSteen(0, this);
    }
}
