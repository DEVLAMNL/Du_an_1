package models;

import models.HangKhachHang;

public class KhachHang {

    int idKhachHang;
    String maKhachHang, tenKhachHang, diaChi, sdt;
    boolean gioiTinh;
    private HangKhachHang loaiKhachHang;

    public KhachHang() {
    }

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
    }

    public HangKhachHang getLoaiKhachHang() {
        return loaiKhachHang;
    }

    public void setLoaiKhachHang(HangKhachHang loaiKhachHang) {
        this.loaiKhachHang = loaiKhachHang;
    }

    
}
