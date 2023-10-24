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
    public List<NhanVien> getALL() {
        return nvdal.getALL();
    }
    
    public void Add(NhanVien nv){
        nvdal.Add(nv);
    }
    
    public void Update(NhanVien nv){
        nvdal.Update(nv);
    }
    
    public int Delete(NhanVien nv){
        return nvdal.Delete(nv);
    }
    
    
    
    public List<NhanVien> getMnsTnv(String tenDangNhap){
        return nvdal.getMnsTnv(tenDangNhap);
    }
}
