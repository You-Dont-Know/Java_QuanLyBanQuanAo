/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;
import Entity.ThongKe;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ThongKeDAL extends DataAcessHelper{
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

    public List<ThongKe> getALLThongke() {
        getConnect();
        try {
            List<ThongKe> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(GET_TABLEALLTHONGKE);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ThongKe(rs.getDate(1), rs.getInt(2), rs.getFloat(3), rs.getString(4), rs.getString(5)));
            }
            getClose();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ThongKe> getALLThongkeByDate(String Date1, String Date2) {
        getConnect();
        try {
            List<ThongKe> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(GET_TABLETHONGKE);
            ps.setString(1, Date1);
            ps.setString(2, Date2);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ThongKe(rs.getDate(1), rs.getInt(2), rs.getFloat(3), rs.getString(4), rs.getString(5)));
            }
            getClose();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    

    public List<ThongKe> getALLThongkeByName(String Name) {
        getConnect();
        try {
            List<ThongKe> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(GET_TABLETHONGKEBYNAME);
            ps.setString(1, Name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ThongKe(rs.getDate(1), 
                        rs.getString(2), 
                        rs.getInt(3), 
                        rs.getFloat(4), 
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7), 
                        rs.getFloat(8), 
                        rs.getInt(9)));
            }
            getClose();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    } 
}
