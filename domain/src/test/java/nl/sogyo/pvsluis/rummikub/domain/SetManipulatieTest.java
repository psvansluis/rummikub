package nl.sogyo.pvsluis.rummikub.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import nl.sogyo.pvsluis.rummikub.domain.Steen.*;

public class SetManipulatieTest {
    // Test het maken, aanleggen en verwijderen bij Sets

    @Test
    public void voegSteenToeSorteert() {
        Steen a = new Steen(9, Kleur.ZWART);
        Steen b = new Steen(8, Kleur.ZWART);
        Set set = new Set(a);
        set.voegSteenToe(b);
        assertEquals(b, set.getStenen().get(0));
    }

    @Test
    public void voegSteenToeVoegtSteenToe() {
        Steen a = new Steen(1, Kleur.ZWART);
        Steen b = new Steen(5, Kleur.KLEUR3);
        Set set = new Set(a);
        set.voegSteenToe(b);
        assertEquals(2, set.getStenen().size());
    }

    @Test
    public void verwijderSteenVerwijdertSteen() {
        Steen a = new Steen(1, Kleur.KLEUR1);
        Steen b = new Steen(5, Kleur.KLEUR2);
        Set set = new Set(a);
        set.voegSteenToe(b);
        set.verwijderSteen(a);
        assertEquals(b, set.getStenen().get(0));
    }

}
