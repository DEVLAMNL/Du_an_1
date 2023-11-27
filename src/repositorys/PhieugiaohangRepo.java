/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorys;

import viewmodels.KhachhangViewModel;
import viewmodels.PhieuGiaoHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class PhieugiaohangRepo {

    private static Connection conn = (Connection) Utilcontext.Util.getConnection();

    public ArrayList<PhieuGiaoHang> getAll() {
        ArrayList<PhieuGiaoHang> listPgh = new ArrayList<>();
        String sql = "select pgh.IdPhieuGiao ,kh.IdKhachHang,pgh.MaVanDon ,kh.TenKhachHang,kh.SDT, kh.DiaChi, kh.NgayTao , pgh.TrangThai from  PhieuGiaoHang pgh join  KhachHang kh on pgh.IdKhachHang = kh.IdKhachHang";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                int id = rs.getInt(1);
                int idKh = rs.getInt(2);
                String ma = rs.getString(3);
                String Tenkh = rs.getString(4);
                String sdt = rs.getString(5);
                String DiaChi = rs.getString(6);
                Date NgayTao = rs.getDate(7);
                Boolean Trangthai = rs.getBoolean(8);
                KhachhangViewModel kh = new KhachhangViewModel(idKh, Tenkh, DiaChi, sdt, NgayTao);
                PhieuGiaoHang pgh = new PhieuGiaoHang(id, idKh, 1, ma, kh, true);
                listPgh.add(pgh);
            }
        } catch (Exception e) {
        }
        return listPgh;
    }

//    public String insert(PhieuGiaoHang pgh) {
//        String sql = "INSERT INTO [dbo].[PhieuGiaoHang]\n"
//                + "           ([MaVanDon]\n"
//                + "           ,[TenKhachHang]\n"
//                + "           ,[SDT]\n"
//                + "           ,[DiaChi]\n"
//                + "           ,[TrangThai])\n"
//                + "     VALUES\n"
//                + "           (?,?,?,?,?)";
//        try {
//            PreparedStatement ps = conn.prepareCall(sql);
//            ps.setString(1, pgh.getMaVanDon());
//            ps.setString(2, pgh.getTenkhachhang());
//            ps.setString(3, pgh.getSdt());
//            ps.setString(4, pgh.getDiachi());
//            ps.setBoolean(5, pgh.isTrangthai());
//            ps.execute();
//        } catch (Exception e) {
//        }
//        return null;
//    }
//
//    public void Delete(String Id) {
//        String sql = "delete from PhieuGiaoHang where IdPhieuGiao = ?";
//        try {
//            PreparedStatement ps = conn.prepareCall(sql);
//            ps.setString(1, Id);
//            ps.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public void update(String Id, PhieuGiaoHang pgh) {
//        String sql = "UPDATE [dbo].[PhieuGiaoHang]\n"
//                + "   SET [MaVanDon] = ?\n"
//                + "      ,[TenKhachHang] = ?\n"
//                + "      ,[SDT] = ?\n"
//                + "      ,[DiaChi] = ?\n"
//                + "      ,[TrangThai] = ?\n"
//                + " WHERE IdPhieuGiao = ?";
//        try {
//            PreparedStatement ps = conn.prepareCall(sql);
//            ps.setString(1, pgh.getMaVanDon());
//            ps.setString(2, pgh.getTenkhachhang());
//            ps.setString(3, pgh.getSdt());
//            ps.setString(4, pgh.getDiachi());
//            ps.setBoolean(5, pgh.isTrangthai());
//            ps.setString(6, Id);
//            ps.execute();
//        } catch (Exception e) {
//        }
//    }
//
//    public ArrayList<PhieuGiaoHang> FindByMa(String ma) {
//        ArrayList<PhieuGiaoHang> listpgh = new ArrayList<>();
//        String sql = "SELECT [IdPhieuGiao]\n"
//                + "      ,[MaVanDon]\n"
//                + "      ,[TenKhachHang]\n"
//                + "      ,[SDT]\n"
//                + "      ,[DiaChi]\n"
//                + "      ,[TrangThai]\n"
//                + "  FROM [dbo].[PhieuGiaoHang]"
//                + "WHERE MaVanDon =?";
//        try {
//            PreparedStatement ps = conn.prepareCall(sql);
//            ps.setString(1, ma);
//            ps.execute();
//            ResultSet rs = ps.getResultSet();
//            while (rs.next() == true) {
//                int id = rs.getInt(1);
//                String maPgh = rs.getString(2);
//                String ten = rs.getString(3);
//                String sdt = rs.getString(4);
//                String DiaChi = rs.getString(5);
//                Boolean TrangThai = rs.getBoolean(6);
//                PhieuGiaoHang pgh = new PhieuGiaoHang(id, 0, 0, maPgh, ten, sdt, DiaChi, true);
//                listpgh.add(pgh);
//            }
//        } catch (Exception e) {
//        }
//        return listpgh;
//    }
    public void insert(KhachhangViewModel kh) {
        String sql = "insert into  KhachHang (NgayTao) values (?)";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setDate(1, (java.sql.Date) kh.getNgayTao());
            ps.execute();
        } catch (Exception e) {
        }
    }

    public String insert(KhachhangViewModel kh, PhieuGiaoHang pgh) {
        String sql = "insert into  KhachHang (TenkhachHang,NgayTao) values (?,?)"
                + "insert into PhieuGiaoHang(Trangthai, IdKhachHang) values(?,?)";

        try {
            PreparedStatement ps = conn.prepareCall(sql);
            int index;
            ps.setString(1, kh.getTenkhachhang());
            ps.setDate(2, (java.sql.Date) kh.getNgayTao());
            ps.setBoolean(3, pgh.isTrangthai());
            ps.setInt(4, pgh.getKh().getIdKhachHang());
            index = ps.executeUpdate();
        } catch (Exception e) {
        }
        return null;
    }

    public ArrayList<KhachhangViewModel> getIdKh() {
        ArrayList<KhachhangViewModel> listkh = new ArrayList<>();
        String sql = "select IdKhachHang from KhachHang";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                KhachhangViewModel kh = new KhachhangViewModel();
                kh.setIdKhachHang(rs.getInt(1));
                listkh.add(kh);
            }
        } catch (Exception e) {

        }
        return listkh;
    }

    public void Delete(int idPhieuGiao) {
        String sql = "delete * from PhieuGiaoHang where IdPhieuGiao = ? ";
//                + "delete from KhachHang where idKhachHang =?";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setInt(1, idPhieuGiao);
//            ps.setInt(2, IdKhachHang);
            ps.execute();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        System.out.println(new PhieugiaohangRepo().getIdKh());
    }
}
