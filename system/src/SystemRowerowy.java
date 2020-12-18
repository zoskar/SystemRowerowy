import java.util.ArrayList;
import java.util.List;

/** Klasa SystemRowerowy
 *
 */
public class SystemRowerowy {
    private List<Rower> listaRowerow;
    private ArrayList<StacjaRowerowa> stacjeRowerowe;

    /**
     * @param listaRowerow wypełnić
     * @param stacjeRowerowe wypełnić
     */
    public SystemRowerowy (ArrayList<Rower> listaRowerow, ArrayList<StacjaRowerowa> stacjeRowerowe) {
        this.listaRowerow = listaRowerow;
        this.stacjeRowerowe = stacjeRowerowe;
    }


//    public void StacjaRowerowa jakaStacja(List<Integer> lokalizacja) {
//        // return stacjeRowerowe.get(lokalizacja.get());
//    }

    public Rower jakiRower(int nrRoweru) {
        return listaRowerow.get(nrRoweru);
    }
    // Metoda do pobierania opłaty za konto.

    public void pomniejszKonto(double czasWypozyczenia) {

    }
    // Metoda do zasilania konta.

    public void powiekszKonto(double kwota) {

    }
}
