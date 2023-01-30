package nl.sogyo.pvsluis.rummikub.domain;

interface SteenGedrag {
    int getWaardeVoorScore();

    void setWaarde() throws Exception;

    boolean isJoker();
}
