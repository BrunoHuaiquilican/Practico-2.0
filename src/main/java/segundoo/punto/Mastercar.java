package segundoo.punto;

public class Mastercar extends Tarjeta{

    @Override
    public double calcularDescuento(double totalPlatos, double totalBebidas) {
        double totalDeplatoConDecuento = totalPlatos - (totalPlatos * 0.02);
        return totalDeplatoConDecuento + totalBebidas;
    }
}
