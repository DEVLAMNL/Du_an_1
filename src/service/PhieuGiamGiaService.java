/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import models.PhieuGiamGia;

/**
 *
 * @author Acer
 */
public interface PhieuGiamGiaService {
    List<PhieuGiamGia> getAll();
    
    String add(PhieuGiamGia pgg);
    
    List<PhieuGiamGia> searchBy(List<PhieuGiamGia> listpgg, String ma);
    
    String delete(String MaPhieu);
    
    String update(PhieuGiamGia pgg, String MaPhieu);
}
