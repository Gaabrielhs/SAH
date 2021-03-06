/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import classes.Cliente;
import classes.Pedido;
import classes.Quarto;
import dao.ClienteDAO;
import dao.DAOFactory;
import dao.PedidoDAO;
import dao.QuartoDAO;
import java.awt.Color;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Gaabrielhs
 */
public class JDialogVisaoQuarto extends javax.swing.JDialog {

    private DefaultListModel<Cliente> modeloCliente;
    private DefaultListModel<Pedido> modeloPedido;
    private DAOFactory fabrica;
    private Quarto quarto;
    private JDialogEntradaDeHospede entrada;
    private JFrameVisaoGeral visaogeral;
    private JDialogCadastroPedido pedido;

    /**
     * Creates new form JDialogVisaoQuarto
     */
    public JDialogVisaoQuarto(Quarto quarto, java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        modeloCliente = (DefaultListModel<Cliente>) jListCliente.getModel();
        modeloPedido = (DefaultListModel<Pedido>) jListPedido.getModel();
        entrada = new JDialogEntradaDeHospede(quarto, parent, true);
        pedido = new JDialogCadastroPedido(quarto, parent, true);
        visaogeral = (JFrameVisaoGeral) parent;
        this.quarto = quarto;
        fabrica = new DAOFactory();

//        fabrica = new DAOFactory();
//        fabrica.abrirConexao();
//        QuartoDAO dao = fabrica.criarQuartoDAO();
//        //Seta os atributos do quarto para o mesmo do BD
//        dao.buscar(quarto);
//        fabrica.fecharConexao();
        atualizar();
    }

    public void atualizar() {
        limpar();
        jTextFieldidQuarto.setText("" + quarto.getIdQuarto());
        jTextFieldTipo.setText("" + quarto.getTipo().getNome());
        jPanelSituacao.setBackground(quarto.getCorSituacao());
        jPanelSituacao.setBorder(new TitledBorder(quarto.getTxtSituacao()));

        for (Cliente c : quarto.getClientes()) {
            modeloCliente.addElement(c);
        }

        for (Pedido p : quarto.getPedidos()) {
            modeloPedido.addElement(p);
        }
    }

    public void setQuarto(Quarto quarto) {
        limpar();
        jTextFieldidQuarto.setText("" + quarto.getIdQuarto());
        jTextFieldTipo.setText("" + quarto.getTipo().getNome());
        jPanelSituacao.setBackground(quarto.getCorSituacao());
        jPanelSituacao.setBorder(new TitledBorder(quarto.getTxtSituacao()));

        for (Cliente c : quarto.getClientes()) {
            modeloCliente.addElement(c);
        }

        for (Pedido p : quarto.getPedidos()) {
            modeloPedido.addElement(p);
        }

    }

    public void limpar() {
        jTextFieldidQuarto.setText("");
        jTextFieldTipo.setText("");
        jPanelSituacao.setBackground(Color.WHITE);
        jPanelSituacao.setBorder(new TitledBorder(""));
        modeloCliente.clear();
        modeloPedido.clear();
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
        jTextFieldidQuarto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldTipo = new javax.swing.JTextField();
        jPanelSituacao = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListCliente = new javax.swing.JList<Cliente>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListPedido = new javax.swing.JList<Pedido>();
        jButtonEntrada = new javax.swing.JButton();
        jButtonReserva = new javax.swing.JButton();
        jButtonFecharConta = new javax.swing.JButton();
        jButtonFazerPedido = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButtonAgendarLimpeza1 = new javax.swing.JButton();
        jButtonAgendarLimpeza = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("idQuarto:");

        jTextFieldidQuarto.setEnabled(false);

        jLabel2.setText("Tipo:");

        jTextFieldTipo.setEnabled(false);

        jPanelSituacao.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout jPanelSituacaoLayout = new javax.swing.GroupLayout(jPanelSituacao);
        jPanelSituacao.setLayout(jPanelSituacaoLayout);
        jPanelSituacaoLayout.setHorizontalGroup(
            jPanelSituacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        jPanelSituacaoLayout.setVerticalGroup(
            jPanelSituacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jListCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Clientes"));
        jListCliente.setModel(new DefaultListModel<Cliente>());
        jScrollPane1.setViewportView(jListCliente);

        jListPedido.setBorder(javax.swing.BorderFactory.createTitledBorder("Pedidos"));
        jListPedido.setModel(new DefaultListModel<Pedido>());
        jScrollPane3.setViewportView(jListPedido);

        jButtonEntrada.setText("Entrada de H??spedes");
        jButtonEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntradaActionPerformed(evt);
            }
        });

        jButtonReserva.setText("Reserva");

        jButtonFecharConta.setText("Fechar Conta");
        jButtonFecharConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharContaActionPerformed(evt);
            }
        });

        jButtonFazerPedido.setText("Fazer Pedido");
        jButtonFazerPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFazerPedidoActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Limpeza"));

        jButtonAgendarLimpeza1.setText("Limpeza Efetuada");
        jButtonAgendarLimpeza1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgendarLimpeza1ActionPerformed(evt);
            }
        });

        jButtonAgendarLimpeza.setText("Requisitar Limpeza");
        jButtonAgendarLimpeza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgendarLimpezaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonAgendarLimpeza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAgendarLimpeza1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 2, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAgendarLimpeza)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonAgendarLimpeza1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldidQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addComponent(jPanelSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonFazerPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonReserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonFecharConta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonEntrada, jButtonFazerPedido, jButtonFecharConta, jButtonReserva});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldidQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanelSituacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonEntrada)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonReserva)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonFecharConta)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonFazerPedido)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFazerPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFazerPedidoActionPerformed
        pedido.setVisible(true);
        visaogeral.atualizarQuartos();
        atualizar();
    }//GEN-LAST:event_jButtonFazerPedidoActionPerformed

    private void jButtonEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntradaActionPerformed
        entrada.setVisible(true);
        visaogeral.atualizarQuartos();
        atualizar();
    }//GEN-LAST:event_jButtonEntradaActionPerformed

    private void jButtonFecharContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharContaActionPerformed
        double valor = 0;
        fabrica.abrirConexao();
        QuartoDAO dao = fabrica.criarQuartoDAO();
        PedidoDAO pdao = fabrica.criarPedidoDAO();
        ClienteDAO cdao = fabrica.criarClienteDAO();
        for (int i = 0; i < modeloPedido.getSize(); i++) {
            valor += modeloPedido.getElementAt(i).getValor();
            pdao.tirarPedidodoQuarto(modeloPedido.getElementAt(i));
        }
        
        for (int i = 0; i < modeloCliente.getSize(); i++) {
            cdao.tirarClientedoQuarto(modeloCliente.getElementAt(i));
        }
        
        valor += quarto.getTipo().getPreco_diaria();
        JOptionPane.showMessageDialog(this, "Valor a pagar: " + valor);
        setVisible(false);
        quarto.setSituacao(quarto.DESOCUPADO);
        quarto.limparPedido();
        quarto.limparCliente();
        modeloCliente.clear();
        modeloPedido.clear();
        atualizar();
        quarto.limparPedido();
        
        dao.atualizar(quarto);
        fabrica.fecharConexao();
        visaogeral.atualizarQuartos();
    }//GEN-LAST:event_jButtonFecharContaActionPerformed

    private void jButtonAgendarLimpezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgendarLimpezaActionPerformed
        quarto.setSituacao(quarto.LIMPEZA);
        atualizar();
        fabrica.abrirConexao();
        QuartoDAO dao = fabrica.criarQuartoDAO();
        dao.atualizar(quarto);
        fabrica.fecharConexao();
        visaogeral.atualizarQuartos();
        setVisible(false);
    }//GEN-LAST:event_jButtonAgendarLimpezaActionPerformed

    private void jButtonAgendarLimpeza1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgendarLimpeza1ActionPerformed
        if (quarto.getClientes() != null) {
            if (quarto.getClientes().size() > 0) {
                quarto.setSituacao(quarto.OCUPADO);
                atualizar();
            } else {
                quarto.setSituacao(quarto.DESOCUPADO);
                atualizar();
            }
            fabrica.abrirConexao();
            QuartoDAO dao = fabrica.criarQuartoDAO();
            dao.atualizar(quarto);
            fabrica.fecharConexao();
            visaogeral.atualizarQuartos();
        }
        setVisible(false);
    }//GEN-LAST:event_jButtonAgendarLimpeza1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgendarLimpeza;
    private javax.swing.JButton jButtonAgendarLimpeza1;
    private javax.swing.JButton jButtonEntrada;
    private javax.swing.JButton jButtonFazerPedido;
    private javax.swing.JButton jButtonFecharConta;
    private javax.swing.JButton jButtonReserva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<Cliente> jListCliente;
    private javax.swing.JList<Pedido> jListPedido;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelSituacao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextFieldTipo;
    private javax.swing.JTextField jTextFieldidQuarto;
    // End of variables declaration//GEN-END:variables
}
