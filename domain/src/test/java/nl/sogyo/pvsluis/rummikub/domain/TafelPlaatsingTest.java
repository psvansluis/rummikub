package nl.sogyo.pvsluis.rummikub.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TafelPlaatsingTest {
    // Alle verplaatsingen van:
    // - Een Set size 1
    // - Een Set size >1
    // - Een Plankje
    // En naar:
    // - Een bestaande Set
    // - Een nieuwe Set
    // Check volgende eigenschappen:
    // - Verwijdering uit bronSet
    // - Toevoeging aan doelSet
    // - Verwijdering lege Sets

    @Test
    public void setsIsLeegBijNieuwSpel() {
        Tafel tafel = new Tafel(1);

        assertTrue(tafel.getSets().isEmpty());
    }

    private static Tafel voorbeeldSpel1() {
        Tafel tafel = new Tafel(2);
        tafel.speelSteenVanPlankjeNaarNieuweSet(0);
        return tafel;
    }

    @Test
    public void vanPlankjeNaarNieuweSetVerwijdertVanPlankje() {
        Tafel test = voorbeeldSpel1();

        assertEquals(13, test.getPlankjeMetBeurt().getStenen().size());
    }

    @Test
    public void vanPlankjeNaarNieuweSetMaaktSetAan() {
        Tafel test = voorbeeldSpel1();

        assertEquals(1, test.getSets().size());
    }

    private static Tafel voorbeeldSpel2() {
        Tafel tafel = new Tafel(2);
        tafel.speelSteenVanPlankjeNaarNieuweSet(0);
        tafel.speelSteenVanPlankjeNaarBestaandeSet(0, 0);
        return tafel;
    }

    @Test
    public void vanPlankjeNaarBestaandeSetVerwijdertVanPlankje() {
        Tafel test = voorbeeldSpel2();

        assertEquals(12, test.getPlankjeMetBeurt().getStenen().size());
    }

    @Test
    public void vanPlankjeNaarBestaandeSetVergrootBestaandeSet() {
        Tafel test = voorbeeldSpel2();

        assertEquals(2, test.getSets().get(0).getStenen().size());
    }

    @Test
    public void vanSetNaarNieuweSetVerkleintOudeSet() {
        Tafel test = voorbeeldSpel2();
        test.speelSteenVanSetNaarNieuweSet(0, 0);

        assertEquals(1, test.getSets().get(0).getStenen().size());
    }

    @Test
    public void vanSetNaarNieuweSetMaaktSetErbij() {
        Tafel test = voorbeeldSpel2();
        test.speelSteenVanSetNaarNieuweSet(0, 0);

        assertEquals(2, test.getSets().size());
    }

    @Test
    public void vanSetNaarBestaandeSetGeeft2StenenInDoelSet() {
        Tafel test = voorbeeldSpel2();
        test.speelSteenVanSetNaarNieuweSet(0, 0);
        test.speelSteenVanSetNaarBestaandeSet(1, 0, 0);

        assertEquals(2, test.getSets().get(0).getStenen().size());
    }

    @Test
    public void vanSetSize1NaarNieuweSetVerwijdertSet() {
        Tafel test = voorbeeldSpel1();
        test.speelSteenVanSetNaarNieuweSet(0, 0);

        assertEquals(1, test.getSets().size());
    }

}
