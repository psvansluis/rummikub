package nl.sogyo.pvsluis.rummikub.domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import nl.sogyo.pvsluis.rummikub.domain.AbstractSteen.Kleur;
import nl.sogyo.pvsluis.rummikub.domain.Steen.*;

public class SetValidatieTest {
    // Test het checken van validiteit van sets

    // Verwacht true
    @Test
    public void eenValideSerieIsValide1() {
        Steen a = new Steen(1, Kleur.KLEUR1);
        Steen b = new Steen(2, Kleur.KLEUR1);
        Steen c = new Steen(3, Kleur.KLEUR1);
        Set set = new Set();
        set.voegSteenToe(a);
        set.voegSteenToe(b);
        set.voegSteenToe(c);
        assertTrue(set.isValide());
    }

    @Test
    public void eenValideSerieIsValide2() {
        Steen a = new Steen(5, Kleur.KLEUR2);
        Steen b = new Steen(6, Kleur.KLEUR2);
        Steen c = new Steen(7, Kleur.KLEUR2);
        Set set = new Set();
        set.voegSteenToe(a);
        set.voegSteenToe(b);
        set.voegSteenToe(c);
        assertTrue(set.isValide());
    }

    @Test
    public void eenValideRijIsValide1() {
        Steen a = new Steen(4, Kleur.ZWART);
        Steen b = new Steen(4, Kleur.KLEUR1);
        Steen c = new Steen(4, Kleur.KLEUR3);
        Set set = new Set();
        set.voegSteenToe(a);
        set.voegSteenToe(b);
        set.voegSteenToe(c);
        assertTrue(set.isValide());
    }

    @Test
    public void eenValideRijIsValide2() {
        Steen a = new Steen(10, Kleur.KLEUR2);
        Steen b = new Steen(10, Kleur.KLEUR1);
        Steen c = new Steen(10, Kleur.KLEUR3);
        Set set = new Set();
        set.voegSteenToe(a);
        set.voegSteenToe(b);
        set.voegSteenToe(c);
        assertTrue(set.isValide());
    }

    @Test
    public void volgordeStenenToevoegenMaaktNietUit() {
        Steen a = new Steen(1, Kleur.KLEUR1);
        Steen b = new Steen(2, Kleur.KLEUR1);
        Steen c = new Steen(3, Kleur.KLEUR1);
        Set set = new Set();
        set.voegSteenToe(a);
        set.voegSteenToe(c);
        set.voegSteenToe(b);
        assertTrue(set.isValide());
    }

    // Verwacht false
    @Test
    public void eenTeKorteSerieIsInvalide() {
        Steen a = new Steen(5, Kleur.KLEUR1);
        Steen b = new Steen(6, Kleur.KLEUR1);
        Set set = new Set();
        set.voegSteenToe(a);
        set.voegSteenToe(b);
        assertFalse(set.isValide());
    }

    @Test
    public void eenSerieMetTweeDezelfdeStenenIsInvalide() {
        Steen a = new Steen(1, Kleur.KLEUR1);
        Steen b = new Steen(2, Kleur.KLEUR1);
        Steen c = new Steen(3, Kleur.KLEUR1);
        Steen d = new Steen(3, Kleur.KLEUR1);
        Set set = new Set();
        set.voegSteenToe(a);
        set.voegSteenToe(b);
        set.voegSteenToe(c);
        set.voegSteenToe(d);
        assertFalse(set.isValide());
    }

    @Test
    public void eenSerieMetEenGatIsInvalide() {
        Steen a = new Steen(1, Kleur.KLEUR1);
        Steen b = new Steen(2, Kleur.KLEUR1);
        Steen c = new Steen(4, Kleur.KLEUR1);
        Set set = new Set();
        set.voegSteenToe(a);
        set.voegSteenToe(b);
        set.voegSteenToe(c);
        assertFalse(set.isValide());
    }

    @Test
    public void eenTeKorteRijIsInvalide() {
        Steen a = new Steen(4, Kleur.ZWART);
        Steen b = new Steen(4, Kleur.KLEUR1);
        Set set = new Set();
        set.voegSteenToe(a);
        set.voegSteenToe(b);
        assertFalse(set.isValide());
    }

    @Test
    public void eenRijMetTweeKeerDezelfdeSteenIsInvalide() {
        Steen a = new Steen(4, Kleur.ZWART);
        Steen b = new Steen(4, Kleur.KLEUR1);
        Steen c = new Steen(4, Kleur.KLEUR3);
        Steen d = new Steen(4, Kleur.KLEUR1);
        Set set = new Set();
        set.voegSteenToe(a);
        set.voegSteenToe(b);
        set.voegSteenToe(c);
        set.voegSteenToe(d);
        assertFalse(set.isValide());
    }

    @Test
    public void eenRijMetVerschillendeCijfersIsInvalide() {
        Steen a = new Steen(4, Kleur.ZWART);
        Steen b = new Steen(4, Kleur.KLEUR1);
        Steen c = new Steen(4, Kleur.KLEUR3);
        Steen d = new Steen(5, Kleur.KLEUR2);
        Set set = new Set();
        set.voegSteenToe(a);
        set.voegSteenToe(b);
        set.voegSteenToe(c);
        set.voegSteenToe(d);
        assertFalse(set.isValide());
    }

}
