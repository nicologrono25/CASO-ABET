public class CalculadoraImpuestos {
    private static final double APORTE_SEGURO_SOCIAL_PORCENTAJE = 0.0935;

    public double calcularAporteSeguroSocial(double sueldo) {
        return sueldo * APORTE_SEGURO_SOCIAL_PORCENTAJE;
    }

    public double calcularImpuestoRenta(double sueldo) {
        double sueldoAnual = sueldo * 12;
        double impuesto = 0;

        if (sueldoAnual > 18000) {
            impuesto += (sueldoAnual - 18000) * 0.3;
            sueldoAnual = 18000;
        }
        if (sueldoAnual > 10000) {
            impuesto += (sueldoAnual - 10000) * 0.2;
            sueldoAnual = 10000;
        }
        if (sueldoAnual > 5000) {
            impuesto += (sueldoAnual - 5000) * 0.1;
        }

        return impuesto / 12;
    }
}

