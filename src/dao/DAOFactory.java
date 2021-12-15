package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOFactory {

    private Connection conexao = null;

    public  ClienteDAO criarClienteDAO() {
        if (conexao == null) {
            throw new IllegalStateException("Abra uma conexão antes de criar um DAO.");
        } else {
            return new ClienteDAO(conexao);
        }
    }
    
    public  TipoDAO criarTipoDAO() {
        if (conexao == null) {
            throw new IllegalStateException("Abra uma conexão antes de criar um DAO.");
        } else {
            return new TipoDAO(conexao);
        }
    }
    
    public  QuartoDAO criarQuartoDAO() {
        if (conexao == null) {
            throw new IllegalStateException("Abra uma conexão antes de criar um DAO.");
        } else {
            return new QuartoDAO(conexao);
        }
    }
    
    public  PedidoDAO criarPedidoDAO() {
        if (conexao == null) {
            throw new IllegalStateException("Abra uma conexão antes de criar um DAO.");
        } else {
            return new PedidoDAO(conexao);
        }
    }
    
    public  FuncionarioDAO criarFuncionarioDAO() {
        if (conexao == null) {
            throw new IllegalStateException("Abra uma conexão antes de criar um DAO.");
        } else {
            return new FuncionarioDAO(conexao);
        }
    }
    
    public  ProdutoDAO criarProdutoDAO() {
        if (conexao == null) {
            throw new IllegalStateException("Abra uma conexão antes de criar um DAO.");
        } else {
            return new ProdutoDAO(conexao);
        }
    }
    

    public  void abrirConexao() {
        if (conexao == null) {
            conexao = ConexaoFactory.getConexao();
        } else {
            throw new IllegalStateException("A conexão já está aberta.");
        }
    }

    public  void fecharConexao() {
        if (conexao != null) {
            System.out.println("Terminando a conexão com o banco de dados.");
            try {
                conexao.close();
                conexao = null;
                System.out.println("Conexão com o banco de dados terminada.");
            } catch (SQLException ex) {
                System.out.println("Erro fechando a conexão com o banco de dados.");
            }
        } else {
            throw new IllegalStateException("A conexão com o BD já está fechada.");
        }
    }

    public  void iniciarTransacao() {
        try {
            conexao.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public  void terminarTransacao() {
        try {
            conexao.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conexao.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE,
                        null, ex);
            }
        }
    }

    public  void abortarTransacao() {
        try {
            conexao.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conexao.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public DAOFactory() {
    }
}

