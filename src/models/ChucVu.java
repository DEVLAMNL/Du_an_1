/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
<<<<<<< HEAD
package models;
=======
package model;
>>>>>>> 5b54ac0152933e4f0064ab38b0f34ada86e049f3

/**
 *
 * @author LEGION
 */
public class ChucVu {
    private int IdChucVu;
    private String TenChucVu;

<<<<<<< HEAD
    public ChucVu(String TenChucVu) {
        this.TenChucVu = TenChucVu;
    }

    public ChucVu() {
    }

    
=======
>>>>>>> 5b54ac0152933e4f0064ab38b0f34ada86e049f3
    public ChucVu(int IdChucVu, String TenChucVu) {
        this.IdChucVu = IdChucVu;
        this.TenChucVu = TenChucVu;
    }

    public int getIdChucVu() {
        return IdChucVu;
    }

    public void setIdChucVu(int IdChucVu) {
        this.IdChucVu = IdChucVu;
    }

    public String getTenChucVu() {
        return TenChucVu;
    }

    public void setTenChucVu(String TenChucVu) {
        this.TenChucVu = TenChucVu;
    }
}
