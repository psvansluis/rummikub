package nl.sogyo.pvsluis.rummikub.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import nl.sogyo.pvsluis.rummikub.domain.Steen.Kleur;

public class ResetTest {
    // Test op juiste resultaat bij Plankje én Tafel
    // In de volgende situaties:
    // Nadat nog niet eerder is gereset
    // Nadat al wel eerder is gereset binnen de beurt

    @Test
    public void tafelIsLeegAlsEersteSpelerReset() {
        Tafel test = new Tafel(2);
        test.speelSteenVanPlankjeNaarSet(0, 0);
        test.speelSteenVanPlankjeNaarSet(0, 0);
        test.speelSteenVanPlankjeNaarSet(0, 0);
        test.resetSpelNaarAanvangBeurt();
        assertEquals(0, test.lengteSets());
    }

    @Test
    public void plankjeHeeft14StenenAlsEersteSpelerReset() {
        Tafel test = new Tafel(2);
        test.speelSteenVanPlankjeNaarSet(0, 0);
        test.speelSteenVanPlankjeNaarSet(0, 0);
        test.speelSteenVanPlankjeNaarSet(0, 0);
        test.resetSpelNaarAanvangBeurt();
        assertEquals(14, test.getPlankjeMetBeurt().lengte());
    }

    @Test
    public void tafelIsNietLeegAlsTweedeSpelerReset() {
        Tafel test = new Tafel(2);
        test.getPlankjeMetBeurt().voegSteenToe(new Steen(10, Kleur.ZWART));
        test.getPlankjeMetBeurt().voegSteenToe(new Steen(11, Kleur.ZWART));
        test.getPlankjeMetBeurt().voegSteenToe(new Steen(12, Kleur.ZWART));
        test.speelSteenVanPlankjeNaarSet(14, 0);
        test.speelSteenVanPlankjeNaarSet(14, 0);
        test.speelSteenVanPlankjeNaarSet(14, 0);
        test.geefBeurtDoor();
        test.speelSteenVanPlankjeNaarSet(0, 1);
        test.speelSteenVanPlankjeNaarSet(0, 1);
        test.speelSteenVanPlankjeNaarSet(0, 1);
        test.resetSpelNaarAanvangBeurt();
        assertEquals(1, test.lengteSets());
    }

    @Test
    public void plankjeHeeft14StenenAlsTweedeSpelerReset() {
        Tafel test = new Tafel(2);
        test.getPlankjeMetBeurt().voegSteenToe(new Steen(10, Kleur.ZWART));
        test.getPlankjeMetBeurt().voegSteenToe(new Steen(11, Kleur.ZWART));
        test.getPlankjeMetBeurt().voegSteenToe(new Steen(12, Kleur.ZWART));
        test.speelSteenVanPlankjeNaarSet(14, 0);
        test.speelSteenVanPlankjeNaarSet(14, 0);
        test.speelSteenVanPlankjeNaarSet(14, 0);
        test.geefBeurtDoor();
        test.speelSteenVanPlankjeNaarSet(0, 1);
        test.speelSteenVanPlankjeNaarSet(0, 1);
        test.speelSteenVanPlankjeNaarSet(0, 1);
        test.resetSpelNaarAanvangBeurt();
        assertEquals(14, test.getPlankjeMetBeurt().lengte());
    }

    @Test
    public void tweeKeerResettenTest() {
        Tafel test = new Tafel(2);
        test.speelSteenVanPlankjeNaarSet(0, 0);
        test.speelSteenVanPlankjeNaarSet(0, 0);
        test.speelSteenVanPlankjeNaarSet(0, 0);
        test.resetSpelNaarAanvangBeurt();
        test.speelSteenVanPlankjeNaarSet(4, 0);
        test.speelSteenVanPlankjeNaarSet(1, 1);
        test.speelSteenVanPlankjeNaarSet(8, 1);
        test.resetSpelNaarAanvangBeurt();
        assertEquals(0, test.lengteSets());
    }

    // Test terugzetten van Steen op Plankje
    @Test
    public void eenSteenUitSetMagTerugNaarPlankjeBinnenBeurt() {
        Tafel test = new Tafel(2);
        test.speelSteenVanPlankjeNaarSet(0, 0);
        test.speelSteenVanSetNaarPlankje(0, 0);
        assertEquals(14, test.getPlankjeMetBeurt().lengte());
    }

    @Test
    public void eenSteenUitSetMagNietTerugNaarPlankjeBuitenBeurt() {
        Tafel test = new Tafel(2);
        test.getPlankjeMetBeurt().voegSteenToe(new Steen(10, Kleur.ZWART));
        test.getPlankjeMetBeurt().voegSteenToe(new Steen(11, Kleur.ZWART));
        test.getPlankjeMetBeurt().voegSteenToe(new Steen(12, Kleur.ZWART));
        test.speelSteenVanPlankjeNaarSet(14, 0);
        test.speelSteenVanPlankjeNaarSet(14, 0);
        test.speelSteenVanPlankjeNaarSet(14, 0);
        test.geefBeurtDoor();
        test.speelSteenVanSetNaarPlankje(0, 0);
        assertEquals(14, test.getPlankjeMetBeurt().lengte());
    }

    @Test
    public void eenEigenSteenUitSetMagOokNietTerugNaarPlankjeBuitenBeurt() {
        Tafel test = new Tafel(2);
        test.getPlankjeMetBeurt().voegSteenToe(new Steen(10, Kleur.ZWART));
        test.getPlankjeMetBeurt().voegSteenToe(new Steen(11, Kleur.ZWART));
        test.getPlankjeMetBeurt().voegSteenToe(new Steen(12, Kleur.ZWART));
        test.speelSteenVanPlankjeNaarSet(14, 0);
        test.speelSteenVanPlankjeNaarSet(14, 0);
        test.speelSteenVanPlankjeNaarSet(14, 0);
        test.geefBeurtDoor();
        test.getPlankjeMetBeurt().voegSteenToe(new Steen(10, Kleur.ZWART));
        test.getPlankjeMetBeurt().voegSteenToe(new Steen(11, Kleur.ZWART));
        test.getPlankjeMetBeurt().voegSteenToe(new Steen(12, Kleur.ZWART));
        test.speelSteenVanPlankjeNaarSet(14, 1);
        test.speelSteenVanPlankjeNaarSet(14, 1);
        test.speelSteenVanPlankjeNaarSet(14, 1);
        test.geefBeurtDoor();
        test.speelSteenVanSetNaarPlankje(0, 0);
        assertEquals(14, test.getPlankjeMetBeurt().lengte());
    }

}
