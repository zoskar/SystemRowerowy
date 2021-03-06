import java.util.List;

/** Klasa StacjaRowerowa ...
 *
 */
public class StacjaRowerowa {
    private List<Stojak> stojaki;
    private int x;
    private int y;
    private int wolneMiejsca;   //aby nie pokazywać tej stacji użytkownikowi szukającemu stacji do odłożenia roweru, jeśli
                                //stacja jest pełna
    private String nazwaStacji;


    /**
     * pole wolne miejsca jest ustawiane na ilość stojaków * 5, jest to ilość rowerów jaką można przypiąć do danego
     * stojaka aby nie zakłócać porządku ruchu na chodniku
     *
     * @param stojaki lista stojaków na danej stacji
     * @param x współrzędna "x" stacji
     * @param y współrzędna "y" stacji
     * @param nazwaStacji nazwa charakterystyczna stacji
     */
    public StacjaRowerowa(List<Stojak> stojaki, int x, int y, String nazwaStacji) {
        this.stojaki = stojaki;
        this.x = x;
        this.y = y;
        this.nazwaStacji = nazwaStacji;
        this.wolneMiejsca = this.stojaki.size() * 5;
    }

    public List<Stojak> getStojaki() {
        return stojaki;
    }

    public String getNazwaStacji() {
        return nazwaStacji;
    }

    public void setNazwaStacji(String nazwaStacji) {
        this.nazwaStacji = nazwaStacji;
    }

    public int getWolneMiejsca() {
        return wolneMiejsca;
    }

    public void setWolneMiejsca(int wolneMiejsca) {
        this.wolneMiejsca = wolneMiejsca;
    }

    public void setStojaki(List<Stojak> stojaki) {
        this.stojaki = stojaki;
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

    /**
     * Metoda obliczająca liczbę rowerów w stacji
     * @return liczba rowerów na stacji
     */
    //
    public int liczbaRowerow() {
        int sum = 0;
        for (Stojak stojak : this.stojaki) {
            sum += stojak.ileRowerow();
        }
        return sum;
    }

    /**
     * Metoda która, jeśli są wolne miejsca, przyjmuje rower i odkłada go na stojak na którym jest najmniej rowerów
     * (dla zachowania porządku na chodniku).
     * @param rower - Rower który odkładamy na stojak
     */
    public boolean przyjmijRower(Rower rower) {
        if (this.wolneMiejsca <= 0){
//            System.out.println("Brak miejsc, wyszukaj stację");//można tu automatycznie uruchomic metode wyszukajStacje
            return false;
        }
        else {
            int min = 5;
            for (Stojak stojak : this.stojaki) {
                if (stojak.ileRowerow() < min) {
                    min = stojak.ileRowerow();
                }
            }
            //szuka pierwszego stojaka z min rowerów, odkłada go i zmniejsza liczbę wolnych miejsc na stacji
            for (Stojak stojak : stojaki) {
                if (stojak.ileRowerow() == min) {
                    this.wolneMiejsca -= 1;
                    stojak.getRowery().push(rower);
                    break;
                }
            }
            return true;
        }
    }
    /**
     * @param nrRoweru kod roweru który użytkownik chce wypożyczyć
     * @return Rower, jeśli pomyślnie wypożyczono, null jeśli nie
     */
    public Rower wydajRower(int nrRoweru){
        //iterujemy po stojakach szukając stojaka z szukanym rowerem
        for (Stojak stojak : stojaki) {
            if (stojak.isCzyPusty()) {
                continue;
            }
            //jeśli znaleźliśmy rower o podanym numerze
            if (stojak.getRowery().peek().getNrRoweru() == nrRoweru) {
                //jeśli użytkownik wypożycza rower który jest przypięty obręczą podajemu mu kod obręczy
                if(stojak.getRowery().size() == 1) {
                    stojak.setCzyPusty(true);
                }
                return stojak.getRowery().pop();
            }
        }
        return null;
    }
}