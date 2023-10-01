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
}
