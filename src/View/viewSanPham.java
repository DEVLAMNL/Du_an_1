/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package View;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.SanPham;
import repository.SanPhamRepository;

/**
 *
 * @author admin
 */
public class viewSanPham extends javax.swing.JFrame {

    private SanPhamRepository sanPhamRepository = new SanPhamRepository();
    public viewSanPham() {
        initComponents();
        LoadTableQLSPSanPham();
        setLocationRelativeTo(this);
    }

    public void LoadTableQLSPSanPham() {
        DefaultTableModel dtm = (DefaultTableModel) tblQLSP.getModel();
        dtm.setRowCount(0);
        for (SanPham ms : sanPhamRepository.getAllSanPham()) {
            dtm.addRow(new Object[]{
                ms.getMaSanPham(), ms.getTenSanPham(),});
        }
    }

    public void LoadTableQLSanPham(List<SanPham> listSP) {
        DefaultTableModel dtm = (DefaultTableModel) tblQLSP.getModel();
        dtm.setRowCount(0);
        for (SanPham ms : listSP) {
            dtm.addRow(new Object[]{
                ms.getMaSanPham(), ms.getTenSanPham()});
        }
    }

    public SanPham getDataSanPham() {
        try {
            String maSP = txtMaSPP.getText();
            String tenSP = txtTenSPP.getText();
            SanPham sp = new SanPham(maSP, tenSP);
            return sp;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public void searchQLSanPham() {
        String searchCode = jTextField1.getText();
        List<SanPham> listSP = sanPhamRepository.searchSanPham(searchCode);
        LoadTableQLSanPham(listSP);
        if (searchCode.equals("")) {
            LoadTableQLSPSanPham();
        }
    }

    public void clearSanPham() {
        txtMaSPP.setText("");
        txtTenSPP.setText("");
        txtMaSPP.setEnabled(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        txtMaSPP = new javax.swing.JTextField();
        txtTenSPP = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        btnThemKichThuoc1 = new javax.swing.JButton();
        btnSuaKichThuoc1 = new javax.swing.JButton();
        btnLamMoiKichThuoc1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblQLSP = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel27.setText("Tên sản phẩm");

        jLabel28.setText("Mã sản phẩm");

        btnThemKichThuoc1.setText("Thêm");
        btnThemKichThuoc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKichThuoc1ActionPerformed(evt);
            }
        });

        btnSuaKichThuoc1.setText("Sửa");
        btnSuaKichThuoc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaKichThuoc1ActionPerformed(evt);
            }
        });

        btnLamMoiKichThuoc1.setText("Làm mới");
        btnLamMoiKichThuoc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiKichThuoc1ActionPerformed(evt);
            }
        });

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel5.setText("Tìm kiếm");

        tblQLSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
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
        tblQLSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQLSPMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tblQLSP);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addGap(18, 18, 18)
                                .addComponent(txtMaSPP, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnThemKichThuoc1)
                                .addGap(18, 18, 18)
                                .addComponent(btnSuaKichThuoc1)
                                .addGap(18, 18, 18)
                                .addComponent(btnLamMoiKichThuoc1)))
                        .addGap(90, 90, 90)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel27)
                                .addGap(18, 18, 18)
                                .addComponent(txtTenSPP, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txtMaSPP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(txtTenSPP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemKichThuoc1)
                    .addComponent(btnSuaKichThuoc1)
                    .addComponent(btnLamMoiKichThuoc1)
                    .addComponent(jLabel5)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemKichThuoc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKichThuoc1ActionPerformed
        String maSanPham = txtMaSPP.getText();
        String tenSanPham = txtTenSPP.getText();
        SanPham sp = new SanPham(maSanPham, tenSanPham);
        if (sp == null) {
            return;
        }
        sanPhamRepository.insertSanPham(sp);
        LoadTableQLSPSanPham();
        clearSanPham();
    }//GEN-LAST:event_btnThemKichThuoc1ActionPerformed

    private void btnSuaKichThuoc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaKichThuoc1ActionPerformed
        SanPham sp = getDataSanPham();
        if (sp == null) {
            return;
        }
        int row = tblQLSP.getSelectedRow();
        String maSP = tblQLSP.getValueAt(row, 0).toString();
        sanPhamRepository.updateSanPham(maSP, sp);
        LoadTableQLSPSanPham();
        clearSanPham();
    }//GEN-LAST:event_btnSuaKichThuoc1ActionPerformed

    private void btnLamMoiKichThuoc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiKichThuoc1ActionPerformed
        clearSanPham();
    }//GEN-LAST:event_btnLamMoiKichThuoc1ActionPerformed

    private void tblQLSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQLSPMouseClicked
        int row = tblQLSP.getSelectedRow();
        if (row == -1) {
            return;
        }
        txtMaSPP.setText(tblQLSP.getValueAt(row, 0).toString());
        txtTenSPP.setText(tblQLSP.getValueAt(row, 1).toString());
        txtMaSPP.setEnabled(false);
    }//GEN-LAST:event_tblQLSPMouseClicked

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        searchQLSanPham();
    }//GEN-LAST:event_jTextField1KeyReleased

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
            java.util.logging.Logger.getLogger(viewSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewSanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoiKichThuoc1;
    private javax.swing.JButton btnSuaKichThuoc1;
    private javax.swing.JButton btnThemKichThuoc1;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblQLSP;
    private javax.swing.JTextField txtMaSPP;
    private javax.swing.JTextField txtTenSPP;
    // End of variables declaration//GEN-END:variables

}
