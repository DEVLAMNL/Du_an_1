/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.imp;

import service.IHoaDon_Service;
import repositorys.HoaDonRepo;
import java.util.ArrayList;
import viewmodels.HoaDonViewModel;

/**
 *
 * @author Admin
 */
public class HoaDon_Service implements IHoaDon_Service {

    private HoaDonRepo rp = new HoaDonRepo();

    @Override
    public ArrayList<HoaDonViewModel> getAll() {
        return rp.getAll();
    }

    @Override
    public void insert(HoaDonViewModel hd) {
        rp.insert(hd);
    }

}
