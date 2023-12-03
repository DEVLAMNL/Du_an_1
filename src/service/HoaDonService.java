/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
<<<<<<<< HEAD:src/service/HoaDonService.java
import models.HoaDon;
========
import viewmodels.HoaDonViewModel;
>>>>>>>> 5b54ac0152933e4f0064ab38b0f34ada86e049f3:src/service/IHoaDon_Service.java

/**
 *
 * @author Admin
 */
<<<<<<<< HEAD:src/service/HoaDonService.java
public interface HoaDonService {

    public ArrayList<HoaDon> getAllHD();

    public void insert(HoaDon hd);
========
public interface IHoaDon_Service {

    public ArrayList<HoaDonViewModel> getAll();

    public void insert(HoaDonViewModel hd);
>>>>>>>> 5b54ac0152933e4f0064ab38b0f34ada86e049f3:src/service/IHoaDon_Service.java
}
