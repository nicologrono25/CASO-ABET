public class Empleado {
    private String cedula;
    private String nombre;
    private double sueldo;

    public Empleado(String cedula, String nombre, double sueldo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
}
