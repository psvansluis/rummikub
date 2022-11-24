package nl.sogyo.pvsluis.rummikub.api.models;

import java.util.ArrayList;

import nl.sogyo.pvsluis.rummikub.domain.Rummikub;

public class SetDTO {
    private SteenDTO[] stenen;
    private boolean isValide;

    public SetDTO(Rummikub spel, int setIndex) {
        ArrayList<ArrayList<Integer>> container = spel.getStenenOpTafel()
                .get(setIndex);
        this.stenen = new SteenDTO[container.size()];
        for (int i = 0; i < stenen.length; i++) {
            stenen[i] = new SteenDTO(
                    container.get(i).get(0),
                    container.get(i).get(1));
        }
        this.isValide = spel.getValiditeitSets().get(setIndex);
    }

    public SteenDTO[] getStenen() {
        return stenen;
    }

    public boolean isValide() {
        return this.isValide;
    }

}
