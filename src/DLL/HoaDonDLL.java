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
    public List<HoaDon> getALL(){
        return hddal.getALL();
    }
    
    public void Update(HoaDon hd){
        hddal.Update(hd);
    }
    
    public int Delete(HoaDon hd){
        return hddal.Delete(hd);
    }
    
    public void Add(HoaDon hd){
        hddal.Add(hd);
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
