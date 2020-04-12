import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.junit.Assert;
import org.junit.Test;

public class Tests {


    @Test
    public void CalculoValorOperacionDeEgresoVacia(){
        double resultado = 0;
        OperacionDeEgreso operacionDeEgreso = new OperacionDeEgreso();
        Assert.assertEquals(resultado,operacionDeEgreso.calcularValor(),0.001);
    }

    @Test
    public void CalculoValorOperacionDeEgresoConItems(){
        double resultado = 11;
        OperacionDeEgreso operacionDeEgreso = new OperacionDeEgreso();
        Item item1 = new Item(operacionDeEgreso,7);
        Item item2 = new Item(operacionDeEgreso,4);

        Assert.assertEquals(resultado,operacionDeEgreso.calcularValor(),0.001);
    }

    @Test
    public void CerrarOperacionDeEgreso(){
        OperacionDeEgreso operacionDeEgreso = new OperacionDeEgreso();
        Item item1 = new Item(operacionDeEgreso,7);
        Item item2 = new Item(operacionDeEgreso,4);
        operacionDeEgreso.cerrar();
    }

    @Test
    public void CambiarPrecioItemEnOperacionDeEgresoCerrada(){
        OperacionDeEgreso operacionDeEgreso = new OperacionDeEgreso();
        Item item1 = new Item(operacionDeEgreso,7);
        Item item2 = new Item(operacionDeEgreso,4);
        operacionDeEgreso.cerrar();
        try {
            item2.setPrecio(11);
        }catch (BusinessException e){
            Assert.assertEquals("La Operacion de Egreso del item ya se encuentra cerrada",e.getMessage());
        }
    }

    @Test
    public void GenerDocumentoRemitoValido(){
        OperacionDeCompra operacionDeCompra = new OperacionDeCompra();
        Item item1 = new Item(operacionDeCompra,7);
        Item item2 = new Item(operacionDeCompra,4);
        try {
            Assert.assertTrue(operacionDeCompra.generarDocumentoRemito() instanceof DocumentoRemito);
        }catch (BusinessException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void GenerDocumentoRemitoInvalido(){
        OperacionDeCompra operacionDeCompra = new OperacionDeCompra();
        Item item1 = new Item(operacionDeCompra,7);
        item1.setTipo(Item.Tipo.SERVICIO);
        Item item2 = new Item(operacionDeCompra,4);
        try {
            operacionDeCompra.generarDocumentoRemito();
        }catch (BusinessException e){
            Assert.assertEquals("Todos los items de la Operacion de Compra deben ser de tipo Articulo",e.getMessage());
        }
    }
}
