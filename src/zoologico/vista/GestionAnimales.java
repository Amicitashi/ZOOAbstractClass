package zoologico.vista;

import zoologico.controlador.AnimalesController;
import zoologico.modelo.Animales;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class GestionAnimales extends JPanel {
    private final AnimalesController controller = new AnimalesController();

    public GestionAnimales() {
        setLayout(new GridLayout(8, 2, 10, 10));

        // Componentes del formulario
        JLabel nombreLabel = new JLabel("Nombre del Animal:");
        JTextField nombreField = new JTextField();
        add(nombreLabel);
        add(nombreField);

        JLabel tipoClimaLabel = new JLabel("Tipo de Clima:");
        String[] tiposClima = {"Tropical", "Seco", "Templado", "Continental", "Polar"};
        JComboBox<String> habitatTypeComboBox = new JComboBox<>(tiposClima);
        add(tipoClimaLabel);
        add(habitatTypeComboBox);

        JLabel condicionesLabel = new JLabel("Condiciones Especiales:");
        JCheckBox enPeligroCheckBox = new JCheckBox("En Peligro de Extinción");
        JCheckBox vacunadoCheckBox = new JCheckBox("Vacunado");
        JCheckBox enfermedadesCheckBox = new JCheckBox("Enfermedades");

        JPanel condicionesPanel = new JPanel();
        condicionesPanel.setLayout(new FlowLayout());
        condicionesPanel.add(enPeligroCheckBox);
        condicionesPanel.add(vacunadoCheckBox);
        condicionesPanel.add(enfermedadesCheckBox);

        add(condicionesLabel);
        add(condicionesPanel);

        JPanel enfermedadesPanel = new JPanel();
        enfermedadesPanel.setLayout(new GridLayout(4, 1));
        JCheckBox enfermedad1 = new JCheckBox("Fiebre aftosa");
        JCheckBox enfermedad2 = new JCheckBox("Parasitosis");
        JCheckBox enfermedad3 = new JCheckBox("Enfermedad de Borna");
        JCheckBox enfermedad4 = new JCheckBox("Dermatitis");

        enfermedadesPanel.add(new JLabel("Enfermedades Comunes:"));
        enfermedadesPanel.add(enfermedad1);
        enfermedadesPanel.add(enfermedad2);
        enfermedadesPanel.add(enfermedad3);
        enfermedadesPanel.add(enfermedad4);

        JTextField enfermedadesTextoField = new JTextField("Especificar otras enfermedades...");
        enfermedadesTextoField.setVisible(false);

        JPanel enfermedadesTextoPanel = new JPanel();
        enfermedadesTextoPanel.setLayout(new BorderLayout());
        enfermedadesTextoPanel.add(enfermedadesPanel, BorderLayout.CENTER);
        enfermedadesTextoPanel.add(enfermedadesTextoField, BorderLayout.SOUTH);
        enfermedadesTextoPanel.setVisible(false);

        add(new JLabel());
        add(enfermedadesTextoPanel);

        JButton botonGuardar = new JButton("Guardar");
        add(new JLabel());
        add(botonGuardar);

        // Acción del botón guardar
        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = nombreField.getText();
                    String tipoClima = (String) habitatTypeComboBox.getSelectedItem();
                    boolean enPeligro = enPeligroCheckBox.isSelected();
                    boolean vacunado = vacunadoCheckBox.isSelected();
                    boolean enfermedades = enfermedadesCheckBox.isSelected();

                    StringBuilder enfermedadesSeleccionadas = new StringBuilder();
                    if (enfermedad1.isSelected()) enfermedadesSeleccionadas.append("Fiebre aftosa, ");
                    if (enfermedad2.isSelected()) enfermedadesSeleccionadas.append("Parasitosis, ");
                    if (enfermedad3.isSelected()) enfermedadesSeleccionadas.append("Enfermedad de Borna, ");
                    if (enfermedad4.isSelected()) enfermedadesSeleccionadas.append("Dermatitis, ");
                    if (!enfermedadesTextoField.getText().trim().isEmpty()) {
                        enfermedadesSeleccionadas.append(enfermedadesTextoField.getText().trim());
                    }

                    // Guardar en la base de datos
                    Animales animal = new Animales(nombre, tipoClima);
                    animal.setEnPeligro(enPeligro);
                    animal.setVacunado(vacunado);
                    animal.setEnfermedades(enfermedades ? enfermedadesSeleccionadas.toString() : null);
                    controller.agregarAnimal(animal);

                    // Mostrar la información guardada en una ventana emergente
                    String message = String.format(
                            "Animal guardado exitosamente:\n\n" +
                            "Nombre: %s\n" +
                            "Tipo de Clima: %s\n" +
                            "En Peligro de Extinción: %s\n" +
                            "Vacunado: %s\n" +
                            "Enfermedades: %s",
                            nombre, tipoClima, enPeligro, vacunado,
                            enfermedades ? enfermedadesSeleccionadas.toString() : "Ninguna"
                    );
                    JOptionPane.showMessageDialog(GestionAnimales.this, message);

                    // Mostrar la información en la terminal
                    System.out.println(message);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(GestionAnimales.this, "Error al guardar el animal.");
                }
            }
        });

        // Listener para mostrar/ocultar panel de enfermedades adicionales
        enfermedadesCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean selected = enfermedadesCheckBox.isSelected();
                enfermedadesTextoPanel.setVisible(selected);
            }
        });
    }
}
