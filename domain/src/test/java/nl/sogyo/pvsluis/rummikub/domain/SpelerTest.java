package nl.sogyo.pvsluis.rummikub.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SpelerTest {

    @Test
    public void eenNieuwAangemaakteSpelerHeeft14StenenOpZijnPlankje() {
        Speler henk = new Speler(true);
        assertEquals(14, henk.getPlankje().getStenen().size());
    }

    @Test
    public void eenSpelerDieBijStartEenSteenpaktHeeft15StenenOpZijnPlankje() {
        Speler henk = new Speler(true);
        henk.getPlankje().neemSteenUitPot();
        assertEquals(15, henk.getPlankje().getStenen().size());
    }

}
