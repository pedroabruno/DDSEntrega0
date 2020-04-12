import java.util.ArrayList;
import java.util.List;

public class OperacionDeCompra extends Operacion {

    public DocumentoRemito generarDocumentoRemito() throws BusinessException{
        if( this.getListaItems().stream().allMatch(i -> i.getTipo().equals(Item.Tipo.ARTICULO))){
            return new DocumentoRemito();
        }else{
            throw new BusinessException("Todos los items de la Operacion de Compra deben ser de tipo Articulo");
        }
    }
}
