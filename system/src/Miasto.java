/**
 * Klasa danegi miasta, zawiera jego nazwę, zakres współrzędnych miasta (aby informować go, że wyjechał on poza jego
 * granice) oraz informacje o jego systemie rowerowym
 */
public class Miasto {

    //Pola-------------------------------------------------------------------------------------------------------------
    private SystemRowerowy system;
    private String nazwa;

    //Settery/Gettery/Konstruktory-------------------------------------------------------------------------------------


    public SystemRowerowy getSystem() {
        return system;
    }

    public void setSystem(SystemRowerowy system) {
        this.system = system;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Miasto(SystemRowerowy system, String nazwa) {

        this.system = system;
        this.nazwa = nazwa;
    }
    //Metody-----------------------------------------------------------------------------------------------------------

}
