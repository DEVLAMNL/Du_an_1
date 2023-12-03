/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import models.ChatLieu;
import models.KichThuoc;
import models.MauSac;
import models.SanPham;
import models.SanPhamChiTiet;
import repository.ChatLieuRepository;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import repository.KichThuocRepository;
import repository.MauSacRepository;
import repository.SanPhamChiTietRepository;
import repository.SanPhamRepository;

/**
 *
 * @author admin
 */
public class viewQuanLySanPham extends javax.swing.JFrame {

    private MauSacRepository mauSacRepository = new MauSacRepository();
    private ChatLieuRepository chatLieuRepository = new ChatLieuRepository();
    private KichThuocRepository kichThuocRepository = new KichThuocRepository();
    private SanPhamRepository sanPhamRepository = new SanPhamRepository();
    private SanPhamChiTietRepository sanPhamChiTietRepository = new SanPhamChiTietRepository();

    private DefaultComboBoxModel<String> defaultCBBKichThuoc = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<String> defaultCBBChatLieu = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<String> defaultCBBMauSac = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<String> defaultCBBSanPham = new DefaultComboBoxModel<>();

    private ArrayList<KichThuoc> listcbbKichThuoc = kichThuocRepository.getAllKichThuoc();
    private ArrayList<ChatLieu> listcbbChatLieu = chatLieuRepository.getAllChatLieu();
    private ArrayList<MauSac> listcbbMauSac = mauSacRepository.getAllMauSac();
    private ArrayList<SanPham> listcbbSanPham = sanPhamRepository.getAllSanPham();

    /**
     * Creates new form QuanLySanPham
     */
    public viewQuanLySanPham() {
        initComponents();
        //LoadCBB
        loadCBBChatLieu();
        loadCBBMauSac();
        loadCBBKichThuoc();
        loadCBBSanPham();

        //Load table
        
        LoadTableSanPham();
        loadTableQLSPCT();
        this.setLocationRelativeTo(this);
    }

    //ComboBoxChatLieu
    private void loadCBBChatLieu() {
        cbbChatLieuSP.setModel(defaultCBBChatLieu);
        for (int i = 0; i < listcbbChatLieu.size(); i++) {
            defaultCBBChatLieu.addElement(listcbbChatLieu.get(i).getTenChatLieu());
        }
    }

    private void loadCBBMauSac() {
        cbbMauSacSP.setModel(defaultCBBMauSac);
        for (int i = 0; i < listcbbMauSac.size(); i++) {
            defaultCBBMauSac.addElement(listcbbMauSac.get(i).getTenMauSac());
        }
    }

    private void loadCBBKichThuoc() {
        cbbKichThuocSP.setModel(defaultCBBKichThuoc);
        for (int i = 0; i < listcbbKichThuoc.size(); i++) {
            defaultCBBKichThuoc.addElement(listcbbKichThuoc.get(i).getTenKichThuoc());
        }
    }

    private void loadCBBSanPham() {
        cbbTenSP.setModel(defaultCBBSanPham);
        for (int i = 0; i < listcbbSanPham.size(); i++) {
            defaultCBBSanPham.addElement(listcbbSanPham.get(i).getTenSanPham());
        }
    }

    //Sản phẩm
    public void LoadTableSanPham() {
        DefaultTableModel dtm = (DefaultTableModel) tblSanPham.getModel();
        dtm.setRowCount(0);
        for (SanPham ms : sanPhamRepository.getAllSanPham()) {
            dtm.addRow(new Object[]{
                ms.getMaSanPham(), ms.getTenSanPham(),});
        }
    }

    public void LoadTableSanPham(List<SanPham> listSP) {
        DefaultTableModel dtm = (DefaultTableModel) tblSanPham.getModel();
        dtm.setRowCount(0);
        for (SanPham ms : listSP) {
            dtm.addRow(new Object[]{
                ms.getMaSanPham(), ms.getTenSanPham()});
        }
    }

    

    public void searchSanPham() {
        String searchCode = txtTimKiemSanPham.getText();
        List<SanPham> listSP = sanPhamRepository.searchSanPham(searchCode);
        LoadTableSanPham(listSP);
        if (searchCode.equals("")) {
            LoadTableSanPham();
        }
    }

    

    //Chi tiết sản phẩm
    private SanPhamChiTiet getDataChiTietSanPham() {
        try {
            float giaBan = Float.parseFloat(txtGiaBanSP.getText());
            int soLuong = Integer.parseInt(txtSoLuongSP.getText());
            KichThuoc kichThuoc = listcbbKichThuoc.get(cbbKichThuocSP.getSelectedIndex());
            ChatLieu chatLieu = listcbbChatLieu.get(cbbChatLieuSP.getSelectedIndex());
            MauSac mauSac = listcbbMauSac.get(cbbMauSacSP.getSelectedIndex());
            SanPham sanPham = listcbbSanPham.get(cbbTenSP.getSelectedIndex());

            SanPhamChiTiet spct = new SanPhamChiTiet(ICONIFIED, sanPham, kichThuoc, chatLieu, mauSac, soLuong, giaBan);
            return spct;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }

//========================================================================================================//
    public void LoadTableSanPhamChiTiet() {
        int rowSP = tblSanPham.getSelectedRow();
        DefaultTableModel dtm = (DefaultTableModel) tblCTSP.getModel();
        dtm.setRowCount(0);
        List<SanPhamChiTiet> listCtsp = sanPhamChiTietRepository.getAllSanPhamCT(tblSanPham.getValueAt(rowSP, 0).toString());

        for (SanPhamChiTiet spct : listCtsp) {
            int duplicateRowIndex = findDuplicateRowSPCT(dtm, spct);
            if (duplicateRowIndex != -1) {
                int currentSoLuong = (int) dtm.getValueAt(duplicateRowIndex, 5);
                int newSoLuong = currentSoLuong + spct.getSoLuong();
                dtm.setValueAt(newSoLuong, duplicateRowIndex, 5);
            } else {
                dtm.addRow(new Object[]{
                    spct.getIdSanPhamChiTiet(),
                    spct.getSanPham().getTenSanPham(),
                    spct.getKichThuoc().getTenKichThuoc(),
                    spct.getMauSac().getTenMauSac(),
                    spct.getChatLieu().getTenChatLieu(),
                    spct.getGiaBan(),
                    spct.getSoLuong()
                });
            }
        }
    }

// Phương thức tìm kiếm sản phẩm trùng trong bảng
    private int findDuplicateRowSPCT(DefaultTableModel dtm, SanPhamChiTiet spct) {
        for (int i = 0; i < dtm.getRowCount(); i++) {
            String tenSanPham = (String) dtm.getValueAt(i, 1);
            String tenKichThuoc = (String) dtm.getValueAt(i, 2);
            String tenChatLieu = (String) dtm.getValueAt(i, 3);
            String tenMauSac = (String) dtm.getValueAt(i, 4);
            float giaBan = (float) dtm.getValueAt(i, 5);
            
            // Kiểm tra null trước khi sử dụng equals
            if (tenSanPham != null
                    && tenSanPham.equals(spct.getSanPham().getTenSanPham())
                    && tenKichThuoc != null
                    && tenKichThuoc.equals(spct.getKichThuoc().getTenKichThuoc())
                    && tenChatLieu != null
                    && tenChatLieu.equals(spct.getChatLieu().getTenChatLieu())
                    && tenMauSac != null
                    && tenMauSac.equals(spct.getMauSac().getTenMauSac())
                    && giaBan == spct.getGiaBan()) {
                return i;
            }
        }
        return -1;
    }
//========================================================================================================//

    public void LoadTableSanPhamChiTiet(List<SanPhamChiTiet> listSPCT) {
        DefaultTableModel dtm = (DefaultTableModel) tblCTSP.getModel();
        dtm.setRowCount(0);

        for (SanPhamChiTiet sp : listSPCT) {
            int duplicateRowIndex = findDuplicateRowSPCTforSearch(dtm, sp);

            if (duplicateRowIndex != -1) {  
                int currentSoLuong = (int) dtm.getValueAt(duplicateRowIndex, 5);
                int newSoLuong = currentSoLuong + sp.getSoLuong();
                dtm.setValueAt(newSoLuong, duplicateRowIndex, 5);
            } else {
                dtm.addRow(new Object[]{
                    sp.getIdSanPhamChiTiet(),
                    sp.getSanPham().getTenSanPham(),
                    sp.getKichThuoc().getTenKichThuoc(),
                    sp.getChatLieu().getTenChatLieu(),
                    sp.getMauSac().getTenMauSac(),
                    sp.getSoLuong(),
                    sp.getGiaBan()
                });
            }
        }
    }

    private int findDuplicateRowSPCTforSearch(DefaultTableModel dtm, SanPhamChiTiet spct) {
        for (int i = 0; i < dtm.getRowCount(); i++) {
            String tenSanPham = (String) dtm.getValueAt(i, 1);
            String tenKichThuoc = (String) dtm.getValueAt(i, 2);
            String tenMauSac = (String) dtm.getValueAt(i, 3);
            String tenChatLieu = (String) dtm.getValueAt(i, 4);
            float giaBan = (float) dtm.getValueAt(i, 6);

            if (tenSanPham.equals(spct.getSanPham().getTenSanPham())
                    && tenKichThuoc.equals(spct.getKichThuoc().getTenKichThuoc())
                    && tenMauSac.equals(spct.getMauSac().getTenMauSac())
                    && tenChatLieu.equals(spct.getChatLieu().getTenChatLieu())
                    && giaBan == spct.getGiaBan()) {
                return i; // Trả về chỉ số hàng nếu tìm thấy hàng trùng lặp
            }
        }
        return -1; // Trả về -1 nếu không tìm thấy hàng trùng lặp
    }
//========================================================================================================//

    public void loadTableQLSPCT() {
        DefaultTableModel dtm = (DefaultTableModel) tblQuanLyCTSP.getModel();
        dtm.setRowCount(0);
        List<SanPhamChiTiet> allSPCT = sanPhamChiTietRepository.getAllQLSanPhamCT();

        for (SanPhamChiTiet spct : allSPCT) {
            int duplicateRowIndex = findDuplicateRowQLSPCT(dtm, spct);

            if (duplicateRowIndex != -1) {
                int currentSoLuong = (int) dtm.getValueAt(duplicateRowIndex, 5);
                int newSoLuong = currentSoLuong + spct.getSoLuong();
                dtm.setValueAt(newSoLuong, duplicateRowIndex, 5);
            } else {
                dtm.addRow(new Object[]{
                    spct.getIdSanPhamChiTiet(),
                    spct.getSanPham().getTenSanPham(),
                    spct.getKichThuoc().getTenKichThuoc(),
                    spct.getChatLieu().getTenChatLieu(),
                    spct.getMauSac().getTenMauSac(),
                    spct.getSoLuong(),
                    spct.getGiaBan()
                });
            }
        }
    }

    private int findDuplicateRowQLSPCT(DefaultTableModel dtm, SanPhamChiTiet spct) {
        for (int i = 0; i < dtm.getRowCount(); i++) {
            String tenSanPham = (String) dtm.getValueAt(i, 1);
            String tenKichThuoc = (String) dtm.getValueAt(i, 2);
            String tenChatLieu = (String) dtm.getValueAt(i, 3);
            String tenMauSac = (String) dtm.getValueAt(i, 4);
            float giaBan = (float) dtm.getValueAt(i, 6);
            if (tenSanPham.equals(spct.getSanPham().getTenSanPham())
                    && tenKichThuoc.equals(spct.getKichThuoc().getTenKichThuoc())
                    && tenChatLieu.equals(spct.getChatLieu().getTenChatLieu())
                    && tenMauSac.equals(spct.getMauSac().getTenMauSac())
                    && giaBan == spct.getGiaBan()) {
                return i;
            }
        }
        return -1;
    }
//========================================================================================================//

    public void loadTableQLSPCT(List<SanPhamChiTiet> listSPCT) {
        DefaultTableModel dtm = (DefaultTableModel) tblQuanLyCTSP.getModel();
        dtm.setRowCount(0);
        for (SanPhamChiTiet spct : listSPCT) {
            int duplicateRowIndex = findDuplicateRowQLSPCTforSearch(dtm, spct);

            if (duplicateRowIndex != -1) {
                int currentSoLuong = (int) dtm.getValueAt(duplicateRowIndex, 5);
                int newSoLuong = currentSoLuong + spct.getSoLuong();
                dtm.setValueAt(newSoLuong, duplicateRowIndex, 5);
            } else {
                dtm.addRow(new Object[]{
                    spct.getIdSanPhamChiTiet(),
                    spct.getSanPham().getTenSanPham(),
                    spct.getKichThuoc().getTenKichThuoc(),
                    spct.getChatLieu().getTenChatLieu(),
                    spct.getMauSac().getTenMauSac(),
                    spct.getSoLuong(),
                    spct.getGiaBan()
                });
            }
        }
    }

    private int findDuplicateRowQLSPCTforSearch(DefaultTableModel dtm, SanPhamChiTiet spct) {
        for (int i = 0; i < dtm.getRowCount(); i++) {
            String tenSanPham = (String) dtm.getValueAt(i, 1);
            String tenKichThuoc = (String) dtm.getValueAt(i, 2);
            String tenChatLieu = (String) dtm.getValueAt(i, 3);
            String tenMauSac = (String) dtm.getValueAt(i, 4);
            float giaBan = (float) dtm.getValueAt(i, 6);
            if (tenSanPham.equals(spct.getSanPham().getTenSanPham())
                    && tenKichThuoc.equals(spct.getKichThuoc().getTenKichThuoc())
                    && tenChatLieu.equals(spct.getChatLieu().getTenChatLieu())
                    && tenMauSac.equals(spct.getMauSac().getTenMauSac())
                    && giaBan == spct.getGiaBan()) {
                return i;
            }
        }
        return -1;
    }
//========================================================================================================//

    public void searchSanPhamChiTiet() {
        String searchCode = txtTimKiemCTSP.getText();
        List<SanPhamChiTiet> listSPCT = sanPhamChiTietRepository.searchSanPhamChiTiet(searchCode);
        LoadTableSanPhamChiTiet(listSPCT);
        if (searchCode.equals("")) {
            LoadTableSanPhamChiTiet();
        }
    }

    public void searchQLSanPhamChiTiet() {
        String searchCode = txtseachQLCTSP.getText();
        List<SanPhamChiTiet> listSPCT = sanPhamChiTietRepository.searchSanPhamChiTiet(searchCode);
        loadTableQLSPCT(listSPCT);
        if (searchCode.equals("")) {
            loadTableQLSPCT();
        }
    }

    public void clearQLSPCT() {
        txtIdQLSPCT.setText("");
        cbbTenSP.setSelectedIndex(0);
        txtSoLuongSP.setText("");
        txtGiaBanSP.setText("");
        cbbKichThuocSP.setSelectedIndex(0);
        cbbChatLieuSP.setSelectedIndex(0);
        cbbMauSacSP.setSelectedIndex(0);
        cbbTenSP.setEnabled(true);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblCTSP = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        txtTimKiemCTSP = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtTimKiemSanPham = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtSoLuongSP = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbbKichThuocSP = new javax.swing.JComboBox<>();
        cbbChatLieuSP = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cbbMauSacSP = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txtGiaBanSP = new javax.swing.JTextField();
        btnThemSP = new javax.swing.JButton();
        btnSuaSP = new javax.swing.JButton();
        btnXoaSP = new javax.swing.JButton();
        btnLamMoiSP = new javax.swing.JButton();
        txtseachQLCTSP = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblQuanLyCTSP = new javax.swing.JTable();
        txtIdQLSPCT = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbbTenSP = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setText("Quản lý sản phẩm");

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblSanPham);
        if (tblSanPham.getColumnModel().getColumnCount() > 0) {
            tblSanPham.getColumnModel().getColumn(0).setResizable(false);
            tblSanPham.getColumnModel().getColumn(1).setResizable(false);
        }

        tblCTSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id ", "Tên sản phẩm", "Kích thước", "Màu sắc", "Chất liệu", "Giá bán", "Số lượng tồn"
            }
        ));
        jScrollPane7.setViewportView(tblCTSP);

        jLabel25.setText("Tìm kiếm");

        txtTimKiemCTSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemCTSPActionPerformed(evt);
            }
        });
        txtTimKiemCTSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemCTSPKeyReleased(evt);
            }
        });

        jLabel26.setText("Tìm kiếm");

        txtTimKiemSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemSanPhamActionPerformed(evt);
            }
        });
        txtTimKiemSanPham.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemSanPhamKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemSanPhamKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(490, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimKiemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimKiemCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addComponent(jScrollPane7)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Quản lý sản phẩm", jPanel6);

        jLabel6.setText("Id sản phẩm chi tiết");

        jLabel8.setText("Số lượng");

        jLabel10.setText("Giá bán");

        jLabel11.setText("Màu sắc");

        cbbKichThuocSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbChatLieuSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel12.setText("Kích thước");

        cbbMauSacSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel14.setText("Chất liệu");

        btnThemSP.setText("Thêm");
        btnThemSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSPActionPerformed(evt);
            }
        });

        btnSuaSP.setText("Sửa");
        btnSuaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaSPActionPerformed(evt);
            }
        });

        btnXoaSP.setText("Xóa");
        btnXoaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSPActionPerformed(evt);
            }
        });

        btnLamMoiSP.setText("Làm mới");
        btnLamMoiSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiSPActionPerformed(evt);
            }
        });

        txtseachQLCTSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtseachQLCTSPKeyReleased(evt);
            }
        });

        jLabel15.setText("Tìm kiếm");

        tblQuanLyCTSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Tên sản phẩm", "Kích thước", "Chất liệu", "Màu sắc", "Số lượng", "Giá bán"
            }
        ));
        tblQuanLyCTSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQuanLyCTSPMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblQuanLyCTSP);

        txtIdQLSPCT.setEnabled(false);

        jLabel7.setText("Tên sản phẩm");

        cbbTenSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("+");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("+");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("+");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("+");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnThemSP)
                        .addGap(18, 18, 18)
                        .addComponent(btnSuaSP)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaSP)
                        .addGap(18, 18, 18)
                        .addComponent(btnLamMoiSP))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbbTenSP, 0, 200, Short.MAX_VALUE)
                            .addComponent(txtIdQLSPCT)
                            .addComponent(txtSoLuongSP)
                            .addComponent(txtGiaBanSP))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(28, 28, 28)
                                .addComponent(cbbChatLieuSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(cbbKichThuocSP, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jButton3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbbMauSacSP, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(txtseachQLCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbKichThuocSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtIdQLSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbChatLieuSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel7)
                    .addComponent(cbbTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel8)
                    .addComponent(txtSoLuongSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbMauSacSP, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtGiaBanSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemSP)
                    .addComponent(btnSuaSP)
                    .addComponent(btnXoaSP)
                    .addComponent(btnLamMoiSP)
                    .addComponent(jLabel15)
                    .addComponent(txtseachQLCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Chi tiết sản phẩm", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemSanPhamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemSanPhamKeyReleased
        searchSanPham();
    }//GEN-LAST:event_txtTimKiemSanPhamKeyReleased

    private void txtTimKiemSanPhamKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemSanPhamKeyPressed

    }//GEN-LAST:event_txtTimKiemSanPhamKeyPressed

    private void txtTimKiemCTSPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemCTSPKeyReleased
        searchSanPhamChiTiet();
    }//GEN-LAST:event_txtTimKiemCTSPKeyReleased

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        LoadTableSanPhamChiTiet();
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void btnLamMoiSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiSPActionPerformed
        clearQLSPCT();
    }//GEN-LAST:event_btnLamMoiSPActionPerformed

    private void btnXoaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSPActionPerformed
        int row = tblQuanLyCTSP.getSelectedRow();
        if (row == -1) {
            return;
        }
        int id = Integer.parseInt(tblQuanLyCTSP.getValueAt(row, 0).toString());
        sanPhamChiTietRepository.deleteSanPhamCT(id);
        loadTableQLSPCT();
        clearQLSPCT();
        LoadTableSanPhamChiTiet();
    }//GEN-LAST:event_btnXoaSPActionPerformed

    private void btnSuaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaSPActionPerformed
        int row = tblQuanLyCTSP.getSelectedRow();
        if (row == -1) {
            return;
        }
        SanPhamChiTiet spct = getDataChiTietSanPham();
        int idSPCT = Integer.parseInt(tblQuanLyCTSP.getValueAt(row, 0).toString());
        sanPhamChiTietRepository.updateSanPhamCT(idSPCT, spct);
        loadTableQLSPCT();
        clearQLSPCT();
        LoadTableSanPhamChiTiet();
    }//GEN-LAST:event_btnSuaSPActionPerformed

    private void btnThemSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSPActionPerformed

        float giaBan = Float.parseFloat(txtGiaBanSP.getText());
        int soLuong = Integer.parseInt(txtSoLuongSP.getText());
        KichThuoc kichThuoc = listcbbKichThuoc.get(cbbKichThuocSP.getSelectedIndex());
        ChatLieu chatLieu = listcbbChatLieu.get(cbbChatLieuSP.getSelectedIndex());
        MauSac mauSac = listcbbMauSac.get(cbbMauSacSP.getSelectedIndex());
        SanPham sanPham = listcbbSanPham.get(cbbTenSP.getSelectedIndex());

        SanPhamChiTiet spct = new SanPhamChiTiet(sanPham, kichThuoc, chatLieu, mauSac, soLuong, giaBan);
        if (spct != null) {
            sanPhamChiTietRepository.insertSanPhamCT(spct);
            loadTableQLSPCT();
        }
        clearQLSPCT();
        LoadTableSanPhamChiTiet();
    }//GEN-LAST:event_btnThemSPActionPerformed

    private void txtTimKiemSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemSanPhamActionPerformed

    private void txtTimKiemCTSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemCTSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemCTSPActionPerformed

    private void txtseachQLCTSPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtseachQLCTSPKeyReleased
        searchQLSanPhamChiTiet();
    }//GEN-LAST:event_txtseachQLCTSPKeyReleased

    private void tblQuanLyCTSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQuanLyCTSPMouseClicked
        int row = tblQuanLyCTSP.getSelectedRow();
        if (row == -1) {
            return;
        }
        txtIdQLSPCT.setText(tblQuanLyCTSP.getValueAt(row, 0).toString());
        cbbTenSP.setSelectedItem(tblQuanLyCTSP.getValueAt(row, 1).toString());
        txtSoLuongSP.setText(tblQuanLyCTSP.getValueAt(row, 5).toString());
        txtGiaBanSP.setText(tblQuanLyCTSP.getValueAt(row, 6).toString());

        cbbKichThuocSP.setSelectedItem(tblQuanLyCTSP.getValueAt(row, 2).toString());
        cbbChatLieuSP.setSelectedItem(tblQuanLyCTSP.getValueAt(row, 3).toString());
        cbbMauSacSP.setSelectedItem(tblQuanLyCTSP.getValueAt(row, 4).toString());
        cbbTenSP.setEnabled(false);
    }//GEN-LAST:event_tblQuanLyCTSPMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        viewKichThuoc vkt = new viewKichThuoc();
        vkt.setVisible(true);
        setLocationRelativeTo(this);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        viewChatLieu vcl = new viewChatLieu();
        vcl.setVisible(true);
        setLocationRelativeTo(this);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        viewMauSac vms = new viewMauSac();
        vms.setVisible(true);
        setLocationRelativeTo(this);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        viewSanPham vsp = new viewSanPham();
        vsp.setVisible(true);
        setLocationRelativeTo(this);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(viewQuanLySanPham.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewQuanLySanPham.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewQuanLySanPham.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewQuanLySanPham.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewQuanLySanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoiSP;
    private javax.swing.JButton btnSuaSP;
    private javax.swing.JButton btnThemSP;
    private javax.swing.JButton btnXoaSP;
    private javax.swing.JComboBox<String> cbbChatLieuSP;
    private javax.swing.JComboBox<String> cbbKichThuocSP;
    private javax.swing.JComboBox<String> cbbMauSacSP;
    private javax.swing.JComboBox<String> cbbTenSP;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblCTSP;
    private javax.swing.JTable tblQuanLyCTSP;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtGiaBanSP;
    private javax.swing.JTextField txtIdQLSPCT;
    private javax.swing.JTextField txtSoLuongSP;
    private javax.swing.JTextField txtTimKiemCTSP;
    private javax.swing.JTextField txtTimKiemSanPham;
    private javax.swing.JTextField txtseachQLCTSP;
    // End of variables declaration//GEN-END:variables
}
