/** Ejercicio 3: Calculadora de movimiento. */
public class Ejercicio3 {

    /** Distancia recorrida a velocidad constante. */
    static double calcularDistancia(double velocidad, double tiempo) {
        return velocidad * tiempo;
    }

    /** Convierte pulgadas a centímetros (1 in = 2.54 cm). */
    static double convertirPulgadasACm(double pulgadas) {
        return pulgadas * 2.54;
    }

    /** True si el voltaje está por debajo de 11.5 V. */
    static boolean bateriaBaja(double voltaje) {
        return voltaje < 11.5;
    }

    public static void main(String[] args) {
        System.out.println("-- calcularDistancia(velocidad m/s, tiempo s) --");
        System.out.println(calcularDistancia(2.0, 5.0));   // 10.0
        System.out.println(calcularDistancia(0.0, 10.0));  // 0.0
        System.out.println(calcularDistancia(3.5, 2.0));   // 7.0

        System.out.println("-- convertirPulgadasACm --");
        System.out.println(convertirPulgadasACm(1.0));     // 2.54
        System.out.println(convertirPulgadasACm(0.0));     // 0.0
        System.out.println(convertirPulgadasACm(12.0));    // 30.48

        System.out.println("-- bateriaBaja --");
        System.out.println(bateriaBaja(12.6));  // false
        System.out.println(bateriaBaja(11.5));  // false (límite)
        System.out.println(bateriaBaja(11.49)); // true
    }
}
