package repositorys;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
<<<<<<< HEAD
import models.KhachHang;
import models.HangKhachHang;
=======
import entity.KhachHang;
import entity.HangKhachHang;
>>>>>>> 5b54ac0152933e4f0064ab38b0f34ada86e049f3

public class KhachHangReponsitory {

    public void insert(KhachHang b) {
        try {
         Connection conn = (Connection) Utilcontext.Util.getConnection();
            String query = "INSERT INTO KhachHang (MaKhachHang, TenKhachHang, DiaChi,SDT,GioiTinh,IdHangKhachHang) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, b.getMaKhachHang());
            ps.setString(2, b.getTenKhachHang());

            ps.setString(3, b.getDiaChi());
            ps.setString(4, b.getSDT());
            ps.setInt(5, b.getGioiTinh());
            Integer idLkh = null ;
            if (b.getLoaiKhachHang()!=null) {
                idLkh = b.getLoaiKhachHang().getIdHangKhachHang();
            }
            ps.setInt(6, idLkh);
            System.out.println(idLkh);
            ps.execute();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String id) {
        try {
              Connection conn = (Connection) Utilcontext.Util.getConnection();
            String query = "DELETE FROM KhachHang WHERE IdKhachHang =?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void update(String id, KhachHang b) {
        try {
               Connection conn = (Connection) Utilcontext.Util.getConnection();
            String query = "UPDATE KhachHang SET MaKhachHang=?, TenKhachHang=?, DiaChi= ? , SDT=?, GioiTinh=?, IdHangKhachHang=? WHERE IdKhachHang=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, b.getMaKhachHang());
            ps.setString(2, b.getTenKhachHang());
            ps.setString(4, b.getSDT());
            ps.setInt(5, b.getGioiTinh());
            ps.setString(3, b.getDiaChi());
              Integer idLkh = null ;
            if (b.getLoaiKhachHang()!=null) {
                idLkh = b.getLoaiKhachHang().getIdHangKhachHang();
            }
            ps.setInt(6, idLkh);
            System.out.println(idLkh);
            ps.setString(7, id);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

<<<<<<< HEAD
    public ArrayList<KhachHang> getall() {
=======
    public ArrayList<KhachHang> all() {
>>>>>>> 5b54ac0152933e4f0064ab38b0f34ada86e049f3
        ArrayList<KhachHang> listBan2 = new ArrayList<>();

        try {
             Connection conn = (Connection) Utilcontext.Util.getConnection();
            String query = "SSELECT dbo.KhachHang.IdKhachHang, dbo.KhachHang.MaKhachHang, dbo.KhachHang.TenKhachHang, dbo.KhachHang.GioiTinh, dbo.KhachHang.DiaChi, dbo.KhachHang.SDT, dbo.KhachHang.NgayTao, \n"
                    + "                  dbo.HangKhachHang.TenHangKhachHang\n"
                    + "FROM    dbo.KhachHang   LEFT JOIN\n"
                    + "                   dbo.HangKhachHang ON dbo.HangKhachHang.IdHangKhachHang = dbo.KhachHang.IdHangKhachHang";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("IdKhachHang");
                String ma = rs.getString("MaKhachHang");
                String ten = rs.getString("TenKhachHang");
                String diaChi = rs.getString("DiaChi");
                String sdt = rs.getString("SDT");
                int gioiTinh = rs.getInt("GioiTinh");
                String tenKhachHang = rs.getString("TenHangKhachHang");

                HangKhachHang lkh = new HangKhachHang();
                lkh.setTenHangKhachHang(tenKhachHang);

                KhachHang kh = new KhachHang();

                kh.setIdKhachHang(id);
                kh.setMaKhachHang(ma);
                kh.setTenKhachHang(ten);
                kh.setDiaChi(diaChi);
                kh.setSDT(sdt);
                kh.setGioiTinh(gioiTinh);
                kh.setLoaiKhachHang(lkh);

                listBan2.add(kh);

            }

        } catch (Exception e) {
            e.printStackTrace();

        }

        return listBan2;

    }

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
                String id = rs.getString("IdKhachHang");
                String ma = rs.getString("MaKhachHang");
                String ten = rs.getString("TenKhachHang");
                String diaChi = rs.getString("DiaChi");
                String sdt = rs.getString("SDT");
                int gioiTinh = rs.getInt("GioiTinh");
                String tenKhachHang = rs.getString("TenHangKhachHang");

                HangKhachHang lkh = new HangKhachHang();
                lkh.setTenHangKhachHang(tenKhachHang);

                KhachHang kh = new KhachHang(id, ma, ten, diaChi, sdt, gioiTinh,lkh);
                listBan2.add(kh);

            }

        } catch (Exception e) {
            e.printStackTrace();

        }

        return listBan2;

    }

}
