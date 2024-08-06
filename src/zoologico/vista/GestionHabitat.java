package zoologico.vista;

import zoologico.controlador.HabitatController;
import zoologico.modelo.Habitat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class GestionHabitat extends JPanel {
    private final HabitatController controller = new HabitatController();

    public GestionHabitat() {
        setLayout(new GridLayout(8, 2, 10, 10));

        // Componentes del formulario
        JLabel sizeLabel = new JLabel("Tamaño del Hábitat (m²):");
        JLabel sizeValueLabel = new JLabel("0"); // Inicialmente en 0 m²
        add(sizeLabel);
        add(sizeValueLabel);

        JButton increaseSizeButton = new JButton("Aumentar Tamaño en 10 m²");
        final int[] size = {0};

        increaseSizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                size[0] += 10;
                sizeValueLabel.setText(String.valueOf(size[0]));
            }
        });
        add(increaseSizeButton);
        add(new JLabel());

        JLabel temperatureLabel = new JLabel("Temperatura del Hábitat (°C):");
        JTextField temperatureField = new JTextField();
        add(temperatureLabel);
        add(temperatureField);

        JLabel habitatTypeLabel = new JLabel("Tipo de Hábitat:");
        JPanel habitatTypePanel = new JPanel();
        habitatTypePanel.setLayout(new FlowLayout());
        JRadioButton forestRadioButton = new JRadioButton("Bosque");
        JRadioButton desertRadioButton = new JRadioButton("Desierto");
        JRadioButton aquaticRadioButton = new JRadioButton("Acuático");
        JRadioButton savannaRadioButton = new JRadioButton("Sabana");
        JRadioButton mountainRadioButton = new JRadioButton("Montaña");
        JRadioButton paramoRadioButton = new JRadioButton("Páramo");
        JRadioButton nevadoRadioButton = new JRadioButton("Nevado");

        ButtonGroup habitatTypeGroup = new ButtonGroup();
        habitatTypeGroup.add(forestRadioButton);
        habitatTypeGroup.add(desertRadioButton);
        habitatTypeGroup.add(aquaticRadioButton);
        habitatTypeGroup.add(savannaRadioButton);
        habitatTypeGroup.add(mountainRadioButton);
        habitatTypeGroup.add(paramoRadioButton);
        habitatTypeGroup.add(nevadoRadioButton);

        habitatTypePanel.add(forestRadioButton);
        habitatTypePanel.add(desertRadioButton);
        habitatTypePanel.add(aquaticRadioButton);
        habitatTypePanel.add(savannaRadioButton);
        habitatTypePanel.add(mountainRadioButton);
        habitatTypePanel.add(paramoRadioButton);
        habitatTypePanel.add(nevadoRadioButton);

        add(habitatTypeLabel);
        add(habitatTypePanel);

        JLabel soilTypeLabel = new JLabel("Tipo de Suelo:");
        String[] soilTypes = {"Arcilloso", "Arenoso", "Pedregoso", "Húmedo", "Seco"};
        JComboBox<String> soilTypeComboBox = new JComboBox<>(soilTypes);
        add(soilTypeLabel);
        add(soilTypeComboBox);

        JLabel descriptionLabel = new JLabel("Descripción Adicional:");
        JTextArea descriptionArea = new JTextArea(3, 20);
        JScrollPane scrollPane = new JScrollPane(descriptionArea);
        add(descriptionLabel);
        add(scrollPane);

        JButton saveButton = new JButton("Guardar");
        add(new JLabel());
        add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String sizeValue = sizeValueLabel.getText();
                    String temperature = temperatureField.getText();
                    String habitatType = null;
                    if (forestRadioButton.isSelected()) habitatType = "Bosque";
                    else if (desertRadioButton.isSelected()) habitatType = "Desierto";
                    else if (aquaticRadioButton.isSelected()) habitatType = "Acuático";
                    else if (savannaRadioButton.isSelected()) habitatType = "Sabana";
                    else if (mountainRadioButton.isSelected()) habitatType = "Montaña";
                    else if (paramoRadioButton.isSelected()) habitatType = "Páramo";
                    else if (nevadoRadioButton.isSelected()) habitatType = "Nevado";
                    String soilType = (String) soilTypeComboBox.getSelectedItem();
                    String description = descriptionArea.getText();

                    // Guardar en la base de datos
                    Habitat habitat = new Habitat(sizeValue, temperature, habitatType, soilType, description);
                    controller.agregarHabitat(habitat);

                    // Mostrar la información guardada en una ventana emergente
                    String message = String.format(
                            "Hábitat guardado exitosamente:\n\n" +
                                    "Tamaño: %s m²\n" +
                                    "Temperatura: %s °C\n" +
                                    "Tipo de Hábitat: %s\n" +
                                    "Tipo de Suelo: %s\n" +
                                    "Descripción: %s",
                            sizeValue, temperature, habitatType, soilType, description
                    );
                    JOptionPane.showMessageDialog(GestionHabitat.this, message);

                    // Mostrar la información en la terminal
                    System.out.println(message);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(GestionHabitat.this, "Error al guardar el hábitat.");
                }
            }
        });
    }
}
