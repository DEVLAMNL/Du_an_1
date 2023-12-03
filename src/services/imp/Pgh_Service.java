/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.imp;

//import services.imp.NhanVien_Service;
//import service.INhanVien_Service;
import service.Ipgh_Service;
import viewmodels.PhieuGiaoHang;
import repositorys.PhieugiaohangRepo;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Pgh_Service implements Ipgh_Service {

    private PhieugiaohangRepo Repo = new PhieugiaohangRepo();

//    @Override
//    public void Insert(PhieuGiaoHang pgh) {
//        Repo.insert(pgh);
//    }
//    
//    @Override
//    public void Update(String Id, PhieuGiaoHang pgh) {
//        Repo.update(Id, pgh);
//    }
//    
//    @Override
//    public void Delete(String Id) {
//        Repo.Delete(Id);
//    }
//    
    @Override
    public ArrayList<PhieuGiaoHang> getAll() {
        return Repo.getAll();
    }

//    @Override
//    public ArrayList<PhieuGiaoHang> findbyMa(String ma) {
//        return Repo.FindByMa(ma);
//    }
    @Override
    public void Insert(PhieuGiaoHang pgh) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Update(String Id, PhieuGiaoHang pgh) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Delete(String Id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<PhieuGiaoHang> findbyMa(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void main(String[] args) {
//        INhanVien_Service sv = new NhanVien_Service();
//        System.out.println(sv.getAll().toString());
    }
}
