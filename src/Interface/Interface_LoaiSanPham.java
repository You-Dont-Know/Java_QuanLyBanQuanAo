/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Entity.LoaiSanPham;
import java.util.List;

/**
 *
 * @author kien
 */
public interface Interface_LoaiSanPham {
    public final String GET_LOAISANPHAM = "select * from loaisanpham";
    public final String GET_TENLOAISANPHAM = "select tenloaisanpham from loaisanpham where maloaisanpham = ?";
        
    public final String GET_ADDLOAISANPHAM = "INSERT INTO loaisanpham VALUES (?,?)";
    public final String GET_UPDATELOAISANPHAM = "UPDATE loaisanpham SET tenloaisanpham = ? WHERE maloaisanpham= ?";
    public final String GET_DELETELOAISANPHAM = "DELETE FROM loaisanpham WHERE maloaisanpham = ?";
    public final String GET_MALSP = "SELECT maloaisanpham from loaisanpham where tenloaisanpham = ?";
    
    public List<LoaiSanPham> getALLLoaiSanPham();
    public String getTenLoaiKhachHang(String maLoaiSanPham);
    
    public void AddLSP(String tenLoaiSanPHam);
    public void UpdateLSP(int maLoaiSanPham, String tenLoaiSanPHam);
    public int deleteLSP(int maLoaiSanPham);
    public int getMaLoaiSanPham(String s);
}
