import java.util.List;

public class Uzytkownik {

    private int userID;
    private Miasto miasto;
    private Rower rower;
    private int[] lokalizacja;
    private int czasWypozyczenia;
    private SystemRowerowy systemRowerowy;
    private Saldo saldo;

    public Uzytkownik(int userID, Miasto miasto, int[] lokalizacja, Saldo saldo) {
        this.userID = userID;
        this.miasto = miasto;
        this.rower = null;
        this.lokalizacja = lokalizacja;
        this.czasWypozyczenia = 0;
        this.systemRowerowy = this.miasto.getSystem();
        this.saldo = saldo;
    }

    public boolean maRower(){
        return rower != null;
    }

    /**
     * Metoda wypożyczenia roweru
     * @param nrRoweru numer roweru który użytkownik chce wypożyczyć
     */
    public void wypozyczRower(int nrRoweru){
        //sprawdzamy czy użytkownik nie ma już wypożyczonego roweru
        if (!maRower()){
            Pair para = systemRowerowy.najblizszaStacja(lokalizacja, maRower());
            StacjaRowerowa najblizszaStacja = para.getNajblizszaStacja();
            double odlegloscOdStacji = para.getOdlegloscOdStacji();
            if (odlegloscOdStacji < 20){
                //jest możliwość braku powodzenia: podany rower jest w środku stacja rowerów
                rower = najblizszaStacja.wydajRower(nrRoweru);
                //jeżeli udało się wypożyczyć rower
                if (maRower()){
                    systemRowerowy.getListaWypozyczonychRowerow().add(rower);
                    // TODO wystartowanie timera w GUI
                }
            }
            else {
                System.out.println("Nie znajdujesz się w pobliżu żadnej stacji. Najbliższa stacja to " +
                        najblizszaStacja.getNazwaStacji() + " odległa od Ciebie o " + odlegloscOdStacji);
            }
        }
        else {
            System.out.println("Masz obecnie wypożyczony rower!");
        }

    }
    public void oddajRower(){
        if(maRower()){
            Pair para = this.systemRowerowy.najblizszaStacja(this.lokalizacja, maRower());
            StacjaRowerowa najblizszaStacja = para.getNajblizszaStacja();
            double odlegloscOdStacji = para.getOdlegloscOdStacji();
            if (odlegloscOdStacji <= 20){
                System.out.println("Czy chcesz oddać rower w stacji: " + najblizszaStacja.getNazwaStacji() + "?");
                //wyswietlenie przycisków
                boolean wybor = true; //wybor użytkownika

                //sprawdzamy czy stacja przyjmie rower (czy ma wolne miejsca)
                if (najblizszaStacja.przyjmijRower(this.rower)){
                    this.systemRowerowy.getListaWypozyczonychRowerow().remove(this.rower);//usuniecie roweru z listy wypozyczonych rowerów
                    //czy to można tak robić?
                    System.out.print("Udało się zwrócić rower o numerze: ");
                    System.out.println(rower.getNrRoweru());
                    this.rower = null;
                    //zmniejszenie salda
                    saldo.pomniejsz(this.czasWypozyczenia);
                    //reset zegara wypożyczenia
                    System.out.println("Czas wypożyczenia: " +czasWypozyczenia);
                    this.czasWypozyczenia = 0;
                }
                // stacja nie ma wolnych miejsc
                else {
                    System.out.println("Stacja przy ktorej stoisz jest pełna");
                    System.out.print("Najbliższa stacja z wolnymi miejscami to: ");
                    jakaNajblizszaStacja();
                }

            }
            else {
                System.out.println("Jesteś za daleko od najbliższej stacji. Najbliższa stacja to: " +
                        najblizszaStacja.getNazwaStacji() + ". Znajdujesz się " + odlegloscOdStacji + " od niej");
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
     * Metoda wyświetlająca użytkownikowi nazwę najbliższej mu stacji rowerowej
     */
    public void jakaNajblizszaStacja() {
        System.out.println(this.systemRowerowy.najblizszaStacja(lokalizacja, maRower()).getNajblizszaStacja().getNazwaStacji());
    }

    public int sprawdzKodObreczy(){
        if (maRower()) return rower.getKodObreczy();

        else {
            return -1;
        }
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

    public int getCzasWypozyczenia() {
        return czasWypozyczenia;
    }

    public void setCzasWypozyczenia(int czasWypozyczenia) {
        this.czasWypozyczenia = czasWypozyczenia;
    }

    public SystemRowerowy getSystemRowerowy() {return systemRowerowy;}

    public void setSystemRowerowy(SystemRowerowy systemRowerowy) {this.systemRowerowy = systemRowerowy;}

    public Saldo getSaldo() {return saldo;}

    public void setSaldo(Saldo saldo) {this.saldo = saldo;}
}
