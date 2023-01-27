package nl.sogyo.pvsluis.rummikub.domain;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import nl.sogyo.pvsluis.rummikub.domain.AbstractSteen.Kleur;

public class PotTest {

    private static int nStenenMetWaardeInPot(Pot pot, int cijfer, Kleur kleur) {
        ArrayList<Steen> stenenMetWaarde = new ArrayList<Steen>();
        for (Steen steen : pot.getStenen()) {
            if (steen.getCijfer() == cijfer && steen.getKleur().equals(kleur)) {
                stenenMetWaarde.add(steen);
            }
        }
        return stenenMetWaarde.size();
    }

    @Test
    public void eenNieuwePotHeeftTweeZwarteVieren() {
        Pot pot = new Pot(1);
        assertEquals(2, nStenenMetWaardeInPot(pot, 4, Kleur.ZWART));
    }

    @Test
    public void eenNieuwePotHeeftTweeKleur1Dertienen() {
        Pot pot = new Pot(1);
        assertEquals(2, nStenenMetWaardeInPot(pot, 13, Kleur.KLEUR1));
    }

    @Test
    public void eenNieuwePotHeeftTweeKleur2Enen() {
        Pot pot = new Pot(1);
        assertEquals(2, nStenenMetWaardeInPot(pot, 1, Kleur.KLEUR2));
    }

    @Test
    public void eenNieuwePotHeeftTweeKleur3Tienen() {
        Pot pot = new Pot(1);
        assertEquals(2, nStenenMetWaardeInPot(pot, 10, Kleur.KLEUR3));
    }
}
