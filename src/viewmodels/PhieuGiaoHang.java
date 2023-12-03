/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodels;

/**
 *
 * @author Admin
 */
public class PhieuGiaoHang {

    private int IdPgh;
    private int IdHoaDon;
    private int IdKhachHan;
    private String MaVanDon;
    private KhachhangViewModel kh;
    private boolean Trangthai;

    public PhieuGiaoHang() {
    }

    public PhieuGiaoHang(int IdPgh, int IdHoaDon, int IdKhachHan, String MaVanDon, KhachhangViewModel kh, boolean Trangthai) {
        this.IdPgh = IdPgh;
        this.IdHoaDon = IdHoaDon;
        this.IdKhachHan = IdKhachHan;
        this.MaVanDon = MaVanDon;
        this.kh = kh;
        this.Trangthai = Trangthai;
    }

    public int getIdPgh() {
        return IdPgh;
    }

    public void setIdPgh(int IdPgh) {
        this.IdPgh = IdPgh;
    }

    public int getIdHoaDon() {
        return IdHoaDon;
    }

    public void setIdHoaDon(int IdHoaDon) {
        this.IdHoaDon = IdHoaDon;
    }

    public int getIdKhachHan() {
        return IdKhachHan;
    }

    public void setIdKhachHan(int IdKhachHan) {
        this.IdKhachHan = IdKhachHan;
    }

    public String getMaVanDon() {
        return MaVanDon;
    }

    public void setMaVanDon(String MaVanDon) {
        this.MaVanDon = MaVanDon;
    }

    public KhachhangViewModel getKh() {
        return kh;
    }

    public void setKh(KhachhangViewModel kh) {
        this.kh = kh;
    }

    public boolean isTrangthai() {
        return Trangthai;
    }

    public void setTrangthai(boolean Trangthai) {
        this.Trangthai = Trangthai;
    }

    @Override
    public String toString() {
        return "PhieuGiaoHang{" + "IdPgh=" + IdPgh + ", IdHoaDon=" + IdHoaDon + ", IdKhachHan=" + IdKhachHan + ", MaVanDon=" + MaVanDon + ", kh=" + kh + ", Trangthai=" + Trangthai + '}';
    }

}
