import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        Rower rower1 = new Rower(1234,4321);

        Stack<Rower> stack = new Stack<>();

        stack.push(rower1);

        Stojak stojak1 = new Stojak(stack);

        List<Stojak> stojakList = new ArrayList<>();

        stojakList.add(stojak1);

        StacjaRowerowa staszic = new StacjaRowerowa(stojakList,68,421,"STASZIC");

        List<Rower> rowerList = new ArrayList<>();

        List<StacjaRowerowa> stacjeRowerowaList = new ArrayList<>();

        stacjeRowerowaList.add(staszic);

        SystemRowerowy systemRowerowy = new SystemRowerowy(rowerList,stacjeRowerowaList);

        Miasto miasto = new Miasto(systemRowerowy,"Lublin");

        int [] lokalizacja = {0,423};

        Uzytkownik mati = new Uzytkownik(1234,miasto,lokalizacja,new Saldo(10));




        System.out.println(mati.maRower());

        mati.wypozyczRower(1234);

        System.out.println(mati.maRower());

        System.out.println(mati.sprawdzKodObreczy());

        System.out.println(systemRowerowy.getListaWypozyczonychRowerow());

        mati.oddajRower();

        System.out.println(mati.maRower());





    }
}

















