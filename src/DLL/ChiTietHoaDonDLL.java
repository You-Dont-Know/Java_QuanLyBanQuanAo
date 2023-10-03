/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DLL;

import DAL.ChiTietHoaDonDAL;
import Entity.ChiTietHoaDon;
import java.util.List;

/**
 *
 * @author hieun
 */
public class ChiTietHoaDonDLL {
    ChiTietHoaDonDAL cchddal = new ChiTietHoaDonDAL();
    public List<ChiTietHoaDon> getALLChiTietHoaDon(){
        return cchddal.getALLChiTietHoaDon();
    }
    public List<ChiTietHoaDon> GetALLChiTietHoaDon(String soHD){
        return cchddal.GetALLChiTietHoaDon(soHD);
    }
    
    public void UpdateCTHD(String sohd, String masanpham, String sanpham, float dongia, int soluong, float tongtien){
        cchddal.UpdateCTHD(sohd, masanpham, sanpham, dongia, soluong, tongtien);
    }
    
    public int deleteCTHD(String maCTHD, String maSP){
      return cchddal.deleteCTHD(maCTHD, maSP);
    }
    
    public void AddCTHD(String sohd, String masanpham, String sanpham, float dongia, int soluong, float tongtien){
        cchddal.AddCTHD(sohd, masanpham, sanpham, dongia, soluong, tongtien);
    }
    
    
}
