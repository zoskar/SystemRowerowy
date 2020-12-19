import java.util.ArrayList;
import java.util.List;

/** Klasa SystemRowerowy
 *
 */
public class SystemRowerowy {
    private List<Rower> listaWypozyczonychRowerow;
    private ArrayList<StacjaRowerowa> stacjeRowerowe;

    public List<Rower> getListaWypozyczonychRowerow() {
        return listaWypozyczonychRowerow;
    }

    public void setListaWypozyczonychRowerow(List<Rower> listaWypozyczonychRowerow) {
        this.listaWypozyczonychRowerow = listaWypozyczonychRowerow;
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
        this.listaWypozyczonychRowerow = listaRowerow;
        this.stacjeRowerowe = stacjeRowerowe;
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
    public Pair najblizszaStacja(int [] lokalizacja, boolean czyMaRower){
        Pair pair = new Pair();
        //jako minimum ustawiamy parametry pierwszej stacji, potem ewentualnie są one zmieniane
        String stacja = this.stacjeRowerowe.get(0).getNazwaStacji();
        double x2 = Math.pow(lokalizacja[0]-this.stacjeRowerowe.get(0).getX(), 2);
        double y2 = Math.pow(lokalizacja[1]-this.stacjeRowerowe.get(0).getY(), 2);
        double minimalnaOdleglosc = Math.sqrt(x2 + y2);
        //pętla przechodząca po stacjach i szukająca stacji dla której odległość od użytkownika jest mniejsza
        //zapisuje również nową nazwę stacji minimum
        for (int i = 1; i <this.stacjeRowerowe.size(); i++) {
            //jeśli użytkownik ma rower i szuka najbliższej stacji to pomijamy stacje bez wolnych miejsc
            if (czyMaRower && this.stacjeRowerowe.get(i).getWolneMiejsca() <= 0 ) continue;
            x2 = Math.pow(lokalizacja[0]-this.stacjeRowerowe.get(i).getX(), 2);
            y2 = Math.pow(lokalizacja[1]-this.stacjeRowerowe.get(i).getY(), 2);
            if (minimalnaOdleglosc>Math.sqrt(x2 + y2)){
                minimalnaOdleglosc = Math.sqrt(x2 + y2);
                stacja = this.stacjeRowerowe.get(i).getNazwaStacji();
            }
        }
        pair.setNazwaStacji(stacja);
        pair.setOdlegloscOdStacji(minimalnaOdleglosc);
        return pair;
    }



}
