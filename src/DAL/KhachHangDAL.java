/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Entity.KhachHang;
import GUI.Main;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Interface.Interface_KhachHang;

/**
 *
 * @author hieun
 */
public class KhachHangDAL extends DataAcessHelper implements Interface_KhachHang{
    
    
    
    @Override
    public List<KhachHang> getALLKhachHang() {
        getConnect();
        try {
            List<KhachHang> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(GET_ALLKHACHHANG);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new KhachHang(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public void UpdateKH(int maKH, String tenKH, String diaChi, String gioiTinh, String sdt, int maloaikhachhang) {
        getConnect();
        try {
            PreparedStatement ps = con.prepareStatement(GET_UPDATEKHACHHANG);
            ps.setString(1, tenKH);
            ps.setString(2, gioiTinh);
            ps.setString(3, diaChi);
            ps.setString(4, sdt);
            ps.setInt(5, maloaikhachhang);
            ps.setInt(6, maKH);
            ps.executeUpdate();

            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    @Override
    public List<KhachHang> GetALLSDT(String SDT) {
        getConnect();
        try {
            List<KhachHang> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(GET_SEARCHSDT);
            ps.setString(1,"%" + SDT + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new KhachHang(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
            }
            getClose();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<KhachHang> GetALLTenKhachHang(String TenKH) {
        getConnect();
        try {
            List<KhachHang> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(GET_SEARCHKHACHHANG);
            ps.setString(1,"%" + TenKH + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new KhachHang(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
            }
            getClose();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    @Override
    public void AddKH(String tenKH, String diaChi, String gioiTinh, String sdt, int maloaikhachhang) {                  
        
        List<KhachHang> addkh = getALLKhachHang();
        try{
                int makhachhang = addkh.size() + 1;
                PreparedStatement ps = con.prepareStatement(GET_ADDKH);
                ps.setInt(1, makhachhang);
                ps.setString(2, tenKH);
                ps.setString(3, diaChi);
                ps.setString(4, gioiTinh);
                ps.setString(5, sdt);
                ps.setInt(6, maloaikhachhang);
                ps.executeUpdate();               
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public int deleteKH(int maKH) {
        getConnect();
        int row = 0;
            try {
            PreparedStatement ps_Check = con.prepareStatement(GET_CheckKNKH);
            ps_Check.setInt(1, maKH);
            ResultSet rs = ps_Check.executeQuery();
            StringBuilder sb = new StringBuilder();
            if (rs.next()) {
                sb.append("khách hàng đang đặt hàng, vui lòng thanh toán rồi xóa!!");
            }
            if (sb.length() > 0) {
                Main m = new Main();
                JOptionPane.showMessageDialog( m, sb.toString());
            }else{
            PreparedStatement ps = con.prepareStatement(GET_DELETEKHACHHANG);
            ps.setInt(1, maKH);
            row = ps.executeUpdate();
            }
            getClose();
            return row;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    @Override
    public String getTenKhachHang(String s) {
        String check ="";
        try {
            getConnect();

            PreparedStatement ps = con.prepareStatement(GET_CheckTENKH);
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
