/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Entity.SanPham;
import GUI.Main;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author hieun
 */
public class SanPhamDAL extends DataAcessHelper {

    private final String GET_ALLSANPHAM = "select * from sanpham";
    private final String GET_UPDATESP = "UPDATE SanPham SET tensanpham = ?, giasanpham = ?, motasanpham = ?, size = ?,ngaysanxuat = ?, soluong = ? WHERE masanpham = ?";
    private final String GET_SEARCHSP = "SELECT * FROM SanPham where tensanpham = ?";
    private final String GET_DELETESP = "DELETE from SanPham WHERE masanpham = ? ";
    private final String GET_ADDSP = "insert into sanpham(masanpham,tensanpham,giasanpham, motasanpham,size,ngaysanxuat,soluong ) values(?, ?, ?, ?, ?, ?, ?)";
    private final String GET_CheckSP = "select masanpham from sanpham where masanpham = ?";
    private final String GET_MASP = "SELECT masanpham from sanpham where motasanpham = ?";
    private final String GET_GIASP = "SELECT giasanpham from sanpham where motasanpham = ?";
    
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

    public List<SanPham> GetALLTenSanPham(String Tensp) {
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

    public int deleteSP(String maSP) {
        getConnect();
        int row;
        try {
            PreparedStatement ps = con.prepareStatement(GET_DELETESP);
            ps.setString(1, maSP);
            row = ps.executeUpdate();
            getClose();
            return row;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void AddSP(String maSP, String tenSP, float giaSP, String motaSP, String size, String date, int soLuong) {
        try {
            getConnect();
            PreparedStatement ps_Check = con.prepareStatement(GET_CheckSP);
            ps_Check.setString(1, maSP);
            ResultSet rs = ps_Check.executeQuery();
            StringBuffer sb = new StringBuffer();
            if (rs.next()) {
                sb.append("Khách Hàng đã tồn tại");
            }
            if (sb.length() > 0) {
                Main m = new Main();
                JOptionPane.showMessageDialog( m, sb.toString());
            } else {
                PreparedStatement ps = con.prepareStatement(GET_ADDSP);
                ps.setString(1, maSP);
                ps.setString(2, tenSP);
                ps.setFloat(3, giaSP);
                ps.setString(4, motaSP);
                ps.setString(5, size);
                ps.setString(6, date);
                ps.setInt(7, soLuong);
                ps.executeUpdate();
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String getMaSanPham(String s) {
        String check ="";
        try {
            getConnect();

            PreparedStatement ps = con.prepareStatement(GET_MASP);
            ps.setString(1, s);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null && rs.next()) { 
                
                check = rs.getString(1);
                
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
    
    public String getGiaSP(String s) {
        String check ="";
        try {
            getConnect();

            PreparedStatement ps = con.prepareStatement(GET_GIASP);
            ps.setString(1, s);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null && rs.next()) { 
                
                check = rs.getString(1);
                
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
}
