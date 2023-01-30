package nl.sogyo.pvsluis.rummikub.domain;

public class JokerGedrag implements SteenGedrag {
    private static final int WAARDE_SCORE_JOKER = 30;

    public int getWaardeVoorScore() {
        return WAARDE_SCORE_JOKER;
    }

    public void setWaarde() throws Exception {

    }

    public boolean isJoker() {
        return true;
    }

}
