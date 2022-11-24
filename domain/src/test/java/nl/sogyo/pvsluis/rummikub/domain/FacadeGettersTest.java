package nl.sogyo.pvsluis.rummikub.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.containsString;

import java.util.ArrayList;

import org.junit.Test;

public class FacadeGettersTest {

    private static ArrayList<String> spelernamen = new ArrayList<String>() {
        {
            add("Henk");
            add("Toos");
        }
    };

    private static Rummikub testSpel() {
        Rummikub test = new Rummikub(spelernamen);
        return test;
    }

    @Test
    public void testGetNaamSpelerMetBeurt() {
        Rummikub test = testSpel();
        assertThat(test.getNaamSpelerMetBeurt(), containsString("Henk"));
    }

    @Test
    public void testGetStenenOpPlankjeMetBeurt() {
        Rummikub test = testSpel();
        assertEquals(14, test.getStenenOpPlankjeMetBeurt().size());
    }

    @Test
    public void potHeeft14MinderStenenBijEenSpelerMeerBijAanvangSpel() {
        ArrayList<String> henk = new ArrayList<String>() {
            {
                add("Henk");
            }
        };
        Rummikub henkspel = new Rummikub(henk);
        Rummikub henkToosSpel = testSpel();
        assertEquals(
                henkspel.aantalStenenInPot() - 14,
                henkToosSpel.aantalStenenInPot());
    }

    @Test
    public void bijBeginSpelKanDeSpelerZijnBeurtNietAfsluiten() {
        Rummikub test = testSpel();
        assertFalse(test.kanBeurtDoorgeven());
    }

    @Test
    public void getValiditeitSetsIsAanvankelijkLeeg() {
        Rummikub test = testSpel();
        assertEquals(0, test.getValiditeitSets().size());
    }

    @Test
    public void spelenVanEenSteenGeeftEenInvalideSet() {
        Rummikub test = testSpel();
        test.speelSteen(-1, 0, 0);
        assertFalse(test.getValiditeitSets().get(0));
    }

    @Test
    public void spelenVanEenSteenGeeftEenSetMetEenSteen() {
        Rummikub test = testSpel();
        test.speelSteen(-1, 0, 0);
        assertEquals(1, test.getStenenOpTafel().get(0).size());
    }

    @Test
    public void bijAanvangSpelIsSpelerMetBeurtNietUitgekomen() {
        Rummikub test = testSpel();
        assertFalse(test.spelerMetBeurtIsUitgekomen());
    }

    @Test
    public void bijAanvangSpelIsSpelNietAfgelopen() {
        Rummikub test = testSpel();
        assertFalse(test.spelIsAfgelopen());
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
}
