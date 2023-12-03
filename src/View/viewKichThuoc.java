/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.KichThuoc;
import repository.KichThuocRepository;

/**
 *
 * @author admin
 */
public class viewKichThuoc extends javax.swing.JFrame {

    private KichThuocRepository kichThuocRepository = new KichThuocRepository();

    public viewKichThuoc() {
        initComponents();
        LoadTableKichThuoc();
        this.setLocationRelativeTo(this);
    }

    public KichThuoc getDataKichThuoc() {
        try {
            int idKichThuoc = Integer.parseInt(txtIdKichThuoc.getText());
            String tenKichThuoc = txtTenKichThuoc.getText();
            KichThuoc kt = new KichThuoc(idKichThuoc, tenKichThuoc);
            return kt;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void LoadTableKichThuoc() {
        DefaultTableModel dtm = (DefaultTableModel) tblKichThuoc.getModel();
        dtm.setRowCount(0);
        for (KichThuoc kt : kichThuocRepository.getAllKichThuoc()) {
            dtm.addRow(new Object[]{
                kt.getIdKichThuoc(), kt.getTenKichThuoc().trim(),});
        }
    }

    public void LoadTableKichThuoc(List<KichThuoc> listKT) {
        DefaultTableModel dtm = (DefaultTableModel) tblKichThuoc.getModel();
        dtm.setRowCount(0);
        for (KichThuoc kt : listKT) {
            dtm.addRow(new Object[]{
                kt.getIdKichThuoc(), kt.getTenKichThuoc()});
        }
    }

    public void searchKichThuoc() {
        String searchCode = txtSearchKichThuoc.getText();
        List<KichThuoc> listKT = kichThuocRepository.searchKichThuoc(searchCode);
        LoadTableKichThuoc(listKT);
        if (searchCode.equals("")) {
            LoadTableKichThuoc();
        }
    }

    public void clearKichThuoc() {
        txtIdKichThuoc.setText("");
        txtTenKichThuoc.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        txtTenKichThuoc = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtIdKichThuoc = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        btnThemKichThuoc = new javax.swing.JButton();
        btnSuaKichThuoc = new javax.swing.JButton();
        btnLamMoiKichThuoc = new javax.swing.JButton();
        txtSearchKichThuoc = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblKichThuoc = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel22.setText("Id kích thước");

        txtIdKichThuoc.setEnabled(false);

        jLabel23.setText("Tên kích thước");

        btnThemKichThuoc.setText("Thêm");
        btnThemKichThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKichThuocActionPerformed(evt);
            }
        });

        btnSuaKichThuoc.setText("Sửa");
        btnSuaKichThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaKichThuocActionPerformed(evt);
            }
        });

        btnLamMoiKichThuoc.setText("Làm mới");
        btnLamMoiKichThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiKichThuocActionPerformed(evt);
            }
        });

        txtSearchKichThuoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKichThuocKeyReleased(evt);
            }
        });

        jLabel24.setText("Tìm kiếm");

        tblKichThuoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id kích thước", "Tên kích thước"
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
        tblKichThuoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKichThuocMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblKichThuoc);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(18, 18, 18)
                                .addComponent(txtIdKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(89, 89, 89))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(btnThemKichThuoc)
                                .addGap(18, 18, 18)
                                .addComponent(btnSuaKichThuoc)
                                .addGap(18, 18, 18)
                                .addComponent(btnLamMoiKichThuoc)
                                .addGap(99, 99, 99)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel23))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSearchKichThuoc, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(txtTenKichThuoc))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtIdKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(txtTenKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemKichThuoc)
                    .addComponent(btnSuaKichThuoc)
                    .addComponent(btnLamMoiKichThuoc)
                    .addComponent(jLabel24)
                    .addComponent(txtSearchKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemKichThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKichThuocActionPerformed
        String tenKichThuoc = txtTenKichThuoc.getText();
        KichThuoc kt = new KichThuoc(tenKichThuoc);
        if (kt == null) {
            return;
        }
        kichThuocRepository.insertKichThuoc(kt);
        LoadTableKichThuoc();
        clearKichThuoc();
    }//GEN-LAST:event_btnThemKichThuocActionPerformed

    private void btnSuaKichThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaKichThuocActionPerformed
        KichThuoc kt = getDataKichThuoc();
        if (kt == null) {
            return;
        }
        int row = tblKichThuoc.getSelectedRow();
        int id = Integer.parseInt(tblKichThuoc.getValueAt(row, 0).toString());
        kichThuocRepository.updateKichThuoc(id, kt);
        LoadTableKichThuoc();
        clearKichThuoc();
    }//GEN-LAST:event_btnSuaKichThuocActionPerformed

    private void btnLamMoiKichThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiKichThuocActionPerformed
        clearKichThuoc();
    }//GEN-LAST:event_btnLamMoiKichThuocActionPerformed

    private void txtSearchKichThuocKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKichThuocKeyReleased
        searchKichThuoc();
    }//GEN-LAST:event_txtSearchKichThuocKeyReleased

    private void tblKichThuocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKichThuocMouseClicked
        int row = tblKichThuoc.getSelectedRow();
        if (row == -1) {
            return;
        }
        txtIdKichThuoc.setText(tblKichThuoc.getValueAt(row, 0).toString());
        txtTenKichThuoc.setText(tblKichThuoc.getValueAt(row, 1).toString());
    }//GEN-LAST:event_tblKichThuocMouseClicked

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
            java.util.logging.Logger.getLogger(viewKichThuoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewKichThuoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewKichThuoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewKichThuoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewKichThuoc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoiKichThuoc;
    private javax.swing.JButton btnSuaKichThuoc;
    private javax.swing.JButton btnThemKichThuoc;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tblKichThuoc;
    private javax.swing.JTextField txtIdKichThuoc;
    private javax.swing.JTextField txtSearchKichThuoc;
    private javax.swing.JTextField txtTenKichThuoc;
    // End of variables declaration//GEN-END:variables

}
