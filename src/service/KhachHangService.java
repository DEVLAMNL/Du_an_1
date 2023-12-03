/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import models.KhachHang;

/**
 *
 * @author Admin
 */
public interface KhachHangService {

    public void insert(KhachHang kh);

    public void update(int id, KhachHang kh);

    public void delete(int id);

    public ArrayList<KhachHang> getall();

    public ArrayList<KhachHang> search(String key);
}
