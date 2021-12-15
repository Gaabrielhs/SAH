/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.glazed;

import ca.odell.glazedlists.gui.TableFormat;
import classes.Pedido;

/**
 *
 * @author Gaabrielhs
 */
public class PedidoTableFormat implements TableFormat<Pedido> {

    @Override
    public int getColumnCount() {
            return 3;
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "idPedido";
            case 1: return "Data";
            case 2: return "Valor";
            default: throw new IllegalArgumentException();
        }
    }

    @Override
    public Object getColumnValue(Pedido pedido, int column) {
        switch(column){
            case 0: return pedido.getIdPedido();
            case 1: return pedido.getData();
            case 2: return pedido.getValor();
            default: throw new IllegalArgumentException();
        }
    }
    
}
