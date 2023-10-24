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
    public List<KhachHang> getALL(){
        return khdal.getALL();
    }
    public List<KhachHang> GetALLTenKhachHang(String TenKH){
        return khdal.GetALLTenKhachHang(TenKH);
    }
    
    public void Update(KhachHang kh){
        khdal.Update(kh);
    }
    
    public int Delete(KhachHang kh){
        return khdal.Delete(kh);
    }
    
    public void Add(KhachHang kh){
        khdal.Add(kh);
    }
    
    public List<KhachHang> GetALLSDT(String SDT){
        return khdal.GetALLSDT(SDT);
    }
    
    public String getTenKhachHang(String s){
        return khdal.getTenKhachHang(s);
    }
}
