/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import models.SanPhamChiTiet;
import repository.SanPhamChiTietRepository;

/**
 *
 * @author admin
 */
public class SanPhamChiTietServiceImpl extends SanPhamChiTietRepository{
    SanPhamChiTietRepository repo = new SanPhamChiTietRepository();
    
    public ArrayList<SanPhamChiTiet> getAllQLSanPhamCT() {
        return this.repo.getAllQLSanPhamCT();
    }
    
    public ArrayList<SanPhamChiTiet> getAllSanPhamCT(String maSP) {
        return this.repo.getAllSanPhamCT(maSP);
    }
    
    public void insertSanPhamCT(SanPhamChiTiet spct) {
        this.repo.insertSanPhamCT(spct);
    }
    
    public void updateSanPhamCT(int id, SanPhamChiTiet spct) {
        this.repo.updateSanPhamCT(id, spct);
    }
    
    public void deleteSanPhamCT(int id) {
        this.repo.deleteSanPhamCT(id);
    }
    
    public List<SanPhamChiTiet> searchSanPhamChiTiet(String searchCode) {
        return this.repo.searchSanPhamChiTiet(searchCode);
    }
}
