/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.telas;

/**
 *
 * @author Bruno
 */
import java.sql.*;
import br.com.infox.dal.ModuloConexao;
import javax.swing.JOptionPane;

public class TelaUsuario extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form TelaUsuario
     */
    public TelaUsuario() {
        initComponents();
        conexao = ModuloConexao.conector();
    }
    // metodo para consultado usuario no banco de dados

    private void consultar() {
        String sql = "select * from tbusuarios where iduser=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, textUsuId.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                textUsuNome.setText(rs.getString(2));
                textUsuFone.setText(rs.getString(3));
                textUsuLogin.setText(rs.getString(4));
                textUsuSenha.setText(rs.getString(5));
                // a linha abaixo se refere ao combobox
                comboBoxUsuPerfil.setSelectedItem(rs.getString(6));
            } else {
                JOptionPane.showMessageDialog(null, "Usuario não encontrado");

                // as linhas abaixo "limpar" os campos
                textUsuNome.setText(null);
                textUsuFone.setText(null);
                textUsuLogin.setText(null);
                textUsuSenha.setText(null);
                comboBoxUsuPerfil.setSelectedItem(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // metodo para adicionar usuario
    private void adicionar() {
        String sql = "insert into tbusuarios (iduser,usuario,fone,login,senha,perfil) values (?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, textUsuId.getText());
            pst.setString(2, textUsuNome.getText());
            pst.setString(3, textUsuFone.getText());
            pst.setString(4, textUsuLogin.getText());
            pst.setString(5, textUsuSenha.getText());
            pst.setString(6, comboBoxUsuPerfil.getSelectedItem().toString());

            // validaçao dos campos obrigatórios
            if ((textUsuId.getText().isEmpty())|| (textUsuLogin.getText().isEmpty()) || (textUsuNome.getText().isEmpty()) || (textUsuSenha.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
            } else {

                // a linha abaixo atualiza a tabela usuario com os dados do formulario
                // a linha abaixo é para confirmar a criaçao do usuario
                int adicionado = pst.executeUpdate();
                //System.out.println(adicionado);
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "usuario adicionado com sucesso");

                    // as linhas abaixo "limpar" os campos
                    textUsuId.setText(null);
                    textUsuNome.setText(null);
                    textUsuFone.setText(null);
                    textUsuLogin.setText(null);
                    textUsuSenha.setText(null); 
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    // metodo para alterar dados do usuario
        private void alterar(){
            String sql = "update tbusuarios set usuario=?,fone=?,login=?,senha=?,perfil=? where iduser=?";
            try {
                 pst = conexao.prepareStatement(sql);
            pst.setString(1, textUsuNome.getText());
            pst.setString(2, textUsuFone.getText());
            pst.setString(3, textUsuLogin.getText());
            pst.setString(4, textUsuSenha.getText());
            pst.setString(5, comboBoxUsuPerfil.getSelectedItem().toString());
            pst.setString(6,textUsuId.getText());
          
            
            if ((textUsuId.getText().isEmpty())|| (textUsuLogin.getText().isEmpty()) || (textUsuNome.getText().isEmpty()) || (textUsuSenha.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
            } else {

                // a linha abaixo atualiza a tabela usuario com os dados do formulario
                // a linha abaixo é para confirmar a alteraçãp dos dados  do usuario
                int adicionado = pst.executeUpdate();
                //System.out.println(adicionado);
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados do usuario alterados com sucesso");

                    // as linhas abaixo "limpar" os campos
                    textUsuId.setText(null);
                    textUsuNome.setText(null);
                    textUsuFone.setText(null);
                    textUsuLogin.setText(null);
                    textUsuSenha.setText(null); 
                }
            }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
            // metodo para apagar usuario
        private void apagar (){
            // a estrutura abaixo confima a remoção do uusario
            int confirma=JOptionPane.showConfirmDialog(null,"Você realmente deseja excluir esse usuario ?", "Atenção", JOptionPane.YES_NO_OPTION);
            if (confirma == JOptionPane.YES_OPTION) {
                 String sql = "delete from tbusuarios where iduser=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, textUsuId.getText());
                int delete = pst.executeUpdate();
                 if (delete > 0) {
                    JOptionPane.showMessageDialog(null, "Usuario excluido com sucesso");

                    // as linhas abaixo "limpar" os campos
                    textUsuId.setText(null);
                    textUsuNome.setText(null);
                    textUsuFone.setText(null);
                    textUsuLogin.setText(null);
                    textUsuSenha.setText(null); 
                 }
            
            } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, e);
            }
            }    
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textUsuId = new javax.swing.JTextField();
        textUsuNome = new javax.swing.JTextField();
        textUsuLogin = new javax.swing.JTextField();
        textUsuSenha = new javax.swing.JTextField();
        textUsuFone = new javax.swing.JTextField();
        comboBoxUsuPerfil = new javax.swing.JComboBox<>();
        btnUsuCreate = new javax.swing.JButton();
        btnUsuRead = new javax.swing.JButton();
        btnUsuUpdate = new javax.swing.JButton();
        btnUsuDelete = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Usuarios");
        setPreferredSize(new java.awt.Dimension(765, 0));
        setRequestFocusEnabled(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("*Nome");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 95, -1, -1));

        jLabel2.setText("*Id");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 55, -1, -1));

        jLabel3.setText("*Login");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 129, -1, -1));

        jLabel4.setText("*Perfil");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 40, 30));

        jLabel5.setText("*Senha");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 163, -1, -1));

        jLabel6.setText("Fone:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 129, -1, -1));
        getContentPane().add(textUsuId, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 147, -1));
        getContentPane().add(textUsuNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 92, 360, -1));
        getContentPane().add(textUsuLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 126, 147, -1));
        getContentPane().add(textUsuSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 160, 147, -1));
        getContentPane().add(textUsuFone, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 126, 147, -1));

        comboBoxUsuPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "user", "admin" }));
        comboBoxUsuPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxUsuPerfilActionPerformed(evt);
            }
        });
        getContentPane().add(comboBoxUsuPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 160, 147, -1));

        btnUsuCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/create.png"))); // NOI18N
        btnUsuCreate.setToolTipText("Adicionar");
        btnUsuCreate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuCreate.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUsuCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuCreateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUsuCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 200, 60, 86));

        btnUsuRead.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/read.png"))); // NOI18N
        btnUsuRead.setToolTipText("Pesquisar");
        btnUsuRead.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuRead.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUsuRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuReadActionPerformed(evt);
            }
        });
        getContentPane().add(btnUsuRead, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 200, 59, 86));

        btnUsuUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/update.png"))); // NOI18N
        btnUsuUpdate.setToolTipText("Atualizar");
        btnUsuUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuUpdate.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUsuUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUsuUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 200, 60, 86));

        btnUsuDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/delete.png"))); // NOI18N
        btnUsuDelete.setToolTipText("Deletar");
        btnUsuDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuDelete.setPreferredSize(new java.awt.Dimension(60, 60));
        btnUsuDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnUsuDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(441, 200, -1, 86));

        jLabel7.setText("* Campos obrigatorios");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, -1, -1));

        setBounds(0, 0, 821, 517);
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxUsuPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxUsuPerfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxUsuPerfilActionPerformed

    private void btnUsuReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuReadActionPerformed
        // chamar o metodo consultar
        consultar();
    }//GEN-LAST:event_btnUsuReadActionPerformed

    private void btnUsuCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuCreateActionPerformed
        // chama o metodo adicionar
        adicionar();
    }//GEN-LAST:event_btnUsuCreateActionPerformed

    private void btnUsuUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuUpdateActionPerformed
       alterar();
    }//GEN-LAST:event_btnUsuUpdateActionPerformed

    private void btnUsuDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuDeleteActionPerformed
        // chamar o metodo apagar
        apagar();
    }//GEN-LAST:event_btnUsuDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUsuCreate;
    private javax.swing.JButton btnUsuDelete;
    private javax.swing.JButton btnUsuRead;
    private javax.swing.JButton btnUsuUpdate;
    private javax.swing.JComboBox<String> comboBoxUsuPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField textUsuFone;
    private javax.swing.JTextField textUsuId;
    private javax.swing.JTextField textUsuLogin;
    private javax.swing.JTextField textUsuNome;
    private javax.swing.JTextField textUsuSenha;
    // End of variables declaration//GEN-END:variables
}
