/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import models.HoaDon;
import repository.HoaDonRepository;

/**
 *
 * @author admin
 */
public class HoaDonServiceImpl extends HoaDonRepository{
    HoaDonRepository repo = new HoaDonRepository();
    
    public ArrayList<HoaDon> getAll(){
        return this.repo.getAll();
    }
    
    public void insert(HoaDon hd) {
        this.repo.insert(hd);
    }
}
