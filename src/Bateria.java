/** Batería simulada: el voltaje baja 0.01 V por cada 10 Ah consumidos. */
public class Bateria {
    private static final double VOLTAJE_LLENA = 12.6;
    private static final double VOLTAJE_VACIA = 10.0;
    private static final double VOLTAJE_BAJO = 11.5;
    private static final double CAIDA_V_POR_10AH = 0.01;

    private double voltaje;
    private final double capacidadAh;

    public Bateria(double voltaje, double capacidadAh) {
        this.voltaje = voltaje;
        this.capacidadAh = capacidadAh;
    }

    /** Consume carga: amperios durante minutos y reduce el voltaje en consecuencia. */
    public void usar(double amperios, double minutos) {
        double ahConsumidos = amperios * (minutos / 60.0);
        voltaje -= (ahConsumidos / 10.0) * CAIDA_V_POR_10AH;
    }

    public boolean estaBaja() {
        return voltaje < VOLTAJE_BAJO;
    }

    /** Porcentaje de carga estimado (0-100) según el voltaje. */
    public double porcentaje() {
        double p = (voltaje - VOLTAJE_VACIA) / (VOLTAJE_LLENA - VOLTAJE_VACIA) * 100.0;
        return Math.max(0.0, Math.min(100.0, p));
    }

    public double getVoltaje() {
        return voltaje;
    }

    public double getCapacidadAh() {
        return capacidadAh;
    }
}
