package nl.sogyo.pvsluis.rummikub.domain;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class SorteerPlankjeTest {
    private Rummikub testSpel;

    @Before
    public void initialiseerSpel() {
        testSpel = new Rummikub(new ArrayList<String>() {
            {
                add("Henk");
                add("Toos");
            }
        }, 1);
    }

    @Test
    public void sorterenOpKleurWerkt1() {
        testSpel.sorteerPlankjeOpKleur();
        assertEquals(0,
                testSpel.getStenenOpPlankjeMetBeurt().get(0).get(1).intValue());
    }

    @Test
    public void sorterenOpKleurWerkt2() {
        testSpel.sorteerPlankjeOpKleur();
        assertEquals(2,
                testSpel.getStenenOpPlankjeMetBeurt()
                        .get(13).get(1).intValue());
    }

    @Test
    public void sorterenOpCijferWerkt1() {
        testSpel.sorteerPlankjeOpCijfer();
        assertEquals(1,
                testSpel.getStenenOpPlankjeMetBeurt().get(0).get(0).intValue());
    }

    @Test
    public void sorterenOpCijferWerkt2() {
        testSpel.sorteerPlankjeOpCijfer();
        assertEquals(12,
                testSpel.getStenenOpPlankjeMetBeurt()
                        .get(13).get(0).intValue());
    }
}
