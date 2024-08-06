package zoologico.vista;

import zoologico.controlador.AlimentosController;
import zoologico.modelo.Alimento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class GestionAlimentos extends JPanel {
    public GestionAlimentos() {
        setLayout(new GridLayout(8, 2, 10, 10)); // Ajustado para acomodar todos los componentes

        // Crear y agregar componentes

        // Campo de texto para la cantidad de alimento
        JLabel cantidadLabel = new JLabel("Cantidad de Alimento (kg):");
        JTextField cantidadField = new JTextField();
        add(cantidadLabel);
        add(cantidadField);

        // Panel para tipo de alimento con JRadioButtons organizados horizontalmente
        JLabel tipoComidaLabel = new JLabel("Tipo de Alimento:");
        JPanel tipoComidaPanel = new JPanel();
        tipoComidaPanel.setLayout(new GridLayout(2, 3)); // Diseño en filas de 2 y columnas de 3

        // Crear botones de opción para el tipo de alimento
        JRadioButton carneButton = new JRadioButton("Carnes");
        JRadioButton vegetalButton = new JRadioButton("Vegetales");
        JRadioButton frutaButton = new JRadioButton("Frutas");
        JRadioButton insectoButton = new JRadioButton("Insectos");
        JRadioButton pescadoButton = new JRadioButton("Pescado");
        JRadioButton mixtoButton = new JRadioButton("Mixto");

        // Agrupar los botones en un ButtonGroup para que se comporten como un grupo exclusivo
        ButtonGroup foodTypeGroup = new ButtonGroup();
        foodTypeGroup.add(carneButton);
        foodTypeGroup.add(vegetalButton);
        foodTypeGroup.add(frutaButton);
        foodTypeGroup.add(insectoButton);
        foodTypeGroup.add(pescadoButton);
        foodTypeGroup.add(mixtoButton);

        // Agregar los botones al panel
        tipoComidaPanel.add(carneButton);
        tipoComidaPanel.add(vegetalButton);
        tipoComidaPanel.add(frutaButton);
        tipoComidaPanel.add(insectoButton);
        tipoComidaPanel.add(pescadoButton);
        tipoComidaPanel.add(mixtoButton);

        add(tipoComidaLabel);
        add(tipoComidaPanel);

        // Lista desplegable para frecuencia de alimentación
        JLabel alimentarFrequencyLabel = new JLabel("Cada Cuánto se Alimenta:");
        String[] frequencies = {"Cada 6 horas", "Cada 12 horas", "Diariamente", "Cada 2 Días", "Cada 3 Días", "Semanalmente", "Mensualmente"};
        JComboBox<String> alimentarFrequencyComboBox = new JComboBox<>(frequencies);
        add(alimentarFrequencyLabel);
        add(alimentarFrequencyComboBox);

        // Checkbox para añadir más información
        JCheckBox añadirMasInfoCheckBox = new JCheckBox("Añadir más información");
        add(añadirMasInfoCheckBox);

        // Campo de texto para notas adicionales
        JLabel notasLabel = new JLabel("Notas Adicionales:");
        JTextArea notasArea = new JTextArea(3, 20);
        JScrollPane scrollPane = new JScrollPane(notasArea);
        notasArea.setVisible(false); // Inicialmente oculto

        // Crear un panel para el campo de notas
        JPanel notasPanel = new JPanel();
        notasPanel.setLayout(new BorderLayout());
        notasPanel.add(notasLabel, BorderLayout.NORTH);
        notasPanel.add(scrollPane, BorderLayout.CENTER);
        notasPanel.setVisible(false); // Inicialmente oculto

        add(notasPanel);

        // Botón para guardar la información
        JButton botonGuardar = new JButton("Guardar");
        add(new JLabel()); // Espacio vacío en la interfaz
        add(botonGuardar);

        // Acción del botón guardar
        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Crear instancia del controlador
                    AlimentosController controller = new AlimentosController();

                    // Obtener datos del formulario
                    double cantidad = Double.parseDouble(cantidadField.getText());
                    String tipoComida = null;
                    // Obtener el tipo de alimento seleccionado
                    if (carneButton.isSelected()) tipoComida = "Carnes";
                    if (vegetalButton.isSelected()) tipoComida = "Vegetales";
                    if (frutaButton.isSelected()) tipoComida = "Frutas";
                    if (insectoButton.isSelected()) tipoComida = "Insectos";
                    if (pescadoButton.isSelected()) tipoComida = "Pescado";
                    if (mixtoButton.isSelected()) tipoComida = "Mixto";
                    String frecuenciaAlimentacion = (String) alimentarFrequencyComboBox.getSelectedItem();
                    String notas = notasArea.getText();

                    // Crear objeto Alimento
                    Alimento alimento = new Alimento(cantidad, tipoComida, frecuenciaAlimentacion, notas);

                    // Usar el controlador para agregar el alimento
                    controller.agregarAlimento(alimento);

                    // Mostrar los datos guardados en una ventana emergente
                    String message = String.format(
                            "Alimento guardado exitosamente.\n\n" +
                            "Cantidad: %.2f kg\n" +
                            "Tipo de Alimento: %s\n" +
                            "Frecuencia de Alimentación: %s\n" +
                            "Notas: %s",
                            alimento.getCantidad(),
                            alimento.getTipoComida(),
                            alimento.getFrecuenciaAlimentacion(),
                            alimento.getNotas().isEmpty() ? "Ninguna" : alimento.getNotas()
                    );
                    JOptionPane.showMessageDialog(GestionAlimentos.this, message);

                    // Mostrar los datos guardados en la terminal
                    System.out.println(message);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(GestionAlimentos.this, "Error al guardar el alimento.");
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(GestionAlimentos.this, "Error en el formato de cantidad.");
                }
            }
        });

        // Listener para mostrar/ocultar campo de notas adicionales
        añadirMasInfoCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean selected = añadirMasInfoCheckBox.isSelected();
                notasPanel.setVisible(selected);
            }
        });
    }
}