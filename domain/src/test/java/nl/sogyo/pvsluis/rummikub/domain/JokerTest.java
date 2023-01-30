package nl.sogyo.pvsluis.rummikub.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class JokerTest {
    private Rummikub testSpel;

    @Before
    public void setUpSpel() {
        testSpel = new Rummikub(new ArrayList<String>() {
            {
                add("Henk");
                add("Toos");
            }
        }, 9);
    }

    @Test
    public void jokerAanpassenKanWel() {
        testSpel.setJokerWaarde(-1, 10, 5, 1);
        int deCijferWaarde = testSpel.getStenenOpPlankjeMetBeurt()
                .get(10).get(0);
        assertEquals("Bij een joker moet aanpassen wel effect hebben",
                5, deCijferWaarde);
    }

    @Test
    public void gewoneSteenAanpassenKanNiet() {
        testSpel.setJokerWaarde(-1, 0, 5, 1);
        int deCijferWaarde = testSpel.getStenenOpPlankjeMetBeurt()
                .get(0).get(0);
        assertEquals("Bij een joker moet aanpassen wel effect hebben",
                13, deCijferWaarde);
    }
}
