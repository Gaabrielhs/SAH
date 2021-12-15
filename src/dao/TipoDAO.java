/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Tipo;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;

/**
 *
 * @author Gaabrielhs
 */
public class TipoDAO {

    private Connection conexao;

    public TipoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void gravar(Tipo tipo) {
        long idGerado = -1;
        try {
            String sql = "INSERT INTO tipo (camas, nome, r, g, b, preco, arcondicionado, tv, telefone, frigobar, banheiro, qntQuartos) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

            PreparedStatement pstmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, tipo.getQntCamas());
            pstmt.setString(2, tipo.getNome());
            pstmt.setInt(3, tipo.getRed());
            pstmt.setInt(4, tipo.getGreen());
            pstmt.setInt(5, tipo.getBlue());
            pstmt.setDouble(6, tipo.getPreco_diaria());
            pstmt.setBoolean(7, tipo.isAr_condicionado());
            pstmt.setBoolean(8, tipo.isTv());
            pstmt.setBoolean(9, tipo.isTelefone());
            pstmt.setBoolean(10, tipo.isFrigobar());
            pstmt.setBoolean(11, tipo.isBanheiro());
            pstmt.setInt(12, tipo.getQntQuartos());

            int quantos = pstmt.executeUpdate();
            if (quantos == 1) {
                System.out.println("Inserção efetuada com sucesso");
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        tipo.setIdTipo(rs.getLong(1));
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

    public List<Tipo> buscarTodos() {
        List<Tipo> tipos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tipo;";
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                do {
                    Tipo tipo = new Tipo();
                    tipo.setIdTipo(rs.getLong("idTipo"));
                    tipo.setQnTCamas(rs.getInt("camas"));
                    tipo.setNome(rs.getString("nome"));
                    tipo.setCor(rs.getInt("r"), rs.getInt("g"), rs.getInt("b"));
                    tipo.setPreco_diaria(rs.getDouble("preco"));
                    tipo.setAr_condicionado(rs.getBoolean("arcondicionado"));
                    tipo.setTv(rs.getBoolean("tv"));
                    tipo.setTelefone(rs.getBoolean("telefone"));
                    tipo.setFrigobar(rs.getBoolean("frigobar"));
                    tipo.setBanheiro(rs.getBoolean("banheiro"));
                    tipo.setQntQuartos(rs.getInt("qntQuartos"));
                    tipos.add(tipo);
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
        return tipos;
    }

    public Tipo buscar(long idTipo) {
        Tipo tipo = null;
        try {
            String sql = "SELECT * FROM tipo WHERE idTipo = ?;";
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setLong(1, idTipo);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                tipo = new Tipo();
                tipo.setIdTipo(rs.getLong("idTipo"));
                tipo.setQnTCamas(rs.getInt("camas"));
                tipo.setNome(rs.getString("nome"));
                tipo.setCor(rs.getInt("r"), rs.getInt("g"), rs.getInt("b"));
                tipo.setPreco_diaria(rs.getDouble("preco"));
                tipo.setAr_condicionado(rs.getBoolean("arcondicionado"));
                tipo.setTv(rs.getBoolean("tv"));
                tipo.setTelefone(rs.getBoolean("telefone"));
                tipo.setFrigobar(rs.getBoolean("frigobar"));
                tipo.setBanheiro(rs.getBoolean("banheiro"));
                tipo.setQntQuartos(rs.getInt("qntQuartos"));
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
        return tipo;
    }

    public List<Tipo> buscar(String nome) {
        List<Tipo> tipos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tipo WHERE UPPER(nome) LIKE UPPER(?);";
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, "%" + nome + "%");
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                do {
                    Tipo tipo = new Tipo();
                    tipo.setIdTipo(rs.getLong("idTipo"));
                    tipo.setQnTCamas(rs.getInt("camas"));
                    tipo.setNome(rs.getString("nome"));
                    tipo.setCor(rs.getInt("r"), rs.getInt("g"), rs.getInt("b"));
                    tipo.setPreco_diaria(rs.getDouble("preco"));
                    tipo.setAr_condicionado(rs.getBoolean("arcondicionado"));
                    tipo.setTv(rs.getBoolean("tv"));
                    tipo.setTelefone(rs.getBoolean("telefone"));
                    tipo.setFrigobar(rs.getBoolean("frigobar"));
                    tipo.setBanheiro(rs.getBoolean("banheiro"));
                    tipo.setQntQuartos(rs.getInt("qntQuartos"));
                    tipos.add(tipo);
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
        return tipos;
    }

    public void atualizar(Tipo tipo) {
        try {
            String sql = "UPDATE Tipo SET camas = ?, nome = ?, r = ?, g = ?, b = ?, preco = ?, arcondicionado = ?, tv = ?, telefone = ?, frigobar = ?, banheiro = ?, qntQuartos = ? WHERE idTipo = ?;";
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, tipo.getQntCamas());
            pstmt.setString(2, tipo.getNome());
            pstmt.setInt(3, tipo.getRed());
            pstmt.setInt(4, tipo.getGreen());
            pstmt.setInt(5, tipo.getBlue());
            pstmt.setDouble(6, tipo.getPreco_diaria());
            pstmt.setBoolean(7, tipo.isAr_condicionado());
            pstmt.setBoolean(8, tipo.isTv());
            pstmt.setBoolean(9, tipo.isTelefone());
            pstmt.setBoolean(10, tipo.isFrigobar());
            pstmt.setBoolean(11, tipo.isBanheiro());
            pstmt.setInt(12, tipo.getQntQuartos());
            pstmt.setLong(13, tipo.getIdTipo());

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

    public void remover(Tipo tipo) {
        try {
            String sql = "DELETE FROM tipo WHERE idTipo = ?;";
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setLong(1, tipo.getIdTipo());

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
