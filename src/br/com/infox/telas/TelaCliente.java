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
// a linha abaixo importa recursos da biblioteca rs2xml.jer
import net.proteanit.sql.DbUtils;

public class TelaCliente extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form NewJInternalFrame
     */
    public TelaCliente() {
        initComponents();
        conexao = ModuloConexao.conector();
    }

    private void pesquisar_cliente() {
        String sql = "select idcli as Id, nomecli as Nome, endcli as Endereço, fonecli as Fone, emailcli as Email from tbclientes where nomecli like ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtCliPesquisar.getText() + "%");

          rs = pst.executeQuery();
          // a linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela
          tblClientes.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void adicionarCli() {
        String sql = "insert into tbclientes(nomecli,endcli,fonecli,emailcli) values (?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txt_Nome_Cli.getText());
            pst.setString(2, txt_End_Cli.getText());
            pst.setString(3, txt_Tel_Cli.getText());
            pst.setString(4, txt_Ema_Cli.getText());

            // validaçao dos campos obrigatórios
            if ((txt_Nome_Cli.getText().isEmpty()) || (txt_Tel_Cli.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
            } else {

                // a linha abaixo é para confirmar a criaçao do cliente
                int adicionado = pst.executeUpdate();
                //System.out.println(adicionado);
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso");

                    // as linhas abaixo "limpar" os campos
                    txt_Nome_Cli.setText(null);
                    txt_End_Cli.setText(null);
                    txt_Tel_Cli.setText(null);
                    txt_Ema_Cli.setText(null);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void setar_campos(){
        int setar = tblClientes.getSelectedRow();
        txt_Nome_Cli.setText(tblClientes.getModel().getValueAt(setar,1).toString());
        txt_End_Cli.setText(tblClientes.getModel().getValueAt(setar,2).toString());
        txt_Tel_Cli.setText(tblClientes.getModel().getValueAt(setar,3).toString());
        txt_Ema_Cli.setText(tblClientes.getModel().getValueAt(setar,4).toString());
        
        // a linha abaixo desabilita o botao adicionar
            btn_Adicionar.setEnabled(false);
        
        
    }

    private void alterarCli() {

        String sql = "update tbclientes set nomecli=?,endcli=?,fonecli=?,emailcli=? where idcli=?";
        try {
            int setar = tblClientes.getSelectedRow();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txt_Nome_Cli.getText());
            pst.setString(2, txt_End_Cli.getText());
            pst.setString(3, txt_Tel_Cli.getText());
            pst.setString(4, txt_Ema_Cli.getText());
            pst.setString(5, tblClientes.getModel().getValueAt(setar, 0) .toString());
              // validaçao dos campos obrigatórios
            if ((txt_Nome_Cli.getText().isEmpty()) || (txt_Tel_Cli.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
            } else {

                // a linha abaixo é para confirmar a alteração de dados do cliente
                int adicionado = pst.executeUpdate();
                //System.out.println(adicionado);
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso");

                    // as linhas abaixo "limpar" os campos
                    txt_Nome_Cli.setText(null);
                    txt_End_Cli.setText(null);
                    txt_Tel_Cli.setText(null);
                    txt_Ema_Cli.setText(null);
                    btn_Adicionar.setEnabled(true);
                    
                    pesquisar_cliente();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void apagar_cliente (){
    //      
     int confirma=JOptionPane.showConfirmDialog(null,"Você realmente deseja excluir esse Cliente ?", "Atenção", JOptionPane.YES_NO_OPTION);
            if (confirma == JOptionPane.YES_OPTION) {
    String sql = " delete from tbclientes where idcli=? ";
        try {
            int setar = tblClientes.getSelectedRow();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, tblClientes.getModel().getValueAt(setar, 0) .toString());
            int delete = pst.executeUpdate();
                 if (delete > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso");

                    // as linhas abaixo "limpar" os campos
                     txt_Nome_Cli.setText(null);
                    txt_End_Cli.setText(null);
                    txt_Tel_Cli.setText(null);
                    txt_Ema_Cli.setText(null);
                    btn_Adicionar.setEnabled(true);
                    
                  // a linha abaixo atualizar a tabela com os novos dados 
                   pesquisar_cliente();
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

        lbl_Nome_Cli = new javax.swing.JLabel();
        lbl_Ende_Cli = new javax.swing.JLabel();
        lbl_Tele_Cli = new javax.swing.JLabel();
        lbl_Ema_Cli = new javax.swing.JLabel();
        btn_Adicionar = new javax.swing.JButton();
        btn_Alterar = new javax.swing.JButton();
        btn_Remover = new javax.swing.JButton();
        txt_Nome_Cli = new javax.swing.JTextField();
        txt_End_Cli = new javax.swing.JTextField();
        txt_Tel_Cli = new javax.swing.JTextField();
        txt_Ema_Cli = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCliPesquisar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();

        setClosable(true);
        setForeground(java.awt.Color.white);
        setIconifiable(true);
        setTitle("Cliente");
        setToolTipText("");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_Nome_Cli.setText("*Nome");
        getContentPane().add(lbl_Nome_Cli, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 218, -1, -1));

        lbl_Ende_Cli.setText("Endereço");
        getContentPane().add(lbl_Ende_Cli, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 255, -1, -1));

        lbl_Tele_Cli.setText("*Telefone");
        getContentPane().add(lbl_Tele_Cli, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 295, -1, -1));

        lbl_Ema_Cli.setText("E-mail");
        getContentPane().add(lbl_Ema_Cli, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 326, -1, -1));

        btn_Adicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/create.png"))); // NOI18N
        btn_Adicionar.setToolTipText("Adicionar");
        btn_Adicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Adicionar.setPreferredSize(new java.awt.Dimension(60, 60));
        btn_Adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AdicionarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Adicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, -1, 69));

        btn_Alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/update.png"))); // NOI18N
        btn_Alterar.setToolTipText("Alterar");
        btn_Alterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Alterar.setPreferredSize(new java.awt.Dimension(60, 60));
        btn_Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AlterarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Alterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 370, -1, 69));

        btn_Remover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/delete.png"))); // NOI18N
        btn_Remover.setToolTipText("Remover");
        btn_Remover.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Remover.setPreferredSize(new java.awt.Dimension(60, 60));
        btn_Remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RemoverActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Remover, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 370, -1, 69));
        getContentPane().add(txt_Nome_Cli, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 215, 370, -1));
        getContentPane().add(txt_End_Cli, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 249, 370, -1));
        getContentPane().add(txt_Tel_Cli, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 289, 151, -1));
        getContentPane().add(txt_Ema_Cli, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 323, 370, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/pesquisa-de-dados.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(546, 0, -1, -1));

        txtCliPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCliPesquisarKeyReleased(evt);
            }
        });
        getContentPane().add(txtCliPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, -1));

        jLabel7.setText("* Campos obrigatorios");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, -1, -1));

        tblClientes = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int ColIndex){
                return false;
            }
        };
        tblClientes.setBorder(new javax.swing.border.MatteBorder(null));
        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Endereço", "Fone", "Email"
            }
        ));
        tblClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblClientes.setFocusable(false);
        tblClientes.getTableHeader().setReorderingAllowed(false);
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 740, 160));

        setBounds(0, 0, 823, 521);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AdicionarActionPerformed
        // chamando metodo adicionar
        adicionarCli();
    }//GEN-LAST:event_btn_AdicionarActionPerformed

    private void txtCliPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCliPesquisarKeyReleased
        // o evento abaixo é do tipo "enquanto for digitando ele mostrar o resultado"
        pesquisar_cliente();
    }//GEN-LAST:event_txtCliPesquisarKeyReleased

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        // chamando o evento para setar os campos da tabela clicando com o mouse
       setar_campos();
    }//GEN-LAST:event_tblClientesMouseClicked

    private void btn_AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AlterarActionPerformed
        // chamando o metodo update
        alterarCli();
    }//GEN-LAST:event_btn_AlterarActionPerformed

    private void btn_RemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RemoverActionPerformed
        // chamando metodo para exluir cliente
        apagar_cliente();
    }//GEN-LAST:event_btn_RemoverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btn_Adicionar;
    public static javax.swing.JButton btn_Alterar;
    public static javax.swing.JButton btn_Remover;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Ema_Cli;
    private javax.swing.JLabel lbl_Ende_Cli;
    private javax.swing.JLabel lbl_Nome_Cli;
    private javax.swing.JLabel lbl_Tele_Cli;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtCliPesquisar;
    private javax.swing.JTextField txt_Ema_Cli;
    private javax.swing.JTextField txt_End_Cli;
    private javax.swing.JTextField txt_Nome_Cli;
    private javax.swing.JTextField txt_Tel_Cli;
    // End of variables declaration//GEN-END:variables
}
