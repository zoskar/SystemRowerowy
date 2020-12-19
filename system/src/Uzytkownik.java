import java.util.List;
import java.util.Scanner;

public class Uzytkownik {

    private int userID;
    private Miasto miasto;
    private List<Rower> historiaWypozyczen;

    private Rower rower;
    private int[] lokalizacja = new int[2];
    private double stanKonta;
    private int czasWypozyczenia;
    private SystemRowerowy systemRowerowy;


    public Uzytkownik(int userID, Miasto miasto, List<Rower> historiaWypozyczen,
                      Rower rower, int[] lokalizacja, double stanKonta, int czasWypozyczenia) {
        this.userID = userID;
        this.miasto = miasto;
        this.historiaWypozyczen = historiaWypozyczen;
        this.rower = rower;
        this.lokalizacja = lokalizacja;
        this.stanKonta = stanKonta;
        this.czasWypozyczenia = czasWypozyczenia;
        this.systemRowerowy = this.miasto.getSystem();

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
            Scanner scanner = new Scanner(System.in);
            Pair para = this.systemRowerowy.najblizszaStacja(this.lokalizacja);
            String najblizszaStacja = para.getNazwaStacji();
            double odlegloscOdStacji = para.getOdlegloscOdStacji();
            if (odlegloscOdStacji <= 20){
                System.out.println("Czy chcesz oddać rower w stacji: " + najblizszaStacja + "?");
                //wyswietlenie przycisków
                boolean wybor = true; //wybor użytkownika
                for (int i = 0; i <this.systemRowerowy.getStacjeRowerowe().size(); i++) {
                    if (this.systemRowerowy.getStacjeRowerowe().get(i).getNazwaStacji().equals(najblizszaStacja) ){
                        if (this.systemRowerowy.getStacjeRowerowe().get(i).przyjmijRower(this.rower)){
                            this.rower = null; //czy to można tak robić
                        }
                        else System.out.println("Stacja przy ktorej stoisz jest pełna");



                    }
                }
            }
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
        System.out.println(this.systemRowerowy.najblizszaStacja(lokalizacja).getNazwaStacji());
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

    public SystemRowerowy getSystemRowerowy() {return systemRowerowy;}

    public void setSystemRowerowy(SystemRowerowy systemRowerowy) {this.systemRowerowy = systemRowerowy;}
}
