package View;

//import viewmodels.HoaDon;
//import viewmodels.Khachhang;
import repositorys.PhieugiaohangRepo;
import services.imp.HoaDon_Service;
import service.IHoaDon_Service;
import service.Ipgh_Service;
import services.imp.Pgh_Service;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import viewmodels.HoaDonViewModel;
import viewmodels.KhachhangViewModel;

public class PhieuGiaoHang extends javax.swing.JFrame {

    private Ipgh_Service Pgh_Service = new Pgh_Service();
//    private ArrayList<Model.PhieuGiaoHang> listPgh = Pgh_Service.getAll();
    private PhieugiaohangRepo pgh = new PhieugiaohangRepo();
    private DefaultComboBoxModel cbbDefault = new DefaultComboBoxModel();
    private DefaultComboBoxModel cbbDefaultKhachhang = new DefaultComboBoxModel();
    private ArrayList<viewmodels.PhieuGiaoHang> listCbbpgh = Pgh_Service.getAll();
    private ArrayList<KhachhangViewModel> GetById;
    private IHoaDon_Service HDsv = new HoaDon_Service();
    private ArrayList<HoaDonViewModel> listHD = HDsv.getAll();

    public PhieuGiaoHang() {
        initComponents();
        LoadTablePgh();
        GetById = pgh.getIdKh();
        loadComboboxKH();
        loadCombobox();
//        LoadTableByMa(listPgh);
        LoadTableHoaDon();
//        loadCbbTinhtrang();
    }

    private void loadCombobox() {
        cbbDefault.removeAllElements();
        cbbDefault.addElement("Đang xác nhận");
        cbbDefault.addElement("Đã Giao");
        cbbTrangthai.setModel(cbbDefault);
//        for (int i = 0; i < 2; i++) {
//            cbbDefault.addElement(listCbbpgh.get(i).isTrangthai() == true ? "Đang xác nhận" : "Đã Giao");
//        }
    }

    private void loadComboboxKH() {
        cbbKhachHang.setModel(cbbDefaultKhachhang);
        for (int i = 0; i < GetById.size(); i++) {
            cbbDefaultKhachhang.addElement(GetById.get(i).getIdKhachHang());
        }
    }

    private void LoadTablePgh() {
        DefaultTableModel dtm = (DefaultTableModel) tblTb.getModel();
        dtm.setRowCount(0);
        for (viewmodels.PhieuGiaoHang pgh : pgh.getAll()) {
            dtm.addRow(new Object[]{
                pgh.getIdPgh(), pgh.getMaVanDon(), pgh.getKh().getTenkhachhang(), pgh.getKh().getSdt(), pgh.getKh().getDiachi(), pgh.getKh().getNgayTao(), pgh.isTrangthai() == true ? "Đang xác nhận" : "Đã Giao"});
        }
//        System.out.println(Pgh_Service.getAll().toString());
    }

    private void LoadTableHoaDon() {
        DefaultTableModel dtm;
        dtm = (DefaultTableModel) tblTb2.getModel();
        dtm.setRowCount(0);
        for (viewmodels.HoaDonViewModel x : HDsv.getAll()) {
            dtm.addRow(new Object[]{
                x.getIdHoaDon(), x.getMaHoaDon(), x.getNgayTao(), x.getTinhTrang()
            });
        }
    }

    private void LoadTableByMa(ArrayList<viewmodels.PhieuGiaoHang> listPgh) {
        DefaultTableModel dtm = (DefaultTableModel) tblTb.getModel();
        dtm.setRowCount(0);
        for (viewmodels.PhieuGiaoHang pgh : listPgh) {
            dtm.addRow(new Object[]{ //                pgh.getIdPgh(), pgh.getMaVanDon(), pgh.getTenkhachhang(), pgh.getSdt(), pgh.getDiachi(), pgh.isTrangthai()
            });
        }
    }

    private viewmodels.PhieuGiaoHang GetData() {
        Random rd = new Random();
        String Ma = "" + rd.nextInt(999999999);
        String Tenkh = txtTenkh.getText();
        String Sdt = txtSdt.getText();
        String DiaChi = txtDiachi.getText();
        String Trangthai = cbbTrangthai.getSelectedItem().toString();
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        int idKH = Integer.valueOf(cbbKhachHang.getSelectedItem().toString());
        KhachhangViewModel kh = new KhachhangViewModel(idKH, Tenkh, DiaChi, Sdt, date);
        viewmodels.PhieuGiaoHang pgh = new viewmodels.PhieuGiaoHang(1, 1, 1, Ma, kh, false);
        System.out.println(pgh.toString());
        return pgh;
    }

    private HoaDonViewModel getDataHd() {
        HoaDonViewModel hd = new HoaDonViewModel();
        Random rd = new Random();
        hd.setMaHoaDon("HD" + rd.nextInt(99999));
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        hd.setNgayTao(date);
        hd.setTinhTrang(true);
        return hd;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTb1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtSdt = new javax.swing.JTextField();
        btnTao = new javax.swing.JButton();
        txtDiachi = new javax.swing.JTextField();
        btnSuaohieu = new javax.swing.JButton();
        cbbTrangthai = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        txtTenkh = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtId = new javax.swing.JLabel();
        btnXoa = new javax.swing.JButton();
        txtTimkiem = new javax.swing.JTextField();
        txtMaVanDon = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblTb = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblTb2 = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        txtNgaytao = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbbKhachHang = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();

        jScrollPane1.setViewportView(jEditorPane1);

        tblTb1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Mã phiếu giao hàng", "Tên phiếu ", "Tên khách hàng", "Số điện thoại", "Địa chỉ", "Trạng thái"
            }
        ));
        tblTb1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTb1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblTb1);
        if (tblTb1.getColumnModel().getColumnCount() > 0) {
            tblTb1.getColumnModel().getColumn(0).setResizable(false);
            tblTb1.getColumnModel().getColumn(2).setHeaderValue("Tên phiếu ");
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delivery notes.png"))); // NOI18N
        jLabel5.setText("Phiếu Giao Hàng");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setFocusCycleRoot(true);

        jLabel6.setText("Mã vận đơn");

        jLabel7.setText("Tên khách hàng");

        jLabel8.setText("Số điện thoại");

        jLabel9.setText("Địa chỉ");

        btnTao.setText("Tạo phiếu");
        btnTao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoActionPerformed(evt);
            }
        });

        btnSuaohieu.setText("Sửa phiếu");
        btnSuaohieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaohieuActionPerformed(evt);
            }
        });

        cbbTrangthai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang chờ xác nhận", "Đang giao" }));
        cbbTrangthai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTrangthaiActionPerformed(evt);
            }
        });

        jButton3.setText("Xuất phiếu(Excel)");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel12.setText("Trạng thái");

        jLabel13.setText("Id");

        txtId.setText("-");

        btnXoa.setText("Xóa phiếu");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        txtTimkiem.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimkiemActionPerformed(evt);
            }
        });
        txtTimkiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimkiemKeyReleased(evt);
            }
        });

        txtMaVanDon.setText("-");

        jButton1.setText("Làm mới");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tblTb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id phiếu giao", "Mã phiếu giao", "Tên khách hàng", "Sdt", "Địa chỉ", "Ngày tạo", "Trạng thái "
            }
        ));
        tblTb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTbMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblTb);

        tblTb2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Mã Hóa Đơn", "Ngày tạo", "Tình trạng"
            }
        ));
        tblTb2.setEnabled(false);
        tblTb2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTb2MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblTb2);
        if (tblTb2.getColumnModel().getColumnCount() > 0) {
            tblTb2.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel14.setText("Ngày tạo");

        txtNgaytao.setText("-");

        jLabel1.setText("IdKhachHang");

        cbbKhachHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
<<<<<<< HEAD
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addGap(39, 39, 39)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSdt, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                    .addComponent(txtTenkh, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                    .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtMaVanDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(161, 161, 161)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel9)
                            .addComponent(jLabel14))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNgaytao)
                                .addGap(166, 166, 166))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(cbbTrangthai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(445, 445, 445)
                                .addComponent(jLabel1))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnTao)
                                .addGap(18, 18, 18)
                                .addComponent(btnSuaohieu)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(btnXoa)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTimkiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiachi)
                            .addComponent(cbbKhachHang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(10, 10, 10))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
=======
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel6))
                                        .addGap(39, 39, 39)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtSdt, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                            .addComponent(txtTenkh, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                            .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtMaVanDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(161, 161, 161)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel14))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtNgaytao)
                                        .addGap(166, 166, 166))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(cbbTrangthai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(445, 445, 445)
                                        .addComponent(jLabel1))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(btnTao)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSuaohieu)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton3)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnXoa)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTimkiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDiachi)
                                    .addComponent(cbbKhachHang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
>>>>>>> 5b54ac0152933e4f0064ab38b0f34ada86e049f3
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtId)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaVanDon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTenkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtNgaytao))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTao)
                            .addComponent(btnSuaohieu)
                            .addComponent(jButton3)
                            .addComponent(btnXoa)
                            .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(53, 53, 53)
<<<<<<< HEAD
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
=======
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
>>>>>>> 5b54ac0152933e4f0064ab38b0f34ada86e049f3
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(cbbTrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
<<<<<<< HEAD
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
=======
                .addContainerGap(70, Short.MAX_VALUE))
>>>>>>> 5b54ac0152933e4f0064ab38b0f34ada86e049f3
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbbTrangthaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTrangthaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbTrangthaiActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnTaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoActionPerformed
//        Model.PhieuGiaoHang PGH = GetData();
//        HoaDon hd = new HoaDon();
//        Random rd = new Random();
//        hd.setMaHoaDon("HD" + rd.nextInt(99999));
//        long millis = System.currentTimeMillis();
//        Date date = new Date(millis);
//        hd.setNgayTao(date);
//        hd.setTinhTrang(true);
//        hd.setIdPhieuGiaoHang(45);
        KhachhangViewModel kh = new KhachhangViewModel();
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        kh.setNgayTao(date);
        System.out.println(date);
        viewmodels.PhieuGiaoHang pghs = GetData();
        pgh.insert(kh, pghs);
//        if (PGH == null) {
//            return;
//        }
//        Pgh_Service.Insert(PGH);
//        pgh.insert(kh);
//        HDsv.insert(hd);
        LoadTablePgh();
//        LoadTableHoaDon();
    }//GEN-LAST:event_btnTaoActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int row = tblTb.getSelectedRow();
        if (row == -1) {
            return;
        }
        int idPhieuGiao = Integer.parseInt(tblTb.getValueAt(row, 0).toString());
        int idKhachHang = Integer.parseInt(pgh.getIdKh().toString());
        System.out.println(idPhieuGiao);
        System.out.println(idKhachHang);
//        int idKhachHang = pgh.getIdKh().toString();
        pgh.Delete(idPhieuGiao);
        LoadTablePgh();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaohieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaohieuActionPerformed
        viewmodels.PhieuGiaoHang pgh = GetData();
        int row = tblTb.getSelectedRow();
        if (row == -1) {
            return;
        }
        String id = tblTb.getValueAt(row, 0).toString();
        System.out.println("" + id);
        Pgh_Service.Update(id, pgh);
        LoadTablePgh();
    }//GEN-LAST:event_btnSuaohieuActionPerformed

    private void txtTimkiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimkiemKeyReleased
        String Keyword = txtTimkiem.getText();
        System.out.println(Keyword);
        ArrayList<viewmodels.PhieuGiaoHang> List = Pgh_Service.findbyMa(Keyword);
        System.out.println(List.toString());
        LoadTableByMa(List);
        if (Keyword.equals("")) {
            LoadTablePgh();
        }
    }//GEN-LAST:event_txtTimkiemKeyReleased

    private void tblTb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTb1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblTb1MouseClicked

    private void tblTb2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTb2MouseClicked
//        int row = tblTb2.getSelectedRow();
//        if (row <= -1) {
//            return;
//        }
    }//GEN-LAST:event_tblTb2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txtId.setText("");
        txtMaVanDon.setText("");
        txtTenkh.setText("");
        txtSdt.setText("");
        txtDiachi.setText("");
        cbbTrangthai.setSelectedIndex(0);
//        tblTb1.getModel().setValueAt(0, 1, 2);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimkiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimkiemActionPerformed

    private void tblTbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTbMouseClicked
        int row = tblTb.getSelectedRow();
        if (row == -1) {
            return;
        }
        txtId.setText(tblTb.getValueAt(row, 0).toString());
        txtMaVanDon.setText(tblTb.getValueAt(row, 1).toString());
        txtTenkh.setText(tblTb.getValueAt(row, 2).toString());
        txtSdt.setText(tblTb.getValueAt(row, 3).toString());
        txtDiachi.setText(tblTb.getValueAt(row, 4).toString());
        txtNgaytao.setText(tblTb.getValueAt(row, 5).toString());
//        cbbTrangthai.setSelectedItem(tblTb.getValueAt(row, 6).toString());
        String Trangthai = tblTb.getValueAt(row, 6).toString();


    }//GEN-LAST:event_tblTbMouseClicked

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
            java.util.logging.Logger.getLogger(PhieuGiaoHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PhieuGiaoHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PhieuGiaoHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PhieuGiaoHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
<<<<<<< HEAD
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
=======
>>>>>>> 5b54ac0152933e4f0064ab38b0f34ada86e049f3

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PhieuGiaoHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSuaohieu;
    private javax.swing.JButton btnTao;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbbKhachHang;
    private javax.swing.JComboBox<String> cbbTrangthai;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblTb;
    private javax.swing.JTable tblTb1;
    private javax.swing.JTable tblTb2;
    private javax.swing.JTextField txtDiachi;
    private javax.swing.JLabel txtId;
    private javax.swing.JLabel txtMaVanDon;
    private javax.swing.JLabel txtNgaytao;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTenkh;
    private javax.swing.JTextField txtTimkiem;
    // End of variables declaration//GEN-END:variables
}
