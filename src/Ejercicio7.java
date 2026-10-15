/** Ejercicio 7: ronda de 2:30 min con consumo variable. */
public class Ejercicio7 {
    public static void main(String[] args) {
        Bateria bateria = new Bateria(12.6, 18.0);
        // Consumo (A) por tramo de 30 s; 5 tramos = 2:30 min
        double[] amperiosPorTramo = {10, 60, 120, 80, 30};
        double minutosPorTramo = 0.5;

        System.out.printf("Inicio: %.4f V (%.1f%%)%n", bateria.getVoltaje(), bateria.porcentaje());
        for (int i = 0; i < amperiosPorTramo.length; i++) {
            bateria.usar(amperiosPorTramo[i], minutosPorTramo);
            System.out.printf("Tramo %d (%3.0f A): %.4f V (%.2f%%) baja=%b%n", i + 1,
                    amperiosPorTramo[i], bateria.getVoltaje(), bateria.porcentaje(), bateria.estaBaja());
        }

        // Casos límite
        Bateria casi = new Bateria(11.5, 18.0);
        System.out.println("11.5 V baja? " + casi.estaBaja());
        casi.usar(120, 5); // 10 Ah -> -0.01 V
        System.out.printf("Tras 10 Ah: %.2f V baja? %b%n", casi.getVoltaje(), casi.estaBaja());
    }
}
