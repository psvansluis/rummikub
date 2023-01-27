package nl.sogyo.pvsluis.rummikub.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class FacadeSettersTest {

    private static ArrayList<String> spelernamen = new ArrayList<String>() {
        {
            add("Henk");
            add("Toos");
        }
    };

    private static Rummikub testSpel() {
        Rummikub test = new Rummikub(spelernamen, 2);
        return test;

    }

    private static Rummikub testSpel(int seed) {
        Rummikub test = new Rummikub(spelernamen, seed);
        return test;

    }

    @Test
    public void spelenVanEenSteenGeeftEenInvalideSet() {
        Rummikub test = testSpel();
        test.speelSteen(-1, 0, 0);
        assertFalse(test.getValiditeitSets().get(0));
    }

    @Test
    public void spelenVanContainerNaarZichzelfMoetKunnen() {
        Rummikub test = testSpel();
        test.speelSteen(-1, 0, -1);
        assertEquals(14, test.getStenenOpPlankjeMetBeurt().size());
    }

    @Test
    public void spelenVanSteenVanPlankjeNaarSetNaarPlankjeMoetKunnen() {
        Rummikub test = testSpel();
        test.speelSteen(-1, 0, 0);
        test.speelSteen(0, 0, -1);
        assertEquals(14, test.getStenenOpPlankjeMetBeurt().size());
    }

    @Test
    public void spelenVanEenSteenGeeftEenSetMetEenSteen() {
        Rummikub test = testSpel();
        test.speelSteen(-1, 0, 0);
        assertEquals(1, test.getStenenOpTafel().get(0).size());
    }

    @Test
    public void resetSpelNaarAanvangBeurtZorgtBijBeginVoorLeegBord() {
        Rummikub test = testSpel();
        test.speelSteen(-1, 0, 0);
        test.resetSpelNaarAanvangBeurt();
        assertEquals(0, test.getStenenOpTafel().size());
    }

    @Test
    public void bijNemenSteenUitPotIsTweedeSpelerAanDeBeurt() {
        Rummikub test = testSpel();
        test.neemSteenUitPot();
        assertTrue(test.getNaamSpelerMetBeurt().equals("Toos"));
    }

    @Test
    public void nemenSteenUitPotKanTweeKeerAchterElkaar() {
        Rummikub test = testSpel();
        test.neemSteenUitPot();
        test.neemSteenUitPot();
        assertTrue(test.getNaamSpelerMetBeurt().equals("Henk"));
    }

    @Test
    public void bijNemenSteenUitPotResetTafel() {
        Rummikub test = testSpel();
        test.speelSteen(-1, 0, 0);
        test.neemSteenUitPot();
        assertEquals(0, test.getStenenOpTafel().size());
    }

    @Test
    public void sluitBeurtAfKanWel() {
        Rummikub test = testSpel(5);
        test.speelSteen(-1, 11, 0);
        test.speelSteen(-1, 6, 0);
        test.speelSteen(-1, 1, 0);
        test.sluitBeurtAf();
        assertTrue(
                "Na succesvol doorgeven beurt moet Toos aan de beurt zijn",
                test.getNaamSpelerMetBeurt().equals("Toos"));
    }

    @Test
    public void sluitBeurtAfKanNiet() {
        Rummikub test = testSpel();
        test.speelSteen(-1, 11, 0);
        test.speelSteen(-1, 10, 0);
        test.speelSteen(-1, 8, 0);
        test.sluitBeurtAf();
        assertTrue(
                "Na onsuccesvol doorgeven beurt moet Henk aan de beurt zijn",
                test.getNaamSpelerMetBeurt().equals("Henk"));
    }

}
