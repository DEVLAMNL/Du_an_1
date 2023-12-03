/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorys;

import java.sql.Connection;
import java.util.ArrayList;
import model.ChucVu;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class ChucVuDAO {
    private Connection conn;
    
    public ChucVuDAO() {
        try {
            this.conn = DBContext.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<ChucVu> finALL() {
        ArrayList<ChucVu> ds = new ArrayList<>();
        try {
            String sql = "select * from ChucVu";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int IdChucVu = rs.getInt("IdChucVu");
                String TenChucVu = rs.getString("TenChucVu");
                ChucVu chucVu = new ChucVu(IdChucVu, TenChucVu);
                ds.add(chucVu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }
     public boolean insert(ChucVu cv) {
        Integer row = null;
        try {
            String sql = "INSERT INTO ChucVu( TenChucVu) values(?)";
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
     public boolean delete(int id){
         Integer row = null;
        try {
            String sql = "DELETE FROM ChucVu WHERE IdChucVu= ?";
            PreparedStatement ps = conn.prepareStatement(sql);   
            ps.setInt(1, id);
            ps.execute();
            row = ps.getUpdateCount();
            System.out.println(row);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row > 0;
     }
      public boolean update(ChucVu cv) {
        Integer row = null;
        try {
            String sql = "UPDATE ChucVu SET TenChucVu = ?  WHERE IdChucVu = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cv.getTenChucVu());
            ps.setInt(2, cv.getIdChucVu());
            row = ps.executeUpdate();
            System.out.println(row);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row > 0;
      }
      
}

