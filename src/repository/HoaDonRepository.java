/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import models.HoaDon;
import models.KhachHang;
import models.NhanVien;
import models.PhieuGiaoHang;

/**
 *
 * @author Admin
 */
public class HoaDonRepository {

    private static Connection conn = Utilcontext.Util.getConnection();

    public ArrayList<HoaDon> getAll() {
        ArrayList<HoaDon> listHoaDon = new ArrayList<>();
        String sql = "SELECT [IdHoaDon]\n"
                + "      ,NhanVien.TenNhanVien\n"
                + "      ,KhachHang.TenKhachHang\n"
                + "      ,[MaHoaDon]\n"
                + "      ,[NgayTao]\n"
                + "      ,[TinhTrang]\n"
                + "      ,PhieuGiamGia.TenPhieu\n"
                + "      ,PhieuGiaoHang.MaPhieuGiao\n"
                + "  FROM [dbo].[HoaDon]\n"
                + "  join KhachHang on KhachHang.IdKhachHang = HoaDon.IdKhachHang\n"
                + "  join	PhieuGiamGia on PhieuGiamGia.IdPhieuGiamGia = HoaDon.IdPhieuGiamGia\n"
                + "  join PhieuGiaoHang on PhieuGiaoHang.IdPhieuGiao = HoaDon.IdPhieuGiao\n"
                + "  join NhanVien on NhanVien.IdNhanVien = HoaDon.IdNhanVien";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {

                String maPhieuGiao = rs.getString("MaPhieuGiao");
                String tenKhachHang = rs.getString("TenKhachHang");
                String tenNhanVien = rs.getString("TenNhanVien");
                
                int IdHd = rs.getInt("IdHoaDon");
                String maHoaDon = rs.getString("MaHoaDon");
                Date ngayTao = rs.getDate("NgayTao");
                Boolean trangThai = rs.getBoolean("TinhTrang");

                PhieuGiaoHang pg = new PhieuGiaoHang(maPhieuGiao);
                NhanVien nv = new NhanVien(tenNhanVien);
                KhachHang kh = new KhachHang(tenKhachHang);
                
                HoaDon hd = new HoaDon(IdHd, nv, kh, maHoaDon, ngayTao, trangThai, pg);
                listHoaDon.add(hd);
            }
        } catch (Exception e) {
        }
        return listHoaDon;
    }

    public void insert(HoaDon hd) {
        String sql = "insert into HoaDon( MaHoaDon, NgayTao  , TinhTrang , idPhieuGiao) values( ? , ? , ? , ?)";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, hd.getMaHoaDon());
            ps.setDate(2, (java.sql.Date) hd.getNgayTao());
            ps.setBoolean(3, hd.getTinhTrang());
            ps.setInt(4, hd.getPhieuGiaoHang().getIdPhieuGiao());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(new HoaDonRepository().getAll().toString());
    }
}
