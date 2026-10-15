/** Motor simulado con velocidad limitada a [-1, 1] que puede habilitarse o deshabilitarse. */
public class Motor {
    private final String nombre;
    private double velocidadActual;
    private boolean habilitado;

    public Motor(String nombre) {
        this.nombre = nombre;
        this.velocidadActual = 0.0;
        this.habilitado = true;
    }

    /** Fija la velocidad (limitada a [-1, 1]); no hace nada si el motor está deshabilitado. */
    public void setVelocidad(double v) {
        if (!habilitado) {
            return;
        }
        velocidadActual = Utilidades.limitarVelocidad(v);
    }

    public double getVelocidad() {
        return velocidadActual;
    }

    public String getNombre() {
        return nombre;
    }

    public void detener() {
        velocidadActual = 0.0;
    }

    public void habilitar() {
        habilitado = true;
    }

    /** Deshabilita el motor y lo detiene por seguridad. */
    public void deshabilitar() {
        habilitado = false;
        velocidadActual = 0.0;
    }

    public boolean isHabilitado() {
        return habilitado;
    }
}
