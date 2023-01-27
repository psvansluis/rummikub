package nl.sogyo.pvsluis.rummikub.domain;

import java.util.LinkedHashSet;

import nl.sogyo.pvsluis.rummikub.domain.Steen.Kleur;

class Set extends StenenContainer {
    private static final int MINIMALE_LENGTE_VALIDE_SET = 3;

    Set() {
    }

    boolean isValide() {
        return this.lengte() >= MINIMALE_LENGTE_VALIDE_SET
                && (this.isRij() || this.isSerie());
    }

    @Override
    void voegSteenToe(Steen toeTeVoegenSteen) {
        super.voegSteenToe(toeTeVoegenSteen);
        this.sorteerOpCijfer();
    }

    private int nUniekeCijfers() {
        LinkedHashSet<Integer> uniekeCijfers = new LinkedHashSet<Integer>();
        for (Steen steen : this.getStenen()) {
            uniekeCijfers.add(steen.getCijfer());
        }
        return uniekeCijfers.size();
    }

    private int nUniekeKleuren() {
        LinkedHashSet<Kleur> uniekeKleuren = new LinkedHashSet<Kleur>();
        for (Steen steen : this.getStenen()) {
            uniekeKleuren.add(steen.getKleur());
        }
        return uniekeKleuren.size();
    }

    private boolean isRij() {
        return this.nUniekeCijfers() == 1
                && nUniekeKleuren() == this.lengte();
    }

    private boolean isSerie() {
        int laagsteCijfer = this.getSteen(0).getCijfer();
        int hoogsteCijfer = this.getSteen(this.lengte() - 1).getCijfer();

        return this.nUniekeCijfers() == this.lengte()
                && hoogsteCijfer - laagsteCijfer + 1 == this.lengte()
                && this.nUniekeKleuren() == 1;
    }

}
