/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.imp;

import java.util.List;
import models.MucGiamGia;
import repositorys.MucGiamGiaRepository;
import service.MucGiamGiaService;

/**
 *
 * @author Acer
 */
public class MucGiamGiaServiceImpl implements MucGiamGiaService{
    private MucGiamGiaRepository MucGiamGiaRepository = new MucGiamGiaRepository();
    @Override
    public List<MucGiamGia> getAll() {
        return MucGiamGiaRepository.getAll();
    }

    @Override
    public MucGiamGia getOne(String id) {
        return MucGiamGiaRepository.getOne(id);
    }
    
}
