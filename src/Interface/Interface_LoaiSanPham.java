/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Entity.LoaiSanPham;
import java.util.List;

/**
 *
 * @author hieun
 */
public interface Interface_LoaiSanPham {
    public final String GET_LOAISANPHAM = "select * from loaisanpham";
    public final String GET_TENLOAISANPHAM = "select tenloaisanpham from loaisanpham where maloaisanpham = ?";
    
    public List<LoaiSanPham> getALLLoaiSanPham();
    public String getTenLoaiKhachHang(String maLoaiSanPham);
}
