/**
 * Klasa "robocza", powstała aby nie kopiować kodu liczacego odległość użytkownika od najbliższej stacji.
 * Symuluje ona parę typów <nazwa stacji, odległość od stacji>, ponieważ w jednym wykorzystaniu kodu potrzebujemy
 * tylko nazwy, w innym tylko odległości.
 */
public class Pair {
    private StacjaRowerowa najblizszaStacja;
    private double odlegloscOdStacji;

    public StacjaRowerowa getNajblizszaStacja() {
        return najblizszaStacja;
    }

    public void setNajblizszaStacja(StacjaRowerowa najblizszaStacja) {
        this.najblizszaStacja = najblizszaStacja;
    }

    public double getOdlegloscOdStacji() {
        return odlegloscOdStacji;
    }

    public void setOdlegloscOdStacji(double odlegloscOdStacji) {
        this.odlegloscOdStacji = odlegloscOdStacji;
    }
}