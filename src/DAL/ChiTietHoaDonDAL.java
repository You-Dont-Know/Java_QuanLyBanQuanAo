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
import Interface.Interface_IQueryDatabase;

/**
 *
 * @author hieun
 */
public class ChiTietHoaDonDAL extends DataAcessHelper implements Interface_IQueryDatabase<ChiTietHoaDon>{

    public final String GET_ALLCHITIETHOADON = "select * from cthoadon";
    public final String GET_SEARCHCTHD = "select masanpham,sanpham,dongia,soluong,size,tongtien from CTHoaDon where sohd=?";
    public final String GET_UPDATECTHD = "UPDATE CTHoaDon SET sanpham = ?, dongia = ?, soluong = ?,size = ?, tongtien = ?  WHERE sohd = ? and masanpham= ?";
    public final String GET_DELETECTHOADON = "DELETE FROM CTHoaDon WHERE sohd = ? and masanpham = ?";
    public final String GET_ADDCTHD = "INSERT INTO CTHoaDon VALUES (?, ?, ?, ?, ?,?, ?)";

    @Override
    public List<ChiTietHoaDon> getALL() {
        getConnect();
        try {
            List<ChiTietHoaDon> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(GET_ALLCHITIETHOADON);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ChiTietHoaDon(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getFloat(4), rs.getInt(5), rs.getString(6), rs.getFloat(7)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ChiTietHoaDon> GetALLChiTietHoaDon(String soHD) {
        getConnect();
        try {
            List<ChiTietHoaDon> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(GET_SEARCHCTHD);
            ps.setString(1, soHD);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new ChiTietHoaDon(rs.getString(1), rs.getString(2),
                        rs.getFloat(3), rs.getInt(4), rs.getString(5), rs.getFloat(6)));
            }
            getClose();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void Update(ChiTietHoaDon CTHD) {
        getConnect();
        try {
            PreparedStatement ps = con.prepareStatement(GET_UPDATECTHD);
            ps.setString(1, CTHD.getSanPham());
            ps.setFloat(2, CTHD.getDonGia());
            ps.setInt(3, CTHD.getSoLuong());
            ps.setString(4, CTHD.getSize());
            ps.setFloat(5, CTHD.getTongTien());
            ps.setString(6, CTHD.getSoHD());
            ps.setString(7, CTHD.getMaSanPham());
            ps.executeUpdate();

            
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int Delete(ChiTietHoaDon cthd) {
        getConnect();
        int row;
        try {
            PreparedStatement ps = con.prepareStatement(GET_DELETECTHOADON);
            ps.setString(1, cthd.getSoHD());
            ps.setString(2, cthd.getMaSanPham());
            row = ps.executeUpdate();
            getClose();
            return row;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void Add(ChiTietHoaDon cthd) {
        getConnect();
        try {
            PreparedStatement ps = con.prepareStatement(GET_ADDCTHD);
            ps.setString(1, cthd.getSoHD());
            ps.setString(2, cthd.getMaSanPham());
            ps.setString(3, cthd.getSanPham());
            ps.setFloat(4, cthd.getDonGia());
            ps.setInt(5, cthd.getSoLuong());
            ps.setString(6, cthd.getSize());
            ps.setFloat(7, cthd.getTongTien());
            ps.executeUpdate();
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final String GET_SUMCTSPBYMSP = "SELECT SUM(soluong) as tong_soluong FROM cthoadon WHERE masanpham = ?";

    public int getSumSoLuong(String maSP) {
        int check = 0;
        try {
            getConnect();

            PreparedStatement ps = con.prepareStatement(GET_SUMCTSPBYMSP);
            ps.setString(1, maSP);
            ResultSet rs = ps.executeQuery();

            if (rs != null && rs.next()) {

                check = rs.getInt(1);

            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
}
