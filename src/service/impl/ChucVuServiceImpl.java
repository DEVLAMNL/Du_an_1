/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import model.ChucVu;
import repository.ChucVuRepository;

/**
 *
 * @author admin
 */
public class ChucVuServiceImpl extends ChucVuRepository{
    
    ChucVuRepository repo = new ChucVuRepository();
    
    public ArrayList<ChucVu> finALL() {
        return this.repo.finALL();
    }
    
    public boolean insert(ChucVu cv) {
        return this.repo.insert(cv);
    }
    
    public void delete(int id) {
        this.repo.delete(id);
    }
    
    public void update(ChucVu cv, int id) {
        this.repo.update(cv, id);
    }
}
