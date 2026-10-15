/** Ejercicio 1: Ficha del robot. */
public class Ejercicio1 {
    public static void main(String[] args) {
        final double LIBRAS_POR_KG = 2.2046;

        String nombreEquipo = "Team Robotics";
        int numeroEquipo = 7717;
        double pesoKg = 52.5;
        boolean tieneGarra = true;
        int cantidadMotores = 6;

        System.out.println("=== Ficha del robot ===");
        System.out.println("Equipo: " + nombreEquipo + " (#" + numeroEquipo + ")");
        System.out.println("Peso: " + pesoKg + " kg");
        System.out.println("Tiene garra: " + tieneGarra);
        System.out.println("Motores: " + cantidadMotores);

        double pesoLb = pesoKg * LIBRAS_POR_KG;
        System.out.printf("Peso en libras: %.2f lb%n", pesoLb);
    }
}
