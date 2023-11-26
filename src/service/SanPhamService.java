/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import models.SanPham;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public interface SanPhamService {
    public ArrayList<SanPham> getAllSanPham();
    
    public void insertSanPham(SanPham sp);

    public void updateSanPham(String id, SanPham sp);

    public void deleteSanPham(String id);
    
    public List<SanPham> searchSanPham(String code);
}
