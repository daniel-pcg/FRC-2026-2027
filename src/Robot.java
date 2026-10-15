/** Robot con 4 motores de drivetrain y una batería; aplica zona muerta y límite de seguridad. */
public class Robot {
    private static final double ZONA_MUERTA = 0.05;
    private static final double VELOCIDAD_MAX_BATERIA_BAJA = 0.5;

    private final Motor frontLeft = new Motor("frontLeft");
    private final Motor rearLeft = new Motor("rearLeft");
    private final Motor frontRight = new Motor("frontRight");
    private final Motor rearRight = new Motor("rearRight");
    private final Bateria bateria;

    public Robot(Bateria bateria) {
        this.bateria = bateria;
    }

    /** Conduce en tanque con zona muerta; si la batería está baja limita a ±0.5. */
    public void conducir(double adelante, double giro) {
        adelante = Utilidades.aplicarZonaMuerta(adelante, ZONA_MUERTA);
        giro = Utilidades.aplicarZonaMuerta(giro, ZONA_MUERTA);
        double[] lados = Utilidades.calcularTanque(adelante, giro);
        double izquierda = lados[0];
        double derecha = lados[1];

        if (bateria.estaBaja()) {
            izquierda = limitar(izquierda, VELOCIDAD_MAX_BATERIA_BAJA);
            derecha = limitar(derecha, VELOCIDAD_MAX_BATERIA_BAJA);
        }

        frontLeft.setVelocidad(izquierda);
        rearLeft.setVelocidad(izquierda);
        frontRight.setVelocidad(derecha);
        rearRight.setVelocidad(derecha);
    }

    private static double limitar(double valor, double max) {
        return Math.max(-max, Math.min(max, valor));
    }

    public void detenerTodo() {
        frontLeft.detener();
        rearLeft.detener();
        frontRight.detener();
        rearRight.detener();
    }

    /** Simula el consumo de la batería durante un ciclo. */
    public void consumir(double amperios, double minutos) {
        bateria.usar(amperios, minutos);
    }

    public void estado() {
        System.out.printf("  FL=%5.2f RL=%5.2f FR=%5.2f RR=%5.2f | bateria=%.2f%% (%.3f V)%s%n",
                frontLeft.getVelocidad(), rearLeft.getVelocidad(),
                frontRight.getVelocidad(), rearRight.getVelocidad(),
                bateria.porcentaje(), bateria.getVoltaje(),
                bateria.estaBaja() ? " [BAJA: max 0.5]" : "");
    }
}
