/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import models.HoaDonChiTiet;
import models.PhieuDoi;
import models.SanPhamChiTiet;
import repository.PhieuDoiRepository;

/**
 *
 * @author admin
 */
public class PhieuDoiServiceImpl extends PhieuDoiRepository{
    PhieuDoiRepository repo = new PhieuDoiRepository();
    
    public List<HoaDonChiTiet> searchHDCT(String ma) {
        return this.repo.searchHDCT(ma);
    }
    
    public ArrayList<HoaDonChiTiet> getAllHDCT() {
        return this.repo.getAllHDCT();
    }
    
    public ArrayList<SanPhamChiTiet> getAllCTSP(String maSPCT) {
        return this.repo.getAllCTSP(maSPCT);
    }
    
    public void add(PhieuDoi pd) {
        this.repo.add(pd);
    }
    
    public void update(int id, PhieuDoi pd) {
        this.repo.update(id, pd);
    }
    
    public void deleete(int id) {
        this.repo.deleete(id);
    }
    
    public ArrayList<PhieuDoi> getAllPD() {
        return this.repo.getAllPD();
    }
}
