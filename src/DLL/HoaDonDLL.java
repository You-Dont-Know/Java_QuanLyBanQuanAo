/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DLL;

import DAL.HoaDonDAL;
import Entity.HoaDon;
import java.util.List;
/**
 *
 * @author hieun
 */
public class HoaDonDLL {
    HoaDonDAL hddal = new HoaDonDAL();
    public List<HoaDon> getALLHoaDon(){
        return hddal.getALLHoaDon();
    }
    
    public void UpdateHD(String sohd, String ngaylap, String nhanvienlap, String makh, String manhanvien){
        hddal.UpdateHD(sohd, ngaylap, nhanvienlap, makh, manhanvien);
    }
    
    public int deleteHD(String maHD){
        return hddal.deleteHD(maHD);
    }
    
    public void AddHD(String sohd, String ngaylap, String nhanvienlap, String makh, String manhanvien){
        hddal.AddHD(sohd, ngaylap, nhanvienlap, makh, manhanvien);
    }
    
    public String getNgayLap(String s){
        return hddal.getNgayLap(s);
    }
    
    public String getNhanVienLap(String s){
        return hddal.getNhanVienLap(s);
    }
    
    public String getMaNhanVien(String s){
        return hddal.getMaNhanVien(s);
    }
    
    public String getMaKhachHang(String s){
        return hddal.getMaKhachHang(s);
    }
}
