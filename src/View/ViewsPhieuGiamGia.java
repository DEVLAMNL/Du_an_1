/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.LoaiGiamGia;
import models.MucGiamGia;
import models.PhieuGiamGia;
import services.imp.LoaiGiamGiaServiceImpl;
import services.imp.MucGiamGiaServiceImpl;
import services.imp.PhieuGiamGiaServiceImpl;

/**
 *
 * @author Acer
 */
public class ViewsPhieuGiamGia extends javax.swing.JFrame {

    private DefaultTableModel dtm = new DefaultTableModel();
    private List<PhieuGiamGia> listpgg = new ArrayList<>();
    private List<LoaiGiamGia> listlgg = new ArrayList<>();
    private List<MucGiamGia> listmgg = new ArrayList<>();
    private DefaultComboBoxModel dcbbMuc = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcbbLoai = new DefaultComboBoxModel();
    private PhieuGiamGiaServiceImpl phieuGiamGiaServiceImpl = new PhieuGiamGiaServiceImpl();
    private LoaiGiamGiaServiceImpl loaiGiamGiaServiceImpl = new LoaiGiamGiaServiceImpl();
    private MucGiamGiaServiceImpl mucGiamGiaServiceImpl = new MucGiamGiaServiceImpl();
    /**
     * Creates new form GiaoDien
     */
    public ViewsPhieuGiamGia() {
        initComponents();
        tbGiamGia.setModel(dtm);
        String[] headers = {"Ma Phieu", "Ten Phieu", "Ngay Bat Dau", "Ngay Ket Thuc", "Loai Giam Gia", "Muc Giam Gia", "Trang Thai"};
        dtm.setColumnIdentifiers(headers);
        listpgg = phieuGiamGiaServiceImpl.getAll();
        //cbbMuc
        listmgg = mucGiamGiaServiceImpl.getAll();
        cbbMucGiamGia.setModel(dcbbMuc);
        listmgg.forEach(MucGiamGia -> cbbMucGiamGia.addItem(String.valueOf(MucGiamGia.getGiatri()) + "%"));
        //cbbLoai
        listlgg = loaiGiamGiaServiceImpl.getAll();
        cbbLoaiGiamGia.setModel(dcbbLoai);
        listlgg.forEach(LoaiGiamGia -> cbbLoaiGiamGia.addItem(LoaiGiamGia.getTenLoaiGiamGia()));
        //show table
        showDataTb(listpgg);
    }

    private void showDataTb(List<PhieuGiamGia> lists) {
        dtm.setRowCount(0);
        for (PhieuGiamGia x : lists) {
            dtm.addRow(x.todataRow());
        }
    }

    private void filldata(int i) {
        PhieuGiamGia pgg = listpgg.get(i);
        txtMa.setText(pgg.getMaPhieuGiamGia());
        txtTen.setText(pgg.getTenPhieuGiamGia());
        cbbLoaiGiamGia.setSelectedItem(pgg.getLGG().getTenLoaiGiamGia());
        cbbMucGiamGia.setSelectedItem(String.valueOf(pgg.getMGG().getGiatri() + "%"));
        if (pgg.isTrangThai()) {
            rdbHoatDong.setSelected(true);
        } else {
            rdbNgungHoatDong.setSelected(true);
        }
        DCNgayBatDau.setDate(pgg.getNgayBatDau());
        DCNgayKetThuc.setDate(pgg.getNgayKetThuc());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lbPhieuGiamGia = new javax.swing.JLabel();
        pnGiamGia = new javax.swing.JPanel();
        lbMucGiamGia = new javax.swing.JLabel();
        lbLoaiGiamGia = new javax.swing.JLabel();
        lbNgayBatDau = new javax.swing.JLabel();
        lbNgayKetThuc = new javax.swing.JLabel();
        lbTrangthai = new javax.swing.JLabel();
        rdbHoatDong = new javax.swing.JRadioButton();
        rdbNgungHoatDong = new javax.swing.JRadioButton();
        btnLuu = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        DCNgayBatDau = new com.toedter.calendar.JDateChooser();
        DCNgayKetThuc = new com.toedter.calendar.JDateChooser();
        btnExit = new javax.swing.JButton();
        cbbMucGiamGia = new javax.swing.JComboBox<>();
        cbbLoaiGiamGia = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbGiamGia = new javax.swing.JTable();
        lbTimkiem = new javax.swing.JLabel();
        txtTimkiem = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lbPhieuGiamGia.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbPhieuGiamGia.setText("PHIẾU GIẢM GIÁ");

        pnGiamGia.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh Sách"));

        lbMucGiamGia.setText("Mức giảm giá");

        lbLoaiGiamGia.setText("Loại giảm giá");

        lbNgayBatDau.setText("Ngày bắt đầu");

        lbNgayKetThuc.setText("Ngày kết thúc");

        lbTrangthai.setText("Trạng thái");

        buttonGroup1.add(rdbHoatDong);
        rdbHoatDong.setText("Hoạt động");

        buttonGroup1.add(rdbNgungHoatDong);
        rdbNgungHoatDong.setText("Ngừng hoạt động");

        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnCapNhat.setText("Cập Nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        jLabel1.setText("Tên Phiếu Giảm Giá");

        jLabel2.setText("Mã Phiếu Giảm Giá");

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        cbbMucGiamGia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item" }));

        cbbLoaiGiamGia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout pnGiamGiaLayout = new javax.swing.GroupLayout(pnGiamGia);
        pnGiamGia.setLayout(pnGiamGiaLayout);
        pnGiamGiaLayout.setHorizontalGroup(
            pnGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnGiamGiaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnGiamGiaLayout.createSequentialGroup()
                        .addGroup(pnGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbMucGiamGia)
                            .addComponent(lbLoaiGiamGia)
                            .addComponent(lbNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnGiamGiaLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(pnGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DCNgayBatDau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(DCNgayKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(pnGiamGiaLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(pnGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbLoaiGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbMucGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(pnGiamGiaLayout.createSequentialGroup()
                        .addGroup(pnGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnGiamGiaLayout.createSequentialGroup()
                                .addGroup(pnGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnGiamGiaLayout.createSequentialGroup()
                                        .addComponent(btnCapNhat)
                                        .addGap(30, 30, 30))
                                    .addGroup(pnGiamGiaLayout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(btnLuu)
                                        .addGap(147, 147, 147)))
                                .addComponent(btnXoa))
                            .addGroup(pnGiamGiaLayout.createSequentialGroup()
                                .addComponent(lbTrangthai)
                                .addGap(37, 37, 37)
                                .addComponent(rdbHoatDong, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdbNgungHoatDong)))
                        .addGap(0, 60, Short.MAX_VALUE))
                    .addGroup(pnGiamGiaLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(20, 20, 20)
                        .addComponent(txtMa))
                    .addGroup(pnGiamGiaLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtTen)))
                .addContainerGap())
            .addGroup(pnGiamGiaLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(btnNew)
                .addGap(48, 48, 48)
                .addComponent(btnExit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnGiamGiaLayout.setVerticalGroup(
            pnGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnGiamGiaLayout.createSequentialGroup()
                .addGroup(pnGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnGiamGiaLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel2)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnGiamGiaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(pnGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(pnGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMucGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbMucGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbLoaiGiamGia)
                    .addComponent(cbbLoaiGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(pnGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNgayBatDau)
                    .addComponent(DCNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(pnGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbNgayKetThuc)
                    .addComponent(DCNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(pnGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTrangthai)
                    .addComponent(rdbHoatDong)
                    .addComponent(rdbNgungHoatDong))
                .addGap(23, 23, 23)
                .addGroup(pnGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuu)
                    .addComponent(btnCapNhat)
                    .addComponent(btnXoa))
                .addGap(18, 18, 18)
                .addGroup(pnGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew)
                    .addComponent(btnExit))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh Sách"));

        tbGiamGia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbGiamGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbGiamGiaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbGiamGia);

        lbTimkiem.setText("Tìm kiếm");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTimkiem)
                .addGap(39, 39, 39)
                .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnSearch)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTimkiem)
                    .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(507, 507, 507)
                        .addComponent(lbPhieuGiamGia))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(pnGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(pnGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lbPhieuGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
        String ma = txtMa.getText();
        String ten = txtTen.getText();
        LoaiGiamGia lgg = new LoaiGiamGia(Integer.toString(cbbLoaiGiamGia.getSelectedIndex()));
        MucGiamGia mgg = new MucGiamGia(cbbMucGiamGia.getSelectedIndex());
        boolean hoatDong = rdbHoatDong.isSelected();
        Date ngaybatDau = DCNgayBatDau.getDate();
        Date ngayKetthuc = DCNgayKetThuc.getDate();
        PhieuGiamGia pgg = new PhieuGiamGia(lgg, mgg, ma, ten, ngaybatDau, ngayKetthuc, hoatDong);
        String add = phieuGiamGiaServiceImpl.add(pgg);
        listpgg = phieuGiamGiaServiceImpl.getAll();
        JOptionPane.showMessageDialog(this, add);
        showDataTb(listpgg);
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        // TODO add your handling code here:
        String ma = txtMa.getText();
        String ten = txtTen.getText();
        LoaiGiamGia lgg = new LoaiGiamGia(Integer.toString(cbbLoaiGiamGia.getSelectedIndex()));
        MucGiamGia mgg = new MucGiamGia(cbbMucGiamGia.getSelectedIndex());
        boolean hoatDong = rdbHoatDong.isSelected();
        Date ngaybatDau = DCNgayBatDau.getDate();
        Date ngayKetthuc = DCNgayKetThuc.getDate();
        PhieuGiamGia pgg = new PhieuGiamGia(lgg, mgg, ma, ten, ngaybatDau, ngayKetthuc, hoatDong);
        String update = phieuGiamGiaServiceImpl.update(pgg, ma);
        listpgg = phieuGiamGiaServiceImpl.getAll();
        JOptionPane.showMessageDialog(this, update);
        showDataTb(listpgg);
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        String ma = txtMa.getText();
        String delete = phieuGiamGiaServiceImpl.delete(ma);
        listpgg = phieuGiamGiaServiceImpl.getAll();
        JOptionPane.showMessageDialog(this, delete);
        showDataTb(listpgg);
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        txtMa.setText("");
        txtTen.setText("");
        cbbLoaiGiamGia.setSelectedItem("Giảm theo đơn hàng");
        cbbMucGiamGia.setSelectedIndex(0);
        txtTimkiem.setText("");
        DCNgayBatDau.setCalendar(null);
        DCNgayKetThuc.setCalendar(null);
        buttonGroup1.clearSelection();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String ma = txtTimkiem.getText();
        List<PhieuGiamGia> listgg = phieuGiamGiaServiceImpl.searchBy(listpgg, ma);
        showDataTb(listgg);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tbGiamGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbGiamGiaMouseClicked
        // TODO add your handling code here:
        int row = tbGiamGia.getSelectedRow();
        filldata(row);
    }//GEN-LAST:event_tbGiamGiaMouseClicked

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
       System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

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
            java.util.logging.Logger.getLogger(ViewsPhieuGiamGia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewsPhieuGiamGia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewsPhieuGiamGia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewsPhieuGiamGia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewsPhieuGiamGia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DCNgayBatDau;
    private com.toedter.calendar.JDateChooser DCNgayKetThuc;
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbLoaiGiamGia;
    private javax.swing.JComboBox<String> cbbMucGiamGia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbLoaiGiamGia;
    private javax.swing.JLabel lbMucGiamGia;
    private javax.swing.JLabel lbNgayBatDau;
    private javax.swing.JLabel lbNgayKetThuc;
    private javax.swing.JLabel lbPhieuGiamGia;
    private javax.swing.JLabel lbTimkiem;
    private javax.swing.JLabel lbTrangthai;
    private javax.swing.JPanel pnGiamGia;
    private javax.swing.JRadioButton rdbHoatDong;
    private javax.swing.JRadioButton rdbNgungHoatDong;
    private javax.swing.JTable tbGiamGia;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTimkiem;
    // End of variables declaration//GEN-END:variables
}