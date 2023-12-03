package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.KhachHang;
import models.HangKhachHang;
import service.KhachHangService;

public class KhachHangReponsitory implements KhachHangService {

    @Override
    public void insert(KhachHang b) {
        try {
            Connection conn = (Connection) Utilcontext.Util.getConnection();
            String query = "INSERT INTO KhachHang (MaKhachHang, TenKhachHang, DiaChi,SDT,GioiTinh,IdHangKhachHang) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, b.getMaKhachHang());
            ps.setString(2, b.getTenKhachHang());
            ps.setString(3, b.getDiaChi());
            ps.setString(4, b.getSdt());
            ps.setBoolean(5, b.isGioiTinh());
            Integer idLkh = null;
            if (b.getLoaiKhachHang() != null) {
                idLkh = b.getLoaiKhachHang().getIdHangKhachHang();
            }
            ps.setInt(6, idLkh);
            System.out.println(idLkh);
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            Connection conn = (Connection) Utilcontext.Util.getConnection();
            String query = "DELETE FROM KhachHang WHERE IdKhachHang =?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Override
    public void update(int id, KhachHang b) {
        try {
            Connection conn = (Connection) Utilcontext.Util.getConnection();
            String query = "UPDATE KhachHang SET MaKhachHang=?, TenKhachHang=?, DiaChi= ? , SDT=?, GioiTinh=?, IdHangKhachHang=? WHERE IdKhachHang=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, b.getMaKhachHang());
            ps.setString(2, b.getTenKhachHang());
            ps.setString(4, b.getSdt());
            ps.setBoolean(5, b.isGioiTinh());
            ps.setString(3, b.getDiaChi());
            Integer idLkh = null;
            if (b.getLoaiKhachHang() != null) {
                idLkh = b.getLoaiKhachHang().getIdHangKhachHang();
            }
            ps.setInt(6, idLkh);
            System.out.println(idLkh);
            ps.setInt(7, id);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Override
    public ArrayList<KhachHang> getall() {
    ArrayList<KhachHang> listKH = new ArrayList<>();

    try {
        Connection conn = (Connection) Utilcontext.Util.getConnection();
        String query = "SELECT [IdKhachHang]\n"
                + "      ,[MaKhachHang]\n"
                + "      ,[TenKhachHang]\n"
                + "      ,[GioiTinh]\n"
                + "      ,[DiaChi]\n"
                + "      ,[SDT]\n"
                + "      ,[NgayTao]\n"
                + "      ,HangKhachHang.[TenHangKhachHang]\n"
                + "FROM [dbo].[KhachHang]\n"
                + "JOIN HangKhachHang ON HangKhachHang.IdHangKhachHang = KhachHang.IdHangKhachHang";
        PreparedStatement ps = conn.prepareStatement(query);
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("IdKhachHang");
                String ma = rs.getString("MaKhachHang");
                String ten = rs.getString("TenKhachHang");
                String diaChi = rs.getString("DiaChi");
                String sdt = rs.getString("SDT");
                boolean gioiTinh = rs.getBoolean("GioiTinh");
                String tenHangKhachHang = rs.getString("TenHangKhachHang");

                HangKhachHang lkh = new HangKhachHang(tenHangKhachHang);

                KhachHang kh = new KhachHang();

                kh.setIdKhachHang(id);
                kh.setMaKhachHang(ma);
                kh.setTenKhachHang(ten);
                kh.setDiaChi(diaChi);
                kh.setSdt(sdt);
                kh.setGioiTinh(gioiTinh);
                kh.setLoaiKhachHang(lkh);

                listKH.add(kh);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return listKH;
}


    @Override
    public ArrayList<KhachHang> search(String key) {
        ArrayList<KhachHang> listBan2 = new ArrayList<>();

        try {
            Connection conn = (Connection) Utilcontext.Util.getConnection();
            String query = "SELECT dbo.KhachHang.IdKhachHang, dbo.KhachHang.MaKhachHang, dbo.KhachHang.TenKhachHang, dbo.KhachHang.GioiTinh, dbo.KhachHang.DiaChi, dbo.KhachHang.SDT, dbo.KhachHang.NgayTao, \n"
                    + "                  dbo.HangKhachHang.TenHangKhachHang\n"
                    + "FROM    dbo.KhachHang   LEFT JOIN\n"
                    + "                   dbo.HangKhachHang ON dbo.HangKhachHang.IdHangKhachHang = dbo.KhachHang.IdHangKhachHang"
                    + " where dbo.KhachHang.IdKhachHang like '%'+?+'%'"
                    + " or dbo.KhachHang.MaKhachHang like '%'+?+'%'"
                    + " or dbo.KhachHang.TenKhachHang like '%'+?+'%' "
                    + "or dbo.KhachHang.DiaChi like '%'+?+'%' "
                    + "or dbo.KhachHang.SDT like '%'+?+'%' ";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, key);
            ps.setString(2, key);
            ps.setString(3, key);
            ps.setString(4, key);
            ps.setString(5, key);

            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int idKH = rs.getInt("IdKhachHang");
                String ma = rs.getString("MaKhachHang");
                String ten = rs.getString("TenKhachHang");
                String diaChi = rs.getString("DiaChi");
                String sdt = rs.getString("SDT");
                Boolean gioiTinh = rs.getBoolean("GioiTinh");
                String tenKhachHang = rs.getString("TenHangKhachHang");

                HangKhachHang lkh = new HangKhachHang();
                lkh.setTenHangKhachHang(tenKhachHang);

                KhachHang kh = new KhachHang(idKH, tenKhachHang, tenKhachHang, diaChi, sdt, gioiTinh, lkh);
                listBan2.add(kh);

            }

        } catch (Exception e) {
            e.printStackTrace();

        }

        return listBan2;

    }

    public static void main(String[] args) {
        System.out.println(new KhachHangReponsitory().getall());
    }
}
