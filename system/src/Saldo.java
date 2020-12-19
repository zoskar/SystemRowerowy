public class Saldo {

    private int kwota;

    public Saldo(int kwota) {
        this.kwota = kwota;
    }

    public int getKwota() {
        return kwota;
    }

    public void setKwota(int kwota) {
        this.kwota = kwota;
    }

    public void pomniejsz(int czasWypozyczenia){
        if (czasWypozyczenia <= 15)
            return;
        this.kwota -= czasWypozyczenia;
    }
}
