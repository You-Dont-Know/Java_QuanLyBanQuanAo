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
     public List<LoaiSanPham> getALL(){
         return lspdal.getALL();
     }
     
     public String getTenLoaiKhachHang(String maLoaiSanPham){
         return lspdal.getTenLoaiKhachHang(maLoaiSanPham);
     }
     
     public void Add(LoaiSanPham LSP){
         lspdal.Add(LSP);
     }
     public void Update(LoaiSanPham LSP){
         lspdal.Update(LSP);
     }
     
     public int Delete(LoaiSanPham LSP){
         return lspdal.Delete(LSP);
     }
     
     public int getMaLoaiSanPham(String s){
         return lspdal.getMaLoaiSanPham(s);
     }
}
