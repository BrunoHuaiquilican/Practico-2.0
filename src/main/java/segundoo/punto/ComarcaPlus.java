package segundoo.punto;

public class ComarcaPlus extends Tarjeta{

    private int descuento = 5;

    @Override
    public double calcularDescuento(double totalPlatos, double totalBebidas) {
        double total = totalPlatos + totalBebidas;
        double descuento = total * 0.05;
        return total - descuento;
    }
}
