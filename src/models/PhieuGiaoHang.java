/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Admin
 */
public class PhieuGiaoHang {
    private int idPhieuGiao;
    private String maPhieuGiao;
    private boolean trangThai;
    private KhachHang khachHang;

    public PhieuGiaoHang() {
    }

    public PhieuGiaoHang(String maPhieuGiao) {
        this.maPhieuGiao = maPhieuGiao;
    }

    public PhieuGiaoHang(int idPhieuGiao, String maPhieuGiao, boolean trangThai, KhachHang khachHang) {
        this.idPhieuGiao = idPhieuGiao;
        this.maPhieuGiao = maPhieuGiao;
        this.trangThai = trangThai;
        this.khachHang = khachHang;
    }

    public int getIdPhieuGiao() {
        return idPhieuGiao;
    }

    public void setIdPhieuGiao(int idPhieuGiao) {
        this.idPhieuGiao = idPhieuGiao;
    }

    public String getMaPhieuGiao() {
        return maPhieuGiao;
    }

    public void setMaPhieuGiao(String maPhieuGiao) {
        this.maPhieuGiao = maPhieuGiao;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }
    
}
