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
        assertEquals("Een gewone steen moet niet aanpasbaar zijn",
                13, deCijferWaarde);
    }

    @Test
    public void jokerMoetSorterenInSet() {
        testSpel.speelSteen(-1, 10, 0);
        testSpel.speelSteen(-1, 5, 0);
        testSpel.speelSteen(-1, 2, 0);
        testSpel.setJokerWaarde(0, 0, 11, 1);
        assertTrue("De eerste set moet valide zijn",
                testSpel.getValiditeitSets().get(0));
        assertEquals(11,
                (int) testSpel.getStenenOpTafel().get(0).get(1).get(0));
    }

    @Test
    public void jokerAanpassenKanNietInSetDieNietBewerktMagWorden() {
        testSpel.setJokerWaarde(-1, 10, 11, 1);
        testSpel.speelSteen(-1, 10, 0);
        testSpel.speelSteen(-1, 5, 0);
        testSpel.speelSteen(-1, 2, 0);
        testSpel.sluitBeurtAf(); // Nu is Toos aan de beurt
        testSpel.setJokerWaarde(0, 1, 4, 1);

        assertEquals("Een niet uitgekomen speler hoort geen jokers"
                + " aan te mogen passen in een bestaande Set", 11,
                (int) testSpel.getStenenOpTafel().get(0).get(1).get(0));
        assertTrue("De eerste set moet valide zijn",
                testSpel.getValiditeitSets().get(0));
    }
}
