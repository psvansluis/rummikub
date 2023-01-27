package nl.sogyo.pvsluis.rummikub.domain;

public class Joker extends Steen {
    private static final int WAARDE_JOKER_VOOR_EINDSCORE = 30;

    Joker() {
        super(1, Kleur.ZWART);
    }

    int getWaardeVoorScore() {
        return WAARDE_JOKER_VOOR_EINDSCORE;
    }
}
