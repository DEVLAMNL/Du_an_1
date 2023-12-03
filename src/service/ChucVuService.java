/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import models.ChucVu;

/**
 *
 * @author admin
 */
public interface ChucVuService {
    public ArrayList<ChucVu> finALL();
    public boolean insert(ChucVu cv);
    public void delete(int id);
    public void update(ChucVu cv, int id);
}
