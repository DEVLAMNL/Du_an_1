/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;


import java.util.Date;

/**
 *
 * @author MSI Laptop
 */
public class HoaDon {
    private int idHoaDon;
    private NhanVien nhanVien;
    private KhachHang khachHang;
    private String maHoaDon;
    private Date ngayTao;
    private Boolean tinhTrang;
    private PhieuGiamGia phieuGiamGia;
    private PhieuGiaoHang phieuGiaoHang;

    public HoaDon() {
    }

    public HoaDon(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public HoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public HoaDon(int idHoaDon, NhanVien nhanVien, Date ngayTao, Boolean tinhTrang) {
        this.idHoaDon = idHoaDon;
        this.nhanVien = nhanVien;
        this.ngayTao = ngayTao;
        this.tinhTrang = tinhTrang;
    }

    public HoaDon(int idHoaDon, Date ngayTao, Boolean tinhTrang) {
        this.idHoaDon = idHoaDon;
        this.ngayTao = ngayTao;
        this.tinhTrang = tinhTrang;
    }

    public HoaDon(String maHoaDon, Date ngayTao, Boolean tinhTrang) {
        this.maHoaDon = maHoaDon;
        this.ngayTao = ngayTao;
        this.tinhTrang = tinhTrang;
    }

    public HoaDon(int idHoaDon, String maHoaDon, Date ngayTao, Boolean tinhTrang) {
        this.idHoaDon = idHoaDon;
        this.maHoaDon = maHoaDon;
        this.ngayTao = ngayTao;
        this.tinhTrang = tinhTrang;
    }

    public HoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public HoaDon(int idHoaDon, NhanVien nhanVien, KhachHang khachHang, String maHoaDon, Date ngayTao, Boolean tinhTrang, PhieuGiaoHang phieuGiaoHang) {
        this.idHoaDon = idHoaDon;
        this.nhanVien = nhanVien;
        this.khachHang = khachHang;
        this.maHoaDon = maHoaDon;
        this.ngayTao = ngayTao;
        this.tinhTrang = tinhTrang;
        this.phieuGiaoHang = phieuGiaoHang;
    }

    

    public HoaDon(int idHoaDon, NhanVien nhanVien, KhachHang khachHang, String maHoaDon, Date ngayTao, Boolean tinhTrang, PhieuGiamGia phieuGiamGia, PhieuGiaoHang phieuGiaoHang) {
        this.idHoaDon = idHoaDon;
        this.nhanVien = nhanVien;
        this.khachHang = khachHang;
        this.maHoaDon = maHoaDon;
        this.ngayTao = ngayTao;
        this.tinhTrang = tinhTrang;
        this.phieuGiamGia = phieuGiamGia;
        this.phieuGiaoHang = phieuGiaoHang;
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Boolean getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(Boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public PhieuGiamGia getPhieuGiamGia() {
        return phieuGiamGia;
    }

    public void setPhieuGiamGia(PhieuGiamGia phieuGiamGia) {
        this.phieuGiamGia = phieuGiamGia;
    }

    public PhieuGiaoHang getPhieuGiaoHang() {
        return phieuGiaoHang;
    }

    public void setPhieuGiaoHang(PhieuGiaoHang phieuGiaoHang) {
        this.phieuGiaoHang = phieuGiaoHang;
    }

    
}
