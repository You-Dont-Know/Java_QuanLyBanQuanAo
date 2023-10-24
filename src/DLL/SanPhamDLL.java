/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DLL;

import Entity.SanPham;
import java.util.List;
import DAL.SanPhamDAL;
import java.util.Date;
/**
 *
 * @author hieun
 */
public class SanPhamDLL {
    SanPhamDAL spdal = new SanPhamDAL();
    public List<SanPham> getALL(){
        return spdal.getALL();
    }
    public void Update(SanPham sp){
        spdal.Update(sp);
    }
    public void Add(SanPham sp){
        spdal.Add(sp);
    }
    public int Delete(SanPham sp){
        return spdal.Delete(sp);
    }
    
    public List<SanPham> GetALLTenSanPham(String Tensp){
        return spdal.GetALLTenSanPham(Tensp);
    }
    
    
    
    public String getMaSanPham(String s){
        return spdal.getMaSanPham(s);
    }
    
    public String getGiaSP(String s){
        return spdal.getGiaSP(s);
    }
    public List<SanPham> GetALLLoaiSanPham(String Tenlsp){
        return spdal.GetALLLoaiSanPham(Tenlsp);
    }
    
    public List<SanPham> GetALLMaSanPham(String maSP){
        return spdal.GetALLMaSanPham(maSP);
    }
    public List<SanPham> getALLSanPham(String s){
        return spdal.getALLSanPham(s);
    }
    
    public float getGiaNhap(String s){
        return spdal.getGiaNhap(s);
    }
}
