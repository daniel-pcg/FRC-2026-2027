/** Funciones de control compartidas por los ejercicios 4, 5 y 8. */
public class Utilidades {

    /** Limita un valor entre -1.0 y 1.0, como hace WPILib con los motores. */
    public static double limitarVelocidad(double valor) {
        return Math.max(-1.0, Math.min(1.0, valor));
    }

    /** Devuelve 0 si |valor| es menor al umbral (ignora el drift del joystick). */
    public static double aplicarZonaMuerta(double valor, double umbral) {
        return Math.abs(valor) < umbral ? 0.0 : valor;
    }

    /** Tracción tipo tanque: devuelve {izquierda, derecha}, ambos limitados a [-1, 1]. */
    public static double[] calcularTanque(double adelante, double giro) {
        double izquierda = limitarVelocidad(adelante + giro);
        double derecha = limitarVelocidad(adelante - giro);
        return new double[] {izquierda, derecha};
    }
}
