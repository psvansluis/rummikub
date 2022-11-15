package nl.sogyo.pvsluis.rummikub.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;

import nl.sogyo.pvsluis.rummikub.domain.Steen.Kleur;

class Set {
    private static final int MINIMALE_LENGTE_VALIDE_SET = 3;
    private ArrayList<Steen> stenen;

    Set(Steen eersteSteen) {
        this.stenen = new ArrayList<Steen>();
        this.stenen.add(eersteSteen);
    }

    ArrayList<Steen> getStenen() {
        return this.stenen;
    }

    void voegSteenToe(Steen toeTeVoegenSteen) {
        this.stenen.add(toeTeVoegenSteen);
        this.sorteer();
    }

    void verwijderSteen(Steen teVerwijderenSteen) {
        this.stenen.remove(teVerwijderenSteen);
    }

    boolean isValide() {
        return this.stenen.size() >= MINIMALE_LENGTE_VALIDE_SET
                && (this.isRij() || this.isSerie());
    }

    private void sorteer() {
        Collections.sort(this.stenen);
    }

    private int nUniekeCijfers() {
        LinkedHashSet<Integer> uniekeCijfers = new LinkedHashSet<Integer>();
        for (Steen steen : this.stenen) {
            uniekeCijfers.add(steen.getCijfer());
        }
        return uniekeCijfers.size();
    }

    private int nUniekeKleuren() {
        LinkedHashSet<Kleur> uniekeKleuren = new LinkedHashSet<Kleur>();
        for (Steen steen : this.stenen) {
            uniekeKleuren.add(steen.getKleur());
        }
        return uniekeKleuren.size();
    }

    private boolean isRij() {
        return this.nUniekeCijfers() == 1
                && nUniekeKleuren() == this.stenen.size();
    }

    private boolean isSerie() {
        int laagsteCijfer = this.stenen.get(0).getCijfer();
        int hoogsteCijfer = this.stenen.get(this.stenen.size() - 1).getCijfer();

        return this.nUniekeCijfers() == this.stenen.size()
                && hoogsteCijfer - laagsteCijfer + 1 == this.stenen.size()
                && this.nUniekeKleuren() == 1;
    }

}
