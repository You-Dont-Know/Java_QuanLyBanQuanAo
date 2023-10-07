/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.util.Date;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Entity.ChiTietHoaDon;
import GUI.Main;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Interface.Interface_ChiTietHoaDon;

/**
 *
 * @author hieun
 */
public class ChiTietHoaDonDAL extends DataAcessHelper implements Interface_ChiTietHoaDon{

    
    @Override
    public List<ChiTietHoaDon> getALLChiTietHoaDon() {
        getConnect();
        try {
            List<ChiTietHoaDon> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(GET_ALLCHITIETHOADON);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ChiTietHoaDon(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getFloat(4), rs.getInt(5), rs.getFloat(6)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<ChiTietHoaDon> GetALLChiTietHoaDon(String soHD) {
        getConnect();
        try {
            List<ChiTietHoaDon> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(GET_SEARCHCTHD);
            ps.setString(1, soHD);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new ChiTietHoaDon(rs.getString(1), rs.getString(2),
                        rs.getFloat(3), rs.getInt(4), rs.getFloat(5)));
            }
            getClose();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public void UpdateCTHD(String sohd, String masanpham, String sanpham, float dongia, int soluong, float tongtien) {
        getConnect();
        try {
            PreparedStatement ps = con.prepareStatement(GET_UPDATECTHD);
            ps.setString(1, sanpham);
            ps.setFloat(2, dongia);
            ps.setInt(3, soluong);
            ps.setFloat(4, tongtien);
            ps.setString(5, sohd);
            ps.setString(6, masanpham);
            ps.executeUpdate();

            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public int deleteCTHD(String maCTHD, String maSP) {
        getConnect();
        int row;
        try {
            PreparedStatement ps = con.prepareStatement(GET_DELETECTHOADON);
            ps.setString(1, maCTHD);
            ps.setString(2, maSP);
            row = ps.executeUpdate();
            getClose();
            return row;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    @Override
    public void AddCTHD(String sohd, String masanpham, String sanpham, float dongia, int soluong, float tongtien) {
        getConnect();
        try{
                PreparedStatement ps = con.prepareStatement(GET_ADDCTHD);
                ps.setString(1, sohd);
                ps.setString(2, masanpham);
                ps.setString(3, sanpham);
                ps.setFloat(4, dongia);
                ps.setInt(5, soluong);
                ps.setFloat(6, tongtien);
                ps.executeUpdate();           
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
