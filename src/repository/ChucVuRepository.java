/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import Utilcontext.Util;
import java.sql.Connection;
import java.util.ArrayList;
import model.ChucVu;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChucVuRepository {

    private Connection conn = Util.getConnection();

    public ArrayList<ChucVu> finALL() {
        String sql = "select * from ChucVu";
        ArrayList<ChucVu> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                int idChucVu = rs.getInt(1);
                String tenChucVu = rs.getString(2);
                ChucVu ms = new ChucVu(idChucVu, tenChucVu);
                list.add(ms);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean insert(ChucVu cv) {
        Integer row = null;
        try {
            String sql = "INSERT INTO [dbo].[ChucVu]\n"
                    + "           ([TenChucVu])\n"
                    + "     VALUES\n"
                    + "           (?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cv.getTenChucVu());
            ps.execute();
            row = ps.getUpdateCount();
            System.out.println(row);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row > 0;
    }

    public void delete(int id) {
        String sql = "DELETE FROM [dbo].[ChucVu]\n"
                + "      WHERE IdChucVu = ?";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(ChucVu cv, int id) {
        String sql = "UPDATE [dbo].[ChucVu]\n"
                + "   SET [TenChucVu] = ?\n"
                + " WHERE IdChucVu = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cv.getTenChucVu());
            ps.setInt(2, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
