import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ManejoEmpleados {
    private ArrayList<Empleado> empleados;
    private Validacion validacion;

    public ManejoEmpleados() {
        empleados = new ArrayList<>();
        validacion = new Validacion();
    }

    public boolean agregarEmpleado(Empleado empleado) {
        if (validacion.validarEmpleado(empleado)) {
            empleados.add(empleado);
            JOptionPane.showMessageDialog(null, "Empleado registrado con éxito.");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Los datos del empleado no son válidos.");
            return false;
        }
    }

    public Empleado buscarEmpleado(String cedula) {
        for (Empleado empleado : empleados) {
            if (empleado.getCedula().equals(cedula)) {
                return empleado;
            }
        }
        return null;
    }

    public boolean modificarEmpleado(String cedula, String nombre, double sueldo) {
        Empleado empleado = buscarEmpleado(cedula);
        if (empleado != null) {
            empleado.setNombre(nombre);
            empleado.setSueldo(sueldo);
            JOptionPane.showMessageDialog(null, "Empleado modificado con éxito.");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Empleado no encontrado.");
            return false;
        }
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }
}
