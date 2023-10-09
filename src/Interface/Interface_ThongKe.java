/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Entity.ThongKe;
import java.util.List;

/**
 *
 * @author hieun
 */
public interface Interface_ThongKe {
    
    public final String GET_TABLEALLTHONGKE = "SELECT  hd.NgayLap, COUNT(hd.SoHD) AS TongSosanPham,SUM(ct.TongTien) AS TongTien,nv.MaNhanVien,nv.TenNhanVien AS NhanVienLapHoaDon FROM hoadon hd \n" +
                                            "JOIN cthoadon ct ON hd.SoHD = ct.SoHD\n" +
                                            "JOIN nhanvien nv ON hd.MaNhanVien = nv.MaNhanVien\n" +
                                            "GROUP BY \n" +
                                            "    hd.NgayLap, nv.MaNhanVien, nv.TenNhanVien\n" +
                                            "ORDER BY \n" +
                                            "    hd.NgayLap;";
    
    public final String GET_TABLETHONGKE = "SELECT  hd.NgayLap, COUNT(hd.SoHD) AS TongSosanPham,SUM(ct.TongTien) AS TongTien,nv.MaNhanVien,nv.TenNhanVien AS NhanVienLapHoaDon FROM hoadon hd \n" +
                                            "JOIN cthoadon ct ON hd.SoHD = ct.SoHD\n" +
                                            "JOIN nhanvien nv ON hd.MaNhanVien = nv.MaNhanVien\n" +
                                            "	where hd.ngaylap >= ? and hd.ngaylap <= ?\n" +
                                            "GROUP BY \n" +
                                            "    hd.NgayLap, nv.MaNhanVien, nv.TenNhanVien\n" +
                                            "ORDER BY \n" +
                                            "    hd.NgayLap;";
    
    public final String GET_TABLETHONGKEBYNAME = "SELECT hd.NgayLap, hd.SoHD,COUNT(hd.SoHD) AS TongSoHoaDon,SUM(ct.TongTien) AS TongTien,nv.MaNhanVien,nv.TenNhanVien AS NhanVienLapHoaDon,sp.TenSanPham AS SanPham,ct.DonGia,ct.SoLuong\n" +
                                                    "FROM hoadon hd	\n" +
                                                    "JOIN cthoadon ct ON hd.SoHD = ct.SoHD JOIN nhanvien nv ON hd.MaNhanVien = nv.MaNhanVien JOIN sanpham sp ON ct.MaSanPham = sp.MaSanPham\n" +
                                                    "where nv.tennhanvien = ?\n" +
                                                    "GROUP BY hd.NgayLap, hd.SoHD, nv.MaNhanVien, nv.TenNhanVien, sp.TenSanPham, ct.DonGia, ct.SoLuong\n" +
                                                    "ORDER BY hd.NgayLap;";
    
    
    
    public List<ThongKe> getALLThongkeByDate(String Date1, String Date2);
    public List<ThongKe> getALLThongke();
    public List<ThongKe> getALLThongkeByName(String Name);
}
