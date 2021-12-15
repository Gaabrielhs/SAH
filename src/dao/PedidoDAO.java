/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
public class PedidoDAO {
    private final Connection conexao;

    public PedidoDAO(Connection conexao) {
        this.conexao = conexao;
    }
    
    //GRAVA OS ITENSPEDIDO AUTOMÁTICO, NÃO CHAMAR SEPARADAMENTE.
    public void gravar(Pedido pedido, Quarto quarto) {
        try {
            String insercao = "INSERT INTO pedido (idQuarto, data, valor) VALUES (?, ?, ?);";
            try (PreparedStatement pstmt = conexao.prepareStatement(insercao, PreparedStatement.RETURN_GENERATED_KEYS)) {
                pstmt.setLong(1, quarto.getIdQuarto());
                pstmt.setTimestamp(2, new Timestamp(pedido.getData().getMillis()));
                pstmt.setDouble(3, pedido.getValor());
                
                int resultado = pstmt.executeUpdate();
                if (resultado == 1) {
                    System.out.println("\nInserção bem sucedida.");

                    try (ResultSet rs = pstmt.getGeneratedKeys()) {
                        if (rs.next()) {
                            pedido.setIdPedido(rs.getLong(1));
                        }
                    }

                //gravar todos os ItemPedido dentro de pedido
                ItemPedidoDAO itempedidoDAO = new ItemPedidoDAO(conexao);
                itempedidoDAO.gravar(pedido);
                
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

    //gravar todos pedidos daquele quarto
    public void gravar(Quarto quarto) {
        try {
            String insercao = "INSERT INTO pedido (idQuarto, data, valor) VALUES (?, ?, ?);";
            try (PreparedStatement pstmt = conexao.prepareStatement(insercao, PreparedStatement.RETURN_GENERATED_KEYS)) {
                for (Pedido pedido : quarto.getPedidos()) {
                    pstmt.setLong(1, quarto.getIdQuarto());
                    pstmt.setTimestamp(2, new Timestamp(pedido.getData().getMillis()));
                    pstmt.setDouble(3, pedido.getValor());
                    
                    int resultado = pstmt.executeUpdate();
                    if (resultado == 1) {
                        System.out.println("\nInserção bem sucedida.");

                        try (ResultSet rs = pstmt.getGeneratedKeys()) {
                            if (rs.next()) {
                                pedido.setIdPedido(rs.getLong(1));
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

    
    public Pedido buscar(long idPedido) {
        Pedido pedido = null;
        try {
            String selecao = "SELECT * FROM pedido WHERE idPedido = ?";
            try (PreparedStatement pstmt = conexao.prepareStatement(selecao)) {
                pstmt.setLong(1, idPedido);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        pedido = new Pedido();
                        pedido.setIdPedido(rs.getLong(1));
                        pedido.setData(new DateTime(rs.getTimestamp(3)));
                        pedido.setValor(rs.getDouble(4));
                        //ItemPedidoDAO itempedidoDAO = new ItemPedidoDAO();
                        //itempedidoDAO.buscarTodos(pedido);//criar
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
        return pedido;
    }

    public List<Pedido> buscarTodos() {
        Pedido pedido;
        List<Pedido> pedidos = new ArrayList<Pedido>();
        try {
            String selecao = "SELECT * FROM pedido";
            try (Statement stmt = conexao.createStatement()) {
                try (ResultSet rs = stmt.executeQuery(selecao)) {
                    while (rs.next()) {
                        pedido = new Pedido();
                        pedido.setIdPedido(rs.getLong(1));
                        pedido.setData(new DateTime(rs.getTimestamp(3)));
                        pedido.setValor(rs.getDouble(4));
                        //ItemPedidoDAO itempedidoDAO = new ItemPedidoDAO();
                        //itempedidoDAO.buscarTodos(pedido);//criar
                        pedidos.add(pedido);
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
        return pedidos;
    }

    public List<Pedido> buscarTodos(Quarto quarto) {
        List<Pedido> pedidos = new ArrayList<>();
        Pedido pedido;
        try {
            String selecao = "SELECT * FROM pedido WHERE idQuarto = ?";
            try (PreparedStatement pstmt = conexao.prepareStatement(selecao)) {
                pstmt.setLong(1, quarto.getIdQuarto());
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        pedido = new Pedido();
                        pedido.setIdPedido(rs.getLong(1));
                        pedido.setData(new DateTime(rs.getTimestamp(3)));
                        pedido.setValor(rs.getDouble(4));
                        //ItemPedidoDAO itempedidoDAO = new ItemPedidoDAO();
                        //itempedidoDAO.buscarTodos(pedido);//criar
                        pedidos.add(pedido);
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
        return pedidos;
    }

    public void remover(Pedido pedido) {
        try {
            String remocao = "DELETE FROM pedido WHERE idPedido = ?";
            try (PreparedStatement pstmt = conexao.prepareStatement(remocao)) {
                pstmt.setLong(1, pedido.getIdPedido());
                
                ItemPedidoDAO itempedidoDAO = new ItemPedidoDAO(conexao);
                itempedidoDAO.remover(pedido);
                
                int remocoes = pstmt.executeUpdate();
                if (remocoes == 1) {
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

    //REMOVER TODOS OS PEDIDOS DO QUARTO
    public void remover(Quarto quarto) {
        try {
            String remocao = "DELETE FROM pedido WHERE idQuarto = ?";
            try (PreparedStatement pstmt = conexao.prepareStatement(remocao)) {
                pstmt.setLong(1, quarto.getIdQuarto());
                
                ItemPedidoDAO itempedidoDAO = new ItemPedidoDAO(conexao);
                for(Pedido p: quarto.getPedidos()){
                    itempedidoDAO.remover(p);
                }
  
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

    public void tirarPedidodoQuarto (Pedido pedido) {
        try {
            //f) Atualize o banco de dados usando os novos dados desse pedido
            String alteracao = "UPDATE pedido SET idQuarto = ? WHERE idPedido = ?;";
            try (PreparedStatement pstmt = conexao.prepareStatement(alteracao)) {
                pstmt.setLong(1, 0);
                pstmt.setDouble(2, pedido.getIdPedido());
                
                int alteracoes = pstmt.executeUpdate();
                if (alteracoes == 1) {
                    System.out.println("\nAlteracao bem sucedida.");
                } else {
                    System.out.println("A alteracao não foi feita corretamente.");
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
