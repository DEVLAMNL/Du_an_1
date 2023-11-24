/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import viewmodels.NhanVien;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface INhanVien_Service  {
    
    public void Insert(NhanVien nv);

    public void Update(String Id,  NhanVien nv);

    public void Delete(String Id);

    public ArrayList<NhanVien> getAll();

}
