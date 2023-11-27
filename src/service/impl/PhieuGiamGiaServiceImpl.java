/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import models.PhieuGiamGia;
import repository.PhieuGiamGiaRepository;

/**
 *
 * @author admin
 */
public class PhieuGiamGiaServiceImpl extends PhieuGiamGiaRepository{
    PhieuGiamGiaRepository repo = new PhieuGiamGiaRepository();
    
    public List<PhieuGiamGia> getAll() {
        return this.repo.getAll();
    }
    
    public boolean add(PhieuGiamGia pgg) {
        return this.repo.add(pgg);
    }
    
    public boolean update(PhieuGiamGia pgg, String MaPhieu) {
        return this.repo.update(pgg, MaPhieu);
    }
    
    public boolean delete(String MaPhieu) {
        return this.repo.delete(MaPhieu);
    }
}
