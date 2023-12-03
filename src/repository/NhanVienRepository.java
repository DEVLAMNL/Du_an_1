package repository;

import Utilcontext.Util;
import java.sql.Connection;
import java.util.ArrayList;
import models.NhanVien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import service.NhanVienService;

/**
 *
 * @author Admin
 */
public class NhanVienRepository implements NhanVienService {

    private Connection conn = Util.getConnection();

    @Override
    public ArrayList<NhanVien> getAllNhanVien() {
        ArrayList<NhanVien> ds = new ArrayList<>();
        String sql = "SELECT [IdNhanVien]\n"
                + "      ,[IdChucVu]\n"
                + "      ,[MaNhanVien]\n"
                + "      ,[TenNhanVien]\n"
                + "      ,[GioiTinh]\n"
                + "      ,[DiaChi]\n"
                + "      ,[NgaySinh]\n"
                + "      ,[NgayTao]\n"
                + "      ,[TaiKhoan]\n"
                + "      ,[MatKhau]\n"
                + "      ,[Luong]\n"
                + "	  ,[TrangThai]\n"
                + "  FROM [dbo].[NhanVien]";

        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int IdNhanVien = rs.getInt("IdNhanVien");
                int IdChucVu = rs.getInt("IdChucVu");
                String MaNhanVien = rs.getString("MaNhanVien");
                String TenNhanVien = rs.getString("TenNhanVien");
                boolean GioiTinh = rs.getBoolean("GioiTinh");
                String DiaChi = rs.getString("DiaChi");

                Date NgaySinh = rs.getDate("NgaySinh");
                Date NgayTao = rs.getDate("NgayTao");

                String TaiKhoan = rs.getString("TaiKhoan");
                String MatKhau = rs.getString("MatKhau");
                int Luong = rs.getInt("Luong");
                String TrangThai = rs.getString("TrangThai");

                NhanVien nv = new NhanVien(IdNhanVien, IdChucVu, MaNhanVien, TenNhanVien, GioiTinh, DiaChi, NgaySinh, NgayTao, TaiKhoan, MatKhau, Luong, TrangThai);
                ds.add(nv);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ds;
    }

    public boolean insertNhanVien(NhanVien nv) {
        Integer row = null;
        try {
            String sql = "INSERT INTO NhanVien ( IdChucVu, MaNhanVien, TenNhanVien, GioiTinh, DiaChi, NgaySinh, NgayTao, TaiKhoan, MatKhau, Luong, TrangThai) values(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, nv.getIdChucVu());
            ps.setString(2, nv.getMaNhanVien());
            ps.setString(3, nv.getTenNhanVien());
            ps.setBoolean(4, nv.isGioiTinh());
            ps.setString(5, nv.getDiaChi());
            ps.setDate(6, new java.sql.Date(nv.getNgaySinh().getTime()));
            ps.setDate(7, new java.sql.Date(nv.getNgayTao().getTime()));
            ps.setString(8, nv.getTaiKhoan());
            ps.setString(9, nv.getMatKhau());
            ps.setFloat(10, nv.getLuong());
            ps.setString(11, nv.getTrangThai());
            ps.execute();
            row = ps.getUpdateCount();
            System.out.println(row);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteNhanVien(int id) {
        Integer row = null;
        try {
            String sql = "delete from NhanVien where IdNhanVien = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            row = ps.getUpdateCount();
            System.out.println(row);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateNhanVien(int id, NhanVien nv) {
        Integer row = null;
        try {
            String sql = "UPDATE NhanVien SET IdChucVu = ?, MaNhanVien = ?, TenNhanVien = ?, GioiTinh = ?, DiaChi = ?, NgaySinh = ?, NgayTao= ?, TaiKhoan = ?, MatKhau = ?, Luong = ?, TrangThai = ?  WHERE IdNhanVien = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, nv.getIdChucVu());
            ps.setString(2, nv.getMaNhanVien());
            ps.setString(3, nv.getTenNhanVien());
            ps.setBoolean(4, nv.isGioiTinh());
            ps.setString(5, nv.getDiaChi());
            ps.setDate(6, new java.sql.Date(nv.getNgaySinh().getTime())); // Chuyển từ java.util.Date sang java.sql.Date
            ps.setDate(7, new java.sql.Date(nv.getNgayTao().getTime())); // Chuyển từ java.util.Date sang java.sql.Date
            ps.setString(8, nv.getTaiKhoan());
            ps.setString(9, nv.getMatKhau());
            ps.setInt(10, nv.getLuong());
            ps.setString(11, nv.getTrangThai());
            ps.setInt(12, nv.getIdNhanVien());

            row = ps.executeUpdate();
            System.out.println(row);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<NhanVien> timKiem(int ma) {
        ArrayList<NhanVien> listNV = new ArrayList<>();
        try {
            String sql = "select * from NhanVien where IDNhanVien LIKE '%" + ma + "%'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int IdNhanVien = rs.getInt("IDNhanVien");
                int IdChucVu = rs.getInt("IdChucVu");
                String MaNhanVien = rs.getString("MaNhanVien");
                String TenNhanVien = rs.getString("TenNhanVien");
                boolean GioiTinh = rs.getBoolean("GioiTinh");
                String DiaChi = rs.getString("DiaChi");
                Date ngaySinh = rs.getDate("NgaySinh");
                Date NgayTao = rs.getDate("NgayTao");
                String TaiKhoan = rs.getString("TaiKhoan");
                String MatKhau = rs.getString("MatKhau");
                int Luong = rs.getInt("Luong");
                String TrangThai = rs.getString("TrangThai");
                NhanVien nv = new NhanVien(IdNhanVien, IdChucVu, MaNhanVien, TenNhanVien, GioiTinh, DiaChi, ngaySinh, NgayTao, TaiKhoan, MatKhau, Luong, TrangThai);
                listNV.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNV;
    }

    public ArrayList<NhanVien> Loc(String condition) {
        ArrayList<NhanVien> ds = new ArrayList<>();
        try {
            String sql = "SELECT * FROM NhanVien WHERE TrangThai = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, condition);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int IdNhanVien = rs.getInt("IdNhanVien");
                int IdChucVu = rs.getInt("IdChucVu");
                String MaNhanVien = rs.getString("MaNhanVien");
                String TenNhanVien = rs.getString("TenNhanVien");
                boolean GioiTinh = rs.getBoolean("GioiTinh");
                String DiaChi = rs.getString("DiaChi");
                Date NgaySinh = rs.getDate("NgaySinh");
                Date NgayTao = rs.getDate("NgayTao");
                String TaiKhoan = rs.getString("MatKhau");
                String MatKhau = rs.getString("MatKhau");
                int luong = rs.getInt("Luong");
                String TrangThai = rs.getString("TrangThai");
                NhanVien nv = new NhanVien(IdNhanVien, IdChucVu, MaNhanVien, TenNhanVien, GioiTinh, DiaChi, NgaySinh, NgayTao, TaiKhoan, MatKhau, luong, TrangThai);
                ds.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public static void main(String[] args) {
        System.out.println(new NhanVienRepository().getAllNhanVien().toString());
    }
}