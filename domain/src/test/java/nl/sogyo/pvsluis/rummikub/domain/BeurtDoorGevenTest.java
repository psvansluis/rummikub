package nl.sogyo.pvsluis.rummikub.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import nl.sogyo.pvsluis.rummikub.domain.Steen.Kleur;

public class BeurtDoorGevenTest {
    private Pot pot;

    @Before
    public void maakPot() {
        this.pot = new Pot(2);
    }

    private static void beurtDieWelDoorgegevenKanWorden(Tafel tafel) {
        tafel.getPlankjeMetBeurt().voegSteenToe(new Steen(11, Kleur.KLEUR1));
        tafel.getPlankjeMetBeurt().voegSteenToe(new Steen(11, Kleur.KLEUR2));
        tafel.getPlankjeMetBeurt().voegSteenToe(new Steen(11, Kleur.KLEUR3));
        tafel.speelSteen(-1, 14, tafel.lengteSets());
        tafel.speelSteen(-1, 14, 0);
        tafel.speelSteen(-1, 14, 0);
    }

    private static void beurtDieNietDoorgegevenKanWorden(Tafel tafel) {
        tafel.getPlankjeMetBeurt().voegSteenToe(new Steen(5, Kleur.KLEUR1));
        tafel.getPlankjeMetBeurt().voegSteenToe(new Steen(4, Kleur.KLEUR2));
        tafel.getPlankjeMetBeurt().voegSteenToe(new Steen(7, Kleur.KLEUR1));
        tafel.speelSteen(-1, 14, tafel.lengteSets());
        tafel.speelSteen(-1, 14, 0);
        tafel.speelSteen(-1, 14, 0);
    }

    @Test
    public void bijEenLegeTafelMagBeurtNietDoorgegevenWorden() {
        Tafel test = new Tafel(0, this.pot);
        assertFalse(test.kanBeurtDoorgeven());
    }

    @Test
    public void bijEenInvalideTafelMagBeurtNietDoorgegevenWorden() {
        Tafel test = new Tafel(2, this.pot);
        beurtDieNietDoorgegevenKanWorden(test);
        assertFalse(test.kanBeurtDoorgeven());
    }

    @Test
    public void bijEenValideTafelMagBeurtWelDoorgegevenWorden() {
        Tafel test = new Tafel(2, this.pot);
        beurtDieWelDoorgegevenKanWorden(test);
        assertTrue(test.kanBeurtDoorgeven());
    }

    @Test
    public void ookTweedeSpelerMagBijInvalideTafelBeurtNietDoorgeven() {
        Tafel test = new Tafel(2, this.pot);
        beurtDieWelDoorgegevenKanWorden(test);
        test.geefBeurtDoor();
        beurtDieNietDoorgegevenKanWorden(test);
        assertFalse(test.kanBeurtDoorgeven());
    }

    @Test
    public void beurtDoorgevenDoetNietsAlsDatNietKan() {
        Tafel test = new Tafel(2, this.pot);
        beurtDieNietDoorgegevenKanWorden(test);
        test.geefBeurtDoor();
        assertEquals(test.getEerstePlankje(), test.getPlankjeMetBeurt());
    }

    @Test
    public void beurtDoorgevenGeeftBeurtDoor() {
        Tafel test = new Tafel(2, this.pot);
        beurtDieWelDoorgegevenKanWorden(test);
        test.geefBeurtDoor();
        assertEquals(
                test.getEerstePlankje().getVolgendePlankje(),
                test.getPlankjeMetBeurt());
    }
}
