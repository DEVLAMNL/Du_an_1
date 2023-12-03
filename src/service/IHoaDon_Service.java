/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import viewmodels.HoaDonViewModel;

/**
 *
 * @author Admin
 */
public interface IHoaDon_Service {

    public ArrayList<HoaDonViewModel> getAll();

    public void insert(HoaDonViewModel hd);
}
