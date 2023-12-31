/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import View.Mensagens;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Model.*;
import javax.swing.JDialog;

/**
 *
 * @author li058737
 */
public class AdicionarAmigo extends javax.swing.JFrame {

    /**
     * Creates new form adicionaramigo
     */
    private Amigos objetoAmigos;
    private JDialog frame = new JDialog();

    public AdicionarAmigo() {
        initComponents();
        this.objetoAmigos = new Amigos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        btn_voltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        c_nome = new javax.swing.JTextField();
        c_telefone = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_salvar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adicionar Amigo");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        btn_voltar.setBackground(new java.awt.Color(255, 255, 255));
        btn_voltar.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        btn_voltar.setForeground(new java.awt.Color(51, 51, 51));
        btn_voltar.setText("VOLTAR");
        btn_voltar.setBorderPainted(false);
        btn_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_voltarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Adicionar Amigo");
        jLabel1.setFocusable(false);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        c_nome.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        c_nome.setForeground(new java.awt.Color(51, 51, 51));

        c_telefone.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        c_telefone.setForeground(new java.awt.Color(51, 51, 51));

        jLabel2.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Telefone:");

        jLabel3.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nome:");

        btn_salvar.setBackground(new java.awt.Color(51, 255, 51));
        btn_salvar.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        btn_salvar.setForeground(new java.awt.Color(255, 255, 255));
        btn_salvar.setText("SALVAR");
        btn_salvar.setBorderPainted(false);
        btn_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(jSeparator5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(c_telefone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(c_nome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(c_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(c_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        new view.CadastrosAmigos().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_voltarActionPerformed

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed
        try {
            String nome = "";
            String telefone = "";

            if (!this.c_nome.getText().trim().matches("[a-zA-Z\\s]+")) {
                throw new Mensagens("O campo Nome deve conter apenas letras.");
            } else if (this.c_nome.getText().isEmpty()) {
                throw new Mensagens("Por favor, preencha o campo Nome.");
            } else if (this.c_nome.getText().length() < 2) {
                throw new Mensagens("Nome deve conter ao menos 2 caracteres.");
            } else {
                nome = this.c_nome.getText();
            }

            if (!this.c_telefone.getText().trim().matches("[0-9]+")) {
                throw new Mensagens("O campo Telefone deve conter apenas números.");
            } else if (this.c_telefone.getText().isEmpty()) {
                throw new Mensagens("Por favor, preencha o campo Telefone.");
            } else if (this.c_telefone.getText().trim().length() < 0 && this.c_telefone.getText().trim().length() > 13) {
                throw new Mensagens("Número de telefone precisa ser maior que 0 caracteres e menor ou igual a 13.");
            } else {
                telefone = this.c_telefone.getText();
            }

            if (this.objetoAmigos.InsertAmigoDB(nome, telefone)) {
                JOptionPane.showMessageDialog(frame, "Amigo Cadastrado com Sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                this.c_nome.setText("");
                this.c_telefone.setText("");
            }
            System.out.println(this.objetoAmigos.getListaAmigos().toString());

        } catch (Mensagens erro) {
            JOptionPane.showMessageDialog(rootPane, erro.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(rootPane, "Informe um número.", "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(AdicionarAmigo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_salvarActionPerformed

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
            java.util.logging.Logger.getLogger(AdicionarAmigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdicionarAmigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdicionarAmigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdicionarAmigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdicionarAmigo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_salvar;
    private javax.swing.JButton btn_voltar;
    private javax.swing.JTextField c_nome;
    private javax.swing.JTextField c_telefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
