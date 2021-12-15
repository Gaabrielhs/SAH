/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.glazed;

import ca.odell.glazedlists.gui.TableFormat;
import classes.ItemPedido;

/**
 *
 * @author Gaabrielhs
 */
public class ItensPedidoTableFormat implements TableFormat<ItemPedido> {

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Produto";
            case 1:
                return "Quantidade";
            default: throw new IllegalArgumentException();
        }
    }

    @Override
    public Object getColumnValue(ItemPedido itempedido, int column) {
        switch (column) {
            case 0:
                return itempedido.getProduto().getDescricao();
            case 1:
                return itempedido.getQuantidade();
            default: throw new IllegalArgumentException();
        }
    }

}
