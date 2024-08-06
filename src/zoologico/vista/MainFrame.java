package zoologico.vista;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Gestión de Zoológico");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Gestión de Hábitat", new GestionHabitat());
        tabbedPane.addTab("Gestión de Animales", new GestionAnimales());
        tabbedPane.addTab("Gestión de Alimentos", new GestionAlimentos());

        add(tabbedPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}
