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
import service.HoaDonService;

/**
 *
 * @author Admin
 */
public class HoaDonRepository implements HoaDonService {

    private static Connection conn = Utilcontext.Util.getConnection();

    @Override
    public ArrayList<HoaDon> getAllHD() {
        ArrayList<HoaDon> listHoaDon = new ArrayList<>();
        String sql = "SELECT  IdHoaDon,\n"
                + "		NhanVien.TenNhanVien,\n"
                + "        HoaDon.NgayTao,\n"
                + "        TinhTrang\n"
                + "FROM [dbo].[HoaDon]\n"
                + "join NhanVien on NhanVien.IdNhanVien = HoaDon.IdNhanVien\n"
                + "where TinhTrang = 0";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {

                String tennv = rs.getString("TenNhanVien");
                NhanVien nv = new NhanVien(tennv);

                int idHD = rs.getInt("IdHoaDon");
                Date ngayTao = rs.getDate("NgayTao");
                Boolean trangThai = rs.getBoolean("TinhTrang");

                HoaDon hd = new HoaDon(idHD, nv, ngayTao, trangThai);
                listHoaDon.add(hd);
            }
        } catch (Exception e) {
        }
        return listHoaDon;
    }

    public ArrayList<HoaDon> getHD() {
        ArrayList<HoaDon> ListHoaDon = new ArrayList<>();
        String sql = "select  hd.IdHoaDon , hd.MaHoaDon, hd.NgayTao , nv.TenNhanVien,hd.TinhTrang from HoaDon hd join NhanVien nv on hd.IdNhanVien = nv.IdNhanVien";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                int idhoadon = rs.getInt("IdHoaDon");
                String mahoadon = rs.getString("MaHoaDon");
                Date ngaytao = rs.getDate("NgayTao");
                String tennhanvien = rs.getString("TenNhanVien");
                Boolean tinhtrang = rs.getBoolean("TinhTrang");
                NhanVien nhanVien = new NhanVien(tennhanvien);
                PhieuGiaoHang phieuGiaoHang = new PhieuGiaoHang();
                KhachHang khachHang = new KhachHang();
                HoaDon hd = new HoaDon(idhoadon, nhanVien, khachHang, mahoadon, ngaytao, tinhtrang, phieuGiaoHang);
                ListHoaDon.add(hd);
            }
        } catch (Exception e) {
        }
        return ListHoaDon;
    }

    @Override
    public void insert(HoaDon hd) {
        String sql = "INSERT INTO [dbo].[HoaDon]\n"
                + "           ([IdNhanVien])\n"
                + "     VALUES\n"
                + "           (?)";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setInt(1, hd.getNhanVien().getIdNhanVien());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Integer getIdHoaDon(int idHD) {
        Integer idSP = 0;
        try {
            String sql = "select IdHoaDon from HoaDon where IdHoaDon = ?";
            PreparedStatement pr = conn.prepareStatement(sql);
            pr.setInt(1, idHD);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                idSP = rs.getInt(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return idSP;
    }
    
    public static void main(String[] args) {
        System.out.println(new HoaDonRepository().getAllHD().toString());
    }
}
