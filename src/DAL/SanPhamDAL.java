/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Entity.SanPham;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author hieun
 */
public class SanPhamDAL extends DataAcessHelper {

    private final String GET_ALLSANPHAM = "select * from sanpham";
    private final String GET_UPDATESP = "UPDATE SanPham SET tensanpham = ?, giasanpham = ?, motasanpham = ?, size = ?,ngaysanxuat = ?, soluong = ? WHERE masanpham = ?";
    private final String GET_SEARCHSP = "SELECT * FROM SanPham where tensanpham = ?";
    public List<SanPham> getALLSanPham() {
        getConnect();
        try {
            List<SanPham> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(GET_ALLSANPHAM);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new SanPham(rs.getString(1),
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getInt(7)));
            }
            
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void UpdateSP(String maSP, String tenSP, float giaSP, String motaSP, String size, String date, int soLuong) {
        getConnect();
        try {
            PreparedStatement ps = con.prepareStatement(GET_UPDATESP);
            ps.setString(1, tenSP);
            ps.setFloat(2, giaSP);           
            ps.setString(3, motaSP);
            ps.setString(4, size);
            ps.setString(5, date);
            ps.setInt(6, soLuong);
            ps.setString(7, maSP);
            ps.executeUpdate();
        getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public List<SanPham> GetALLTenSanPham(String Tensp){
        getConnect();
        try {
            List<SanPham> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(GET_SEARCHSP);
            ps.setString(1, Tensp);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new SanPham(rs.getString(1),
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getInt(7)));
            }
            getClose();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
