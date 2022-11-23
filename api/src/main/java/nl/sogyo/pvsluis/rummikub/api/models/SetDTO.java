package nl.sogyo.pvsluis.rummikub.api.models;

import nl.sogyo.pvsluis.rummikub.domain.Rummikub;

public class SetDTO {
    private StenenContainerDTO stenen;
    private boolean isValide;

    public SetDTO(Rummikub spel, int setIndex) {
        this.stenen = new StenenContainerDTO(
                spel.getStenenOpTafel().get(setIndex));
        this.isValide = spel.getValiditeitSets().get(setIndex);
    }

    public StenenContainerDTO getStenen() {
        return stenen;
    }

    public boolean isValide() {
        return isValide;
    }

}
