import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class GuiTest extends JComponent{

        private MyPanel contentPane;
        private int x1,y1;
        private Thread thread;

        void displayGUI() {

            // Generowanie obiektów do GUI
            java.util.List<Rower> rowery = Test.genRower();
            java.util.List<Stack<Rower>> stackList = Test.genStacks(rowery);
            java.util.List<Stojak> stojakList = Test.genStojaki(stackList);
            List<StacjaRowerowa> stacjaRowerowaList = Test.genStacjeRowerowe(stojakList);
            SystemRowerowy systemRowerowy = new SystemRowerowy(new ArrayList<>(), stacjaRowerowaList);
            Miasto miasto = new Miasto(systemRowerowy, "Lublin");
            int[] lokalizacja = {22, 22};
            Saldo saldo = new Saldo(10);
            Uzytkownik user = new Uzytkownik(1, miasto, lokalizacja, saldo);


            int x = 12, y = 222, szer = 150, wys = 90;
            int vShift = 100; // vertical
            Font czcionka = new Font("Courier", Font.BOLD, 50);

            JFrame frame = new JFrame("System Rowerowy");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            contentPane = new MyPanel();
            contentPane.setPreferredSize(new Dimension(1024, 750));

            // Napis Lublin
            JLabel miastoNapis = new JLabel("Lublin");
            miastoNapis.setBounds(480,29,300,50);
            miastoNapis.setFont(czcionka);

            // Przyciski pod Informacjami o użytkowniku
            JButton buttonWypozyczRower = new JButton("Wypożycz rower");
            JButton buttonOddajRower = new JButton("Oddaj rower");
            JButton buttonNajblizszaStacja = new JButton("Najbliższa stacja");
            JButton buttonKodObreczy = new JButton("Kod obręczy");
            JButton buttonKontakt = new JButton("Kontakt");


            // Położenie przycisków
            buttonWypozyczRower.setBounds(x, y, szer, wys);
            buttonOddajRower.setBounds(x, y+vShift, szer, wys);
            buttonNajblizszaStacja.setBounds(x, y+2*vShift, szer, wys);
            buttonKodObreczy.setBounds(x, y+3*vShift, szer, wys);
            buttonKontakt.setBounds(x, y+4*vShift, szer, wys);


            // GridLayouty
            GridLayout gridLayoutInformacje = new GridLayout(4, 2); //GridLayout dla małego panelu informacji
            GridLayout gridLayoutPrawyGorny = new GridLayout(2,2); //GridLayout dla prawego górnego rogu
            gridLayoutInformacje.setVgap(15);
            gridLayoutInformacje.setHgap(5);
            gridLayoutPrawyGorny.setVgap(15);
            gridLayoutPrawyGorny.setHgap(5);

            // Panele i obramówki do paneli
            JPanel panelMaly = new JPanel(gridLayoutInformacje);
            JPanel panelPrawyGorny = new JPanel(gridLayoutPrawyGorny);

            panelMaly.setBounds(x,0,szer,wys+110);
            panelPrawyGorny.setBounds(x+816,0,szer,wys);
            panelMaly.setBorder(BorderFactory.createTitledBorder("Informacje o użytk."));
            panelPrawyGorny.setBorder(BorderFactory.createTitledBorder("Info"));

            // Pola wyświetlania mały panel informacji
            JTextPane rowerWyswietlanie = new JTextPane();
            JTextPane nrRoweruWyswietlanie = new JTextPane();
            JTextPane czasWyswietlanie = new JTextPane();
            JTextPane lokalizacjaWyswietlanie = new JTextPane();

            // Pola wyświetlania panel prawy górny róg
            JTextPane idWyswietlanie = new JTextPane();
            JTextPane saldoWyswietlanie = new JTextPane();
            rowerWyswietlanie.setEditable(false);
            nrRoweruWyswietlanie.setEditable(false);
            czasWyswietlanie.setEditable(false);
            lokalizacjaWyswietlanie.setEditable(false);
            idWyswietlanie.setEditable(false);
            saldoWyswietlanie.setEditable(false);

            // Centrowanie napisów w panelach
            JPanel panelRowerWyswietlanieCenter = new JPanel(new GridLayout(0,1));
            rowerWyswietlanie.setBorder(new EmptyBorder(7,17,5,3));
            panelRowerWyswietlanieCenter.add(rowerWyswietlanie);

            JPanel panelNrRoweruWyswietlanieCenter = new JPanel(new GridLayout(0,1));
            nrRoweruWyswietlanie.setBorder(new EmptyBorder(8,24,5,3));
            panelNrRoweruWyswietlanieCenter.add(nrRoweruWyswietlanie);

            JPanel panelCzasWyswietlanieCenter = new JPanel(new GridLayout(0,1));
            czasWyswietlanie.setBorder(new EmptyBorder(8,24,5,3));
            panelCzasWyswietlanieCenter.add(czasWyswietlanie);

            JPanel panelLokalizacjaWyswietlanieCenter = new JPanel(new GridLayout(0,1));
            lokalizacjaWyswietlanie.setBorder(new EmptyBorder(7,4,5,3));
            panelLokalizacjaWyswietlanieCenter.add(lokalizacjaWyswietlanie);

            JPanel panelIdWyswietlenieCenter = new JPanel(new GridLayout(0,1));
            idWyswietlanie.setBorder(new EmptyBorder(7,30,5,3));
            panelIdWyswietlenieCenter.add(idWyswietlanie);

            JPanel panelSaldoWyswietlenieCenter = new JPanel(new GridLayout(0,1));
            saldoWyswietlanie.setBorder(new EmptyBorder(7,25,5,3));
            panelSaldoWyswietlenieCenter.add(saldoWyswietlanie);


            // Dodawanie do panela małego z obramówką
            panelMaly.add(new JLabel("Rower: "));
            panelMaly.add(panelRowerWyswietlanieCenter);
            panelMaly.add(new JLabel("Nr roweru: "));
            panelMaly.add(panelNrRoweruWyswietlanieCenter);
            panelMaly.add(new JLabel("Czas: "));
            panelMaly.add(panelCzasWyswietlanieCenter);
            panelMaly.add(new JLabel("Pozycja: "));
            panelMaly.add(panelLokalizacjaWyswietlanieCenter);

            // Dodawanie do panela prawy górny róg z obramówką
            panelPrawyGorny.add(new JLabel("ID: "));
            panelPrawyGorny.add(panelIdWyswietlenieCenter);
            panelPrawyGorny.add(new JLabel("Saldo: "));
            panelPrawyGorny.add(panelSaldoWyswietlenieCenter);

            // Użytkownik na mapie
            JPanel marker = new JPanel(null);
            marker.setBackground(new Color(255,128,0));

            // Dodawanie do głównego panelu

            contentPane.add(buttonWypozyczRower);
            contentPane.add(buttonOddajRower);
            contentPane.add(buttonNajblizszaStacja);
            contentPane.add(buttonKodObreczy);
            contentPane.add(buttonKontakt);
            contentPane.add(panelMaly);
            contentPane.add(panelPrawyGorny);
            contentPane.add(miastoNapis);
            contentPane.add(marker);
            frame.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    PointerInfo a = MouseInfo.getPointerInfo();
                    Point point = new Point(a.getLocation());
                    SwingUtilities.convertPointFromScreen(point, e.getComponent());
                    x1=(int) point.getX();
                    y1=(int) point.getY();
                    int [] lokalizacjaUzytkownika = new int[2];
                    lokalizacjaUzytkownika[0] = x1;
                    lokalizacjaUzytkownika[1] = y1;
                    user.setLokalizacja(lokalizacjaUzytkownika);
                    lokalizacjaWyswietlanie.setText("(" +x1 +","+y1+")");
                    marker.setBounds(x1-10, y1-34, 20, 20);
//                    System.out.println(Arrays.toString(user.getLokalizacja()));
//                    System.out.println("X: "+ x1 + ", Y: "+ y1);

                }
            });
            contentPane.setLayout(null);

            // Ustawienie labelów
            rowerWyswietlanie.setText(String.valueOf(user.maRower()));
            idWyswietlanie.setText(String.valueOf(user.getUserID()));
            saldoWyswietlanie.setText(String.valueOf(user.getSaldo().getKwota()));


            // Funkcjonalność przycisków
            ActionListener wypozyczRowerAkcja = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if(!user.maRower()){

                        Pair stacjaObokUzytkownika = user.getSystemRowerowy().najblizszaStacja(user.getLokalizacja(),user.maRower());
                        if(stacjaObokUzytkownika.getOdlegloscOdStacji() <= 35){
                            StringBuilder info = new StringBuilder("Stacja: " + stacjaObokUzytkownika.getNajblizszaStacja().getNazwaStacji() +
                                    "\nDostępne rowery na stacji: \n") ;
                            for (int i = 0; i < stacjaObokUzytkownika.getNajblizszaStacja().getStojaki().size(); i++) {
                                    info.append("Stojak ").append(i).append(": ");
                                for (int j = 0; j < stacjaObokUzytkownika.getNajblizszaStacja().getStojaki().get(i).ileRowerow() ; j++) {
                                    info.append(stacjaObokUzytkownika.getNajblizszaStacja().getStojaki().get(i).getRowery().get(j).getNrRoweru()).append(", ");
                                }
                                info.append("\n");
                            }

                            String wypozyczRowerInfo = "Numer roweru";
                            String opcja = (String) JOptionPane.showInputDialog(contentPane, info,wypozyczRowerInfo);

                            try {

                                user.wypozyczRower(Integer.parseInt(opcja));
                                thread = new Thread() {
                                    @Override
                                    public void run() {
                                        int czas = 0;
                                        while(!Thread.currentThread().isInterrupted() && user.maRower()) {
                                            czasWyswietlanie.setText(String.valueOf(czas));
                                            czas += 1;
                                            try {
                                                Thread.sleep(1000);
                                            } catch (InterruptedException interruptedException) {
                                                break;
                                            }
                                        }
                                    }

                                };
                                thread.start();
                                rowerWyswietlanie.setText(String.valueOf(user.maRower()));
                                nrRoweruWyswietlanie.setText(String.valueOf(user.getRower().getNrRoweru()));
                                JOptionPane.showMessageDialog(contentPane, "Szerokiej drogi","Pomyślne wypożyczenie roweru",JOptionPane.INFORMATION_MESSAGE);
                            }
                            catch (NullPointerException e1){
                                String msg = "Rower o podanym numerze nie znajduje się na stacji na ktrórej jest użytkownik lub rower " +
                                        "nie jest ostatni w danym stojaku";
                                JOptionPane.showMessageDialog(contentPane, msg,"Błąd wypożyczania",JOptionPane.ERROR_MESSAGE);
                            }
                            catch (NumberFormatException e2) {
                                String msg = "Przerwano wypożyczanie roweru";
                                JOptionPane.showMessageDialog(contentPane, msg,"Przerwanie wypożyczania",JOptionPane.ERROR_MESSAGE);
                            }
                        }

                        else{
                            JOptionPane.showMessageDialog(contentPane, "Jesteś za daleko od stacji!","Za daleko od stacji",JOptionPane.INFORMATION_MESSAGE);
                        }
                    }

                    else{

                        JOptionPane.showMessageDialog(contentPane,"Masz już wypożyczony rower","Wypożyczony rower",JOptionPane.ERROR_MESSAGE );
                    }

                }
            };
            ActionListener oddajRowerAkcja = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(user.maRower()){

                        Pair stacjaObokUzytkownika = user.getSystemRowerowy().najblizszaStacja(user.getLokalizacja(),user.maRower());
                        if(stacjaObokUzytkownika.getOdlegloscOdStacji() <= 35){
                            String info = "Czy chcesz oddać rower na stację: " + stacjaObokUzytkownika.getNajblizszaStacja().getNazwaStacji();
                            Object[] options = {"Tak",
                                    "Nie!"};
                            int potwierdzWybor = JOptionPane.showOptionDialog(contentPane,info,"Potwierdzenie oddania",JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                            if(potwierdzWybor == 0){
                                try{
                                    user.oddajRower();

                                    thread.interrupt();
                                    user.getSaldo().pomniejsz(Integer.parseInt(czasWyswietlanie.getText()));
                                    saldoWyswietlanie.setText(String.valueOf(user.getSaldo().getKwota()));


                                    rowerWyswietlanie.setText(String.valueOf(user.maRower()));
                                    czasWyswietlanie.setText("");
                                    nrRoweruWyswietlanie.setText("");

                                    if(user.getSaldo().getKwota() <= 0 ) {
                                        JOptionPane.showMessageDialog(contentPane, "Stan twojego konta jest nie większy niż 0", "Uwaga niski stan konta", JOptionPane.WARNING_MESSAGE);
                                    }

                                } catch (PelnaStacjaException pelnaStacjaException) {
                                    JOptionPane.showMessageDialog(contentPane,pelnaStacjaException.getMessage(),"Pełna stacja",JOptionPane.ERROR_MESSAGE );
                                }
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(contentPane, "Jesteś za daleko od stacji!","Za daleko od stacji",JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(contentPane,"Nie masz wypożyczonego roweru","Brak wypożyczonego roweru",JOptionPane.ERROR_MESSAGE );
                    }

                }
            };
            ActionListener najblizszaStacjaAkcja = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String nazwaStacji = user.jakaNajblizszaStacja().getNazwaStacji();
                    String najblizszaStacjaInfo = "Najblisza stacja to " + nazwaStacji;
                    JOptionPane.showMessageDialog(contentPane, najblizszaStacjaInfo,"Najbliższa stacja", JOptionPane.INFORMATION_MESSAGE);
                }
            };
            ActionListener kodObreczyAkcja = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(user.maRower()){
                        String kodObreczy = "Kod obręczy to: " + user.getRower().getKodObreczy();
                        JOptionPane.showMessageDialog(contentPane, kodObreczy,"Kod obręczy", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(contentPane, "Nie posiadasz roweru.","Błąd kodu obręczy", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            };
            ActionListener kontaktAkcja = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String msg = """
                    Autorzy projektu: Mateusz Mianowny, Rafał Wolter, Oscar Zając.""";
                    JOptionPane.showMessageDialog(contentPane, msg,"Kontakt", JOptionPane.INFORMATION_MESSAGE);
                }
            };


            // Dodanie funkcjonalności do przycisków
            buttonWypozyczRower.addActionListener(wypozyczRowerAkcja);
            buttonOddajRower.addActionListener(oddajRowerAkcja);
            buttonNajblizszaStacja.addActionListener(najblizszaStacjaAkcja);
            buttonKodObreczy.addActionListener(kodObreczyAkcja);
            buttonKontakt.addActionListener(kontaktAkcja);


            frame.setResizable(false);
            frame.setLayout(null);
            frame.setContentPane(contentPane);
            frame.pack();
            frame.setLocationByPlatform(true);
            frame.setVisible(true);



        }

        private class MyPanel extends JPanel {

            private BufferedImage image;

            public MyPanel() {
                try {
                    image = ImageIO.read(MyPanel.class.getResource("/resources/images/bg_final.jpg"));

                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }


            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 175, 90, this);
//                g.fillOval(x1, y1, 20, 20);
            }
        }


}
