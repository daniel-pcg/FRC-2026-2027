/** Ejercicio 6: prueba de la clase Motor con los 4 motores de un drivetrain. */
public class Ejercicio6 {

    static void imprimir(Motor[] motores, String paso) {
        System.out.println("-- " + paso);
        for (Motor m : motores) {
            System.out.printf("   %-18s vel=%5.2f habilitado=%b%n",
                    m.getNombre(), m.getVelocidad(), m.isHabilitado());
        }
    }

    public static void main(String[] args) {
        Motor[] motores = {
            new Motor("frontLeft"), new Motor("rearLeft"),
            new Motor("frontRight"), new Motor("rearRight")
        };

        imprimir(motores, "Estado inicial");

        for (Motor m : motores) m.setVelocidad(0.6);
        imprimir(motores, "Todos a 0.6");

        motores[0].setVelocidad(1.7);
        motores[1].setVelocidad(-3.0);
        imprimir(motores, "frontLeft a 1.7 (-> 1.0) y rearLeft a -3.0 (-> -1.0)");

        motores[2].deshabilitar();
        motores[2].setVelocidad(0.9);
        imprimir(motores, "frontRight deshabilitado; setVelocidad(0.9) ignorado");

        motores[2].habilitar();
        motores[2].setVelocidad(0.9);
        imprimir(motores, "frontRight rehabilitado y a 0.9");

        for (Motor m : motores) m.detener();
        imprimir(motores, "Detener todos");
    }
}
