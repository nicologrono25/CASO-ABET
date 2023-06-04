public class Validacion {
    public boolean validarCedula(String cedula) {
        return cedula != null && cedula.matches("\\d{10}");
    }

    public boolean validarNombre(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }

    public boolean validarSueldo(double sueldo) {
        return sueldo > 0;
    }

    public boolean validarEmpleado(Empleado empleado) {
        return validarCedula(empleado.getCedula()) && validarNombre(empleado.getNombre()) && validarSueldo(empleado.getSueldo());
    }

    public String mensajeErrorCedula(String cedula) {
        if (cedula == null || cedula.length() != 10) {
            return "La cédula debe tener 10 dígitos.";
        }
        if (!cedula.matches("\\d+")) {
            return "La cédula solo debe contener números.";
        }
        return null;
    }

    public String mensajeErrorSueldo(double sueldo) {
        if (sueldo <= 0) {
            return "El sueldo debe ser un número positivo.";
        }
        return null;
    }
}


