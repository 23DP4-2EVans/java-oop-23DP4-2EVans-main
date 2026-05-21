package rvt.Swing_01; // Pakotne (tai jāsakrīt ar mapes struktūru)

import javax.swing.JFrame; // Importē JFrame klasi (loga klase)

// Klase, kas atbild par galveno logu
public class MainWindow {

    // Mainīgais, kas satur JFrame objektu (pašu logu)
    private JFrame window;

    // Klases konstruktors – tiek izsaukts, kad veido jaunu MainWindow objektu
    public MainWindow() {

        // Izveido jaunu logu
        window = new JFrame();

        // Uzstāda loga virsrakstu (tekstus augšā)
        window.setTitle("Hello World !");

        // Nosaka, kas notiek, kad logs tiek aizvērts
        // DISPOSE_ON_CLOSE aizver logu, bet NEAPTUR visu programmu
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Uzstāda loga izmēru (platums = 800, augstums = 500 pikseļi)
        window.setSize(800, 500);

        // Novieto logu ekrāna centrā
        window.setLocationRelativeTo(null);
    }

    // Metode, kas parāda logu
    public void show() {

        // Padara logu redzamu
        window.setVisible(true);
    }
}