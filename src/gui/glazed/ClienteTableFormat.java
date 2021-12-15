/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.glazed;

import ca.odell.glazedlists.gui.TableFormat;
import classes.Cliente;

/**
 *
 * @author Gaabrielhs
 */
public class ClienteTableFormat implements TableFormat<Cliente> {

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "idCliente";
            case 1: return "Nome";
            case 2: return "RG";
            case 3: return "CPF";
            case 4: return "Endereco";
            case 5: return "Telefone";
            case 6: return "Email";
            case 7: return "dataNasc";
            default: throw new IllegalArgumentException();
        }
    }

    @Override
    public Object getColumnValue(Cliente cliente, int column) {
        switch(column){
            case 0: return cliente.getIdCliente();
            case 1: return cliente.getNome();
            case 2: return cliente.getRg();
            case 3: return cliente.getCpf();
            case 4: return cliente.getEndereco();
            case 5: return cliente.getTelefone();
            case 6: return cliente.getEmail();
            case 7: return cliente.getDataNasc().toString("dd/MM/yyyy");
            default: throw new IllegalArgumentException();
        }
    }
    
}
