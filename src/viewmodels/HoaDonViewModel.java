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
public class HoaDonViewModel {

    private int IdHoaDon;
    private int IdNhanVien;
    private int IdKhachHang;
    private String MaHoaDon;
    private Date NgayTao;
    private Boolean TinhTrang;
    private int IdPhieuGiamGia;
    private int IdPhieuGiaoHang;

    public HoaDonViewModel() {
    }

    public HoaDonViewModel(int IdHoaDon, int IdNhanVien, int IdKhachHang, String MaHoaDon, Date NgayTao, Boolean TinhTrang, int IdPhieuGiamGia, int IdPhieuGiaoHang) {
        this.IdHoaDon = IdHoaDon;
        this.IdNhanVien = IdNhanVien;
        this.IdKhachHang = IdKhachHang;
        this.MaHoaDon = MaHoaDon;
        this.NgayTao = NgayTao;
        this.TinhTrang = TinhTrang;
        this.IdPhieuGiamGia = IdPhieuGiamGia;
        this.IdPhieuGiaoHang = IdPhieuGiaoHang;
    }

    public int getIdHoaDon() {
        return IdHoaDon;
    }

    public void setIdHoaDon(int IdHoaDon) {
        this.IdHoaDon = IdHoaDon;
    }

    public int getIdNhanVien() {
        return IdNhanVien;
    }

    public void setIdNhanVien(int IdNhanVien) {
        this.IdNhanVien = IdNhanVien;
    }

    public int getIdKhachHang() {
        return IdKhachHang;
    }

    public void setIdKhachHang(int IdKhachHang) {
        this.IdKhachHang = IdKhachHang;
    }

    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public Boolean getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(Boolean TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

    public int getIdPhieuGiamGia() {
        return IdPhieuGiamGia;
    }

    public void setIdPhieuGiamGia(int IdPhieuGiamGia) {
        this.IdPhieuGiamGia = IdPhieuGiamGia;
    }

    public int getIdPhieuGiaoHang() {
        return IdPhieuGiaoHang;
    }

    public void setIdPhieuGiaoHang(int IdPhieuGiaoHang) {
        this.IdPhieuGiaoHang = IdPhieuGiaoHang;
    }

}
