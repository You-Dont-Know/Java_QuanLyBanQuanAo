/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;
import java.util.Date;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Entity.HoaDon;
import GUI.Main;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Interface.Interface_HoaDon;

/**
 *
 * @author hieun
 */
public class HoaDonDAL extends DataAcessHelper implements Interface_HoaDon{
    
    @Override
    public List<HoaDon> getALLHoaDon(){
        getConnect();
        try{
            List<HoaDon> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(GET_ALLHOADON); 
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new HoaDon(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getDate(4), rs.getInt(5)));
            }
            return list;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public void UpdateHD(String sohd, String ngaylap, String nhanvienlap, String makh, String manhanvien){
        getConnect();
        try {
            PreparedStatement ps = con.prepareStatement(GET_UPDATEHD);
            ps.setString(1, ngaylap);
            ps.setString(2, nhanvienlap);
            ps.setString(3, makh);
            ps.setString(4, manhanvien);
            ps.setString(5, sohd);
            ps.executeUpdate();

            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public int deleteHD(String maHD) {
        getConnect();
        int row;
        try {
            PreparedStatement ps = con.prepareStatement(GET_DELETEHOADON);
            ps.setString(1, maHD);
            row = ps.executeUpdate();
            getClose();
            return row;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    @Override
    public void AddHD(String sohd, String ngaylap, String nhanvienlap, String makh, String manhanvien) {
        try {
            getConnect();
            PreparedStatement ps_Check = con.prepareStatement(GET_CHECKHD);
            ps_Check.setString(1, sohd);
            ResultSet rs = ps_Check.executeQuery();
            StringBuilder sb = new StringBuilder();
            if (rs.next()) {
                sb.append("mã hóa đơn đã tồn tại");
            }
            if (sb.length() > 0) {
                
                Main m = new Main();
                JOptionPane.showMessageDialog(m, sb.toString());
            } else {
                PreparedStatement ps = con.prepareStatement(GET_ADDHD);
                ps.setString(1, sohd);
                ps.setString(2, manhanvien);
                ps.setString(3, nhanvienlap);
                ps.setString(4, ngaylap);
                ps.setString(5, makh);
                ps.executeUpdate();
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public String getNgayLap(String s) {
        String check ="";
        try {
            getConnect();

            PreparedStatement ps = con.prepareStatement(GET_NGAYLAP);
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
    public String getNhanVienLap(String s) {
        String check ="";
        try {
            getConnect();

            PreparedStatement ps = con.prepareStatement(GET_NHANVIENLAP);
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
    public String getMaNhanVien(String s) {
        String check ="";
        try {
            getConnect();

            PreparedStatement ps = con.prepareStatement(GET_MANHANVIEN);
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
    public String getMaKhachHang(String s) {
        String check ="";
        try {
            getConnect();

            PreparedStatement ps = con.prepareStatement(GET_MAKHACHHANG);
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
