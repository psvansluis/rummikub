package nl.sogyo.pvsluis.rummikub.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import nl.sogyo.pvsluis.rummikub.domain.AbstractSteen.Kleur;

public class UitkomenTest {
    private static Tafel testSpel1() {
        Tafel test = new Tafel(2, 1);
        test.getPlankjeMetBeurt().voegSteenToe(new Steen(10, Kleur.ZWART));
        test.getPlankjeMetBeurt().voegSteenToe(new Steen(11, Kleur.ZWART));
        test.getPlankjeMetBeurt().voegSteenToe(new Steen(12, Kleur.ZWART));
        test.getPlankjeMetBeurt().voegSteenToe(new Steen(1, Kleur.KLEUR1));
        test.getPlankjeMetBeurt().voegSteenToe(new Steen(2, Kleur.KLEUR1));
        test.getPlankjeMetBeurt().voegSteenToe(new Steen(3, Kleur.KLEUR1));
        return test;
    }

    private static Tafel testSpel2() {
        Tafel test = new Tafel(2, 1);
        test.getPlankjeMetBeurt().voegSteenToe(new Steen(7, Kleur.ZWART));
        test.getPlankjeMetBeurt().voegSteenToe(new Steen(8, Kleur.ZWART));
        test.getPlankjeMetBeurt().voegSteenToe(new Steen(9, Kleur.ZWART));
        test.getPlankjeMetBeurt().voegSteenToe(new Steen(1, Kleur.KLEUR1));
        test.getPlankjeMetBeurt().voegSteenToe(new Steen(2, Kleur.KLEUR1));
        test.getPlankjeMetBeurt().voegSteenToe(new Steen(3, Kleur.KLEUR1));
        return test;
    }

    @Test
    public void eenSpelerKanUitkomen() {
        Tafel test = testSpel1();
        test.speelSteen(-1, 14, 0);
        test.speelSteen(-1, 14, 0);
        test.speelSteen(-1, 14, 0);
        test.geefBeurtDoor();
        assertTrue(test.getEerstePlankje().isUitgekomen());
    }

    @Test
    public void eenSpelerKanNietUitkomenBijInvalideSets() {
        Tafel test = testSpel1();
        test.speelSteen(-1, 14, 0);
        test.speelSteen(-1, 14, 0);
        test.speelSteen(-1, 14, 0);
        test.speelSteen(-1, 14, 0);
        test.geefBeurtDoor();
        assertFalse(test.getEerstePlankje().isUitgekomen());
    }

    @Test
    public void eenSpelerKanNietUitkomenDoorTeWeinigPunten() {
        Tafel test = testSpel1();
        test.speelSteen(-1, 17, 0);
        test.speelSteen(-1, 17, 0);
        test.speelSteen(-1, 17, 0);
        test.geefBeurtDoor();
        assertFalse(test.getEerstePlankje().isUitgekomen());
    }

    @Test
    public void eenSpelerKomtUitMetTweeSets() {
        Tafel test = testSpel2();
        test.speelSteen(-1, 14, 0);
        test.speelSteen(-1, 14, 0);
        test.speelSteen(-1, 14, 0);
        test.speelSteen(-1, 14, 1);
        test.speelSteen(-1, 14, 1);
        test.speelSteen(-1, 14, 1);
        test.geefBeurtDoor();
        assertTrue(test.getEerstePlankje().isUitgekomen());
    }

    @Test
    public void eenNietUitgekomenSpelerMagNietSpelenOpBestaandeSet() {
        Tafel test = testSpel1();
        test.speelSteen(-1, 14, 0);
        test.speelSteen(-1, 14, 0);
        test.speelSteen(-1, 14, 0);
        test.geefBeurtDoor();
        test.speelSteen(-1, 0, 0);
        assertEquals(3, test.getSets().get(0).lengte());
    }

    @Test
    public void eenNietUitgekomenSpelerMagWelSpelenOpNieuweSet() {
        Tafel test = testSpel1();
        test.speelSteen(-1, 14, 0);
        test.speelSteen(-1, 14, 0);
        test.speelSteen(-1, 14, 0);
        test.geefBeurtDoor();
        test.speelSteen(-1, 0, 1);
        assertEquals(1, test.getSets().get(1).lengte());
    }

    @Test
    public void eenUitgekomenSpelerMagSpelenOpBestaandeSet() {
        Tafel test = testSpel1();
        test.speelSteen(-1, 14, 0);
        test.speelSteen(-1, 14, 0);
        test.speelSteen(-1, 14, 0);
        test.geefBeurtDoor();
        test.getPlankjeMetBeurt().voegSteenToe(new Steen(10, Kleur.ZWART));
        test.getPlankjeMetBeurt().voegSteenToe(new Steen(11, Kleur.ZWART));
        test.getPlankjeMetBeurt().voegSteenToe(new Steen(12, Kleur.ZWART));
        test.speelSteen(-1, 14, 1);
        test.speelSteen(-1, 14, 1);
        test.speelSteen(-1, 14, 1);
        test.geefBeurtDoor();
        test.speelSteen(0, 0, 1);
        assertEquals(4, test.getSets().get(1).lengte());
    }

    @Test
    public void eenNietUitgekomenSpelerMagNietVanEenBestaandeSetSpelen() {
        Tafel test = testSpel1();
        test.speelSteen(-1, 14, 0);
        test.speelSteen(-1, 14, 0);
        test.speelSteen(-1, 14, 0);
        test.geefBeurtDoor();
        test.speelSteen(0, 0, 1);
        assertEquals(3, test.getSets().get(0).lengte());
    }

    @Test
    public void eenNietUitgekomenSpelerMagNietNaarEenBestaandeSetSpelen() {
        Tafel test = testSpel1();
        test.speelSteen(-1, 14, 0);
        test.speelSteen(-1, 14, 0);
        test.speelSteen(-1, 14, 0);
        test.geefBeurtDoor();
        test.speelSteen(-1, 0, 1);
        test.speelSteen(1, 0, 0);
        assertEquals(1, test.getSets().get(1).lengte());

    }
}
