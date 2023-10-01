/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DLL;

import DAL.NhanVienDAL;
import Entity.NhanVien;
import java.util.List;

/**
 *
 * @author hieun
 */
public class NhanVienDLL {

    NhanVienDAL nvdal = new NhanVienDAL();
    public List<NhanVien> getALLNhanvien() {
        return nvdal.getALLNhanvien();
    }
}
