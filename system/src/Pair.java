/**
 * Klasa "robocza", powstała aby nie kopiować kodu liczacego odległość użytkownika od najbliższej stacji.
 * Symuluje ona parę typów <nazwa stacji, odległość od stacji>, ponieważ w jednym wykorzystaniu kodu potrzebujemy
 * tylko nazwy, w innym tylko odległości.
 */
public class Pair {
    private String nazwaStacji;
    private double odlegloscOdStacji;

    public String getNazwaStacji() {
        return nazwaStacji;
    }

    public void setNazwaStacji(String nazwaStacji) {
        this.nazwaStacji = nazwaStacji;
    }

    public double getOdlegloscOdStacji() {
        return odlegloscOdStacji;
    }

    public void setOdlegloscOdStacji(double odlegloscOdStacji) {
        this.odlegloscOdStacji = odlegloscOdStacji;
    }
}
