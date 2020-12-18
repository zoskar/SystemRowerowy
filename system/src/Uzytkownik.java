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


    public void wypozyczRower(int nrRower){


    }

    public void oddajRower(){
        if(maRower()){
            // oddaj rower
        }
        else{
            System.out.println("Nie posiadasz wypożyczonego roweru!");
        }


    }

    public void wyswietlKodObreczy(){
        if(maRower()){
            //System.out.println(rower.kodObreczy);
        }
        else{
            System.out.println("Nie posiadasz wypożyczonego roweru!");
        }

    }

    public void pokazStanKonta(){
        System.out.println(stanKonta);
    }

    public void doladujKonto(){
        // klasa Konto?
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
