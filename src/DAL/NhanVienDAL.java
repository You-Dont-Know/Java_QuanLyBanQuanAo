/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.util.Date;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Entity.NhanVien;
import GUI.Main;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Interface.Interface_NhanVien;
/**
 *
 * @author hieun
 */
public class NhanVienDAL extends DataAcessHelper implements Interface_NhanVien{

    @Override
    public List<NhanVien> getMnsTnv(String tenDangNhap){
        getConnect();
        try {
            List<NhanVien> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(GET_MnsTnv);
            ps.setString(1, tenDangNhap);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new NhanVien(rs.getString(1), rs.getString(2)));               
            }
            getClose();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }    
        return null;
    }
    
    @Override
    public List<NhanVien> getALLNhanvien() {
        getConnect();
        try {
            List<NhanVien> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(GET_ALLNHANVIEN);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7),
                        rs.getString(8), rs.getString(9)));
            }
            getClose();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void UpdateNV(String manv, String tennv, String gioitinh, String ngaysinh, String diachi, String sdt, String tendn, String matkhau, String chucvu) {
        getConnect();
        try {
            PreparedStatement ps = con.prepareStatement(GET_UPDATENHANVIEN);
            ps.setString(1, tennv);
            ps.setString(2, gioitinh);
            ps.setString(3, ngaysinh);
            ps.setString(4, diachi);
            ps.setString(5, sdt);
            ps.setString(6, tendn);
            ps.setString(7, matkhau);
            ps.setString(8, chucvu);
            ps.setString(9, manv);
            ps.executeUpdate();

            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int deleteNV(String maNV) {
        getConnect();
        int row;
        try {
            PreparedStatement ps = con.prepareStatement(GET_DELETENHANVIEN);
            ps.setString(1, maNV);
            row = ps.executeUpdate();
            getClose();
            return row;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void Them(String manv, String tennv, String gioitinh, String ngaysinh, String diachi, String sdt, String tendn, String matkhau, String chucvu) {
        try {
            getConnect();
            PreparedStatement ps_Check = con.prepareStatement(GET_CHECKNV);
            ps_Check.setString(1, manv);
            ResultSet rs = ps_Check.executeQuery();
            StringBuilder sb = new StringBuilder();
            if (rs.next()) {
                sb.append("mã nhân viên đã tồn tại");
            }
            if (sb.length() > 0) {
                
                Main m = new Main();
                JOptionPane.showMessageDialog(m, sb.toString());
            } else {
                PreparedStatement ps = con.prepareStatement(GET_ADDNV);
                ps.setString(1, manv);
                ps.setString(2, tennv);
                ps.setString(3, gioitinh);
                ps.setString(4, ngaysinh);
                ps.setString(5, diachi);
                ps.setString(6, sdt);
                ps.setString(7, tendn);
                ps.setString(8, matkhau);
                ps.setString(9, chucvu);
                ps.executeUpdate();
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
