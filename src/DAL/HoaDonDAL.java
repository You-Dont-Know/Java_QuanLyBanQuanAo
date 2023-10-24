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
import Interface.Interface_IQueryDatabase;

/**
 *
 * @author hieun
 */
public class HoaDonDAL extends DataAcessHelper implements Interface_IQueryDatabase<HoaDon> {

    public final String GET_ALLHOADON = "select * from hoadon";
    public final String GET_CHECKHD = "select sohd from hoadon where sohd = ?";
    public final String GET_UPDATEHD = "UPDATE HoaDon SET ngaylap = ?, nhanvienlap = ?, makh = ?, manhanvien = ? WHERE sohd = ?";
    public final String GET_DELETEHOADON = "DELETE FROM HoaDon WHERE sohd = ?";
    public final String GET_ADDHD = "INSERT INTO HoaDon VALUES (?, ?, ?, ?, ?)";
    public final String GET_NGAYLAP = "SELECT ngaylap from hoadon where sohd = ?";
    public final String GET_NHANVIENLAP = "select nhanvienlap from hoadon where sohd = ?";
    public final String GET_MANHANVIEN = "select manhanvien from hoadon where sohd = ?";
    public final String GET_MAKHACHHANG = "select makh from hoadon where sohd = ?";
    public final String GET_TENKHACHHANG = "select tenkhachhang from hoadon where sohd = ?";

    @Override
    public List<HoaDon> getALL() {
        getConnect();
        try {
            List<HoaDon> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(GET_ALLHOADON);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new HoaDon(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getDate(4), rs.getInt(5)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void Update(HoaDon hd) {
        getConnect();
        try {
            PreparedStatement ps = con.prepareStatement(GET_UPDATEHD);
            ps.setString(1, hd.getNL());
            ps.setString(2, hd.getNhanVienLap());
            ps.setInt(3, hd.getMaKH());
            ps.setString(4, hd.getMaNhanVien());
            ps.setString(5, hd.getSoHD());
            ps.executeUpdate();

            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int Delete(HoaDon hd) {
        getConnect();
        int row;
        try {
            PreparedStatement ps = con.prepareStatement(GET_DELETEHOADON);
            ps.setString(1, hd.getSoHD());
            row = ps.executeUpdate();
            getClose();
            return row;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void Add(HoaDon hd) {
        try {
            getConnect();
            PreparedStatement ps_Check = con.prepareStatement(GET_CHECKHD);
            ps_Check.setString(1, hd.getSoHD());
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
                ps.setString(1, hd.getSoHD());
                ps.setString(2, hd.getMaNhanVien());
                ps.setString(3, hd.getNhanVienLap());
                ps.setString(4, hd.getNL());
                ps.setInt(5, hd.getMaKH());
                ps.executeUpdate();
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String getNgayLap(String s) {
        String check = "";
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

    public String getNhanVienLap(String s) {
        String check = "";
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

    public String getMaNhanVien(String s) {
        String check = "";
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


    public String getMaKhachHang(String s) {
        String check = "";
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
