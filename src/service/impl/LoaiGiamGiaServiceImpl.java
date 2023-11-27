/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import models.LoaiGiamGia;
import repository.LoaiGiamGiaRepository;

/**
 *
 * @author admin
 */
public class LoaiGiamGiaServiceImpl extends LoaiGiamGiaRepository{
    LoaiGiamGiaRepository repo = new LoaiGiamGiaRepository();
    
    public List<LoaiGiamGia> getAll() {
        return this.repo.getAll();
    }
    
    public LoaiGiamGia getOne(String id) {
        return this.repo.getOne(id);
    }
    
    public boolean add(LoaiGiamGia lgg) {
        return this.repo.add(lgg);
    }
    
    public boolean update(LoaiGiamGia lgg, int id) {
        return this.repo.update(lgg, id);
    }
    
    public boolean delete(String Ten) {
        return this.repo.delete(Ten);
    }
}
