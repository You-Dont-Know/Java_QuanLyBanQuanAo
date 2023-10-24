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
import Interface.Interface_IQueryDatabase;

/**
 *
 * @author hieun
 */
public class NhanVienDAL extends DataAcessHelper implements Interface_IQueryDatabase<NhanVien> {

    public final String GET_ALLNHANVIEN = "select * from nhanvien";
    public final String GET_UPDATENHANVIEN = " UPDATE NhanVien SET tennhanvien = ?, gioitinh = ?, ngaysinh =  ?, diachi = ?, sdt = ?, tendangnhap = ?, matkhau = ?, chucvu = ?  WHERE manhanvien= ?";
    public final String GET_DELETENHANVIEN = "DELETE FROM NhanVien WHERE manhanvien = ?";
    public final String GET_ADDNV = "INSERT INTO NhanVien VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public final String GET_CHECKNV = "select manhanvien from nhanvien where manhanvien = ?";
    public final String GET_MnsTnv = "select manhanvien,tennhanvien from nhanvien where tendangnhap = ?";

    public List<NhanVien> getMnsTnv(String tenDangNhap) {
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
    public List<NhanVien> getALL() {
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
    public void Add(NhanVien nv) {
        try {
            getConnect();
            PreparedStatement ps_Check = con.prepareStatement(GET_CHECKNV);
            ps_Check.setString(1, nv.getMaNhanVien());
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
                ps.setString(1, nv.getMaNhanVien());
                ps.setString(2, nv.getTenNhanVien());
                ps.setString(3, nv.getGioiTinh());
                ps.setString(4, nv.getNS());
                ps.setString(5, nv.getDiaChi());
                ps.setString(6, nv.getSdt());
                ps.setString(7, nv.getTenDangNhap());
                ps.setString(8, nv.getMatKhau());
                ps.setString(9, nv.getChucVu());
                ps.executeUpdate();
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Update(NhanVien nv) {
        getConnect();
        try {
            PreparedStatement ps = con.prepareStatement(GET_UPDATENHANVIEN);
            ps.setString(1, nv.getTenNhanVien());
            ps.setString(2, nv.getGioiTinh());
            ps.setString(3, nv.getNS());
            ps.setString(4, nv.getDiaChi());
            ps.setString(5, nv.getSdt());
            ps.setString(6, nv.getTenDangNhap());
            ps.setString(7, nv.getMatKhau());
            ps.setString(8, nv.getChucVu());
            ps.setString(9, nv.getMaNhanVien());
            ps.executeUpdate();

            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int Delete(NhanVien nv) {
        getConnect();
        int row;
        try {
            PreparedStatement ps = con.prepareStatement(GET_DELETENHANVIEN);
            ps.setString(1, nv.getMaNhanVien());
            row = ps.executeUpdate();
            getClose();
            return row;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
