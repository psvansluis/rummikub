package nl.sogyo.pvsluis.rummikub.domain;

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

    }

    @Test
    public void nietJokerWaardeVeranderenKanNiet() {

    }
}
