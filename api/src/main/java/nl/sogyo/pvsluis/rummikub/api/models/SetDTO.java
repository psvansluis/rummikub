package nl.sogyo.pvsluis.rummikub.api.models;

import nl.sogyo.pvsluis.rummikub.domain.Rummikub;

public class SetDTO extends StenenContainerDTO {
    private boolean isValide;

    public SetDTO(Rummikub spel, int setIndex) {
        super(spel.getStenenOpTafel()
                .get(setIndex));
        this.isValide = spel.getValiditeitSets().get(setIndex);
    }

    public boolean isValide() {
        return this.isValide;
    }

}
