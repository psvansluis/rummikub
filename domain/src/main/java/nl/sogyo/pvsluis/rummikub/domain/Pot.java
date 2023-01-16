package nl.sogyo.pvsluis.rummikub.domain;

import nl.sogyo.pvsluis.rummikub.domain.Steen.Kleur;

class Pot extends StenenContainer {
    private static final int AANTAL_DUPLICATE_STENEN = 2;
    private static final int HOOGST_MOGELIJKE_CIJFER = 13;
    // private static final int AANTAL_JOKERS = 2;

    private void voegAlleStenenVanEenKleurToe(Kleur kleur) {
        for (int i = 1; i <= HOOGST_MOGELIJKE_CIJFER; i++) {
            this.voegSteenToe(new Steen(i, kleur));
        }
    }

    private void voegAlleStenenToe() {
        for (Kleur kleur : Kleur.values()) {
            this.voegAlleStenenVanEenKleurToe(kleur);
        }
    }

    private void voegAlleStenenToe(int aantalKeren) {
        for (int i = 0; i < aantalKeren; i++) {
            voegAlleStenenToe();
        }
    }

    Pot(int seed) {
        this.voegAlleStenenToe(AANTAL_DUPLICATE_STENEN);
        this.schud(seed);
    }

}
