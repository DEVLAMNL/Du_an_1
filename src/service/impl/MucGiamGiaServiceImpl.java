/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import models.MucGiamGia;
import repository.MucGiamGiaRepository;

/**
 *
 * @author admin
 */
public class MucGiamGiaServiceImpl extends MucGiamGiaRepository{
    MucGiamGiaRepository repo = new MucGiamGiaRepository();
    
    public List<MucGiamGia> getAll() {
        return this.repo.getAll();
    }
    
    public MucGiamGia getOne(String id) {
        return this.repo.getOne(id);
    }
}
