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
import Interface.Interface_IQueryDatabase;

public class SanPhamDAL extends DataAcessHelper implements Interface_IQueryDatabase<SanPham> {

    public final String GET_ALLSANPHAM = "select * from sanpham";
    public final String GET_UPDATESP = "UPDATE SanPham SET tensanpham = ?, maloaisanpham = ?, gianhap = ?, giaban = ?, motasanpham = ?, size = ?,ngaysanxuat = ?, soluong = ? WHERE masanpham = ?";
    public final String GET_SEARCHSP = "SELECT * FROM SanPham where tensanpham like ? ";
    public final String GET_SEARCHLSP = "SELECT * FROM SanPham where maloaisanpham = ? ";
    public final String GET_SEARCHMSP = "SELECT * FROM SanPham where masanpham like ?";    
    public final String GET_SEARCHMTSP = "SELECT * from SanPham where motasanpham like ?";    
    public final String GET_DELETESP = "DELETE from SanPham WHERE masanpham = ? ";
    public final String GET_ADDSP = "insert into sanpham(masanpham,tensanpham,maloaisanpham,gianhap, giaban, motasanpham,size,ngaysanxuat,soluong ) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public final String GET_CheckSP = "select masanpham from sanpham where masanpham = ?";
    public final String GET_MASP = "SELECT motasanpham from sanpham where masanpham = ?";
    public final String GET_GIASP = "SELECT giaban from sanpham where masanpham = ?";
    public final String GET_GIANHAP = "SELECT gianhap from sanpham where tensanpham = ?";
    
    @Override
    public List<SanPham> getALL() {
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


    public List<SanPham> getALLSanPham(String s) {
        getConnect();
        try {
            List<SanPham> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(GET_SEARCHMTSP);
            ps.setString(1, "%" + s + "%");
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
    public void Update(SanPham sp) {
        getConnect();
        try {
            PreparedStatement ps = con.prepareStatement(GET_UPDATESP);
            ps.setString(1, sp.getTenSanPham());
            ps.setInt(2, sp.getMaLoaiSanPham());
            ps.setFloat(3, sp.getGiaNhap());
            ps.setFloat(4, sp.getGiaBan());
            ps.setString(5, sp.getMoTaSanPham());
            ps.setString(6, sp.getSize());
            ps.setString(7, sp.getNSX());
            ps.setInt(8, sp.getSoLuong());
            ps.setString(9, sp.getMaSanPham());
            ps.executeUpdate();

            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int Delete(SanPham sp) {
        getConnect();
        int row;
        try {
            PreparedStatement ps = con.prepareStatement(GET_DELETESP);
            ps.setString(1, sp.getMaSanPham());
            row = ps.executeUpdate();
            getClose();
            return row;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void Add(SanPham sp) {
        try {
            getConnect();
            PreparedStatement ps_Check = con.prepareStatement(GET_CheckSP);
            ps_Check.setString(1, sp.getMaSanPham());
            ResultSet rs = ps_Check.executeQuery();
            StringBuffer sb = new StringBuffer();
            if (rs.next()) {
                sb.append("Mã sản phẩm đã tồn tại");
            }
            if (sb.length() > 0) {
                Main m = new Main();
                JOptionPane.showMessageDialog(m, sb.toString());
            } else {
                PreparedStatement ps = con.prepareStatement(GET_ADDSP);
                ps.setString(1, sp.getMaSanPham());
                ps.setString(2, sp.getTenSanPham());
                ps.setInt(3, sp.getMaLoaiSanPham());
                ps.setFloat(4, sp.getGiaNhap());
                ps.setFloat(5, sp.getGiaBan());
                ps.setString(6, sp.getMoTaSanPham());
                ps.setString(7, sp.getSize());
                ps.setString(8, sp.getNSX());
                ps.setInt(9, sp.getSoLuong());
                ps.executeUpdate();
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<SanPham> GetALLLoaiSanPham(String Tenlsp) {
        getConnect();
        try {
            LoaiSanPhamDAL lspdal = new LoaiSanPhamDAL();
            int s = lspdal.getMaLoaiSanPham(Tenlsp);
            List<SanPham> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(GET_SEARCHLSP);
            ps.setInt(1, s);
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

    
    public List<SanPham> GetALLTenSanPham(String Tensp) {
        getConnect();
        try {
            List<SanPham> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(GET_SEARCHSP);
            ps.setString(1, "%" + Tensp + "%");
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

    public List<SanPham> GetALLMaSanPham(String maSP) {
        getConnect();
        try {
            List<SanPham> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(GET_SEARCHMSP);
            ps.setString(1, "%" + maSP + "%");
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


    public String getMaSanPham(String s) {
        String check = "";
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
        String check = "";
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

    public float getGiaNhap(String s) {
        float check = 0;
        try {
            getConnect();

            PreparedStatement ps = con.prepareStatement(GET_GIANHAP);
            ps.setString(1, s);
            ResultSet rs = ps.executeQuery();

            if (rs != null && rs.next()) {

                check = rs.getFloat(1);
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
}
