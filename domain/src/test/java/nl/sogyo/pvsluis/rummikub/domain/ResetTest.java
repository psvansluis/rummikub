package nl.sogyo.pvsluis.rummikub.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import nl.sogyo.pvsluis.rummikub.domain.Steen.Kleur;

public class ResetTest {
    // Test op juiste resultaat bij Plankje én Tafel
    // In de volgende situaties:
    // Nadat nog niet eerder is gereset
    // Nadat al wel eerder is gereset binnen de beurt
    private Tafel test;

    @Before
    public void bouwTafel() {
        this.test = new Tafel(2, 2);
    }

    @Test
    public void tafelIsLeegAlsEersteSpelerReset() {
        this.test.speelSteen(-1, 0, 0);
        this.test.speelSteen(-1, 0, 0);
        this.test.speelSteen(-1, 0, 0);
        this.test.resetSpelNaarAanvangBeurt();
        assertEquals(0, this.test.lengteSets());
    }

    @Test
    public void plankjeHeeft14StenenAlsEersteSpelerReset() {
        this.test.speelSteen(-1, 0, 0);
        this.test.speelSteen(-1, 0, 0);
        this.test.speelSteen(-1, 0, 0);
        this.test.resetSpelNaarAanvangBeurt();
        assertEquals(14, this.test.getPlankjeMetBeurt().lengte());
    }

    @Test
    public void tafelIsNietLeegAlsTweedeSpelerReset() {
        this.test.getPlankjeMetBeurt().voegSteenToe(new Steen(10, Kleur.ZWART));
        this.test.getPlankjeMetBeurt().voegSteenToe(new Steen(11, Kleur.ZWART));
        this.test.getPlankjeMetBeurt().voegSteenToe(new Steen(12, Kleur.ZWART));
        this.test.speelSteen(-1, 14, 0);
        this.test.speelSteen(-1, 14, 0);
        this.test.speelSteen(-1, 14, 0);
        this.test.geefBeurtDoor();
        this.test.speelSteen(-1, 0, 1);
        this.test.speelSteen(-1, 0, 1);
        this.test.speelSteen(-1, 0, 1);
        this.test.resetSpelNaarAanvangBeurt();
        assertEquals(1, this.test.lengteSets());
    }

    @Test
    public void plankjeHeeft14StenenAlsTweedeSpelerReset() {
        this.test.getPlankjeMetBeurt().voegSteenToe(new Steen(10, Kleur.ZWART));
        this.test.getPlankjeMetBeurt().voegSteenToe(new Steen(11, Kleur.ZWART));
        this.test.getPlankjeMetBeurt().voegSteenToe(new Steen(12, Kleur.ZWART));
        this.test.speelSteen(-1, 14, 0);
        this.test.speelSteen(-1, 14, 0);
        this.test.speelSteen(-1, 14, 0);
        this.test.geefBeurtDoor();
        this.test.speelSteen(-1, 0, 1);
        this.test.speelSteen(-1, 0, 1);
        this.test.speelSteen(-1, 0, 1);
        this.test.resetSpelNaarAanvangBeurt();
        assertEquals(14, this.test.getPlankjeMetBeurt().lengte());
    }

    @Test
    public void tweeKeerResettenTest() {
        this.test.speelSteen(-1, 0, 0);
        this.test.speelSteen(-1, 0, 0);
        this.test.speelSteen(-1, 0, 0);
        this.test.resetSpelNaarAanvangBeurt();
        this.test.speelSteen(-1, 4, 0);
        this.test.speelSteen(-1, 1, 1);
        this.test.speelSteen(-1, 8, 1);
        this.test.resetSpelNaarAanvangBeurt();
        assertEquals(0, this.test.lengteSets());
    }

    // Test terugzetten van Steen op Plankje
    @Test
    public void eenSteenUitSetMagTerugNaarPlankjeBinnenBeurt() {
        this.test.speelSteen(-1, 0, 0);
        this.test.speelSteen(0, 0, -1);
        assertEquals(14, this.test.getPlankjeMetBeurt().lengte());
    }

    @Test
    public void eenSteenUitSetMagNietTerugNaarPlankjeBuitenBeurt() {
        this.test.getPlankjeMetBeurt().voegSteenToe(new Steen(10, Kleur.ZWART));
        this.test.getPlankjeMetBeurt().voegSteenToe(new Steen(11, Kleur.ZWART));
        this.test.getPlankjeMetBeurt().voegSteenToe(new Steen(12, Kleur.ZWART));
        this.test.speelSteen(-1, 14, 0);
        this.test.speelSteen(-1, 14, 0);
        this.test.speelSteen(-1, 14, 0);
        this.test.geefBeurtDoor();
        this.test.speelSteen(0, 0, -1);
        assertEquals(14, this.test.getPlankjeMetBeurt().lengte());
    }

    @Test
    public void eenEigenSteenUitSetMagOokNietTerugNaarPlankjeBuitenBeurt() {
        this.test.getPlankjeMetBeurt().voegSteenToe(new Steen(10, Kleur.ZWART));
        this.test.getPlankjeMetBeurt().voegSteenToe(new Steen(11, Kleur.ZWART));
        this.test.getPlankjeMetBeurt().voegSteenToe(new Steen(12, Kleur.ZWART));
        this.test.speelSteen(-1, 14, 0);
        this.test.speelSteen(-1, 14, 0);
        this.test.speelSteen(-1, 14, 0);
        this.test.geefBeurtDoor();
        this.test.getPlankjeMetBeurt().voegSteenToe(new Steen(10, Kleur.ZWART));
        this.test.getPlankjeMetBeurt().voegSteenToe(new Steen(11, Kleur.ZWART));
        this.test.getPlankjeMetBeurt().voegSteenToe(new Steen(12, Kleur.ZWART));
        this.test.speelSteen(-1, 14, 1);
        this.test.speelSteen(-1, 14, 1);
        this.test.speelSteen(-1, 14, 1);
        this.test.geefBeurtDoor();
        this.test.speelSteen(0, 0, -1);
        assertEquals(14, this.test.getPlankjeMetBeurt().lengte());
    }

}
