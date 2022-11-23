package nl.sogyo.pvsluis.rummikub.api.models;

import nl.sogyo.pvsluis.rummikub.domain.Rummikub;

public class RummikubDTO {
    private StenenContainerDTO plankje;
    private String spelerMetBeurt;
    private int stenenInPot;

    public RummikubDTO(Rummikub spel) {
        this.plankje = new StenenContainerDTO(
                spel.getStenenOpPlankjeMetBeurt());
        this.spelerMetBeurt = spel.getNaamSpelerMetBeurt();
        this.stenenInPot = spel.aantalStenenInPot();
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

}
