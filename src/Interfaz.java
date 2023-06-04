import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Interfaz extends JFrame {

    private ManejoEmpleados manejoEmpleados;
    private CalculadoraImpuestos calculadoraImpuestos;
    private JTextField textcedula;
    private JTextField textnombre;
    private JTextField textsueldo;
    private JButton Agregarbutton;
    private JButton Modificarbutton;
    private JButton Listarbutton;
    private JTextArea areaEmpleados;
    private JLabel cedula;
    private JLabel nombre;
    private JLabel sueldo;
    private JPanel mainpanel;
    private Validacion validacion;

    public Interfaz() {
        manejoEmpleados = new ManejoEmpleados();
        calculadoraImpuestos = new CalculadoraImpuestos();
        validacion = new Validacion();

        Agregarbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedula = textcedula.getText();
                String nombre = textnombre.getText();
                double sueldo;
                try {
                    sueldo = Double.parseDouble(textsueldo.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "El sueldo debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String errorCedula = validacion.mensajeErrorCedula(cedula);
                if (errorCedula != null) {
                    JOptionPane.showMessageDialog(null, errorCedula, "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String errorSueldo = validacion.mensajeErrorSueldo(sueldo);
                if (errorSueldo != null) {
                    JOptionPane.showMessageDialog(null, errorSueldo, "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Empleado empleado = new Empleado(cedula, nombre, sueldo);
                if (manejoEmpleados.agregarEmpleado(empleado)) {
                    JOptionPane.showMessageDialog(null, "Empleado agregado correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    textcedula.setText("");
                    textnombre.setText("");
                    textsueldo.setText("");
                }
            }
        });

        Modificarbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedula = textcedula.getText();
                String nombre = textnombre.getText();
                double sueldo;
                try {
                    sueldo = Double.parseDouble(textsueldo.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "El sueldo debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String errorCedula = validacion.mensajeErrorCedula(cedula);
                if (errorCedula != null) {
                    JOptionPane.showMessageDialog(null, errorCedula, "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String errorSueldo = validacion.mensajeErrorSueldo(sueldo);
                if (errorSueldo != null) {
                    JOptionPane.showMessageDialog(null, errorSueldo, "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                manejoEmpleados.modificarEmpleado(cedula, nombre, sueldo);
                JOptionPane.showMessageDialog(null, "Empleado modificado correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                textcedula.setText("");
                textnombre.setText("");
                textsueldo.setText("");
            }
        });

        Listarbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaEmpleados.setText("");
                for (Empleado empleado : manejoEmpleados.getEmpleados()) {
                    double sueldo = empleado.getSueldo();
                    double aporteSeguro = calculadoraImpuestos.calcularAporteSeguroSocial(sueldo);
                    double impuestoRenta = calculadoraImpuestos.calcularImpuestoRenta(sueldo);
                    double sueldoRecibir = sueldo - aporteSeguro - impuestoRenta;
                    String informacion = "Nombre: " + empleado.getNombre() +
                            "\nSueldo: " + sueldo +
                            "\nAporte al Seguro: " + aporteSeguro +
                            "\nImpuesto a la Renta: " + impuestoRenta +
                            "\nSueldo a Recibir: " + sueldoRecibir + "\n\n";
                    areaEmpleados.append(informacion);
                }
            }
        });

        setTitle("Sistema de Empleados");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public JPanel getMainpanel() {
        return mainpanel;
    }
}

