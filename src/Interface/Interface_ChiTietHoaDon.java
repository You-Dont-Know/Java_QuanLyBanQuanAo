/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Entity.ChiTietHoaDon;
import java.util.List;

/**
 *
 * @author hieun
 */
public interface Interface_ChiTietHoaDon {
    public final String GET_ALLCHITIETHOADON = "select * from cthoadon";
    public final String GET_SEARCHCTHD = "select masanpham,sanpham,dongia,soluong,tongtien from CTHoaDon where sohd=?";
    public final String GET_UPDATECTHD = "UPDATE CTHoaDon SET sanpham = ?, dongia = ?, soluong = ?, tongtien = ?  WHERE sohd = ? and masanpham= ?";
    public final String GET_DELETECTHOADON = "DELETE FROM CTHoaDon WHERE sohd = ? and masanpham = ?";
    public final String GET_ADDCTHD = "INSERT INTO CTHoaDon VALUES (?, ?, ?, ?, ?, ?)";
    
    
    public List<ChiTietHoaDon> getALLChiTietHoaDon();
    public List<ChiTietHoaDon> GetALLChiTietHoaDon(String soHD);
    public void UpdateCTHD(String sohd, String masanpham, String sanpham, float dongia, int soluong, float tongtien);
    public int deleteCTHD(String maCTHD, String maSP);
    public void AddCTHD(String sohd, String masanpham, String sanpham, float dongia, int soluong, float tongtien);
}
