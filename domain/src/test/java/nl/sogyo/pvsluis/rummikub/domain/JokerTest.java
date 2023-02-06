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
        this.testSpel = new Rummikub(new ArrayList<String>() {
            {
                this.add("Henk");
                this.add("Toos");
            }
        }, 9);
    }

    @Test
    public void jokerAanpassenKanWel() {
        this.testSpel.setJokerWaarde(-1, 10, 5, 1);
        int deCijferWaarde = this.testSpel.getStenenOpPlankjeMetBeurt()
                .get(10).get(0);
        assertEquals("Bij een joker moet aanpassen wel effect hebben",
                5, deCijferWaarde);
    }

    @Test
    public void gewoneSteenAanpassenKanNiet() {
        this.testSpel.setJokerWaarde(-1, 0, 5, 1);
        int deCijferWaarde = this.testSpel.getStenenOpPlankjeMetBeurt()
                .get(0).get(0);
        assertEquals("Een gewone steen moet niet aanpasbaar zijn",
                13, deCijferWaarde);
    }

    @Test
    public void jokerMoetSorterenInSet() {
        this.testSpel.speelSteen(-1, 10, 0);
        this.testSpel.speelSteen(-1, 5, 0);
        this.testSpel.speelSteen(-1, 2, 0);
        this.testSpel.setJokerWaarde(0, 0, 11, 1);
        assertTrue("De eerste set moet valide zijn",
                this.testSpel.getValiditeitSets().get(0));
        assertEquals(11,
                (int) this.testSpel.getStenenOpTafel().get(0).get(1).get(0));
    }

    @Test
    public void jokerAanpassenKanNietInSetDieNietBewerktMagWorden() {
        this.testSpel.setJokerWaarde(-1, 10, 11, 1);
        this.testSpel.speelSteen(-1, 10, 0);
        this.testSpel.speelSteen(-1, 5, 0);
        this.testSpel.speelSteen(-1, 2, 0);
        this.testSpel.sluitBeurtAf(); // Nu is Toos aan de beurt
        this.testSpel.setJokerWaarde(0, 1, 4, 1);

        assertEquals("Een niet uitgekomen speler hoort geen jokers"
                + " aan te mogen passen in een bestaande Set", 11,
                (int) this.testSpel.getStenenOpTafel().get(0).get(1).get(0));
        assertTrue("De eerste set moet valide zijn",
                this.testSpel.getValiditeitSets().get(0));
    }
}
