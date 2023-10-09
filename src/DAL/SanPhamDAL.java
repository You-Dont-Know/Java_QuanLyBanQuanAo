/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;
import Interface.Interface_SanPham;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Entity.SanPham;
import GUI.Main;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import Interface.Interface_SanPham;


public class SanPhamDAL extends DataAcessHelper implements Interface_SanPham{

    
    
    @Override
    public List<SanPham> getALLSanPham() {
        getConnect();
        try {
            List<SanPham> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(GET_ALLSANPHAM);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new SanPham(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getFloat(4),
                        rs.getFloat(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getDate(8),
                        rs.getInt(9)));
            }
            getClose();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void UpdateSP(String maSP, String tenSP, int maLoaiSP, float giaNhap, float giaBan, String motaSP, String size, String date, int soLuong) {
        getConnect();
        try {
            PreparedStatement ps = con.prepareStatement(GET_UPDATESP);
            ps.setString(1, tenSP);
            ps.setInt(2, maLoaiSP);
            ps.setFloat(3, giaNhap);
            ps.setFloat(4, giaBan);           
            ps.setString(5, motaSP);
            ps.setString(6, size);
            ps.setString(7, date);
            ps.setInt(8, soLuong);
            ps.setString(9, maSP);
            ps.executeUpdate();

            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<SanPham> GetALLTenSanPham(String Tensp) {
        getConnect();
        try {
            List<SanPham> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(GET_SEARCHSP);
            ps.setString(1,"%"+ Tensp +"%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new SanPham(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getFloat(4),
                        rs.getFloat(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getDate(8),
                        rs.getInt(9)));
            }
            getClose();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public List<SanPham> GetALLMaSanPham(String maSP) {
        getConnect();
        try {
            List<SanPham> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(GET_SEARCHMSP);
            ps.setString(1,"%"+ maSP +"%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new SanPham(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getFloat(4),
                        rs.getFloat(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getDate(8),
                        rs.getInt(9)));
            }
            getClose();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
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

    @Override
    public void AddSP(String maSP, String tenSP, int maloaiSP, float giaNhap, float giaBan, String motaSP, String size, String date, int soLuong) {
        try {
            getConnect();
            PreparedStatement ps_Check = con.prepareStatement(GET_CheckSP);
            ps_Check.setString(1, maSP);
            ResultSet rs = ps_Check.executeQuery();
            StringBuffer sb = new StringBuffer();
            if (rs.next()) {
                sb.append("Mã sản phẩm đã tồn tại");
            }
            if (sb.length() > 0) {
                Main m = new Main();
                JOptionPane.showMessageDialog( m, sb.toString());
            } else {
                PreparedStatement ps = con.prepareStatement(GET_ADDSP);
                ps.setString(1, maSP);
                ps.setString(2, tenSP);
                ps.setInt(3, maloaiSP);
                ps.setFloat(4, giaNhap);
                ps.setFloat(5, giaBan);
                ps.setString(6, motaSP);
                ps.setString(7, size);
                ps.setString(8, date);
                ps.setInt(9, soLuong);
                ps.executeUpdate();
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
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
    
    @Override
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
