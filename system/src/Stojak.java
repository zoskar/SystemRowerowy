import java.util.Stack;

public class Stojak {

    //Pola-------------------------------------------------------------------------------------------------------------

    private boolean czyPusty;

    private Stack<Rower> rowery;

    //Settery, gettery, konstruktory-----------------------------------------------------------------------------------

    public boolean isCzyPusty() {
        return czyPusty;
    }

    public void setCzyPusty(boolean czyPusty) {
        this.czyPusty = czyPusty;
    }

    public Stack<Rower> getRowery() {
        return rowery;
    }

    public void setRowery(Stack<Rower> rowery) {
        this.rowery = rowery;
    }

    public Stojak(Stack<Rower> rowery) {
        this.czyPusty = false;
        this.rowery = rowery;
    }
    //Metody------------------------------------------------------------------------------------------------------------

    /**
     * @return liczba rowerów na danym stojaku
     */
    public int ileRowerow(){
        return this.rowery.size();
    }
}
