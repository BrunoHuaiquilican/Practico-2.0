package segundoo.punto;


import java.util.ArrayList;
import java.util.List;

public class Mesa {
    private int numeroDeMesa;
    private int capacidad;
    private List<Plato> platos;
    private double totalPrecioBebidas;
    private double totalPreciosPlatos;
    private boolean confirmarPedido ;
    private Propina propina;
    private GenerarRegistro generarRegistro;
    private ServicioNotificacion notificacion;


    public Mesa(int numeroDeMesa, int capacidad, Propina tres , ServicioNotificacion notificacion, GenerarRegistro generarRegistro) {
        if (numeroDeMesa <= 0) {
            throw new IllegalArgumentException("El numero de mesa no puede ser menor o igual a 0");
        }
        if (capacidad <= 0 && capacidad < 10) {
            throw new IllegalArgumentException("La capacidad de la mesa no puede ser menor o igual a 0");
        }
        this.numeroDeMesa = numeroDeMesa;
        this.capacidad = capacidad;
        this.platos = new ArrayList<>();
        this.totalPrecioBebidas = 0;
        this.totalPreciosPlatos = 0;
        this.confirmarPedido = false;
        this.propina = null;
        this.notificacion = notificacion;
        this.generarRegistro = generarRegistro;

    }

    public void agregarPlatos(Plato plato){
        if (plato.esBebida()){
            this.totalPrecioBebidas += plato.precio();
        }else{
            this.totalPreciosPlatos += plato.precio();
        }
        this.platos.add(plato);
    }
    public void confirmarPedido(boolean confirmacion, Propina propina) {
        this.confirmarPedido = confirmacion;
        this.propina = propina;
    }
    private double calcularTotalPlatos() {
        return platos.stream().filter(p -> !p.esBebida()).mapToDouble(Plato::precio).sum();
    }
    private double calcularTotalBebidas() {
        return platos.stream().filter(Plato::esBebida).mapToDouble(Plato::precio).sum();
    }
    public double calcularPropina() {
        double total = calcularTotalPlatos() + calcularTotalBebidas();
        return propina.calcularPropina(total);
    }
    public double pagar(Tarjeta tarjeta) {
        double totalPlatos = calcularTotalPlatos();
        double totalBebidas = calcularTotalBebidas();
        double descuento = tarjeta.calcularDescuento(totalPlatos, totalBebidas);
        return descuento;
    }
    public double estraerTotaldeLaCuenta() {
        return calcularTotalPlatos() + calcularTotalBebidas();
    }


}
