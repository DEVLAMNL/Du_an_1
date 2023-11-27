/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import models.KhachHang;
import repository.KhachHangReponsitory;

/**
 *
 * @author admin
 */
public class KhachHangServiceImpl extends KhachHangReponsitory{
    
    KhachHangReponsitory repo = new KhachHangReponsitory();
    
    public ArrayList<KhachHang> getall() {
        return this.repo.getall();
    }
    
    public void insert(KhachHang b) {
        this.repo.insert(b);
    }
    
    public void delete(String id) {
        this.repo.delete(id);
    }
    
    public void update(String id, KhachHang b) {
        this.repo.update(id, b);
    }
}
