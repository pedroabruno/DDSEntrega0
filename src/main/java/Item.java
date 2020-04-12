
public class Item {

    private double precio;
    private Operacion operacion;
    private Tipo tipo;

    enum Tipo {
        ARTICULO,
        SERVICIO
    }

    public Item(Operacion operacion,double precio){
        this.operacion = operacion;
        this.precio = precio;
        this.tipo = Tipo.ARTICULO;
        operacion.addItem(this);
    }

    public double getPrecio() {
        return precio;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setPrecio(double precio) throws BusinessException {
        if(operacion.getEstado().equals(OperacionDeEgreso.Estado.CERRADA)){
            throw new BusinessException("La Operacion de Egreso del item ya se encuentra cerrada");
        }else{
            this.precio = precio;
        }
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
