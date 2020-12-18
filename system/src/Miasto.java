/**
 * Klasa danegi miasta, zawiera jego nazwę, zakres współrzędnych miasta (aby informować go, że wyjechał on poza jego
 * granice) oraz informacje o jego systemie rowerowym
 */
public class Miasto {

    //Pola-------------------------------------------------------------------------------------------------------------
    private int xMin;
    private int xMax;
    private int yMin;
    private int yMax;
    private SystemRowerowy system;
    private String nazwa;

    //Settery/Gettery/Konstruktory-------------------------------------------------------------------------------------


    public int getxMin() {
        return xMin;
    }

    public void setxMin(int xMin) {
        this.xMin = xMin;
    }

    public int getxMax() {
        return xMax;
    }

    public void setxMax(int xMax) {
        this.xMax = xMax;
    }

    public int getyMin() {
        return yMin;
    }

    public void setyMin(int yMin) {
        this.yMin = yMin;
    }

    public int getyMax() {
        return yMax;
    }

    public void setyMax(int yMax) {
        this.yMax = yMax;
    }

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

    public Miasto(int xMin, int xMax, int yMin, int yMax, SystemRowerowy system, String nazwa) {
        this.xMin = xMin;
        this.xMax = xMax;
        this.yMin = yMin;
        this.yMax = yMax;
        this.system = system;
        this.nazwa = nazwa;
    }
    //Metody-----------------------------------------------------------------------------------------------------------

}
