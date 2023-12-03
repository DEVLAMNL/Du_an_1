<<<<<<< HEAD
package models;

import models.HangKhachHang;

public class KhachHang {

    int idKhachHang;
    String maKhachHang, tenKhachHang, diaChi, sdt;
    boolean gioiTinh;
    private HangKhachHang loaiKhachHang;
=======

package entity;

public class KhachHang {
String IdKhachHang , MaKhachHang, TenKhachHang, DiaChi,SDT;
int GioiTinh;
private HangKhachHang loaiKhachHang;
>>>>>>> 5b54ac0152933e4f0064ab38b0f34ada86e049f3

    public KhachHang() {
    }

<<<<<<< HEAD
    public KhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }
    
    public KhachHang(int idKhachHang, String maKhachHang, String tenKhachHang, String diaChi, String sdt, boolean gioiTinh, HangKhachHang loaiKhachHang) {
        this.idKhachHang = idKhachHang;
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.gioiTinh = gioiTinh;
        this.loaiKhachHang = loaiKhachHang;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
=======

    public KhachHang(String IdKhachHang, String MaKhachHang, String TenKhachHang, String DiaChi, String SDT, int GioiTinh, HangKhachHang loaiKhachHang) {
        this.IdKhachHang = IdKhachHang;
        this.MaKhachHang = MaKhachHang;
        this.TenKhachHang = TenKhachHang;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.GioiTinh = GioiTinh;
        this.loaiKhachHang = loaiKhachHang;
    }

    public String getIdKhachHang() {
        return IdKhachHang;
    }

    public void setIdKhachHang(String IdKhachHang) {
        this.IdKhachHang = IdKhachHang;
    }

    public String getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(String MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public String getTenKhachHang() {
        return TenKhachHang;
    }

    public void setTenKhachHang(String TenKhachHang) {
        this.TenKhachHang = TenKhachHang;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
>>>>>>> 5b54ac0152933e4f0064ab38b0f34ada86e049f3
    }

    public HangKhachHang getLoaiKhachHang() {
        return loaiKhachHang;
    }

    public void setLoaiKhachHang(HangKhachHang loaiKhachHang) {
        this.loaiKhachHang = loaiKhachHang;
    }
<<<<<<< HEAD

    
}
=======
  

  

    
}
>>>>>>> 5b54ac0152933e4f0064ab38b0f34ada86e049f3
