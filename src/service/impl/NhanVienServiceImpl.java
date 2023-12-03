/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import models.NhanVien;
import repository.NhanVienRepository;

/**
 *
 * @author admin
 */
public class NhanVienServiceImpl extends NhanVienRepository{
    
    NhanVienRepository repo = new NhanVienRepository();
    
    public ArrayList<NhanVien> getAllNhanVien() {
        return this.repo.getAllNhanVien();
    }
    
    public boolean insertNhanVien(NhanVien nv) {
        return this.repo.insertNhanVien(nv);
    }
    
    public boolean deleteNhanVien(int id) {
        return this.repo.deleteNhanVien(id);
    }
    
    public boolean updateNhanVien(int id, NhanVien nv) {
        return this.repo.updateNhanVien(id, nv);
    }
    
    public ArrayList<NhanVien> timKiem(int ma) {
        return this.repo.timKiem(ma);
    }
    
    public ArrayList<NhanVien> Loc(String condition) {
        return this.repo.Loc(condition);
    }
}
