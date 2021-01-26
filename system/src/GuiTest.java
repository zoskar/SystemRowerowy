import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

    public class GuiTest {

        private MyPanel contentPane;

        void displayGUI() {
            //tu bedzie back




            /* TODO:

            funkcjonalność przycisków

            wyświetlanie danych o użytkowniku, rowerze, ID, saldo

            zabezpieczenie współrzędnych użytkownika przed wyjściem poza mapę

            mierzenie czasu

            opcjonalnie: pokazać użytkownikowi gdzie jest na mapie */

            int x = 12, y = 222, szer = 150, wys = 90;
            int vShift = 100; // vertical
            Font czcionka = new Font("Courier", Font.BOLD, 50);

            JFrame frame = new JFrame("System Rowerowy");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            contentPane = new MyPanel();
            contentPane.setPreferredSize(new Dimension(1024, 750));

            // Napis Lublin
            JLabel miasto = new JLabel("Lublin");
            miasto.setBounds(480,29,300,50);
            miasto.setFont(czcionka);

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
            JTextArea rowerWyswietlanie = new JTextArea();
            JTextArea nrRoweruWyswietlanie = new JTextArea();
            JTextArea czasWyswietlanie = new JTextArea();
            JTextArea lokalizacjaWyswietlanie = new JTextArea();

            // Pola wyświetlania panel prawy górny róg
            JTextArea idWyswietlanie = new JTextArea();
            JTextArea saldoWyswietlanie = new JTextArea();
            rowerWyswietlanie.setEditable(false);
            nrRoweruWyswietlanie.setEditable(false);
            czasWyswietlanie.setEditable(false);
            lokalizacjaWyswietlanie.setEditable(false);
            idWyswietlanie.setEditable(false);
            saldoWyswietlanie.setEditable(false);

            // Dodawanie do panela małego z obramówką
            panelMaly.add(new JLabel("Rower: "));
            panelMaly.add(rowerWyswietlanie);
            panelMaly.add(new JLabel("Nr roweru: "));
            panelMaly.add(nrRoweruWyswietlanie);
            panelMaly.add(new JLabel("Czas: "));
            panelMaly.add(czasWyswietlanie);
            panelMaly.add(new JLabel("Pozycja: "));
            panelMaly.add(lokalizacjaWyswietlanie);

            // Dodawanie do panela prawy górny róg z obramówką
            panelPrawyGorny.add(new JLabel("ID: "));
            panelPrawyGorny.add(idWyswietlanie);
            panelPrawyGorny.add(new JLabel("Saldo: "));
            panelPrawyGorny.add(saldoWyswietlanie);


            // Dodawanie do głównego panelu

            contentPane.add(buttonWypozyczRower);
            contentPane.add(buttonOddajRower);
            contentPane.add(buttonNajblizszaStacja);
            contentPane.add(buttonKodObreczy);
            contentPane.add(buttonKontakt);
            contentPane.add(panelMaly);
            contentPane.add(panelPrawyGorny);
            contentPane.add(miasto);
            contentPane.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    PointerInfo a = MouseInfo.getPointerInfo();
                    Point point = new Point(a.getLocation());
                    SwingUtilities.convertPointFromScreen(point, e.getComponent());
                    int x=(int) point.getX();
                    int y=(int) point.getY();
                    System.out.println("X: "+ x + ", Y: "+ y);
                }
            });
            contentPane.setLayout(null);

            // Funkcjonalność przycisków
            ActionListener wypozyczRowerAkcja = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //TODO Metoda wypozyczRower uzytkownik
                    String wypozyczRowerInfo = "Pomyślnie wypożyczono rower"; //TODO tutaj uzupełnić
                    JOptionPane.showMessageDialog(contentPane, wypozyczRowerInfo,"Wypożyczenie roweru", JOptionPane.INFORMATION_MESSAGE);
                }
            };
            ActionListener oddajRowerAkcja = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //TODO Metoda oddaj rower uzytkownik
                    String wypozyczRowerInfo = "Pomyślnie oddano rower"; //TODO tutaj uzupełnić
                    JOptionPane.showMessageDialog(contentPane, wypozyczRowerInfo,"Oddanie roweru", JOptionPane.INFORMATION_MESSAGE);
                }
            };
            ActionListener najblizszaStacjaAkcja = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //TODO Metoda najblizsza stacja
                    String wypozyczRowerInfo = "Najblisza stacja to"; //TODO tutaj uzupełnić
                    JOptionPane.showMessageDialog(contentPane, wypozyczRowerInfo,"Wypożyczenie roweru", JOptionPane.INFORMATION_MESSAGE);
                }
            };
            ActionListener kodObreczyAkcja = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //TODO Metoda
                    String wypozyczRowerInfo = "Kod obręczy to: "; //TODO tutaj uzupełnić
                    JOptionPane.showMessageDialog(contentPane, wypozyczRowerInfo,"Kod obręczy", JOptionPane.INFORMATION_MESSAGE);
                }
            };
            ActionListener kontaktAkcja = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //TODO Metoda wypozyczRower uzytkownik
                    String wypozyczRowerInfo = "Created by mojito1"; //TODO tutaj uzupełnić
                    JOptionPane.showMessageDialog(contentPane, wypozyczRowerInfo,"Kontakt", JOptionPane.WARNING_MESSAGE);
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
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 175, 90, this); // uzytkownik nie przekrocza

            }
        }


}
