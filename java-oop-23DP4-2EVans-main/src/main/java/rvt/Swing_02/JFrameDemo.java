package rvt.Swing_02; // Norāda, kurā mapē/paketē atrodas šī klase

// Importē SwingUtilities, kas nepieciešams GUI pareizai palaišanai
import javax.swing.SwingUtilities;

// Galvenā (starta) klase
public class JFrameDemo {

    // Programmas ieejas punkts
    public static void main(String[] args) {

        // Nodrošina, ka visi GUI elementi tiek izveidoti uz pareizā pavediena (Event Dispatch Thread)
        // Tas ir obligāti Swing aplikācijām
        SwingUtilities.invokeLater(new Runnable() {

            // Šī metode tiks izpildīta, kad GUI starts notiks
            @Override
            public void run() {

                // Izveido pirmo logu (JFrameOne)
                JFrameOne frameOne = new JFrameOne();
                // Konstruktorā jau tiek izsaukta initialize() metode

                // Izveido otro logu (JFrameTwo)
                JFrameTwo frameTwo = new JFrameTwo();

                // Šeit tu VĒLREIZ izsauc initialize()
                // ❗ BET konstruktors to jau dara → tas nozīmē, ka logs inicializējas 2 reizes
                frameTwo.initialize();
            }
        });
    }
}
