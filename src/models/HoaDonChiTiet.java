/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;


import java.util.UUID;

/**
 *
 * @author MSI Laptop
 */
public class HoaDonChiTiet {
    
    
    
    private int IdHoaDonChiTiet;
    private SanPhamChiTiet sanPhamChiTiet;
    private HoaDon hoaDon;
    private int SoLuong;
    private float donGia;

    @Override
    public String toString() {
        return "HoaDonChiTiet{" + "IdHoaDonChiTiet=" + IdHoaDonChiTiet + ", sanPhamChiTiet=" + sanPhamChiTiet + ", hoaDon=" + hoaDon + ", SoLuong=" + SoLuong + ", donGia=" + donGia + '}';
    }



    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int IdHoaDonChiTiet, SanPhamChiTiet sanPhamChiTiet, int SoLuong) {
        this.IdHoaDonChiTiet = IdHoaDonChiTiet;
        this.sanPhamChiTiet = sanPhamChiTiet;
        this.SoLuong = SoLuong;
    }

    public HoaDonChiTiet(SanPhamChiTiet sanPhamChiTiet, int SoLuong) {
        this.sanPhamChiTiet = sanPhamChiTiet;
        this.SoLuong = SoLuong;
    }

    public HoaDonChiTiet(SanPhamChiTiet sanPhamChiTiet) {
        this.sanPhamChiTiet = sanPhamChiTiet;
    }

    public HoaDonChiTiet(SanPhamChiTiet sanPhamChiTiet, HoaDon hoaDon, int SoLuong, float donGia) {
        this.sanPhamChiTiet = sanPhamChiTiet;
        this.hoaDon = hoaDon;
        this.SoLuong = SoLuong;
        this.donGia = donGia;
    }

    public HoaDonChiTiet(SanPhamChiTiet sanPhamChiTiet, int SoLuong, float donGia) {
        this.sanPhamChiTiet = sanPhamChiTiet;
        this.SoLuong = SoLuong;
        this.donGia = donGia;
    }

    public HoaDonChiTiet(int IdHoaDonChiTiet, SanPhamChiTiet sanPhamChiTiet, HoaDon hoaDon, int SoLuong, float donGia) {
        this.IdHoaDonChiTiet = IdHoaDonChiTiet;
        this.sanPhamChiTiet = sanPhamChiTiet;
        this.hoaDon = hoaDon;
        this.SoLuong = SoLuong;
        this.donGia = donGia;
    }




    public int getIdHoaDonChiTiet() {
        return IdHoaDonChiTiet;
    }

    public void setIdHoaDonChiTiet(int IdHoaDonChiTiet) {
        this.IdHoaDonChiTiet = IdHoaDonChiTiet;
    }

    public SanPhamChiTiet getSanPhamChiTiet() {
        return sanPhamChiTiet;
    }

    public void setSanPhamChiTiet(SanPhamChiTiet sanPhamChiTiet) {
        this.sanPhamChiTiet = sanPhamChiTiet;
    }


    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    
}
