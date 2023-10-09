/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Entity.SanPham;
import java.util.List;

/**
 *
 * @author hieun
 */
public interface Interface_SanPham {
    
    
    public final String GET_ALLSANPHAM = "select * from sanpham";
    public final String GET_UPDATESP = "UPDATE SanPham SET tensanpham = ?, maloaisanpham = ?, gianhap = ?, giaban = ?, motasanpham = ?, size = ?,ngaysanxuat = ?, soluong = ? WHERE masanpham = ?";
    public final String GET_SEARCHSP = "SELECT * FROM SanPham where tensanpham like ? ";
    public final String GET_SEARCHMSP = "SELECT * FROM SanPham where masanpham like ?";    
    public final String GET_DELETESP = "DELETE from SanPham WHERE masanpham = ? ";
    public final String GET_ADDSP = "insert into sanpham(masanpham,tensanpham,maloaisanpham,gianhap, giaban, motasanpham,size,ngaysanxuat,soluong ) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public final String GET_CheckSP = "select masanpham from sanpham where masanpham = ?";
    public final String GET_MASP = "SELECT masanpham from sanpham where motasanpham = ?";
    public final String GET_GIASP = "SELECT giaban from sanpham where motasanpham = ?";
    
    public List<SanPham> getALLSanPham();
    public void UpdateSP(String maSP, String tenSP, int maLoaiSP, float giaNhap, float giaBan, String motaSP, String size, String date, int soLuong);
    public List<SanPham> GetALLTenSanPham(String Tensp);
    public List<SanPham> GetALLMaSanPham(String maSP);
    public int deleteSP(String maSP);
    public void AddSP(String maSP, String tenSP, int maloaiSP, float giaNhap, float giaBan, String motaSP, String size, String date, int soLuong);
    public String getMaSanPham(String s);
    public String getGiaSP(String s);
}
