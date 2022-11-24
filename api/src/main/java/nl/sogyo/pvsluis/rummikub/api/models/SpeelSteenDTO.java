package nl.sogyo.pvsluis.rummikub.api.models;

public class SpeelSteenDTO {
    private int bronContainerIndex;
    private int steenIndex;
    private int doelContainerIndex;

    public int getBronContainerIndex() {
        return bronContainerIndex;
    }

    public int getSteenIndex() {
        return steenIndex;
    }

    public int getDoelContainerIndex() {
        return doelContainerIndex;
    }

    public void setBronContainerIndex(int bronContainerIndex) {
        this.bronContainerIndex = bronContainerIndex;
    }

    public void setSteenIndex(int steenIndex) {
        this.steenIndex = steenIndex;
    }

    public void setDoelContainerIndex(int doelContainerIndex) {
        this.doelContainerIndex = doelContainerIndex;
    }
}
