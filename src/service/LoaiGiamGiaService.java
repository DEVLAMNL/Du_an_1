/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import models.LoaiGiamGia;
import models.PhieuGiamGia;

/**
 *
 * @author Acer
 */
public interface LoaiGiamGiaService {
    List<LoaiGiamGia> getAll();
    
    LoaiGiamGia getOne(String id);
    
    public boolean add(LoaiGiamGia lgg);
    
    public boolean update(LoaiGiamGia lgg, int id);
    
    public boolean delete(String Ten);
    
//    List<LoaiGiamGia> searchByName(List<LoaiGiamGia> lgg, String name);
}
