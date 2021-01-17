import java.util.List;

public class Uzytkownik {

    private int userID;
    private Miasto miasto;
    private Rower rower;
    private int[] lokalizacja;
    private int czasWypozyczenia;
    private SystemRowerowy systemRowerowy;
    private Saldo saldo;

    public Uzytkownik(int userID, Miasto miasto, Rower rower, int[] lokalizacja, Saldo saldo, int czasWypozyczenia) {
        this.userID = userID;
        this.miasto = miasto;
        this.rower = rower;
        this.lokalizacja = lokalizacja;
        this.czasWypozyczenia = czasWypozyczenia;
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
            String najblizszaStacja = para.getNazwaStacji();
            double odlegloscOdStacji = para.getOdlegloscOdStacji();
            if (odlegloscOdStacji < 20){
                for (int i = 0; i <systemRowerowy.getStacjeRowerowe().size(); i++) {
                    if (systemRowerowy.getStacjeRowerowe().get(i).getNazwaStacji().equals(najblizszaStacja)){
                        rower = systemRowerowy.getStacjeRowerowe().get(i).wydajRower(nrRoweru);
                        systemRowerowy.getListaWypozyczonychRowerow().add(rower);

                    }
                }
            }
            else {
                System.out.println("Nie znajdujesz się w pobliżu żadnej stacji. Najbliższa stacja to " +
                        najblizszaStacja + " odległa od Ciebie o " + odlegloscOdStacji);
            }
        }
        else {
            System.out.println("Masz obecnie wypożyczony rower!");
        }

    }
    public void oddajRower(){
        if(maRower()){
            Pair para = this.systemRowerowy.najblizszaStacja(this.lokalizacja, maRower());
            String najblizszaStacja = para.getNazwaStacji();
            double odlegloscOdStacji = para.getOdlegloscOdStacji();
            if (odlegloscOdStacji <= 20){
                System.out.println("Czy chcesz oddać rower w stacji: " + najblizszaStacja + "?");
                //wyswietlenie przycisków
                boolean wybor = true; //wybor użytkownika
                //iterujemy po wszystkich stacjach
                for (int i = 0; i <this.systemRowerowy.getStacjeRowerowe().size(); i++) {
                    //szukamy stacji której nazwa jest równa najbliższej stacji od użytkownika
                    //brak else, ponieważ wiemy że musi istnieć stacja o podanej nazwie
                    if (this.systemRowerowy.getStacjeRowerowe().get(i).getNazwaStacji().equals(najblizszaStacja) ){
                        //sprawdzamy czy stacja przyjmie rower (czy ma wolne miejsca)
                        if (this.systemRowerowy.getStacjeRowerowe().get(i).przyjmijRower(this.rower)){
                            this.systemRowerowy.getListaWypozyczonychRowerow().remove(this.rower);//usuniecie roweru z listy wypozyczonych rowerów
                            //czy to można tak robić?
                            this.rower = null;
                            //zwiększenie salda
                            saldo.pomniejsz(this.czasWypozyczenia);
                            //reset zegara wypożyczenia
                            this.czasWypozyczenia = 0;
                            break;
                        }
                        // stacja nie ma wolnych miejsc
                        else {
                            System.out.println("Stacja przy ktorej stoisz jest pełna");
                            System.out.print("Najbliższa stacja z wolnymi miejscami to: ");
                            jakaNajblizszaStacja();
                        }
                    }
                }
            }
            else {
                System.out.println("Jesteś za daleko od najbliższej stacji. Najbliższa stacja to: " + najblizszaStacja +
                        " . Znajdujesz się " + odlegloscOdStacji + " od niej");
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
        System.out.println(this.systemRowerowy.najblizszaStacja(lokalizacja, maRower()).getNazwaStacji());
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
