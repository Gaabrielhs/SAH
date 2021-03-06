/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import classes.Quarto;
import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Gaabrielhs
 */
public class JPanelQuarto extends javax.swing.JPanel {

    private Quarto quarto;
    JDialogEntradaDeHospede entrada;
    JFrameVisaoGeral visaogeral;
    JDialogVisaoQuarto visaoquarto;
    /**
     * Creates new form JPanelQuarto
     */
    public JPanelQuarto(java.awt.Frame parent, Quarto quarto) {
        initComponents();
        Border b = new TitledBorder("" + new Integer("" + quarto.getIdQuarto()));
        this.setBorder(b);
        this.quarto = quarto;
        visaogeral = (JFrameVisaoGeral)parent;
        visaoquarto = new JDialogVisaoQuarto(quarto, parent, true);
        entrada = new JDialogEntradaDeHospede(quarto, parent, true);
        jPanelDentro.setBackground(quarto.getCorSituacao());
        jPanelFora.setBackground(quarto.getTipo().getCor());
    }

//    public JPanelQuarto(int numero) {
//        initComponents();
//        Border b = new TitledBorder("" + numero);
//        this.setBorder(b);
//        jPanelDentro.setBackground(Color.yellow);
//        jPanelFora.setBackground(Color.CYAN);
//    }

    public void setTipo(int numero) {
        this.setBackground(Color.CYAN);
    }
    
    public void attSituacao(){
        jPanelDentro.setBackground(quarto.getCorSituacao());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenuEsq = new javax.swing.JPopupMenu();
        jMenuItemEntrada = new javax.swing.JMenuItem();
        jMenuItemReserva = new javax.swing.JMenuItem();
        jMenuItemFecharConta = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jPanelFora = new javax.swing.JPanel();
        jPanelDentro = new javax.swing.JPanel();

        jMenuItemEntrada.setText("Entrada de H??spede");
        jMenuItemEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEntradaActionPerformed(evt);
            }
        });
        jPopupMenuEsq.add(jMenuItemEntrada);

        jMenuItemReserva.setText("Reserva");
        jMenuItemReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemReservaActionPerformed(evt);
            }
        });
        jPopupMenuEsq.add(jMenuItemReserva);

        jMenuItemFecharConta.setText("Fechar Conta");
        jPopupMenuEsq.add(jMenuItemFecharConta);

        jMenuItem2.setText("Agendar Limpeza");
        jPopupMenuEsq.add(jMenuItem2);

        jMenuItem5.setText("Fazer Pedido");
        jPopupMenuEsq.add(jMenuItem5);

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMaximumSize(new java.awt.Dimension(80, 45));
        setPreferredSize(new java.awt.Dimension(75, 45));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jPanelFora.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanelDentro.setPreferredSize(new java.awt.Dimension(40, 25));

        javax.swing.GroupLayout jPanelDentroLayout = new javax.swing.GroupLayout(jPanelDentro);
        jPanelDentro.setLayout(jPanelDentroLayout);
        jPanelDentroLayout.setHorizontalGroup(
            jPanelDentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );
        jPanelDentroLayout.setVerticalGroup(
            jPanelDentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelForaLayout = new javax.swing.GroupLayout(jPanelFora);
        jPanelFora.setLayout(jPanelForaLayout);
        jPanelForaLayout.setHorizontalGroup(
            jPanelForaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelForaLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jPanelDentro, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanelForaLayout.setVerticalGroup(
            jPanelForaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelForaLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jPanelDentro, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFora, javax.swing.GroupLayout.PREFERRED_SIZE, 45, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if(evt.getButton() == MouseEvent.BUTTON3){
            jPopupMenuEsq.show(evt.getComponent(), evt.getX(), evt.getY());
        }else if(evt.getButton() == MouseEvent.BUTTON1){
            visaoquarto.setVisible(true);
        }
        
    }//GEN-LAST:event_formMouseClicked

    private void jMenuItemEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEntradaActionPerformed
        entrada.setVisible(true);
        visaogeral.atualizarQuartos();
    }//GEN-LAST:event_jMenuItemEntradaActionPerformed

    private void jMenuItemReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemReservaActionPerformed
        
    }//GEN-LAST:event_jMenuItemReservaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItemEntrada;
    private javax.swing.JMenuItem jMenuItemFecharConta;
    private javax.swing.JMenuItem jMenuItemReserva;
    private javax.swing.JPanel jPanelDentro;
    private javax.swing.JPanel jPanelFora;
    private javax.swing.JPopupMenu jPopupMenuEsq;
    // End of variables declaration//GEN-END:variables
}
