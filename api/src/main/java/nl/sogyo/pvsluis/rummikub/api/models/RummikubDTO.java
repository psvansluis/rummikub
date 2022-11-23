package nl.sogyo.pvsluis.rummikub.api.models;

import nl.sogyo.pvsluis.rummikub.domain.Rummikub;

public class RummikubDTO {
    private StenenContainerDTO plankje;
    private SetDTO[] sets;
    private String spelerMetBeurt;
    private int stenenInPot;
    private boolean spelerMetBeurtIsUitgekomen;
    private boolean spelerKanBeurtDoorgeven;

    public RummikubDTO(Rummikub spel) {
        this.plankje = new StenenContainerDTO(
                spel.getStenenOpPlankjeMetBeurt());
        this.sets = new SetDTO[spel.getStenenOpTafel().size()];
        for (int i = 0; i < sets.length; i++) {
            this.sets[i] = new SetDTO(spel, i);
        }
        this.spelerMetBeurt = spel.getNaamSpelerMetBeurt();
        this.stenenInPot = spel.aantalStenenInPot();
        this.spelerMetBeurtIsUitgekomen = spel.spelerMetBeurtIsUitgekomen();
        this.spelerKanBeurtDoorgeven = spel.kanBeurtDoorgeven();
    }

    public StenenContainerDTO getPlankje() {
        return plankje;
    }

    public String getSpelerMetBeurt() {
        return spelerMetBeurt;
    }

    public int getStenenInPot() {
        return stenenInPot;
    }

    public SetDTO[] getSets() {
        return sets;
    }

    public boolean getSpelerMetBeurtIsUitgekomen() {
        return spelerMetBeurtIsUitgekomen;
    }

    public boolean getSpelerKanBeurtDoorgeven() {
        return this.spelerKanBeurtDoorgeven;
    }

}
