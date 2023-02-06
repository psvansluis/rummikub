package nl.sogyo.pvsluis.rummikub.domain;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class SorteerPlankjeTest {
    private Rummikub testSpel;

    @Before
    public void initialiseerSpel() {
        this.testSpel = new Rummikub(new ArrayList<String>() {
            {
                this.add("Henk");
                this.add("Toos");
            }
        }, 1);
    }

    @Test
    public void sorterenOpKleurWerkt1() {
        this.testSpel.sorteerPlankjeOpKleur();
        assertEquals(0,
                this.testSpel.getStenenOpPlankjeMetBeurt()
                        .get(0).get(1).intValue());
    }

    @Test
    public void sorterenOpKleurWerkt2() {
        this.testSpel.sorteerPlankjeOpKleur();
        assertEquals(2,
                this.testSpel.getStenenOpPlankjeMetBeurt()
                        .get(13).get(1).intValue());
    }

    @Test
    public void sorterenOpCijferWerkt1() {
        this.testSpel.sorteerPlankjeOpCijfer();
        assertEquals(1,
                this.testSpel.getStenenOpPlankjeMetBeurt()
                        .get(0).get(0).intValue());
    }

    @Test
    public void sorterenOpCijferWerkt2() {
        this.testSpel.sorteerPlankjeOpCijfer();
        assertEquals(12,
                this.testSpel.getStenenOpPlankjeMetBeurt()
                        .get(13).get(0).intValue());
    }
}
