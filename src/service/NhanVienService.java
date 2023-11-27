/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;


import java.util.ArrayList;
import models.NhanVien;


/**
 *
 * @author MSI Laptop
 */
public interface NhanVienService {
    
    public ArrayList<NhanVien> getAllNhanVien();
    
    public void insertNhanVien(NhanVien nv);
    
    public void updateNhanVien(int id, NhanVien nv);

    public void deleteNhanVien(int id);
    
    public ArrayList<NhanVien> timKiem(int ma);
    
    public ArrayList<NhanVien> Loc(String condition);
}
