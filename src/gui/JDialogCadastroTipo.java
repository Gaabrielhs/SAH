/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import classes.Quarto;
import classes.Tipo;
import dao.DAOFactory;
import dao.QuartoDAO;
import dao.TipoDAO;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Gaabrielhs
 */
public class JDialogCadastroTipo extends javax.swing.JDialog {

    private JFrameVisaoGeral visaoGeral;
    private JDialogEscolherCor escolher_cor;
    private DAOFactory fabrica;

    /**
     * Creates new form JDialogCadastroTipo
     */
    public JDialogCadastroTipo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        escolher_cor = new JDialogEscolherCor(parent, true);
        fabrica = new DAOFactory();
    }

    ;

    public Tipo getTipo() {
        Tipo tipo = new Tipo();
        tipo.setNome(jTextFieldNome.getText());
        tipo.setCor(jPanelCor.getBackground());
        tipo.setQnTCamas(Integer.parseInt(jTextFieldNumCamas.getText()));
        tipo.setPreco_diaria(Double.parseDouble(jTextFieldPreco.getText()));
        tipo.setAr_condicionado(jCheckBoxArCondicionado.isSelected());
        tipo.setTv(jCheckBoxTelevisao.isSelected());
        tipo.setTelefone(jCheckBoxTelefone.isSelected());
        tipo.setBanheiro(jCheckBoxBanheiro.isSelected());
        tipo.setFrigobar(jCheckBoxFrigobar.isSelected());
        tipo.setQntQuartos(Integer.parseInt(jTextFieldQntQuartos.getText()));
        return tipo;
    }
    
    public void setTipo(Tipo tipo){
        jTextFieldIdQuarto.setText("" + tipo.getIdTipo());
        jTextFieldNome.setText(tipo.getNome());
        jTextFieldNumCamas.setText("" + tipo.getQntCamas());
        jTextFieldPreco.setText("" + tipo.getPreco_diaria());
        jTextFieldQntQuartos.setText("" + tipo.getQntQuartos());
        jCheckBoxArCondicionado.setSelected(tipo.isAr_condicionado());
        jCheckBoxBanheiro.setSelected(tipo.isBanheiro());
        jCheckBoxFrigobar.setSelected(tipo.isFrigobar());
        jCheckBoxTelefone.setSelected(tipo.isTelefone());
        jCheckBoxTelevisao.setSelected(tipo.isTv());
        jPanelCor.setBackground(tipo.getCor());
    }

    public boolean isValido() {
        if (!jTextFieldNome.getText().isEmpty()
                && !jTextFieldNumCamas.getText().isEmpty()
                && !jTextFieldPreco.getText().isEmpty()
                && !jTextFieldQntQuartos.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Válido!");
            return true;
        }
        JOptionPane.showMessageDialog(this, "Inválido!");
        return false;
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
        jTextFieldNome = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jCheckBoxArCondicionado = new javax.swing.JCheckBox();
        jCheckBoxTelevisao = new javax.swing.JCheckBox();
        jCheckBoxTelefone = new javax.swing.JCheckBox();
        jCheckBoxBanheiro = new javax.swing.JCheckBox();
        jCheckBoxFrigobar = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jButtonOk = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonEscolherCor = new javax.swing.JButton();
        jPanelCor = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldPreco = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNumCamas = new javax.swing.JTextField();
        jTextFieldQntQuartos = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldIdQuarto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Tipo de Quarto");

        jLabel1.setText("Nome:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Atributos"));

        jCheckBoxArCondicionado.setText("Ar Condicionado");

        jCheckBoxTelevisao.setText("Televisão");

        jCheckBoxTelefone.setText("Telefone");

        jCheckBoxBanheiro.setText("Banheiro");

        jCheckBoxFrigobar.setText("Frigobar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxArCondicionado)
                    .addComponent(jCheckBoxTelevisao)
                    .addComponent(jCheckBoxTelefone)
                    .addComponent(jCheckBoxBanheiro)
                    .addComponent(jCheckBoxFrigobar)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBoxArCondicionado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBoxTelevisao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBoxTelefone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBoxBanheiro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBoxFrigobar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Numero de lugares:");

        jButtonOk.setText("OK");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonEscolherCor.setText("Escolher cor...");
        jButtonEscolherCor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEscolherCorActionPerformed(evt);
            }
        });

        jPanelCor.setBackground(new java.awt.Color(255, 255, 255));
        jPanelCor.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanelCorLayout = new javax.swing.GroupLayout(jPanelCor);
        jPanelCor.setLayout(jPanelCorLayout);
        jPanelCorLayout.setHorizontalGroup(
            jPanelCorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 51, Short.MAX_VALUE)
        );
        jPanelCorLayout.setVerticalGroup(
            jPanelCorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );

        jLabel3.setText("Preço:");

        jTextFieldPreco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldPrecoKeyTyped(evt);
            }
        });

        jLabel4.setText("Numero de quartos:");

        jTextFieldNumCamas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNumCamasKeyTyped(evt);
            }
        });

        jTextFieldQntQuartos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldQntQuartosKeyTyped(evt);
            }
        });

        jLabel5.setText("idTipo:");

        jTextFieldIdQuarto.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNumCamas, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldIdQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonEscolherCor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanelCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonOk)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonCancelar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldQntQuartos)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonCancelar, jButtonOk});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldIdQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNumCamas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jButtonEscolherCor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonOk)
                            .addComponent(jButtonCancelar)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextFieldQntQuartos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEscolherCorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEscolherCorActionPerformed
        if (escolher_cor.isOk()) {
            jPanelCor.setBackground(escolher_cor.getCor());
        }
    }//GEN-LAST:event_jButtonEscolherCorActionPerformed

    private void jTextFieldPrecoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPrecoKeyTyped
        String caracteres = "0123456789,.";
        if (!caracteres.contains(evt.getKeyChar() + "") && !(evt.getKeyCode() == evt.VK_BACK_SPACE) && !(evt.getKeyCode() == evt.VK_ENTER)) {
            evt.consume();
        } else {
            if (evt.getKeyChar() == ',') {
                evt.setKeyChar('.');
            }
        }
    }//GEN-LAST:event_jTextFieldPrecoKeyTyped

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
        setVisible(false);
        if (isValido()) {
            Tipo tipo = getTipo();
            fabrica.abrirConexao();
            TipoDAO dao = fabrica.criarTipoDAO();
            dao.gravar(tipo);
            
            //Gravar todos os quartos no banco de dados daquele respectivo TIPO
            QuartoDAO qDAO = fabrica.criarQuartoDAO();
            for(int i = 0; i < tipo.getQntQuartos(); i++){
                qDAO.gravar(new Quarto(tipo));
            }
            fabrica.fecharConexao();
        }
    }//GEN-LAST:event_jButtonOkActionPerformed

    public void limpar(){
        jTextFieldNome.setText("");
        jTextFieldPreco.setText("");
        jTextFieldQntQuartos.setText("");
        jTextFieldNumCamas.setText("");
        jCheckBoxArCondicionado.setSelected(false);
        jCheckBoxBanheiro.setSelected(false);
        jCheckBoxFrigobar.setSelected(false);
        jCheckBoxTelefone.setSelected(false);
        jCheckBoxTelevisao.setSelected(false);
        jPanelCor.setBackground(Color.WHITE);
    }
    public void cadastrarTipo(JFrameVisaoGeral visaoGeral){
        this.visaoGeral = visaoGeral;
        setVisible(true);
        visaoGeral.atualizarQuartos();
        visaoGeral.atualizarLegenda();
        limpar();
    }
    
    private void jTextFieldNumCamasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNumCamasKeyTyped
        String caracteres = "0123456789";
        if (!caracteres.contains(evt.getKeyChar() + "") && !(evt.getKeyCode() == evt.VK_BACK_SPACE) && !(evt.getKeyCode() == evt.VK_ENTER)) {
            evt.consume();
        } 
    }//GEN-LAST:event_jTextFieldNumCamasKeyTyped

    private void jTextFieldQntQuartosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldQntQuartosKeyTyped
        String caracteres = "0123456789,.";
        if (!caracteres.contains(evt.getKeyChar() + "") && !(evt.getKeyCode() == evt.VK_BACK_SPACE) && !(evt.getKeyCode() == evt.VK_ENTER)) {
            evt.consume();
        } else {
            if (evt.getKeyChar() == ',') {
                evt.setKeyChar('.');
            }
        }
    }//GEN-LAST:event_jTextFieldQntQuartosKeyTyped

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        setVisible(false);
        limpar();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(JDialogCadastroTipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogCadastroTipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogCadastroTipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogCadastroTipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogCadastroTipo dialog = new JDialogCadastroTipo(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEscolherCor;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JCheckBox jCheckBoxArCondicionado;
    private javax.swing.JCheckBox jCheckBoxBanheiro;
    private javax.swing.JCheckBox jCheckBoxFrigobar;
    private javax.swing.JCheckBox jCheckBoxTelefone;
    private javax.swing.JCheckBox jCheckBoxTelevisao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelCor;
    private javax.swing.JTextField jTextFieldIdQuarto;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldNumCamas;
    private javax.swing.JTextField jTextFieldPreco;
    private javax.swing.JTextField jTextFieldQntQuartos;
    // End of variables declaration//GEN-END:variables
}