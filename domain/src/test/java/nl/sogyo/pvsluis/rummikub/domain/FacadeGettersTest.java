package nl.sogyo.pvsluis.rummikub.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.hamcrest.CoreMatchers.containsString;

import java.util.ArrayList;

import org.junit.Test;

public class FacadeGettersTest {

    private static ArrayList<String> spelernamen = new ArrayList<String>() {
        {
            this.add("Henk");
            this.add("Toos");
        }
    };

    private static Rummikub testSpel() {
        Rummikub test = new Rummikub(spelernamen, 2);
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
                this.add("Henk");
            }
        };
        Rummikub henkspel = new Rummikub(henk, 2);
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
    public void bijAanvangSpelIsSpelerMetBeurtNietUitgekomen() {
        Rummikub test = testSpel();
        assertFalse(test.spelerMetBeurtIsUitgekomen());
    }

    @Test
    public void bijAanvangSpelIsSpelNietAfgelopen() {
        Rummikub test = testSpel();
        assertFalse(test.spelIsAfgelopen());
    }

}
