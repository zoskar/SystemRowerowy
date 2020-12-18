import java.util.List;

public class Uzytkownik {

    private int userID;
    private Miasto miasto;
    private List<Rower> historiaWypozyczen;

    private Rower rower;
    private int[] lokalizacja = new int[2];
    private double stanKonta;
    private int czasWypozyczenia;


    public Uzytkownik(int userID, Miasto miasto, List<Rower> historiaWypozyczen,
                      Rower rower, int[] lokalizacja, double stanKonta, int czasWypozyczenia) {
        this.userID = userID;
        this.miasto = miasto;
        this.historiaWypozyczen = historiaWypozyczen;
        this.rower = rower;
        this.lokalizacja = lokalizacja;
        this.stanKonta = stanKonta;
        this.czasWypozyczenia = czasWypozyczenia;
    }

    public boolean maRower(){
        return rower != null;
    }

    //TODO
    public void wypozyczRower(int nrRower){


    }
    //TODO
    public void oddajRower(){
        if(maRower()){

        }
        else{
            System.out.println("Nie posiadasz wypożyczonego roweru!");
        }


    }

    /**
     * Wyświetla na żądanie kod do obręczy wypożyczonego roweru
     */
    public void wyswietlKodObreczy(){
        if(maRower()){
            System.out.println(rower.getKodObreczy());
        }
        else{
            System.out.println("Nie posiadasz wypożyczonego roweru!");
        }

    }

    /**
     * Sprawdzenie salda na koncie
     */
    public void pokazStanKonta(){
        System.out.println(stanKonta);
    }

    //TODO
    public void doladujKonto(){
        // klasa Konto?
    }

    /**
     * Metoda wyświetlająca użytkownikowi nazwę najbliższej mu stacji rowerowej
     */
    public void jakaNajblizszaStacja() {
        System.out.println(this.miasto.getSystem().najblizszaStacja(lokalizacja).getNazwaStacji());
    }


    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Miasto getMiasto() {
        return miasto;
    }

    public void setMiasto(Miasto miasto) {
        this.miasto = miasto;
    }

    public List<Rower> getHistoriaWypozyczen() {
        return historiaWypozyczen;
    }

    public void setHistoriaWypozyczen(List<Rower> historiaWypozyczen) {
        this.historiaWypozyczen = historiaWypozyczen;
    }

    public Rower getRower() {
        return rower;
    }

    public void setRower(Rower rower) {
        this.rower = rower;
    }

    public int[] getLokalizacja() {
        return lokalizacja;
    }

    public void setLokalizacja(int[] lokalizacja) {
        this.lokalizacja = lokalizacja;
    }

    public double getStanKonta() {
        return stanKonta;
    }

    public void setStanKonta(double stanKonta) {
        this.stanKonta = stanKonta;
    }

    public int getCzasWypozyczenia() {
        return czasWypozyczenia;
    }

    public void setCzasWypozyczenia(int czasWypozyczenia) {
        this.czasWypozyczenia = czasWypozyczenia;
    }
}
