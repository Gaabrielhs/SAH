/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Cliente;
import classes.Quarto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.joda.time.DateTime;

/**
 *
 * @author Usuario
 */
public class ClienteDAO {

    private Connection conexao;

    public ClienteDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public long gravar(Cliente cliente, Quarto quarto) {
        long idGerado = -1;
        try {
            String sql = "INSERT INTO cliente (nome, rg, cpf, endereco, dataNasc, telefone, email, idQuarto) VALUES(?, ?, ?, ?, ?, ?, ?,?);";

            PreparedStatement pstmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getRg());
            pstmt.setString(3, cliente.getCpf());
            pstmt.setString(4, cliente.getEndereco());
            pstmt.setTimestamp(5, new Timestamp(cliente.getDataNasc().getMillis()));
            pstmt.setString(6, cliente.getTelefone());
            pstmt.setString(7, cliente.getEmail());
            pstmt.setLong(8, quarto.getIdQuarto());

            int quantos = pstmt.executeUpdate();
            if (quantos == 1) {
                System.out.println("Inserção efetuada com sucesso");
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        idGerado = rs.getLong(1);
                    }
                }
            } else {
                System.out.println("Problema na inserção!");
            }

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
        return idGerado;
    }

    public void gravar(Cliente cliente) {
        try {
            String sql = "INSERT INTO cliente (nome, rg, cpf, endereco, dataNasc, telefone, email) VALUES(?, ?, ?, ?, ?, ?, ?);";

            PreparedStatement pstmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getRg());
            pstmt.setString(3, cliente.getCpf());
            pstmt.setString(4, cliente.getEndereco());
            pstmt.setTimestamp(5, new Timestamp(cliente.getDataNasc().getMillis()));
            pstmt.setString(6, cliente.getTelefone());
            pstmt.setString(7, cliente.getEmail());

            int quantos = pstmt.executeUpdate();
            if (quantos == 1) {
                System.out.println("Inserção efetuada com sucesso");
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        cliente.setIdCliente(rs.getLong(1));
                    }
                }
            } else {
                System.out.println("Problema na inserção!");
            }

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

    //Registra todos os clientes do quarto
    public void gravar(Quarto quarto) {
        long idGerado = -1;
        try {
            String sql = "INSERT INTO cliente (nome, rg, cpf, endereco, dataNasc, telefone, email, idQuarto) VALUES(?, ?, ?, ?, ?, ?, ?,?);";

            PreparedStatement pstmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            for (Cliente cliente : quarto.getClientes()) {
                pstmt.setString(1, cliente.getNome());
                pstmt.setString(2, cliente.getRg());
                pstmt.setString(3, cliente.getCpf());
                pstmt.setString(4, cliente.getEndereco());
                pstmt.setTimestamp(5, new Timestamp(cliente.getDataNasc().getMillis()));
                pstmt.setString(6, cliente.getTelefone());
                pstmt.setString(7, cliente.getEmail());
                pstmt.setLong(8, quarto.getIdQuarto());

                int quantos = pstmt.executeUpdate();
                if (quantos == 1) {
                    System.out.println("Inserção efetuada com sucesso");
                    try (ResultSet rs = pstmt.getGeneratedKeys()) {
                        if (rs.next()) {
                            cliente.setIdCliente(rs.getLong(1));
                        }
                    }
                } else {
                    System.out.println("Problema na inserção!");
                }
            }
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

    public Cliente buscar(long idCliente) {
        Cliente cliente = null;
        try {
            String sql = "SELECT * FROM cliente WHERE idCliente = ?;";
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setLong(1, idCliente);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                cliente = new Cliente(rs.getLong("idCliente"),
                        rs.getString("nome"),
                        rs.getString("rg"),
                        rs.getString("cpf"),
                        rs.getString("endereco"),
                        new DateTime(rs.getTimestamp("dataNasc")),
                        rs.getString("telefone"),
                        rs.getString("email"));
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
        return cliente;
    }

    public List<Cliente> buscarTodos() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM cliente ORDER BY idCliente;";
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                do {
                    Cliente cliente = new Cliente(rs.getLong("idCliente"),
                            rs.getString("nome"),
                            rs.getString("rg"),
                            rs.getString("cpf"),
                            rs.getString("endereco"),
                            new DateTime(rs.getTimestamp("dataNasc")),
                            rs.getString("telefone"),
                            rs.getString("email"));
                    clientes.add(cliente);
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
        return clientes;
    }

    public List<Cliente> buscarTodos(Quarto quarto) {
        List<Cliente> clientes = new ArrayList<Cliente>();
        Cliente cliente;                    
        try {
            //JOptionPane.showMessageDialog(null, "" + quarto.getIdQuarto());
            String selecao = "SELECT * FROM cliente WHERE idQuarto = ?;";
            try (PreparedStatement pstmt = conexao.prepareStatement(selecao)) {
                pstmt.setLong(1, quarto.getIdQuarto());
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        cliente = new Cliente();
                        cliente.setIdCliente(rs.getInt(1));
                        cliente.setNome(rs.getString(3));
                        cliente.setRg(rs.getString(4));
                        cliente.setCpf(rs.getString(5));
                        cliente.setEndereco(rs.getString(6));
                        cliente.setTelefone(rs.getString(7));
                        cliente.setEmail(rs.getString(8));
                        cliente.setDataNasc(new DateTime(rs.getTimestamp(9)));
                        //JOptionPane.showMessageDialog(null, "" + cliente);
                        clientes.add(cliente);
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
        return clientes;
    }

    public List<Cliente> buscar(String nome) {
        List<Cliente> clientes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM cliente WHERE UPPER(nome) LIKE UPPER(?);";
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, "%" + nome + "%");
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                do {
                    Cliente cliente = new Cliente(rs.getLong("idCliente"),
                            rs.getString("nome"),
                            rs.getString("rg"),
                            rs.getString("cpf"),
                            rs.getString("endereco"),
                            new DateTime(rs.getTimestamp("dataNasc")),
                            rs.getString("telefone"),
                            rs.getString("email"));
                    clientes.add(cliente);
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
        return clientes;
    }

    public void atualizar(Cliente cliente) {
        try {
            String sql = "UPDATE Cliente SET nome = ?, rg = ?, cpf = ?, endereco = ?, dataNasc = ?, telefone = ?, email = ? WHERE idCliente = ?;";
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getRg());
            pstmt.setString(3, cliente.getCpf());
            pstmt.setString(4, cliente.getEndereco());
            pstmt.setTimestamp(5, new Timestamp(cliente.getDataNasc().getMillis()));
            pstmt.setString(6, cliente.getTelefone());
            pstmt.setString(7, cliente.getEmail());
            pstmt.setLong(8, cliente.getIdCliente());

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
    public void tirarClientedoQuarto (Cliente cliente) {
        try {
            String sql = "UPDATE Cliente SET idQuarto = ? WHERE idCliente = ?;";
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setNull(1, 1);
            pstmt.setLong(2, cliente.getIdCliente());

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
    

    //Seta o idQuarto na tupla cliente
    public void atualizar(Cliente cliente, Quarto quarto) {
        try {
            String sql = "UPDATE Cliente SET nome = ?, rg = ?, cpf = ?, endereco = ?, dataNasc = ?, telefone = ?, email = ?, idQuarto = ? WHERE idCliente = ?;";
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getRg());
            pstmt.setString(3, cliente.getCpf());
            pstmt.setString(4, cliente.getEndereco());
            pstmt.setTimestamp(5, new Timestamp(cliente.getDataNasc().getMillis()));
            pstmt.setString(6, cliente.getTelefone());
            pstmt.setString(7, cliente.getEmail());
            pstmt.setLong(8, quarto.getIdQuarto());
            pstmt.setLong(9, cliente.getIdCliente());

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

    public void remover(Cliente cliente) {
        try {
            String sql = "DELETE FROM cliente WHERE idCliente = ?;";
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setLong(1, cliente.getIdCliente());

            if (pstmt.executeUpdate() == 1) {
                System.out.println("\nRemoção efetuada com sucesso.");
            } else {
                System.out.println("\nProblema na remoção!");
            }

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
}
