package rvt.Swing_02; // Pakotne

// Importē JFrame klasi (loga izveidei)
import javax.swing.JFrame;

// Klase, kas satur JFrame kā OBJEKTU (nevis pati ir JFrame)
public class JFrameTwo {

    // Mainīgais, kurā glabājas logs
    private JFrame frame;

    // Konstruktors (tiek izsaukts, kad izveido objektu)
    public JFrameTwo() {

        // Izsauc initialize metodi uzreiz
        // Tas nozīmē, ka logs uzreiz tiek izveidots
        initialize();
    }

    // Metode, kas uzstāda un konfigurē logu
    public void initialize() {

        // Izveido jaunu JFrame objektu
        frame = new JFrame();

        // Uzstāda loga virsrakstu
        this.frame.setTitle("JFrame Two");

        // Nosaka, kas notiek, aizverot logu
        // DISPOSE = aizver tikai šo logu (programma vēl var turpināt strādāt)
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Uzstāda loga izmēru
        this.frame.setSize(500, 400);

        // Novieto logu ekrāna centrā
        this.frame.setLocationRelativeTo(null);

        // Aizliedz mainīt loga izmēru
        this.frame.setResizable(false);

        // Padara logu redzamu
        this.frame.setVisible(true);
    }
}