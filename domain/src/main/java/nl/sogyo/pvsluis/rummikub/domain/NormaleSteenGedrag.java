package nl.sogyo.pvsluis.rummikub.domain;

class NormaleSteenGedrag implements SteenGedrag {
    private Steen steen;

    NormaleSteenGedrag(Steen steen) {
        this.steen = steen;
    }

    public int getWaardeVoorScore() {
        return this.steen.getCijfer();
    }

    public void setWaarde() throws Exception {
        throw new Exception("Kan waarde van een gewone steen niet aanpassen");
    }

    public boolean isJoker() {
        return false;
    }

}
