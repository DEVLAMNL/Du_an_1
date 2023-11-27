/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import models.SanPham;
import repository.SanPhamRepository;

/**
 *
 * @author admin
 */
public class SanPhamServiceImpl extends SanPhamRepository{
    SanPhamRepository repo = new SanPhamRepository();
    
    public ArrayList<SanPham> getAllSanPham() {
        return this.repo.getAllSanPham();
    }
    
    public List<SanPham> searchSanPham(String code) {
        return this.repo.searchSanPham(code);
    }
    
    public void insertSanPham(SanPham sp) {
        this.repo.insertSanPham(sp);
    }
    
    public void updateSanPham(String id, SanPham sp) {
        this.repo.updateSanPham(id, sp);
    }
    
    public void deleteSanPham(String id) {
        this.repo.deleteSanPham(id);
    }
}
