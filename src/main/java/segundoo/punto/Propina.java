package segundoo.punto;

public enum Propina {
    DOS(2), TRES(3), CINCO(5);

    private final int valor;

    // Constructor del enum
    Propina(int valor) {
        this.valor = valor;
    }
    public double calcularPropina(double total) {
        return total * (valor/100);
    }
}