/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Entity.LoaiKhachHang;
import java.util.List;

/**
 *
 * @author hieun
 */
public interface Interface_LoaiKhachHang {
    public final String GET_LOAIKHACHHANG = "select * from loaikhachhang";
    public final String GET_TENLOAIKHACHHANG = "select tenloaikhachhang from loaikhachhang where maloaikhachhang = ?";
    
    public List<LoaiKhachHang> getALLLoaiKhachHang();
    public String getTenLoaiKhachHang(String maloaikhachhang);
}
