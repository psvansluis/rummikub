package nl.sogyo.pvsluis.rummikub.domain;

class Speler {
    private boolean heeftBeurt;
    private Speler volgendeSpeler;
    private Plankje plankje;

    Speler(boolean heeftBeurt) {
        this.heeftBeurt = heeftBeurt;
        this.plankje = new Plankje();
    }

    Plankje getPlankje() {
        return this.plankje;
    }

}
