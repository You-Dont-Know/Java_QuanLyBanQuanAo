/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DLL;

import DAL.KhachHangDAL;
import Entity.KhachHang;
import java.util.List;
/**
 *
 * @author hieun
 */
public class KhachHangDLL {
    KhachHangDAL khdal = new KhachHangDAL();
    public List<KhachHang> getALLKhachHang(){
        return khdal.getALLKhachHang();
    }
    public List<KhachHang> GetALLTenKhachHang(String TenKH){
        return khdal.GetALLTenKhachHang(TenKH);
    }
    
    public void UpdateKH(int maKH, String tenKH, String diaChi, String gioiTinh, String sdt){
        khdal.UpdateKH(maKH, tenKH, diaChi, gioiTinh, sdt);
    }
    
    public int deleteKH(int maKH){
        return khdal.deleteKH(maKH);
    }
    
    public void AddKH(String tenKH, String diaChi, String gioiTinh, String sdt){
        khdal.AddKH(tenKH, diaChi, gioiTinh, sdt);
    }
}
