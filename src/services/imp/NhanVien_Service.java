/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.imp;

import service.INhanVien_Service;
import viewmodels.NhanVien;
import repositorys.NhanVienRepo;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class NhanVien_Service implements INhanVien_Service {

    private static NhanVienRepo repo = new NhanVienRepo();

    @Override
    public void Insert(NhanVien nv) {
        repo.insert(nv);
    }

    @Override
    public void Update(String Id, NhanVien nv) {
        repo.update(Id, nv);
    }

    @Override
    public void Delete(String Id) {
        repo.Delete(Id);
    }

    @Override
    public ArrayList<NhanVien> getAll() {
        return repo.getAll();
    }

}
