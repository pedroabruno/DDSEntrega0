import java.util.ArrayList;
import java.util.List;

public class Operacion {

    private List<Item> listaItems = new ArrayList<>();
    private OperacionDeEgreso.Estado estado = OperacionDeEgreso.Estado.ABIERTA ;

    enum Estado {
        CERRADA,
        ABIERTA
    }


    public void addItem(Item item){
        listaItems.add(item);
    }

    public List<Item> getListaItems() {
        return listaItems;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
