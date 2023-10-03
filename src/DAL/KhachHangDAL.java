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

/**
 *
 * @author hieun
 */
public class KhachHangDAL extends DataAcessHelper {

    private final String GET_ALLKHACHHANG = "select * from khachhang";
    private final String GET_UPDATEKHACHHANG = "UPDATE khachhang SET tenkhach = ?, gioitinh = ?, diachi = ?, sdt = ? WHERE makh= ?";
    private final String GET_SEARCHKHACHHANG = "SELECT * FROM KhachHang where tenkhach = ?";
    private final String GET_DELETEKHACHHANG = "DELETE from KhachHang WHERE makh = ? ";
    private final String GET_ADDKH = "INSERT INTO Khachhang VALUES (?, ?, ?, ?)";
    private final String GET_CheckKNKH ="select count(*) from hoadon where makh= ?";
    public List<KhachHang> getALLKhachHang() {
        getConnect();
        try {
            List<KhachHang> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(GET_ALLKHACHHANG);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new KhachHang(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void UpdateKH(int maKH, String tenKH, String diaChi, String gioiTinh, String sdt) {
        getConnect();
        try {
            PreparedStatement ps = con.prepareStatement(GET_UPDATEKHACHHANG);
            ps.setString(1, tenKH);
            ps.setString(2, gioiTinh);
            ps.setString(3, diaChi);
            ps.setString(4, sdt);
            ps.setInt(5, maKH);
            ps.executeUpdate();

            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<KhachHang> GetALLTenKhachHang(String TenKH) {
        getConnect();
        try {
            List<KhachHang> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(GET_SEARCHKHACHHANG);
            ps.setString(1, TenKH);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new KhachHang(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            getClose();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void AddKH(String tenKH, String diaChi, String gioiTinh, String sdt) {                  
        try{
                PreparedStatement ps = con.prepareStatement(GET_ADDKH);
                ps.setString(1, tenKH);
                ps.setString(2, diaChi);
                ps.setString(3, gioiTinh);
                ps.setString(4, sdt);
                ps.executeUpdate();               
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
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
    
    
    
}
