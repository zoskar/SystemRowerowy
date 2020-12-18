public class Rower {

    //Pola-------------------------------------------------------------------------------------------------------------

    private int nrRoweru;

    private int kodObreczy;

    private boolean czyWypozyczony;

    //Settery, gettery, konstruktory-----------------------------------------------------------------------------------

    public int getNrRoweru() {
        return nrRoweru;
    }

    public void setNrRoweru(int nrRoweru) {
        this.nrRoweru = nrRoweru;
    }

    public int getKodObreczy() {
        return kodObreczy;
    }

    public void setKodObreczy(int kodObreczy) {
        this.kodObreczy = kodObreczy;
    }

    public boolean isCzyWypozyczony() {
        return czyWypozyczony;
    }

    public void setCzyWypozyczony(boolean czyWypozyczony) {
        this.czyWypozyczony = czyWypozyczony;
    }

    public Rower(int nrRoweru, int kodObreczy, boolean czyWypozyczony) {
        this.nrRoweru = nrRoweru;
        this.kodObreczy = kodObreczy;
        this.czyWypozyczony = czyWypozyczony;
    }
    //Metody-----------------------------------------------------------------------------------------------------------
}
