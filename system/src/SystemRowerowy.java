import java.util.ArrayList;
import java.util.List;

/** Klasa SystemRowerowy
 *
 */
public class SystemRowerowy {
    private List<Rower> listaRowerow;
    private ArrayList<StacjaRowerowa> stacjeRowerowe;

    public List<Rower> getListaRowerow() {
        return listaRowerow;
    }

    public void setListaRowerow(List<Rower> listaRowerow) {
        this.listaRowerow = listaRowerow;
    }

    public ArrayList<StacjaRowerowa> getStacjeRowerowe() {
        return stacjeRowerowe;
    }

    public void setStacjeRowerowe(ArrayList<StacjaRowerowa> stacjeRowerowe) {
        this.stacjeRowerowe = stacjeRowerowe;
    }

    /**
     * @param listaRowerow wypełnić
     * @param stacjeRowerowe wypełnić
     */
    public SystemRowerowy (ArrayList<Rower> listaRowerow, ArrayList<StacjaRowerowa> stacjeRowerowe) {
        this.listaRowerow = listaRowerow;
        this.stacjeRowerowe = stacjeRowerowe;
    }

    //TODO nie pamiętamy do czego to jest
    public Rower jakiRower(int nrRoweru) {
        return listaRowerow.get(nrRoweru);
    }

    // Metoda do pobierania opłaty za konto.
    public void pomniejszKonto(double czasWypozyczenia) {

    }

    // Metoda do zasilania konta.
    public void powiekszKonto(double kwota) {

    }

    /**
     * Metoda zwraca parę ponieważ szukamy odległości w dwóch scenariuszach: sprawdzenie czy użytkownik jest
     * odpowiednio blisko najbliższej stacji aby oddać rower oraz aby podać użytkownikowi nazwę najbliższej
     * mu stacji jeśli zada on takie pytanie.
     * @param lokalizacja lokalizacja użytkownika
     * @return zwraca parę: nazwa najbliższej stacji oraz odległość od niej
     */
    //TODO czy ustawić MAXINT na odległość i iterować po wszystkich stacjach, czy zostawić jak jest
    public Pair najblizszaStacja(int [] lokalizacja){
        Pair pair = new Pair();
        //jako minimum ustawiamy parametry pierwszej stacji, potem ewentualnie są one zmieniane
        String stacja = stacjeRowerowe.get(0).getNazwaStacji();
        double x2 = Math.pow(lokalizacja[0]-stacjeRowerowe.get(0).getX(), 2);
        double y2 = Math.pow(lokalizacja[1]-stacjeRowerowe.get(0).getY(), 2);
        double minimalnaOdleglosc = Math.sqrt(x2 + y2);
        //pętla przechodząca po stacjach i szukająca stacji dla której odległość od użytkownika jest mniejsza
        //zapisuje również nową nazwę stacji minimum
        for (int i = 1; i <stacjeRowerowe.size(); i++) {
            x2 = Math.pow(lokalizacja[0]-stacjeRowerowe.get(i).getX(), 2);
            y2 = Math.pow(lokalizacja[1]-stacjeRowerowe.get(i).getY(), 2);
            if (minimalnaOdleglosc>Math.sqrt(x2 + y2)){
                minimalnaOdleglosc = Math.sqrt(x2 + y2);
                stacja = stacjeRowerowe.get(i).getNazwaStacji();
            }
        }
        pair.setNazwaStacji(stacja);
        pair.setOdlegloscOdStacji(minimalnaOdleglosc);
        return pair;
    }
}
