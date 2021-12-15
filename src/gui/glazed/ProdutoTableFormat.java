/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.glazed;

import ca.odell.glazedlists.gui.TableFormat;
import classes.Produto;

/**
 *
 * @author Gaabrielhs
 */
public class ProdutoTableFormat implements TableFormat<Produto> {

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "idProduto";
            case 1:
                return "Descricao";
            case 2:
                return "Quantidade";
            case 3:
                return "Preço";
            default: throw new IllegalArgumentException();
        }
    }

    @Override
    public Object getColumnValue(Produto produto, int column) {
        switch (column) {
            case 0:
                return produto.getIdProduto();
            case 1:
                return produto.getDescricao();
            case 2:
                return produto.getQnt_estoque();
            case 3:
                return produto.getPreco();
            default: throw new IllegalArgumentException();
        }
    }
    
}
