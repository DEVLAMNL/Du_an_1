/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
<<<<<<< HEAD
package models;
=======
package entity;
>>>>>>> 5b54ac0152933e4f0064ab38b0f34ada86e049f3

/**
 *
 * @author HP
 */
public class HangKhachHang {

    int IdHangKhachHang;
    String TenHangKhachHang;

    @Override
    public String toString() {
       return TenHangKhachHang;
    }
    

    public HangKhachHang() {
    }

<<<<<<< HEAD
    public HangKhachHang(String TenHangKhachHang) {
        this.TenHangKhachHang = TenHangKhachHang;
    }

=======
>>>>>>> 5b54ac0152933e4f0064ab38b0f34ada86e049f3
    public HangKhachHang(int IdHangKhachHang, String TenHangKhachHang) {
        this.IdHangKhachHang = IdHangKhachHang;
        this.TenHangKhachHang = TenHangKhachHang;
    }

    public int getIdHangKhachHang() {
        return IdHangKhachHang;
    }

    public void setIdHangKhachHang(int IdHangKhachHang) {
        this.IdHangKhachHang = IdHangKhachHang;
    }

    public String getTenHangKhachHang() {
        return TenHangKhachHang;
    }

    public void setTenHangKhachHang(String TenHangKhachHang) {
        this.TenHangKhachHang = TenHangKhachHang;
    }

   


    

}
