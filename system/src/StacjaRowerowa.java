import java.util.List;

/** Klasa StacjaRowerowa ...
 *
 */
public class StacjaRowerowa {
    private List<Rower> Stojak;
    private int x;
    private int y;

    /**
     * @param Stojak Lista obiektów klasy Rower.
     * @param x Pierwsza współrzędna obiektu klasy StacjaRowerowa.
     * @param y Druga współrzędna obiektu klasy Stacjarowerowa.
     */
    public StacjaRowerowa (List<Rower> Stojak, int x, int y){
        this.Stojak = Stojak;
        this.x = x;
        this.y = y;

    }

    public List<Rower> getStojak() {
        return Stojak;
    }

    public void setStojak(List<Rower> stojak) {
        Stojak = stojak;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    // Metoda obliczająca liczbę rowerów w stojaku
    public int liczbaRowerow() {
        return -1;

    }

    // Metoda zwracająca obiekt klasy Stojak
    public List<Rower> ktoryStojak(Object Rower) {
        return Stojak;
    }

    // Metoda ,,przyjmująca'' rower do stacji rowerowej
    public void przyjmijRower() {

    }



}
