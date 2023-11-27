/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;


/**
 *
 * @author admin
 */
public class SanPhamChiTiet {
    private int IdSanPhamChiTiet;

    private SanPham sanPham;
    private KichThuoc kichThuoc;
    private ChatLieu chatLieu;
    private MauSac mauSac;
    
    
    private int soLuong;
    private float giaBan;
    
    
    

    public SanPhamChiTiet() {
        
    }

    public SanPhamChiTiet(int IdSanPhamChiTiet) {
        this.IdSanPhamChiTiet = IdSanPhamChiTiet;
    }

    public SanPhamChiTiet(int IdSanPhamChiTiet, SanPham sanPham, KichThuoc kichThuoc, ChatLieu chatLieu, MauSac mauSac) {
        this.IdSanPhamChiTiet = IdSanPhamChiTiet;
        this.sanPham = sanPham;
        this.kichThuoc = kichThuoc;
        this.chatLieu = chatLieu;
        this.mauSac = mauSac;
    }
    
    public SanPhamChiTiet(SanPham sanPham, KichThuoc kichThuoc, ChatLieu chatLieu, MauSac mauSac, int soLuong, float giaBan) {
        this.sanPham = sanPham;
        this.kichThuoc = kichThuoc;
        this.chatLieu = chatLieu;
        this.mauSac = mauSac;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
    }
    
    
    
    public SanPhamChiTiet(int IdSanPhamChiTiet, SanPham sanPham, KichThuoc kichThuoc, ChatLieu chatLieu, MauSac mauSac, int soLuong, float giaBan) {
        this.IdSanPhamChiTiet = IdSanPhamChiTiet;
        this.sanPham = sanPham;
        this.kichThuoc = kichThuoc;
        this.chatLieu = chatLieu;
        this.mauSac = mauSac;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
    }

    public int getIdSanPhamChiTiet() {
        return IdSanPhamChiTiet;
    }

    public void setIdSanPhamChiTiet(int IdSanPhamChiTiet) {
        this.IdSanPhamChiTiet = IdSanPhamChiTiet;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public KichThuoc getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(KichThuoc kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public ChatLieu getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(ChatLieu chatLieu) {
        this.chatLieu = chatLieu;
    }

    public MauSac getMauSac() {
        return mauSac;
    }

    public void setMauSac(MauSac mauSac) {
        this.mauSac = mauSac;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }
    
    

    
    

}
