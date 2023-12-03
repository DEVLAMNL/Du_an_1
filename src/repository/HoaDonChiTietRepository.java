/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import Utilcontext.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.HoaDon;
import models.HoaDonChiTiet;
import models.SanPham;
import models.SanPhamChiTiet;
import service.HoaDonChiTietService;

/**
 *
 * @author admin
 */
public class HoaDonChiTietRepository implements HoaDonChiTietService {

    private static Connection conn = Util.getConnection();

    @Override
    public List<HoaDonChiTiet> getListHoaDonChiTiet(int idHD) {
        List<HoaDonChiTiet> listHDCT = new ArrayList<>();
        String sql = "SELECT HoaDonChiTiet.IdChiTietSanPham\n"
                + "      ,SanPham.TenSanPham\n"
                + "      ,HoaDonChiTiet.SoLuong\n"
                + "      ,HoaDonChiTiet.GiaBan\n"
                + "  FROM [dbo].[HoaDonChiTiet]\n"
                + "  JOIN HoaDon ON HoaDonChiTiet.IdHoaDon = HoaDon.IdHoaDon\n"
                + "  JOIN SanPhamChiTiet ON SanPhamChiTiet.IdSanPhamChiTiet = HoaDonChiTiet.IdChiTietSanPham\n"
                + "  JOIN SanPham ON SanPham.MaSanPham = SanPhamChiTiet.MaSanPham\n"
                + "  where HoaDon.IdHoaDon = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idHD);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int idSPCT = rs.getInt("IdChiTietSanPham");
                    float giaBan = rs.getFloat("GiaBan");
                    int soLuong = rs.getInt("SoLuong");

                    String tenSanPham = rs.getString("TenSanPham");

                    SanPham sp = new SanPham(tenSanPham);

                    SanPhamChiTiet spct = new SanPhamChiTiet(idSPCT, sp, giaBan);

                    HoaDonChiTiet hdct = new HoaDonChiTiet(spct, soLuong);
                    listHDCT.add(hdct);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHDCT;
    }
////////////////////////////////////////////////////////////////////////////

    public ArrayList<HoaDonChiTiet> getallHDCT() {
        String Query = "SELECT [IdHoaDonChiTiet]\n"
                + "      ,[IdHoaDon]\n"
                + "	  ,SanPham.MaSanPham\n"
                + "	  ,SanPham.TenSanPham\n"
                + "      ,SanPhamChiTiet.IdSanPhamChiTiet\n"
                + "      ,HoaDonChiTiet.SoLuong\n"
                + "      ,SanPhamChiTiet.GiaBan\n"
                + "  FROM [dbo].[HoaDonChiTiet]\n"
                + "  JOIN SanPhamChiTiet ON HoaDonChiTiet.IdChiTietSanPham = SanPhamChiTiet.IdSanPhamChiTiet\n"
                + "  JOIN SanPham ON SanPham.MaSanPham = SanPhamChiTiet.MaSanPham";
        ArrayList<HoaDonChiTiet> ListHDCT = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareCall(Query);
            ps.executeQuery();

            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String MaSanPham = rs.getString("MaSanPham");
                String TenSanPham = rs.getString("TenSanPham");
                int IdCTSP = rs.getInt("IdSanPhamChiTiet");
                int SoLuong = rs.getInt("SoLuong");
                Float GiaBan = rs.getFloat("GiaBan");
                SanPham sp = new SanPham(MaSanPham, TenSanPham);
                SanPhamChiTiet spct = new SanPhamChiTiet(IdCTSP, sp, GiaBan);
                HoaDonChiTiet hdct = new HoaDonChiTiet(spct, SoLuong);
                System.out.println("");
                ListHDCT.add(hdct);
            }

        } catch (Exception e) {
            e.printStackTrace(); // In lỗi để bạn có thể xem nếu có lỗi xảy ra
        }
        return ListHDCT;
    }

    public List<HoaDonChiTiet> getAllHoaDonChiTiet() {
        String sql = "SELECT [IdHoaDonChiTiet], [IdHoaDon], [IdChiTietSanPham], [SoLuong], [GiaBan] FROM [dbo].[HoaDonChiTiet]";
        List<HoaDonChiTiet> list = new ArrayList<>();

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idHoaDonChiTiet = rs.getInt("IdHoaDonChiTiet");
                String idHoaDon = rs.getString("IdHoaDon");
                int idChiTietSanPham = rs.getInt("IdChiTietSanPham");
                int soLuong = rs.getInt("SoLuong");
                float giaBan = rs.getFloat("GiaBan");

                HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
                hoaDonChiTiet.setIdHoaDonChiTiet(idHoaDonChiTiet);
                hoaDonChiTiet.setSoLuong(soLuong);
                hoaDonChiTiet.setDonGia(giaBan);

                SanPhamChiTiet spct = new SanPhamChiTiet(idChiTietSanPham);
                HoaDon hd = new HoaDon(idHoaDon);
                // Đặt thông tin sản phẩm chi tiết và hóa đơn vào đối tượng HoaDonChiTiet
                hoaDonChiTiet.setSanPhamChiTiet(spct);
                hoaDonChiTiet.setHoaDon(hd);
                list.add(hoaDonChiTiet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void insertHoaDonChiTiet(HoaDonChiTiet hdct, int idHoaDon) {
        String sql = "INSERT INTO HoaDonChiTiet (IdChiTietSanPham, IdHoaDon, SoLuong, GiaBan) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, hdct.getSanPhamChiTiet().getIdSanPhamChiTiet());
            ps.setInt(2, idHoaDon);
            ps.setInt(3, hdct.getSoLuong());
            ps.setFloat(4, hdct.getDonGia());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateSoLuongSanPhamChiTiet(int idSP, int soLuongConLai) {
        String sql = "UPDATE SanPhamChiTiet SET SoLuong = ? WHERE IdSanPhamChiTiet = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, soLuongConLai);
            ps.setInt(2, idSP);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteHDCT(int idSPCT) {
        String sql = "DELETE FROM [dbo].[HoaDonChiTiet]\n"
                + "      WHERE IdChiTietSanPham = ?";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setInt(1, idSPCT);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public HoaDonChiTiet getHoaDonChiTietById(int idHD) {
        String sql = "SELECT [IdHoaDonChiTiet]\n"
                + ",HoaDonChiTiet.IdChiTietSanPham\n"
                + ",SanPham.TenSanPham\n"
                + ",HoaDon.IdHoaDon\n"
                + ",HoaDonChiTiet.SoLuong\n"
                + ",SanPhamChiTiet.SoLuong\n"
                + ",HoaDonChiTiet.GiaBan\n"
                + "FROM [dbo].[HoaDonChiTiet]\n"
                + "JOIN HoaDon ON HoaDonChiTiet.IdHoaDon = HoaDon.IdHoaDon\n"
                + "JOIN SanPhamChiTiet ON SanPhamChiTiet.IdSanPhamChiTiet = HoaDonChiTiet.IdChiTietSanPham\n"
                + "JOIN SanPham ON SanPham.MaSanPham = SanPhamChiTiet.MaSanPham\n"
                + "where HoaDon.IdHoaDon = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idHD);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int idHoaDonChiTiet = rs.getInt("IdHoaDonChiTiet");
                    int idChiTietSanPham = rs.getInt("IdChiTietSanPham");
                    float giaBan = rs.getFloat("GiaBan");
                    int soLuongHDCT = rs.getInt(5);
                    int soLuongSPCT = rs.getInt(6);
                    String tenSanPham = rs.getString("TenSanPham");

                    SanPham sp = new SanPham(tenSanPham);
                    SanPhamChiTiet spct = new SanPhamChiTiet(idChiTietSanPham, sp, soLuongSPCT, giaBan);

                    return new HoaDonChiTiet(idHoaDonChiTiet, spct, soLuongHDCT);
                    
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
//        System.out.println(new HoaDonChiTietRepository().getAllHoaDonChiTiet());
//        System.out.println(new HoaDonChiTietRepository().getallHDCTbyIdHoaDon("PH001"));
        System.out.println(new HoaDonChiTietRepository().getHoaDonChiTietById(8).toString());

    }
}
