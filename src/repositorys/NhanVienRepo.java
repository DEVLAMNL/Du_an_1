/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorys;

import viewmodels.NhanVien;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class NhanVienRepo {

    private static Connection conn = (Connection) Utilcontext.Util.getConnection();

    public ArrayList<NhanVien> getAll() {
        ArrayList<NhanVien> listNhanVien = new ArrayList<>();
        String sql = "SELECT [IdNhanVien]\n"
                + "      ,[MaNhanVien]\n"
                + "      ,[TenNhanVien]\n"
                + "      ,[GioiTinh]\n"
                + "      ,[DiaChi]\n"
                + "      ,[NgaySinh]\n"
                + "      ,[NgayTao]\n"
                + "  FROM [dbo].[NhanVien]";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                int Id = rs.getInt(1);
                String Ma = rs.getString(2);
                String Ten = rs.getString(3);
                Boolean GioiTinh = rs.getBoolean(4);
                String DiaChi = rs.getString(5);
                String NgaySinh = rs.getString(6);
                String NgayTao = rs.getString(7);
                NhanVien nv = new NhanVien(Id, Ma, Ten, GioiTinh, DiaChi, NgaySinh, NgayTao);
                listNhanVien.add(nv);
            }
        } catch (Exception e) {
        }
        return listNhanVien;
    }

    public String insert(NhanVien NV) {
        String sql = "INSERT INTO [dbo].[NhanVien]\n"
                + "           ([MaNhanVien]\n"
                + "           ,[TenNhanVien]\n"
                + "           ,[GioiTinh]\n"
                + "           ,[DiaChi]\n"
                + "           ,[NgaySinh]\n"
                + "           ,[NgayTao])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, NV.getMaNhanVien());
            ps.setString(2, NV.getTenNhanVien());
            ps.setBoolean(3, NV.getGioiTinh());
            ps.setString(4, NV.getDiaChi());
            ps.setString(5, NV.getNgaySinh());
            ps.setString(6, NV.getNgayTao());
            ps.execute();
        } catch (Exception e) {
        }
        return null;
    }

    public void Delete(String Id) {
        String sql = "delete from NhanVien where IdNhanVien = ?";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, Id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void update(String Id, NhanVien nv) {
        String sql = "UPDATE [dbo].[NhanVien]"
                + "   SET [MaNhanVien] = ?"
                + "      ,[TenNhanVien] = ?"
                + "      ,[GioiTinh] = ?"
                + "      ,[DiaChi] = ?"
                + "      ,[NgaySinh] = ?"
                + "      ,[NgayTao] = ?"
                + " WHERE IdNhanVien = ?";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, nv.getMaNhanVien());
            ps.setString(2, nv.getTenNhanVien());
            ps.setBoolean(3, nv.getGioiTinh());
            ps.setString(4, nv.getDiaChi());
            ps.setString(5, nv.getNgaySinh());
            ps.setString(6, nv.getNgayTao());
            ps.setString(7, Id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(new NhanVienRepo().getAll());
    }

}
