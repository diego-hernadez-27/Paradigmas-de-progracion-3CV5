import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazGrafica extends JFrame {
    private JTextField txtNombre;
    private JTextField txtApellidoPaterno;
    private JTextField txtApellidoMaterno;
    private JTextField txtDiaNacimiento;
    private JTextField txtMesNacimiento;
    private JTextField txtAnioNacimiento;
    private JTextField txtOcupacion;
    private JTextArea txtAreaInformacion;
    private JButton btnSetNombre;
    private JButton btnSetNacimiento;
    private JButton btnSetOcupacion;
    private JButton btnMostrar;
    private JButton btnOcultar;
    private JButton btnActualizarGlobal;

    Persona p1 = new Persona();
    
    public InterfazGrafica() {
        // Configuración de la ventana principal
        setTitle("Formulario de Información");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Creación de los componentes
        JLabel lblNombre = new JLabel("Nombre:");
        JLabel lblFechaNacimiento = new JLabel("Fecha de Nacimiento (DD/MM/AAAA):");
        JLabel lblOcupacion = new JLabel("Ocupación:");

        txtNombre = new JTextField(20);
        txtApellidoPaterno = new JTextField(10);
        txtApellidoMaterno = new JTextField(10);
        txtDiaNacimiento = new JTextField(2);
        txtMesNacimiento = new JTextField(2);
        txtAnioNacimiento = new JTextField(4);
        txtOcupacion = new JTextField(20);

        btnSetNombre = new JButton("Actualizar Nombre");
        btnSetNacimiento = new JButton("Actualizar Nacimiento");
        btnSetOcupacion = new JButton("Actualizar Ocupación");
        btnMostrar = new JButton("Mostrar Información");
        btnOcultar = new JButton("Ocultar Información");
        btnActualizarGlobal = new JButton("Actualizar Global");

        txtAreaInformacion = new JTextArea(10, 20);
        txtAreaInformacion.setEditable(false);

        // Creación del panel para organizar los componentes
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2));
        panel.add(lblNombre);
        panel.add(txtNombre);
        panel.add(new JLabel("Apellido Paterno:"));
        panel.add(txtApellidoPaterno);
        panel.add(new JLabel("Apellido Materno:"));
        panel.add(txtApellidoMaterno);
        panel.add(lblFechaNacimiento);
        JPanel panelFecha = new JPanel();
        panelFecha.add(txtDiaNacimiento);
        panelFecha.add(new JLabel("/"));
        panelFecha.add(txtMesNacimiento);
        panelFecha.add(new JLabel("/"));
        panelFecha.add(txtAnioNacimiento);
        panel.add(panelFecha);
        panel.add(lblOcupacion);
        panel.add(txtOcupacion);
        panel.add(btnSetNacimiento);
        panel.add(btnSetNombre);
        panel.add(btnSetOcupacion);
        panel.add(btnActualizarGlobal);
        panel.add(btnOcultar);
        panel.add(btnMostrar);

        // Agregar el panel a la ventana
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(txtAreaInformacion), BorderLayout.CENTER);

        // Agregar eventos a los botones
        
        btnSetNombre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarNombre();
            }
        });
        
        btnSetNacimiento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarNacimiento();
            }
        });
        
        btnSetOcupacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarOcupacion();
            }
        });
        
        btnMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarInformacion();
            }
        });

        btnOcultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ocultarInformacion();
            }
        });

        btnActualizarGlobal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarInformacionGlobal();
            }
        });
    }
    
    private void actualizarCalculos(){
        p1.calculateEdad();
        p1.calculateID();
    }
    
    private void actualizarNombre(){
        String nombre = txtNombre.getText();
        String apellidoPaterno = txtApellidoPaterno.getText();
        String apellidoMaterno = txtApellidoMaterno.getText();
        
        if (nombre.isEmpty() || apellidoPaterno.isEmpty() || apellidoMaterno.isEmpty() ) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        p1.setNombre(nombre, apellidoPaterno, apellidoMaterno);
        actualizarCalculos();
        
        // Mostrar el mensaje en el área de texto
        txtAreaInformacion.setText(p1.toString());
    }
    
    private void actualizarNacimiento(){
        String dia = txtDiaNacimiento.getText();
        String mes = txtMesNacimiento.getText();
        String anio = txtAnioNacimiento.getText();

        if (dia.isEmpty() || mes.isEmpty() || anio.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        p1.setNacimiento(dia, mes, anio );
        actualizarCalculos();
        
        // Mostrar el mensaje en el área de texto
        txtAreaInformacion.setText(p1.toString());
    }
    
    private void actualizarOcupacion(){
        String ocupacion = txtOcupacion.getText();

        if (ocupacion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        p1.setOcupacion(ocupacion);
        actualizarCalculos();
        
        // Mostrar el mensaje en el área de texto
        txtAreaInformacion.setText(p1.toString());
    }
    
    private void actualizarInformacionGlobal() {
        // Obtener los valores de los campos
        String nombre = txtNombre.getText();
        String apellidoPaterno = txtApellidoPaterno.getText();
        String apellidoMaterno = txtApellidoMaterno.getText();
        String dia = txtDiaNacimiento.getText();
        String mes = txtMesNacimiento.getText();
        String anio = txtAnioNacimiento.getText();
        String ocupacion = txtOcupacion.getText();

        p1 = new Persona(nombre, apellidoPaterno, apellidoMaterno, ocupacion, dia, mes, anio);
        actualizarCalculos();
        
        // Validar que no haya campos vacíos
        if (nombre.isEmpty() || apellidoPaterno.isEmpty() || apellidoMaterno.isEmpty() ||
            dia.isEmpty() || mes.isEmpty() || anio.isEmpty() || ocupacion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Mostrar el mensaje en el área de texto
        txtAreaInformacion.setText(p1.toString());
    }

    private void mostrarInformacion() {
        txtAreaInformacion.setVisible(true);
    }

    private void ocultarInformacion() {
        txtAreaInformacion.setVisible(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new InterfazGrafica().setVisible(true);
            }
        });
    }
}
