package segundoo.punto;

public class Plato {
    private final String nombre;
    private final double precio;
    private final boolean esBebida;

    public Plato(String nombre, double precio, boolean esBebida) {
        if (nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del plato no puede estar vacío.");
        }
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0.");
        }
        this.nombre = nombre;
        this.precio = precio;
        this.esBebida = esBebida;
    }

    public boolean esBebida() {
        return esBebida;
    }
    public double precio() {
        return precio;
    }
}
