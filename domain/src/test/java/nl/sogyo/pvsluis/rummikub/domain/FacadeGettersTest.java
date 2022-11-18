package nl.sogyo.pvsluis.rummikub.domain;

import static org.hamcrest.MatcherAssert.assertThat;
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
}
