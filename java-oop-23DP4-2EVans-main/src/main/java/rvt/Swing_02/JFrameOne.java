package rvt.Swing_02; // Pakotne

// Importē JFrame klasi
import javax.swing.JFrame;

// Šī klase MANTO no JFrame (tas nozīmē → šī klase IR logs)
public class JFrameOne extends JFrame {

    // Konstruktors
    public JFrameOne() {

        // Izsauc initialize metodi
        initialize();
    }

    // Metode loga konfigurācijai
    public void initialize() {

        // Šeit mēs izmantojam JFrame metodes tieši (jo klase to manto)

        // Uzstāda loga virsrakstu
        setTitle("JFrame One");

        // Nosaka, kas notiek, kad logs aizveras
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Uzstāda izmēru
        setSize(500, 400);

        // Novieto logu centrā
        setLocationRelativeTo(null);

        // Aizliedz resize
        setResizable(false);

        // Padara logu redzamu
        setVisible(true);
    }
}