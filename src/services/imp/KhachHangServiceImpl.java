package services.imp;

import java.util.ArrayList;
import models.KhachHang;

import repositorys.KhachHangReponsitory;
import service.KhachHangService;

public class KhachHangServiceImpl implements KhachHangService {

    private KhachHangReponsitory KhachHangRepo;

    @Override
    public void insert(KhachHang kh) {
        this.KhachHangRepo.insert(kh);
    }

    @Override
    public void update(String id, KhachHang kh) {
        this.KhachHangRepo.update(id, kh);
    }

    @Override
    public void delete(String id) {
        this.KhachHangRepo.delete(id);
    }

    @Override
    public ArrayList<KhachHang> getall() {
        return this.KhachHangRepo.getall();
    }

    @Override
    public ArrayList<KhachHang> search(String key) {
    return this.KhachHangRepo.search(key);
    }

}
