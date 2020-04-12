
import java.util.ArrayList;
import java.util.List;

public class OperacionDeEgreso extends Operacion{


    private DocumentoComercial documentoComercial;

    public double calcularValor(){
        if(!this.getListaItems().isEmpty()) {
            return this.getListaItems().stream().mapToDouble(Item::getPrecio).sum();
        }else{
            return 0;
        }
    }

    public void cerrar(){
        setEstado(Estado.CERRADA);
    }
}
