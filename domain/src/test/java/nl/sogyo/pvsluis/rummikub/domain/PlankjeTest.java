package nl.sogyo.pvsluis.rummikub.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PlankjeTest {

    @Test
    public void eenNieuwPlankjeBegintMet14Stenen() {
        Plankje p = new Plankje(1);
        assertEquals(14, p.lengte());
    }

    @Test
    public void eenPlankjeDatMeteenEenSteenpaktHeeft15StenenOpZijnPlankje() {
        Plankje p = new Plankje(1);
        p.neemSteenUitPot();
        assertEquals(15, p.lengte());
    }

    @Test
    public void bijEenSpelMet1PlankjeHeeftPlankjeZichzelfAlsVolgende() {
        Plankje p = new Plankje(1);
        assertEquals(p, p.getVolgendePlankje());
    }

    @Test
    public void tweePlankjesHebbenDezelfdePot() {
        Plankje p = new Plankje(2);
        assertEquals(p.getPot(), p.getVolgendePlankje().getPot());
    }

    @Test
    public void getVolgendePlankjeMetIntegerWerkt() {
        Plankje p = new Plankje(6);
        assertEquals(
                p.getVolgendePlankje().getVolgendePlankje(),
                p.getVolgendePlankje(2));
    }

    @Test
    public void bijDriePlankjesIsHetEerstePlankjeZijnDerdeVolgendePlankje() {
        Plankje p = new Plankje(3);
        assertEquals(p, p.getVolgendePlankje(3));
    }

    @Test
    public void deBeurtLigtBijTweedePlankjeNaDoorgevenBeurt() {
        Plankje p = new Plankje(3);
        p.geefBeurtDoor();
        assertTrue(p.getVolgendePlankje().getBeurt());
    }

    @Test
    public void deTweedeSpelerIsDegeneMetBeurtNaDoorgevenBeurt() {
        Plankje p = new Plankje(3);
        p.geefBeurtDoor();
        assertEquals(p.getVolgendePlankje(), p.getPlankjeMetBeurt());
    }

    @Test
    public void getVolgendePlankje0GeeftZichzelf() {
        Plankje p = new Plankje(4);
        assertEquals(p, p.getVolgendePlankje(0));
    }

}
