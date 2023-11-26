
package services.imp;

import java.util.ArrayList;
import entity.HangKhachHang;

import repositorys.LoaiKhachHangReponsitory;


public class LoaiKhachHangService {
    private LoaiKhachHangReponsitory lkhrepon ;
    public LoaiKhachHangService() {
        this.lkhrepon = new LoaiKhachHangReponsitory();
    }
    public ArrayList<HangKhachHang> getall() {
        return this.lkhrepon.all();
    }
    
    
}
