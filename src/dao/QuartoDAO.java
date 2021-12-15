/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Cliente;
import classes.Pedido;
import classes.Quarto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Gaabrielhs
 */
public class QuartoDAO {

    private Connection conexao;

    public QuartoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void gravar(Quarto quarto) {
        try {
            String insercao = "INSERT INTO quarto (idTipo, situacao) VALUES (?, ?);";
            try (PreparedStatement pstmt = conexao.prepareStatement(insercao, PreparedStatement.RETURN_GENERATED_KEYS)) {
                pstmt.setLong(1, quarto.getTipo().getIdTipo());
                pstmt.setInt(2, quarto.getSituacao());
                int resultado = pstmt.executeUpdate();

                if (resultado == 1) {
                    System.out.println("\nInserção bem sucedida.");
                    try (ResultSet rs = pstmt.getGeneratedKeys()) {
                        if (rs.next()) {
                            quarto.setIdQuarto(rs.getLong(1));
                        }
                    }
                    ClienteDAO clienteDAO = new ClienteDAO(conexao);
                    clienteDAO.gravar(quarto);
                    PedidoDAO pedidoDAO = new PedidoDAO(conexao);
                    pedidoDAO.gravar(quarto);

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

    public void buscar(Quarto quarto){
        try {
            String sql = "SELECT * FROM quarto order by idQuarto;";
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                    quarto.setIdQuarto(rs.getLong("idQuarto"));
                    quarto.setSituacao(rs.getInt("situacao"));
                    TipoDAO tipoDAO = new TipoDAO(conexao);
                    quarto.setTipo(tipoDAO.buscar(rs.getInt("idTipo")));
                    ClienteDAO clienteDAO = new ClienteDAO(conexao);
                    quarto.setClientes(clienteDAO.buscarTodos(quarto));
                    PedidoDAO pedidoDAO = new PedidoDAO(conexao);
                    pedidoDAO.buscarTodos(quarto);
            }

            rs.close();
            pstmt.close();

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

    public List<Quarto> buscarTodos() {
        List<Quarto> quartos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM quarto order by idQuarto;";
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                do {
                    Quarto quarto = new Quarto();
                    quarto.setIdQuarto(rs.getLong("idQuarto"));
                    quarto.setSituacao(rs.getInt("situacao"));
                    TipoDAO tipoDAO = new TipoDAO(conexao);
                    quarto.setTipo(tipoDAO.buscar(rs.getInt("idTipo")));
                    ClienteDAO clienteDAO = new ClienteDAO(conexao);
                    quarto.setClientes(clienteDAO.buscarTodos(quarto));
                    PedidoDAO pedidoDAO = new PedidoDAO(conexao);
                    quarto.setPedidos(pedidoDAO.buscarTodos(quarto));
                    //JOptionPane.showMessageDialog(null, "" + quarto.getIdQuarto() + quarto.getTipo().toString() + quarto.getClientes() + quarto.getPedidos());
                    quartos.add(quarto);
                } while (rs.next());
            }

            rs.close();
            pstmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro no acesso ao banco de dados.");
            while (ex != null) {
                System.out.println("SQL State: " + ex.getSQLState());
                System.out.println("Mensagem: " + ex.getMessage());
                System.out.println("Error Code: " + ex.getErrorCode());
                ex = ex.getNextException();
            }
        }
        return quartos;
    }

    public void atualizar(Quarto quarto) {
        try {
            String sql = "UPDATE Quarto SET situacao = ? WHERE idQuarto = ?;";
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, quarto.getSituacao());
            pstmt.setLong(2, quarto.getIdQuarto());
            ClienteDAO cdao = new ClienteDAO(conexao);
            for (Cliente c : quarto.getClientes()) {
                cdao.atualizar(c, quarto);
            }

            //inserir pedidos no quarto
            //PedidoDAO pdao = new PedidoDAO(conexao);
            if (pstmt.executeUpdate() == 1) {
                System.out.println("\nAtualização efetuada com sucesso");
            } else {
                System.out.println("\nProblema na atualização!");
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

    //ao remover o quarto, remove-se também todos os clientes e pedidos ligados a ele.
    public void remover(Quarto quarto) {
        try {
            String sql = "DELETE FROM quarto WHERE idQuarto = ?;";
            PreparedStatement delete = conexao.prepareStatement(sql);
            delete.setLong(1, quarto.getIdQuarto());

            ClienteDAO clienteDAO = new ClienteDAO(conexao);
            for (Cliente c : quarto.getClientes()) {
                clienteDAO.remover(c);
            }

            PedidoDAO pedidoDAO = new PedidoDAO(conexao);
            for (Pedido p : quarto.getPedidos()) {
                pedidoDAO.remover(p);
            }

            if (delete.executeUpdate() == 1) {
                System.out.println("\nRemoção efetuada com sucesso.");
            } else {
                System.out.println("\nProblema na remoção!");
            }

            delete.close();

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
