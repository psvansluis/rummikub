package nl.sogyo.pvsluis.rummikub.domain;

import java.util.LinkedHashSet;

import nl.sogyo.pvsluis.rummikub.domain.Steen.Kleur;

class Set extends StenenContainer {
    private static final int MINIMALE_LENGTE_VALIDE_SET = 3;

    Set() {
    }

    boolean isValide() {
        return this.getStenen().size() >= MINIMALE_LENGTE_VALIDE_SET
                && (this.isRij() || this.isSerie());
    }

    @Override
    void voegSteenToe(Steen toeTeVoegenSteen) {
        super.voegSteenToe(toeTeVoegenSteen);
        this.sorteer();
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
                && nUniekeKleuren() == this.getStenen().size();
    }

    private boolean isSerie() {
        int laagsteCijfer = this.getStenen().get(0).getCijfer();
        int hoogsteCijfer = this.getStenen()
                .get(this.getStenen().size() - 1).getCijfer();

        return this.nUniekeCijfers() == this.getStenen().size()
                && hoogsteCijfer - laagsteCijfer + 1 == this.getStenen().size()
                && this.nUniekeKleuren() == 1;
    }

}
