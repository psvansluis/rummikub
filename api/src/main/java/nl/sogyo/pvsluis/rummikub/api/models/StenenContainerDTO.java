package nl.sogyo.pvsluis.rummikub.api.models;

import java.util.ArrayList;

public class StenenContainerDTO {
    private SteenDTO[] stenen;

    public StenenContainerDTO(ArrayList<ArrayList<Integer>> container) {
        this.stenen = new SteenDTO[container.size()];
        for (int i = 0; i < stenen.length; i++) {
            stenen[i] = new SteenDTO(
                    container.get(i).get(0),
                    container.get(i).get(1),
                    container.get(i).get(2));
        }
    }

    public SteenDTO[] getStenen() {
        return this.stenen;
    }

    public void setStenen(SteenDTO[] stenen) {
        this.stenen = stenen;
    }
}
