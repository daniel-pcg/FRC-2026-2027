import java.util.Arrays;

/** Ejercicio 5: Tracción tipo tanque. */
public class Ejercicio5 {
    public static void main(String[] args) {
        double[][] joysticks = {
            {0.5, 0.0},    // recto
            {0.0, 0.5},    // girar en sitio
            {0.8, 0.4},    // curva
            {1.0, 1.0},    // saturación (se limita)
            {-0.6, -0.3}   // reversa con giro
        };

        for (double[] j : joysticks) {
            double[] motores = Utilidades.calcularTanque(j[0], j[1]);
            System.out.println("adelante=" + j[0] + ", giro=" + j[1]
                    + " -> {izq, der} = " + Arrays.toString(motores));
        }
    }
}
