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
    public List<SanPham> getALLSanPham(){
        return spdal.getALLSanPham();
    }
    public void UpdateSP(String maSP, String tenSP, int maloaiSP, float giaNhap, float giaBan, String motaSP, String size, String date, int soLuong){
        spdal.UpdateSP(maSP, tenSP, maloaiSP, giaNhap, giaBan, motaSP, size, date, soLuong);
    }
    public void AddSP(String maSP, String tenSP, int maloaiSP, float giaNhap, float giaBan, String motaSP, String size, String date, int soLuong){
        spdal.AddSP(maSP, tenSP, maloaiSP, giaNhap, giaBan, motaSP, size, date, soLuong);
    }
    
    public List<SanPham> GetALLTenSanPham(String Tensp){
        return spdal.GetALLTenSanPham(Tensp);
    }
    
    public int deleteSP(String maSP){
        return spdal.deleteSP(maSP);
    }
    
    public String getMaSanPham(String s){
        return spdal.getMaSanPham(s);
    }
    
    public String getGiaSP(String s){
        return spdal.getGiaSP(s);
    }
    
    public List<SanPham> GetALLMaSanPham(String maSP){
        return spdal.GetALLMaSanPham(maSP);
    }
}
