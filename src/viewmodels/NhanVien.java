/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodels;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class NhanVien {

    private int IdNhanVien;
    private String MaNhanVien;
    private String TenNhanVien;
    private Boolean GioiTinh;
    private String DiaChi;
    private String NgaySinh;
    private String NgayTao;

    public NhanVien() {
    }

    public NhanVien(int IdNhanVien, String MaNhanVien, String TenNhanVien, Boolean GioiTinh, String DiaChi, String NgaySinh, String NgayTao) {
        this.IdNhanVien = IdNhanVien;
        this.MaNhanVien = MaNhanVien;
        this.TenNhanVien = TenNhanVien;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.NgaySinh = NgaySinh;
        this.NgayTao = NgayTao;
    }

    public int getIdNhanVien() {
        return IdNhanVien;
    }

    public void setIdNhanVien(int IdNhanVien) {
        this.IdNhanVien = IdNhanVien;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "IdNhanVien=" + IdNhanVien + ", MaNhanVien=" + MaNhanVien + ", TenNhanVien=" + TenNhanVien + ", GioiTinh=" + GioiTinh + ", DiaChi=" + DiaChi + ", NgaySinh=" + NgaySinh + ", NgayTao=" + NgayTao + '}';
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getTenNhanVien() {
        return TenNhanVien;
    }

    public void setTenNhanVien(String TenNhanVien) {
        this.TenNhanVien = TenNhanVien;
    }

    public Boolean getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(Boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }

    
    public String setGioiTinh() {
        String Nam = "Nam";
        String Nu = "Nu";
        if (GioiTinh == Boolean.FALSE) {
            return Nam;
        } else {
            return Nu;
        }
    }

}
