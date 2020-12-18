import java.util.Stack;

public class Stojak {

    //Pola-------------------------------------------------------------------------------------------------------------

    private boolean czyWolny;

    private Stack<Rower> rowery;

    //Settery, gettery, konstruktory-----------------------------------------------------------------------------------

    public boolean isCzyWolny() {
        return czyWolny;
    }

    public void setCzyWolny(boolean czyWolny) {
        this.czyWolny = czyWolny;
    }

    public Stack<Rower> getRowery() {
        return rowery;
    }

    public void setRowery(Stack<Rower> rowery) {
        this.rowery = rowery;
    }

    public Stojak(boolean czyWolny, Stack<Rower> rowery) {
        this.czyWolny = czyWolny;
        this.rowery = rowery;
    }
    //Metody------------------------------------------------------------------------------------------------------------
    //TODO
    public boolean czyNaWierzchu(Rower rower){
        return false;
    }
    //TODO
    public Rower wydajRower(Rower rower){
        return null;
    }
    //TODO chyba zrobiliśmy to w StacjaRowerowa
    public void przypnijRower(Rower rower){}

    /**
     * @return liczba rowerów na danym stojaku
     */
    public int ileRowerow(){
        return this.rowery.size();
    }
}
