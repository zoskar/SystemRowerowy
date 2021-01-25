import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GuiTest().displayGUI();
            }
        });

        List<Rower> rowery = genRower();

        List<Stack<Rower>> stackList = genStacks(rowery);

        List<Stojak> stojakList = genStojaki(stackList);

        List<StacjaRowerowa> stacjaRowerowaList = genStacjeRowerowe(stojakList);

        SystemRowerowy systemRowerowy = new SystemRowerowy(new ArrayList<>(), stacjaRowerowaList);

        Miasto miasto = new Miasto(systemRowerowy, "Lublin");

        int[] lokalizacja = {22, 22};

        Saldo saldo = new Saldo(10);

        Uzytkownik uzytkownik = new Uzytkownik(1, miasto, lokalizacja, saldo);

        uzytkownik.jakaNajblizszaStacja();
        uzytkownik.wypozyczRower(51);
        lokalizacja[0] = 90;
        lokalizacja[1] = 90;
        uzytkownik.oddajRower();


//        Stack<Rower> stack = new Stack<>();
//        stack.push(rower01);
//        Stojak stojak1 = new Stojak(stack);
//        List<Stojak> stojakList = new ArrayList<>();
//        stojakList.add(stojak1);
//        StacjaRowerowa staszic = new StacjaRowerowa(stojakList,68,421,"STASZIC");
//        List<Rower> rowerList = new ArrayList<>();
//        List<StacjaRowerowa> stacjeRowerowaList = new ArrayList<>();
//        stacjeRowerowaList.add(staszic);
//        SystemRowerowy systemRowerowy = new SystemRowerowy(rowerList,stacjeRowerowaList);
//        Miasto miasto = new Miasto(systemRowerowy,"Lublin");
//        int [] lokalizacja = {0,423};
//        Uzytkownik mati = new Uzytkownik(1234,miasto,lokalizacja,new Saldo(10));
//        System.out.println(mati.maRower());
//        mati.wypozyczRower(1234);
//        System.out.println(mati.maRower());
//        System.out.println(mati.sprawdzKodObreczy());
//        System.out.println(systemRowerowy.getListaWypozyczonychRowerow());
//        mati.oddajRower();
//        System.out.println(mati.maRower());
    }

    public static List<Rower> genRower() {
        List<Rower> list = new ArrayList<>();
        list.add(new Rower(10, 2797));
        int kod;
        Random random = new Random();

        for (int i = 10; i < 89; i++) {
            kod = 1000 + random.nextInt(9000);
            list.add(new Rower(i, kod));
        }
        return list;
    }

    public static List<Stack<Rower>> genStacks(List<Rower> list) {
        List<Stack<Rower>> stackList = new ArrayList<>();
        Stack<Rower> stack;
        for (int i = 0; i < 40; i++) {
            stack = new Stack<>();
            stack.push(list.get(i));
            stack.push(list.get(i + 40));
            stackList.add(stack);
        }
        return stackList;
    }

    public static List<Stojak> genStojaki(List<Stack<Rower>> stacks) {
        List<Stojak> stojakList = new ArrayList<>();
        Stojak stojak;
        for (int i = 0; i < 40; i++) {
            stojak = new Stojak(stacks.get(i));
            stojakList.add(stojak);
        }
        return stojakList;
    }

    public static List<StacjaRowerowa> genStacjeRowerowe(List<Stojak> stojakList) {
        List<String> names = new ArrayList<>(Arrays.asList("Staszic", "3go Maja", "Podzamcze", "Muzyczna", "PKP",
                "Brama Krakowska", "Politechnika", "UMCS", "KUL", "Dolna Panny Marii"));

        List<StacjaRowerowa> stacjaRowerowaList = new ArrayList<>();
        StacjaRowerowa stacjaRowerowa;
        List<Stojak> stojakList1;
        for (int i = 0; i < 10; i++) {
            stojakList1 = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                stojakList1.add(stojakList.get(i + 10 * j));
            }
            stacjaRowerowa = new StacjaRowerowa(stojakList1, i * 10, i * 10, names.get(i));//TODO współrzędne zgodne z GUI
            stacjaRowerowaList.add(stacjaRowerowa);
        }
        return stacjaRowerowaList;
    }

}

























