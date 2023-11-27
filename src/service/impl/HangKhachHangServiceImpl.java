/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import models.HangKhachHang;
import repository.HangKhachHangReponsitory;

/**
 *
 * @author admin
 */
public class HangKhachHangServiceImpl extends HangKhachHangReponsitory{
    HangKhachHangReponsitory repo = new HangKhachHangReponsitory();
    
    public ArrayList<HangKhachHang> all() {
        return this.repo.all();
    }
}
