/** Ejercicio 4: Control de velocidad. */
public class Ejercicio4 {
    public static void main(String[] args) {
        double[] valores = {0.03, -0.8, 1.5, -2.0, 1.0, -1.0};
        double umbral = 0.05;

        for (double valor : valores) {
            System.out.printf("valor=%5.2f -> limitado=%5.2f, zonaMuerta(%.2f)=%5.2f%n",
                    valor,
                    Utilidades.limitarVelocidad(valor),
                    umbral,
                    Utilidades.aplicarZonaMuerta(valor, umbral));
        }
    }
}
