/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import models.KichThuoc;
import repository.KichThuocRepository;

/**
 *
 * @author admin
 */
public class KichThuocServiceImpl extends KichThuocRepository{
    KichThuocRepository repo = new KichThuocRepository();
    
    public ArrayList<KichThuoc> getAllKichThuoc() {
        return this.repo.getAllKichThuoc();
    }
    
    public void insertKichThuoc(KichThuoc kt) {
        this.repo.insertKichThuoc(kt);
    }
    
    public void updateKichThuoc(int id, KichThuoc kt) {
        this.repo.updateKichThuoc(id, kt);
    }
    
    public void deleteKichThuoc(int id) {
        this.repo.deleteKichThuoc(id);
    }
}
