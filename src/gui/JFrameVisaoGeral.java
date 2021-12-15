/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import classes.Cliente;
import classes.Funcionario;
import classes.Quarto;
import classes.Tipo;
import dao.ClienteDAO;
import dao.DAOFactory;
import dao.FuncionarioDAO;
import dao.QuartoDAO;
import dao.TipoDAO;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import static java.lang.Math.sqrt;
import javax.swing.JOptionPane;

/**
 *
 * @author Gaabrielhs
 */
public class JFrameVisaoGeral extends javax.swing.JFrame {

    private Funcionario funcionario;
    private JFrameLogin login;
    private JDialogCadastroCliente janelaCadastroCliente;
    private JDialogCadastroFuncionario janelaCadastroFuncionario;
    private JFrameCliente janelaCliente;
    private JDialogCadastroTipo janelaTipo;
    private DAOFactory fabrica;
    /**
     * Creates new form JFrameVisaoGeral
     */
    public JFrameVisaoGeral(JFrameLogin login) {
        initComponents();
        this.login = login;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/icone.png")));
        funcionario = new Funcionario();
        janelaCadastroCliente = new JDialogCadastroCliente(this, true);
        janelaCadastroFuncionario = new JDialogCadastroFuncionario(this, true);
        janelaTipo = new JDialogCadastroTipo(this, true);
        janelaCliente = new JFrameCliente();
        fabrica = new DAOFactory();
        
        jPanelQuartos.setLayout(this.criarGridQuartos());
        jPanelTipos.setLayout(this.criarGridLegenda());
        
        jPanelSituacoes.setLayout(new GridLayout(4, 1, 0, 2));
        jPanelSituacoes.add(new JPanelTipo(new Color(0, 255, 0), "Desocupado"));
        jPanelSituacoes.add(new JPanelTipo(new Color(255, 0, 0), "Ocupado"));
        jPanelSituacoes.add(new JPanelTipo(new Color(255, 142, 0), "Em Limpeza"));
        jPanelSituacoes.add(new JPanelTipo(new Color(255, 255, 0), "Reservado"));
      
        //jPanel1.setLayout(new GridLayout(8,8, 5, 5));
        //jPanelLegenda.setLayout(new GridLayout(3, 3, 1, 5));
        //atualizarQuartos();
        //atualizarLegenda();
        
    }
    
    public JFrameVisaoGeral() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/icone.png")));
        janelaCadastroCliente = new JDialogCadastroCliente(this, true);
        janelaTipo = new JDialogCadastroTipo(this, true);
        janelaCliente = new JFrameCliente();
        fabrica = new DAOFactory();
        
        jPanelQuartos.setLayout(this.criarGridQuartos());
        jPanelTipos.setLayout(this.criarGridLegenda());
        
        jPanelSituacoes.setLayout(new GridLayout(4, 1, 0, 2));
        jPanelSituacoes.add(new JPanelTipo(new Color(0, 255, 0), "Desocupado"));
        jPanelSituacoes.add(new JPanelTipo(new Color(255, 0, 0), "Ocupado"));
        jPanelSituacoes.add(new JPanelTipo(new Color(255, 142, 0), "Em Limpeza"));
        jPanelSituacoes.add(new JPanelTipo(new Color(255, 255, 0), "Reservado"));

        atualizarQuartos();
        atualizarLegenda();
    }

    public void fazerLogin(Funcionario funcionario){
        this.funcionario = funcionario;
        setVisible(true);
        atualizarQuartos();
        atualizarLegenda();
    }
    public GridLayout criarGridLegenda(){
        fabrica.abrirConexao();
        TipoDAO dao = fabrica.criarTipoDAO();
        int qntInt = (int)sqrt(dao.buscarTodos().size());
        double qntDouble = sqrt(dao.buscarTodos().size());
        fabrica.fecharConexao();
        if(qntInt == 0){
            qntInt++;
        }else{
            if(qntDouble - qntInt > 0){
            qntInt++;
        }
        }
        return new GridLayout(qntInt, qntInt, 2, 2);
    }
    
    public GridLayout criarGridQuartos(){
        fabrica.abrirConexao();
        QuartoDAO dao = fabrica.criarQuartoDAO();
        int qntInt = (int)sqrt(dao.buscarTodos().size());
        double qntDouble = sqrt(dao.buscarTodos().size());
        fabrica.fecharConexao();
        if(qntInt == 0){
            qntInt++;
        }else{
            if(qntDouble - qntInt > 0){
            qntInt++;
        }
        }
        return new GridLayout(qntInt, qntInt, 2, 2);
    }
    
    public void atualizarLegenda(){
        jPanelTipos.removeAll();
        fabrica.abrirConexao();
        TipoDAO dao = fabrica.criarTipoDAO();
        if(dao.buscarTodos().isEmpty()){
            jPanelTipos.add(new JPanelTipo(Color.WHITE, "Nenhum tipo cadastrado"));
        }else{
            for(Tipo t: dao.buscarTodos()){
            jPanelTipos.add(new JPanelTipo(t));
        }
        }
        fabrica.fecharConexao();
        jPanelTipos.setLayout((this.criarGridLegenda()));
        jLabelFuncionario.setText(funcionario.getNome());
    }
    
    public void atualizarQuartos(){
        jPanelQuartos.removeAll();
        fabrica.abrirConexao();
        QuartoDAO dao = fabrica.criarQuartoDAO();
        for(Quarto q: dao.buscarTodos()){
            jPanelQuartos.add(new JPanelQuarto(this, q));
        }
        fabrica.fecharConexao();
        jPanelQuartos.setLayout(this.criarGridQuartos());
    }
    
    public void adicionarQuartos(Quarto quarto){
        jPanelQuartos.add(new JPanelQuarto(this, quarto));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelQuartos = new javax.swing.JPanel();
        jPanelTabLegenda = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanelTipos = new javax.swing.JPanel();
        jPanelSituacoes = new javax.swing.JPanel();
        jLabelFuncionariotxt = new javax.swing.JLabel();
        jLabelFuncionario = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadastro = new javax.swing.JMenu();
        jMenuItemCliente = new javax.swing.JMenuItem();
        jMenuItemFuncionario = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Visão Geral");
        setMaximumSize(new java.awt.Dimension(1024, 720));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Visão Geral");

        jTabbedPane1.setMaximumSize(new java.awt.Dimension(1024, 720));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(0, 0));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1024, 720));
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jPanelQuartos.setMaximumSize(new java.awt.Dimension(1024, 720));
        jPanelQuartos.setPreferredSize(new java.awt.Dimension(1024, 720));

        javax.swing.GroupLayout jPanelQuartosLayout = new javax.swing.GroupLayout(jPanelQuartos);
        jPanelQuartos.setLayout(jPanelQuartosLayout);
        jPanelQuartosLayout.setHorizontalGroup(
            jPanelQuartosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1019, Short.MAX_VALUE)
        );
        jPanelQuartosLayout.setVerticalGroup(
            jPanelQuartosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 602, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Quartos", jPanelQuartos);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/legenda.png"))); // NOI18N

        jPanelTipos.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipos"));
        jPanelTipos.setMaximumSize(new java.awt.Dimension(216, 78));

        javax.swing.GroupLayout jPanelTiposLayout = new javax.swing.GroupLayout(jPanelTipos);
        jPanelTipos.setLayout(jPanelTiposLayout);
        jPanelTiposLayout.setHorizontalGroup(
            jPanelTiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );
        jPanelTiposLayout.setVerticalGroup(
            jPanelTiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 24, Short.MAX_VALUE)
        );

        jPanelSituacoes.setBorder(javax.swing.BorderFactory.createTitledBorder("Situações"));
        jPanelSituacoes.setMaximumSize(new java.awt.Dimension(216, 78));

        javax.swing.GroupLayout jPanelSituacoesLayout = new javax.swing.GroupLayout(jPanelSituacoes);
        jPanelSituacoes.setLayout(jPanelSituacoesLayout);
        jPanelSituacoesLayout.setHorizontalGroup(
            jPanelSituacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );
        jPanelSituacoesLayout.setVerticalGroup(
            jPanelSituacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 73, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanelSituacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanelTipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelSituacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelTipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(220, Short.MAX_VALUE))
        );

        jLabelFuncionariotxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelFuncionariotxt.setText("Funcionário:");

        jLabelFuncionario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanelTabLegendaLayout = new javax.swing.GroupLayout(jPanelTabLegenda);
        jPanelTabLegenda.setLayout(jPanelTabLegendaLayout);
        jPanelTabLegendaLayout.setHorizontalGroup(
            jPanelTabLegendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTabLegendaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTabLegendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelTabLegendaLayout.createSequentialGroup()
                        .addComponent(jLabelFuncionariotxt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelFuncionario)))
                .addContainerGap(773, Short.MAX_VALUE))
        );
        jPanelTabLegendaLayout.setVerticalGroup(
            jPanelTabLegendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTabLegendaLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanelTabLegendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFuncionariotxt)
                    .addComponent(jLabelFuncionario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );

        jTabbedPane1.addTab("Legenda", jPanelTabLegenda);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/sah_logo.png"))); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jButton1.setText("Atualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenuCadastro.setText("Cadastro");

        jMenuItemCliente.setText("Cliente");
        jMenuItemCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemClienteActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemCliente);

        jMenuItemFuncionario.setText("Funcionario");
        jMenuItemFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFuncionarioActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemFuncionario);

        jMenuItem3.setText("Produto");
        jMenuCadastro.add(jMenuItem3);

        jMenuItem10.setText("Quarto");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItem10);

        jMenuBar1.add(jMenuCadastro);

        jMenu4.setText("Busca");

        jMenuItem5.setText("Cliente");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);

        jMenuItem7.setText("Produto");
        jMenu4.add(jMenuItem7);

        jMenuBar1.add(jMenu4);

        jMenu3.setText("Usuário");

        jMenuItem9.setText("Trocar Usuário");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenuItem8.setText("Sair");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemClienteActionPerformed
        int resposta = janelaCadastroCliente.mostrarNovo();
        
        if(resposta == JDialogCadastroCliente.OK){
            Cliente cliente = janelaCadastroCliente.getCliente();
            fabrica.abrirConexao();
            ClienteDAO dao = fabrica.criarClienteDAO();
            dao.gravar(cliente);
            fabrica.fecharConexao();
            janelaCliente.buscarTodos();
        }
    }//GEN-LAST:event_jMenuItemClienteActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        janelaCliente.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        janelaTipo.cadastrarTipo(this);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        login.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        atualizarQuartos();
        atualizarLegenda();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
//        atualizarQuartos();
//        atualizarLegenda();
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void jMenuItemFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFuncionarioActionPerformed
            int resposta = janelaCadastroFuncionario.mostrarNovo();
        
        if(resposta == JDialogCadastroCliente.OK){
            Funcionario funcionario = janelaCadastroFuncionario.getFuncionario();
            fabrica.abrirConexao();
            FuncionarioDAO dao = fabrica.criarFuncionarioDAO();
            dao.gravar(funcionario);
            fabrica.fecharConexao();
            janelaCliente.buscarTodos();
        }
    }//GEN-LAST:event_jMenuItemFuncionarioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameVisaoGeral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameVisaoGeral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameVisaoGeral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameVisaoGeral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameVisaoGeral().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelFuncionario;
    private javax.swing.JLabel jLabelFuncionariotxt;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastro;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMenuItemCliente;
    private javax.swing.JMenuItem jMenuItemFuncionario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelQuartos;
    private javax.swing.JPanel jPanelSituacoes;
    private javax.swing.JPanel jPanelTabLegenda;
    private javax.swing.JPanel jPanelTipos;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
