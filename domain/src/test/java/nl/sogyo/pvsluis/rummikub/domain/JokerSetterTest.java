package nl.sogyo.pvsluis.rummikub.domain;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class JokerSetterTest {
    private Rummikub testSpel;

    @Before
    public void initialiseerSpel() {
        testSpel = new Rummikub(new ArrayList<String>() {
            {
                add("Henk");
                add("Toos");
            }
        }, 9);
    }

    @Test
    public void jokerWaardeVeranderenKanWel() {
        testSpel.veranderJokerWaarde(-1, 10, 5, 2);
        int jokerCijferwaarde = testSpel.getStenenOpPlankjeMetBeurt()
                .get(10).get(0);
        assertEquals("De waarde van een Joker moet 5 zijn",
                5, jokerCijferwaarde);
    }

    @Test
    public void nietJokerWaardeVeranderenKanNiet() {
        // testSpel.veranderJokerWaarde();

    }
}
