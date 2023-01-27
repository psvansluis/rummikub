package nl.sogyo.pvsluis.rummikub.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import nl.sogyo.pvsluis.rummikub.domain.AbstractSteen.Kleur;
import nl.sogyo.pvsluis.rummikub.domain.Steen.*;

public class SetManipulatieTest {
    // Test het maken, aanleggen en verwijderen bij Sets

    @Test
    public void voegSteenToeSorteert() {
        Steen a = new Steen(9, Kleur.ZWART);
        Steen b = new Steen(8, Kleur.ZWART);
        Set set = new Set();
        set.voegSteenToe(a);
        set.voegSteenToe(b);
        assertEquals(b, set.getSteen(0));
    }

    @Test
    public void voegSteenToeVoegtSteenToe() {
        Steen a = new Steen(1, Kleur.ZWART);
        Steen b = new Steen(5, Kleur.KLEUR3);
        Set set = new Set();
        set.voegSteenToe(a);
        set.voegSteenToe(b);
        assertEquals(2, set.lengte());
    }

    @Test
    public void verwijderSteenVerwijdertSteen() {
        Steen a = new Steen(1, Kleur.KLEUR1);
        Steen b = new Steen(5, Kleur.KLEUR2);
        Set set = new Set();
        set.voegSteenToe(a);
        set.voegSteenToe(b);
        set.verwijderSteen(a);
        assertEquals(b, set.getSteen(0));
    }

    @Test
    public void verplaatsSteenMetSteenGeeftSteenInDoelSet() {
        Steen a = new Steen(1, Kleur.KLEUR1);
        Steen b = new Steen(5, Kleur.KLEUR2);
        Set set1 = new Set();
        set1.voegSteenToe(a);
        Set set2 = new Set();
        set2.voegSteenToe(b);
        set1.verplaatsSteen(a, set2);
        assertEquals(b, set2.getSteen(1));
    }

    @Test
    public void verplaatsSteenMetSteenVerwijdertSteenUitOorspronkelijkeSet() {
        Steen a = new Steen(1, Kleur.KLEUR1);
        Steen b = new Steen(5, Kleur.KLEUR2);
        Set set1 = new Set();
        set1.voegSteenToe(a);
        Set set2 = new Set();
        set2.voegSteenToe(b);
        set1.verplaatsSteen(a, set2);
        assertEquals(0, set1.lengte());
    }

}
