/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.ItemPedido;
import classes.Pedido;
import classes.Quarto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;

/**
 *
 * @author Gaabrielhs
 */
public class ItemPedidoDAO {
    private final Connection conexao;

    public ItemPedidoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void gravar(ItemPedido itempedido, Pedido pedido) {
        try {
            String insercao = "INSERT INTO itempedido (quantidade, idPedido, idProduto) VALUES (?, ?, ?);";
            try (PreparedStatement pstmt = conexao.prepareStatement(insercao, PreparedStatement.RETURN_GENERATED_KEYS)) {
                pstmt.setLong(1, itempedido.getQuantidade());
                pstmt.setLong(2, pedido.getIdPedido());
                pstmt.setLong(3, itempedido.getProduto().getIdProduto());
                
                int resultado = pstmt.executeUpdate();
                if (resultado == 1) {
                    System.out.println("\nInserção bem sucedida.");

                    try (ResultSet rs = pstmt.getGeneratedKeys()) {
                        if (rs.next()) {
                            itempedido.setIdItemPedido(rs.getLong(1));
                        }
                    }

                } else {
                    System.out.println("A inserção não foi feita corretamente.");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro no acesso ao banco de dados.");
            while (ex != null) {
                System.out.println("SQL State: " + ex.getSQLState());
                System.out.println("Mensagem: " + ex.getMessage());
                System.out.println("Error Code: " + ex.getErrorCode());
                ex = ex.getNextException();
            }
        }
    }

    //gravar todos itempedidos daquele pedido
    public void gravar(Pedido pedido) {
        try {
            String insercao = "INSERT INTO itempedido (quantidade, idPedido, idProduto) VALUES (?, ?, ?);";
            try (PreparedStatement pstmt = conexao.prepareStatement(insercao, PreparedStatement.RETURN_GENERATED_KEYS)) {
                for (ItemPedido itempedido : pedido.getItens()) {
                    pstmt.setLong(1, itempedido.getQuantidade());
                    pstmt.setLong(2, pedido.getIdPedido());
                    pstmt.setLong(3, itempedido.getProduto().getIdProduto());
                    
                    int resultado = pstmt.executeUpdate();
                    if (resultado == 1) {
                        System.out.println("\nInserção bem sucedida.");

                        try (ResultSet rs = pstmt.getGeneratedKeys()) {
                            if (rs.next()) {
                                itempedido.setIdItemPedido(rs.getLong(1));
                            }
                        }
                    } else {
                        System.out.println("A inserção não foi feita corretamente.");
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro no acesso ao banco de dados.");
            while (ex != null) {
                System.out.println("SQL State: " + ex.getSQLState());
                System.out.println("Mensagem: " + ex.getMessage());
                System.out.println("Error Code: " + ex.getErrorCode());
                ex = ex.getNextException();
            }
        }
    }

    public void remover(Pedido pedido) {
        try {
            String remocao = "DELETE FROM itempedido WHERE idPedido = ?";
            try (PreparedStatement pstmt = conexao.prepareStatement(remocao)) {
                pstmt.setLong(1, pedido.getIdPedido());
                int remocoes = pstmt.executeUpdate();
                if (remocoes > 0) {
                    System.out.println("Remoção efetuada com sucesso.");
                } else {
                    System.out.println("Não foi possível efetuar a remoção.");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro no acesso ao banco de dados.");
            while (ex != null) {
                System.out.println("SQL State: " + ex.getSQLState());
                System.out.println("Mensagem: " + ex.getMessage());
                System.out.println("Error Code: " + ex.getErrorCode());
                ex = ex.getNextException();
            }
        }
    }
}
