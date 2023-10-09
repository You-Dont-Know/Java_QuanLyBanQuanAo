/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Entity.HoaDon;
import java.util.List;

/**
 *
 * @author hieun
 */
public interface Interface_HoaDon {
    public final String GET_ALLHOADON = "select * from hoadon";
    public final String GET_CHECKHD ="select sohd from hoadon where sohd = ?";
    public final String GET_UPDATEHD = "UPDATE HoaDon SET ngaylap = ?, nhanvienlap = ?, makh = ?, manhanvien = ? WHERE sohd = ?";
    public final String GET_DELETEHOADON = "DELETE FROM HoaDon WHERE sohd = ?";
    public final String GET_ADDHD = "INSERT INTO HoaDon VALUES (?, ?, ?, ?, ?)";
    public final String GET_NGAYLAP = "SELECT ngaylap from hoadon where sohd = ?";
    public final String GET_NHANVIENLAP = "select nhanvienlap from hoadon where sohd = ?";
    public final String GET_MANHANVIEN = "select manhanvien from hoadon where sohd = ?";
    public final String GET_MAKHACHHANG = "select makh from hoadon where sohd = ?";
    public final String GET_TENKHACHHANG = "select tenkhachhang from hoadon where sohd = ?";
    
    public List<HoaDon> getALLHoaDon();
    public void UpdateHD(String sohd, String ngaylap, String nhanvienlap, String makh, String manhanvien);
    public int deleteHD(String maHD);
    public void AddHD(String sohd, String ngaylap, String nhanvienlap, String makh, String manhanvien);
    public String getNgayLap(String s);
    public String getNhanVienLap(String s);
    public String getMaNhanVien(String s);
    public String getMaKhachHang(String s);   
}
