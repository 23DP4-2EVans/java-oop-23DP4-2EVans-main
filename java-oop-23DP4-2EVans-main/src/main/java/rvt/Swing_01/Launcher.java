package rvt.Swing_01; // Norāda, kurā paketē (mapē) atrodas šī klase

// Importē SwingUtilities klasi, kas palīdz palaist GUI (logu) pareizi
import javax.swing.SwingUtilities;

// Galvenā klase, no kuras sākas programma
public class Launcher {

    // Galvenā metode (ieejas punkts programmā)
    public static void main(String[] args) {

        // Šī metode nodrošina, ka GUI tiek palaists uz pareizā pavediena (Event Dispatch Thread)
        // Swing bibliotēka prasa, lai visi GUI elementi tiktu veidoti šajā pavedienā
        SwingUtilities.invokeLater(new Runnable() {

            // Šī metode tiks izsaukta, kad programma startēs GUI
            @Override
            public void run() {

                // Izveido jaunu logu (MainWindow objektu)
                MainWindow main = new MainWindow();

                // Parāda logu uz ekrāna
                main.show();
            }
        });
    }
}