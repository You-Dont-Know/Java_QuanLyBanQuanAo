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
    public void UpdateSP(String maSP, String tenSP, float giaSP, String motaSP, String size, String Date, int soLuong){
        spdal.UpdateSP(maSP, tenSP, giaSP, motaSP, size, Date, soLuong);
    }
    
    public List<SanPham> GetALLTenSanPham(String Tensp){
        return spdal.GetALLTenSanPham(Tensp);
    }
}
