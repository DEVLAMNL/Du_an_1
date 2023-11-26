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
public class KhachhangViewModel {

    private int idKhachHang;
    private String Tenkhachhang;
    private String Diachi;
    private String Sdt;
    private Date NgayTao;

    public KhachhangViewModel() {
    }

    @Override
    public String toString() {
        return "Khachhang{" + "idKhachHang=" + idKhachHang + ", Tenkhachhang=" + Tenkhachhang + ", Diachi=" + Diachi + ", Sdt=" + Sdt + ", NgayTao=" + NgayTao + '}';
    }

    public KhachhangViewModel(int idKhachHang, String Tenkhachhang, String Diachi, String Sdt, Date NgayTao) {
        this.idKhachHang = idKhachHang;
        this.Tenkhachhang = Tenkhachhang;
        this.Diachi = Diachi;
        this.Sdt = Sdt;
        this.NgayTao = NgayTao;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public String getTenkhachhang() {
        return Tenkhachhang;
    }

    public void setTenkhachhang(String Tenkhachhang) {
        this.Tenkhachhang = Tenkhachhang;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

}
