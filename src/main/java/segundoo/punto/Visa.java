package segundoo.punto;

public class Visa extends Tarjeta {

    @Override
    public double calcularDescuento(double totalPlatos, double totalBebidas) {
        double totalBebidasConDescuento = totalBebidas - (totalBebidas * 0.03);
        return totalPlatos + totalBebidasConDescuento;
    }
}
