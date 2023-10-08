/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DLL;

import DAL.LoaiKhachHangDAL;
import Entity.LoaiKhachHang;
import java.util.List;

/**
 *
 * @author hieun
 */
public class LoaiKhachHangDLL {
    LoaiKhachHangDAL lkhdal = new LoaiKhachHangDAL();
    public List<LoaiKhachHang> getALLLoaiKhachHang(){
        return lkhdal.getALLLoaiKhachHang();
    }
    public String getTenLoaiKhachHang(String maloaikhachhang){
        return lkhdal.getTenLoaiKhachHang(maloaikhachhang);
    }
}
