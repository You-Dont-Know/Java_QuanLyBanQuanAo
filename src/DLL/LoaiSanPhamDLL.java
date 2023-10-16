/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DLL;

import DAL.LoaiSanPhamDAL;
import Entity.LoaiSanPham;
import java.util.List;

/**
 *
 * @author hieun
 */
public class LoaiSanPhamDLL {
    LoaiSanPhamDAL lspdal = new LoaiSanPhamDAL();
     public List<LoaiSanPham> getALLLoaiSanPham(){
         return lspdal.getALLLoaiSanPham();
     }
     
     public String getTenLoaiKhachHang(String maLoaiSanPham){
         return lspdal.getTenLoaiKhachHang(maLoaiSanPham);
     }
     
     public void AddLSP(String tenLoaiSanPHam){
         lspdal.AddLSP(tenLoaiSanPHam);
     }
     public void UpdateLSP(int maLoaiSanPham, String tenLoaiSanPHam){
         lspdal.UpdateLSP(maLoaiSanPham, tenLoaiSanPHam);
     }
     
     public int deleteLSP(int maLoaiSanPham){
         return lspdal.deleteLSP(maLoaiSanPham);
     }
     
     public int getMaLoaiSanPham(String s){
         return lspdal.getMaLoaiSanPham(s);
     }
}
