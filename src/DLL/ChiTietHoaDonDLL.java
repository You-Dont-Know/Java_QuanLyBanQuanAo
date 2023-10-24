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
    public List<ChiTietHoaDon> getALL(){
        return cchddal.getALL();
    }
    public List<ChiTietHoaDon> GetALLChiTietHoaDon(String soHD){
        return cchddal.GetALLChiTietHoaDon(soHD);
    }
    
    public void Update(ChiTietHoaDon cthd){
        cchddal.Update(cthd);
    }
    
    public int Delete(ChiTietHoaDon cthd){
      return cchddal.Delete(cthd);
    }
    
    public void Add(ChiTietHoaDon cthd){
        cchddal.Add(cthd);
    }
    
    public int getSumSoLuong(String maSP){
        return cchddal.getSumSoLuong(maSP);
    }
}
