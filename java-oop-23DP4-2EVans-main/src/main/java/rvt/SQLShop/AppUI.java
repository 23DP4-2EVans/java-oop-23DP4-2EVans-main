package rvt.SQLShop;

import javax.swing.*;
import java.awt.*;

public class AppUI {

    private Main db = new Main();
    public AppUI() {
        JFrame frame = new JFrame("Rex Shop");

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JTextField nameField = new JTextField(15);
        JButton addButton = new JButton("Pievienot");
        JButton showButton = new JButton("Paradīt visu");
        JTextArea output = new JTextArea(10, 30);

        panel.add(new JLabel("Nosaukums: "));
        panel.add(nameField);
        panel.add(addButton);
        panel.add(showButton);
        panel.add(output);

        frame.add(panel);
        frame.setVisible(true);

        addButton.addActionListener(e -> {
            String name = nameField.getText();
            db.addCategory(name);
        });
        showButton.addActionListener(e -> {
            output.setText("");

            db.findAll();
        });

    }

    public static void main(String[] args) {
        new AppUI();
    }
}