package View;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.KhachHang;
import models.HangKhachHang;
import repository.HangKhachHangReponsitory;
import repository.KhachHangReponsitory;
//import services.imp.LoaiKhachHangService;

public class viewKhachHang extends javax.swing.JFrame {

    private KhachHangReponsitory khRepo = new KhachHangReponsitory();
    private HangKhachHangReponsitory hangKhachHangReponsitory = new HangKhachHangReponsitory();

    public viewKhachHang() {
        initComponents();
        this.loadTable();
        this.loadCombobox();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        btntTimKiem = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachhang = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtma = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtsdt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtten = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        btnThem = new javax.swing.JButton();
        btnClean = new javax.swing.JButton();
        rdoNu = new javax.swing.JRadioButton();
        txtdiachi = new javax.swing.JTextField();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbbLoaikh = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btntTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/HcIQmljj5Or3.gif"))); // NOI18N
        btntTimKiem.setText("Search");
        btntTimKiem.setPreferredSize(new java.awt.Dimension(293, 232));
        btntTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntTimKiemActionPerformed(evt);
            }
        });

        tblKhachhang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "MÃ ", "Tên", "Địa Chỉ ", "SDT", "Giới Tính ", "Hạng Khách Hàng "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachhangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhachhang);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btntTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btntTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(58, 325, 760, 445);

        jLabel8.setText("Thiết Lập Thông Tin Khách Hàng");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(58, 30, 177, 16);

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("ID");

        lblID.setText("---");

        jLabel2.setText("Mã");

        jLabel3.setText("Tên");

        jLabel5.setText("Sđt");

        jLabel4.setText("Địa Chỉ ");

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");
        rdoNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNamActionPerformed(evt);
            }
        });

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/1211.png"))); // NOI18N
        btnThem.setText("Thêm ");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnClean.setText("Clean");
        btnClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");
        rdoNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNuActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/8.png"))); // NOI18N
        btnXoa.setText("Xóa ");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sua.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        jLabel9.setText("Giới Tính ");

        jLabel11.setText("Loại Khách Hàng ");

        cbbLoaikh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(cbbLoaikh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblID)
                                    .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(btnThem)
                        .addGap(37, 37, 37)
                        .addComponent(btnSua)))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnXoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClean))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rdoNam)
                        .addGap(35, 35, 35)
                        .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(202, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblID)
                    .addComponent(jLabel5)
                    .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoNam)
                    .addComponent(rdoNu)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cbbLoaikh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClean, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(58, 64, 750, 227);

        jLabel10.setText("Thông Tin Khách Hàng ");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(58, 303, 123, 16);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblKhachhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachhangMouseClicked
        int row = this.tblKhachhang.getSelectedRow();
        if (row == -1) {
            return;
        }
        String id = this.tblKhachhang.getValueAt(row, 0).toString();
        String ma = this.tblKhachhang.getValueAt(row, 1).toString();
        String ten = this.tblKhachhang.getValueAt(row, 2).toString();
        String sdt = this.tblKhachhang.getValueAt(row, 4).toString();
        String dc = this.tblKhachhang.getValueAt(row, 3).toString();
        String gt = this.tblKhachhang.getValueAt(row, 5).toString();
        HangKhachHang lkh = (HangKhachHang) this.tblKhachhang.getValueAt(row, 6);

        this.lblID.setText(id);
        this.txtten.setText(ten);
        this.txtma.setText(ma);
        this.txtsdt.setText(sdt);
        if (gt.equals("Nam")) {
            this.rdoNam.setSelected(true);
        } else {
            this.rdoNu.setSelected(true);
        }
        this.txtdiachi.setText(dc);


    }//GEN-LAST:event_tblKhachhangMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        KhachHang ban = this.getFormdata();
        if (ban == null) {
            return;
        }
        this.khRepo.insert(ban);
        this.loadTable();
        this.clean();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanActionPerformed
        this.clean();
    }//GEN-LAST:event_btnCleanActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int row = this.tblKhachhang.getSelectedRow();
        if (row == -1) {
            return;
        }
        KhachHang ban = this.getFormdata();
        if (ban == null) {
            return;
        }
        int id = Integer.parseInt(tblKhachhang.getValueAt(row, 0).toString());
        this.khRepo.update(id, ban);
        this.loadTable();
        this.clean();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int row = this.tblKhachhang.getSelectedRow();
        if (row == -1) {
            return;

        }
        int xacNhan = JOptionPane.showConfirmDialog(this, "Xác Nhân Xóa");
        if (xacNhan != JOptionPane.YES_OPTION) {
            return;

        }
        int id = (int) this.tblKhachhang.getValueAt(row, 0);
        this.khRepo.delete(id);
        this.loadTable();
        this.clean();

    }//GEN-LAST:event_btnXoaActionPerformed

    private void rdoNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNuActionPerformed

    private void rdoNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNamActionPerformed

    private void btntTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntTimKiemActionPerformed
        String key = this.txtTimKiem.getText();
        this.loadTable();
    }//GEN-LAST:event_btntTimKiemActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewKhachHang().setVisible(true);
            }
        });
    }

    private void clean() {
        this.lblID.setText("--");
        this.txtten.setText("");
        this.txtma.setText("");
        this.txtdiachi.setText("");
        this.txtsdt.setText("");
        this.rdoNam.setSelected(true);

    }

    private void loadTable() {
        DefaultTableModel dtm = (DefaultTableModel) this.tblKhachhang.getModel();
        dtm.setRowCount(0);
        for (KhachHang kh : khRepo.getall()) {
            dtm.addRow(new Object[]{
                kh.getIdKhachHang(),
                kh.getMaKhachHang(),
                kh.getTenKhachHang(),
                kh.getDiaChi(),
                kh.getSdt(),
                kh.isGioiTinh() == true ? "Nam" : "Nữ",
                kh.getLoaiKhachHang().getTenHangKhachHang()
            });
        }
    }

    private void loadTableforSearch(String key) {
        DefaultTableModel dtm = (DefaultTableModel) this.tblKhachhang.getModel();
        dtm.setRowCount(0);
        for (KhachHang kh : khRepo.search(key)) {
            dtm.addRow(new Object[]{
                kh.getIdKhachHang(),
                kh.getMaKhachHang(),
                kh.getTenKhachHang(),
                kh.getDiaChi(),
                kh.getSdt(),
                kh.isGioiTinh(),
                kh.getLoaiKhachHang().getTenHangKhachHang()
            });
        }

    }

    public void loadCombobox() {
        cbbLoaikh.removeAllItems();
        List<HangKhachHang> lkh = hangKhachHangReponsitory.all();
        for (HangKhachHang loaiKhachHang : lkh) {
            cbbLoaikh.addItem(String.valueOf(loaiKhachHang));
            System.out.println(loaiKhachHang.getIdHangKhachHang());
        }
    }

    private KhachHang getFormdata() {
        String ten = this.txtten.getText();
        String ma = this.txtma.getText();
        String sdt = this.txtsdt.getText();
        boolean gt = this.rdoNam.isSelected() == true ? true : false;
        String diachi = this.txtdiachi.getText();
        HangKhachHang lkh = (HangKhachHang) cbbLoaikh.getSelectedItem();
        KhachHang kh = new KhachHang();
        kh.setMaKhachHang(ma);
        kh.setTenKhachHang(ten);
        kh.setSdt(sdt);
        kh.setDiaChi(diachi);
        kh.setGioiTinh(gt);
        kh.setLoaiKhachHang(lkh);
        return kh;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btntTimKiem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbLoaikh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblID;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblKhachhang;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtdiachi;
    private javax.swing.JTextField txtma;
    private javax.swing.JTextField txtsdt;
    private javax.swing.JTextField txtten;
    // End of variables declaration//GEN-END:variables
}