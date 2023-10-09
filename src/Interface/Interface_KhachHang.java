/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Entity.KhachHang;
import java.util.List;

/**
 *
 * @author hieun
 */
public interface Interface_KhachHang {
    
    public final String GET_ALLKHACHHANG = "select * from khachhang";
    public final String GET_UPDATEKHACHHANG = "UPDATE khachhang SET tenkhach = ?, gioitinh = ?, diachi = ?, sdt = ?, maloaikhachhang = ? WHERE makh= ?";
    public final String GET_SEARCHKHACHHANG = "SELECT * FROM KhachHang where tenkhach like ?";
    public final String GET_SEARCHSDT = "SELECT * FROM KhachHang where sdt like ?";   
    public final String GET_DELETEKHACHHANG = "DELETE from KhachHang WHERE makh = ? ";
    public final String GET_ADDKH = "INSERT INTO Khachhang VALUES (?,?, ?, ?, ?, ?)";
    public final String GET_CheckKNKH ="select makh from hoadon where makh = ?";
    public final String GET_CheckTENKH ="select tenkhach from khachhang where makh = ?";
    
    
    public List<KhachHang> getALLKhachHang();
    public void UpdateKH(int maKH, String tenKH, String diaChi, String gioiTinh, String sdt, int maloaikhachhang);
    public List<KhachHang> GetALLSDT(String SDT);
    public List<KhachHang> GetALLTenKhachHang(String TenKH);
    public void AddKH(String tenKH, String diaChi, String gioiTinh, String sdt, int maloaikhachhang);
    public int deleteKH(int maKH);
    public String getTenKhachHang(String s);
}
