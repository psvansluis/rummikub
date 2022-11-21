package nl.sogyo.pvsluis.rummikub.api.models;

import nl.sogyo.pvsluis.rummikub.domain.Rummikub;

public class RummikubDTO {
    private StenenContainerDTO plankje;

    public RummikubDTO(Rummikub spel) {
        this.plankje = new StenenContainerDTO(
                spel.getStenenOpPlankjeMetBeurt());
    }

    public StenenContainerDTO getPlankje() {
        return plankje;
    }

}
