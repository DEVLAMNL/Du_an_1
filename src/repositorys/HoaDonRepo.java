/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorys;

import viewmodels.HoaDonViewModel;
//import viewmodels.NhanVien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class HoaDonRepo {

    private static Connection conn = Utilcontext.Util.getConnection();

    public ArrayList<HoaDonViewModel> getAll() {
        ArrayList<HoaDonViewModel> listHoaDon = new ArrayList<>();
        String sql = "SELECT [IdHoaDon]\n"
                + "      ,[MaHoaDon]\n"
                + "      ,[NgayTao]\n"
                + "      ,[TinhTrang]\n"
                + "      ,[IdPhieuGiao]\n"
                + "  FROM [dbo].[HoaDon]";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                int IdHd = rs.getInt(1);
                String Ma = rs.getString(2);
                Date NgayTao = rs.getDate(3);
                Boolean TrangThai = rs.getBoolean(4);
                int IdPg = rs.getInt(5);
                HoaDonViewModel hd = new HoaDonViewModel(IdHd, 0, 0, Ma, NgayTao, TrangThai, 0, IdPg);
                listHoaDon.add(hd);
            }
        } catch (Exception e) {
        }
        return listHoaDon;
    }

    public void insert(HoaDonViewModel hd) {
        String sql = "insert into HoaDon( MaHoaDon, NgayTao  , TinhTrang , idPhieuGiao) values( ? , ? , ? , ?)";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, hd.getMaHoaDon());
            ps.setDate(2, (java.sql.Date) hd.getNgayTao());
            ps.setBoolean(3, hd.getTinhTrang());
            ps.setInt(4, hd.getIdPhieuGiaoHang());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(new HoaDonRepo().getAll().toString());
    }
}
