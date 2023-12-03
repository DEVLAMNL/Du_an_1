/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.ChatLieu;
import repository.ChatLieuRepository;

/**
 *
 * @author admin
 */
public class viewChatLieu extends javax.swing.JFrame {

    private ChatLieuRepository chatLieuRepository = new ChatLieuRepository();
    
    public viewChatLieu() {
        initComponents();
        LoadTableChatLieu();
        this.setLocationRelativeTo(this);
    }

    public ChatLieu getDataChatLieu() {
        try {
            int idChatLieu = Integer.parseInt(txtIdChatLieu.getText());
            String tenChatLieu = txtTenChatLieu.getText();
            ChatLieu cl = new ChatLieu(idChatLieu, tenChatLieu);
            return cl;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void LoadTableChatLieu() {
        DefaultTableModel dtm = (DefaultTableModel) tblChatLieu.getModel();
        dtm.setRowCount(0);
        for (ChatLieu cl : chatLieuRepository.getAllChatLieu()) {
            dtm.addRow(new Object[]{
                cl.getIdChatLieu(), cl.getTenChatLieu(),});
        }
    }

    public void LoadTableChatLieu(List<ChatLieu> listCL) {
        DefaultTableModel dtm = (DefaultTableModel) tblChatLieu.getModel();
        dtm.setRowCount(0);
        for (ChatLieu cl : listCL) {
            dtm.addRow(new Object[]{
                cl.getIdChatLieu(), cl.getTenChatLieu()});
        }
    }

    public void searchChatLieu() {
        String searchCode = txtSearchChatLieu.getText();
        List<ChatLieu> listCL = chatLieuRepository.searchChatLieu(searchCode);
        LoadTableChatLieu(listCL);
        if (searchCode.equals("")) {
            LoadTableChatLieu();
        }
    }

    public void clearChatLieu() {
        txtIdChatLieu.setText("");
        txtTenChatLieu.setText("");
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        txtTenChatLieu = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtIdChatLieu = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        btnSuaChatLieu = new javax.swing.JButton();
        btnLamMoiChatLieu = new javax.swing.JButton();
        txtSearchChatLieu = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblChatLieu = new javax.swing.JTable();
        btnThemChatLieu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel16.setText("Tên chất liệu");

        txtIdChatLieu.setEnabled(false);

        jLabel17.setText("Id chất liệu");

        btnSuaChatLieu.setText("Sửa");
        btnSuaChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaChatLieuActionPerformed(evt);
            }
        });

        btnLamMoiChatLieu.setText("Làm mới");
        btnLamMoiChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiChatLieuActionPerformed(evt);
            }
        });

        txtSearchChatLieu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchChatLieuKeyReleased(evt);
            }
        });

        jLabel18.setText("Tìm kiếm");

        tblChatLieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id chất liệu", "Tên chất liệu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblChatLieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChatLieuMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblChatLieu);

        btnThemChatLieu.setText("Thêm");
        btnThemChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemChatLieuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(18, 18, 18)
                                .addComponent(txtIdChatLieu))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnThemChatLieu)
                                .addGap(18, 18, 18)
                                .addComponent(btnSuaChatLieu)
                                .addGap(18, 18, 18)
                                .addComponent(btnLamMoiChatLieu)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel18))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSearchChatLieu, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(txtTenChatLieu))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIdChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTenChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)))
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSuaChatLieu)
                    .addComponent(btnLamMoiChatLieu)
                    .addComponent(jLabel18)
                    .addComponent(txtSearchChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemChatLieu))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemChatLieuActionPerformed
        String tenChatLieu = txtTenChatLieu.getText();
        ChatLieu cl = new ChatLieu(tenChatLieu);
        if (cl == null) {
            return;
        }
        chatLieuRepository.insertChatLieu(cl);
        LoadTableChatLieu();
        clearChatLieu();
    }//GEN-LAST:event_btnThemChatLieuActionPerformed

    private void btnSuaChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaChatLieuActionPerformed
        ChatLieu cl = getDataChatLieu();
        if (cl == null) {
            return;
        }
        int row = tblChatLieu.getSelectedRow();
        int id = Integer.parseInt(tblChatLieu.getValueAt(row, 0).toString());
        chatLieuRepository.updateChatLieu(id, cl);
        LoadTableChatLieu();
        clearChatLieu();
    }//GEN-LAST:event_btnSuaChatLieuActionPerformed

    private void btnLamMoiChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiChatLieuActionPerformed
        clearChatLieu();
    }//GEN-LAST:event_btnLamMoiChatLieuActionPerformed

    private void txtSearchChatLieuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchChatLieuKeyReleased
        searchChatLieu();
    }//GEN-LAST:event_txtSearchChatLieuKeyReleased

    private void tblChatLieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChatLieuMouseClicked
        int row = tblChatLieu.getSelectedRow();
        if (row == -1) {
            return;
        }
        txtIdChatLieu.setText(tblChatLieu.getValueAt(row, 0).toString());
        txtTenChatLieu.setText(tblChatLieu.getValueAt(row, 1).toString());
    }//GEN-LAST:event_tblChatLieuMouseClicked

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
            java.util.logging.Logger.getLogger(viewChatLieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewChatLieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewChatLieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewChatLieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewChatLieu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoiChatLieu;
    private javax.swing.JButton btnSuaChatLieu;
    private javax.swing.JButton btnThemChatLieu;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblChatLieu;
    private javax.swing.JTextField txtIdChatLieu;
    private javax.swing.JTextField txtSearchChatLieu;
    private javax.swing.JTextField txtTenChatLieu;
    // End of variables declaration//GEN-END:variables
}
