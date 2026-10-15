/** Ejercicio 2: Batería y consumo. */
public class Ejercicio2 {
    public static void main(String[] args) {
        final double VOLTAJE_BATERIA = 12.6;   // V
        final int CORRIENTE_AMPERIOS = 40;     // A
        final int TIEMPO_MINUTOS = 3;          // min

        double potenciaW = VOLTAJE_BATERIA * CORRIENTE_AMPERIOS;
        double tiempoHoras = TIEMPO_MINUTOS / 60.0; // 60.0 evita la división entera
        double energiaWh = potenciaW * tiempoHoras;

        System.out.printf("Potencia: %.1f W%n", potenciaW);
        System.out.printf("Energía consumida en %d min: %.2f Wh%n", TIEMPO_MINUTOS, energiaWh);
    }
}
