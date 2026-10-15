/** Ejercicio 8: ronda de 10 ciclos de control con el robot completo. */
public class Ejercicio8 {
    public static void main(String[] args) {
        // Empieza justo sobre el umbral (11.5 V) para ver cómo se activa la regla de seguridad
        Robot robot = new Robot(new Bateria(11.52, 18.0));

        double[][] joystick = {
            {0.02, 0.01},  // drift: la zona muerta lo anula
            {0.6, 0.0},
            {1.0, 0.0},
            {0.8, 0.4},
            {1.0, 1.0},
            {-0.7, 0.0},
            {0.5, -0.3},
            {1.0, -0.5},
            {0.3, 0.0},
            {0.0, 0.0}
        };

        for (int ciclo = 0; ciclo < joystick.length; ciclo++) {
            System.out.println("Ciclo " + (ciclo + 1) + " joystick=" + joystick[ciclo][0] + "," + joystick[ciclo][1]);
            robot.conducir(joystick[ciclo][0], joystick[ciclo][1]);
            robot.consumir(120, 5); // 10 Ah por ciclo -> -0.01 V
            robot.estado();
        }

        robot.detenerTodo();
        System.out.println("Detenido:");
        robot.estado();
    }
}
