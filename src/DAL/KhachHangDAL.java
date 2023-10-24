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
import Interface.Interface_IQueryDatabase;

/**
 *
 * @author hieun
 */
public class KhachHangDAL extends DataAcessHelper implements Interface_IQueryDatabase<KhachHang> {

    public final String GET_ALLKHACHHANG = "select * from khachhang";
    public final String GET_UPDATEKHACHHANG = "UPDATE khachhang SET tenkhach = ?, gioitinh = ?, diachi = ?, sdt = ?, maloaikhachhang = ? WHERE makh= ?";
    public final String GET_SEARCHKHACHHANG = "SELECT * FROM KhachHang where tenkhach like ?";
    public final String GET_SEARCHSDT = "SELECT * FROM KhachHang where sdt like ?";
    public final String GET_DELETEKHACHHANG = "DELETE from KhachHang WHERE makh = ? ";
    public final String GET_ADDKH = "INSERT INTO Khachhang VALUES (?,?, ?, ?, ?, ?)";
    public final String GET_CheckKNKH = "select makh from hoadon where makh = ?";
    public final String GET_CheckTENKH = "select tenkhach from khachhang where makh = ?";

    @Override
    public List<KhachHang> getALL() {
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
    public void Update(KhachHang kh) {
        getConnect();
        try {
            PreparedStatement ps = con.prepareStatement(GET_UPDATEKHACHHANG);
            ps.setString(1, kh.getTenKhach());
            ps.setString(2, kh.getGioiTinh());
            ps.setString(3, kh.getDiaChi());
            ps.setString(4, kh.getSdt());
            ps.setInt(5, kh.getMaloaikhachhang());
            ps.setInt(6, kh.getMaKH());
            ps.executeUpdate();

            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<KhachHang> GetALLSDT(String SDT) {
        getConnect();
        try {
            List<KhachHang> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(GET_SEARCHSDT);
            ps.setString(1, "%" + SDT + "%");
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

    
    public List<KhachHang> GetALLTenKhachHang(String TenKH) {
        getConnect();
        try {
            List<KhachHang> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(GET_SEARCHKHACHHANG);
            ps.setString(1, "%" + TenKH + "%");
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

    public int generateNewCustomerId() {
        List<KhachHang> addkh = getALL();
        List<Integer> saveMKH = new ArrayList<Integer>();
        for (KhachHang kh : addkh) {
            saveMKH.add(kh.getMaKH());
        }

        for (int i = 0; i < saveMKH.size() - 1; i++) {
            if (saveMKH.get(i + 1) - saveMKH.get(i) != 1) {
                return saveMKH.get(i) + 1;
            }
        }

        return saveMKH.size() + 1;
    }

    @Override
    public void Add(KhachHang kh) {
        try {
            int makhachhang = generateNewCustomerId();
            PreparedStatement ps = con.prepareStatement(GET_ADDKH);
            ps.setInt(1, makhachhang);
            ps.setString(2, kh.getTenKhach());
            ps.setString(3, kh.getDiaChi());
            ps.setString(4, kh.getGioiTinh());
            ps.setString(5, kh.getSdt());
            ps.setInt(6, kh.getMaloaikhachhang());
            ps.executeUpdate();
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int Delete(KhachHang kh) {
        getConnect();
        int row = 0;
        try {
            PreparedStatement ps_Check = con.prepareStatement(GET_CheckKNKH);
            ps_Check.setInt(1, kh.getMaKH());
            ResultSet rs = ps_Check.executeQuery();
            StringBuilder sb = new StringBuilder();
            if (rs.next()) {
                sb.append("khách hàng đang đặt hàng, vui lòng thanh toán rồi xóa!!");
            }
            if (sb.length() > 0) {
                Main m = new Main();
                JOptionPane.showMessageDialog(m, sb.toString());
            } else {
                PreparedStatement ps = con.prepareStatement(GET_DELETEKHACHHANG);
                ps.setInt(1, kh.getMaKH());
                row = ps.executeUpdate();
            }
            getClose();
            return row;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public String getTenKhachHang(String s) {
        String check = "";
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
