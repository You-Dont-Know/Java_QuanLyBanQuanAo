/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Entity.LoaiSanPham;
import java.util.ArrayList;
import java.util.List;
import Interface.Interface_IQueryDatabase;

/**
 *
 * @author hieun
 */
public class LoaiSanPhamDAL extends DataAcessHelper implements Interface_IQueryDatabase<LoaiSanPham> {

    public final String GET_LOAISANPHAM = "select * from loaisanpham";
    public final String GET_TENLOAISANPHAM = "select tenloaisanpham from loaisanpham where maloaisanpham = ?";

    public final String GET_ADDLOAISANPHAM = "INSERT INTO loaisanpham VALUES (?,?)";
    public final String GET_UPDATELOAISANPHAM = "UPDATE loaisanpham SET tenloaisanpham = ? WHERE maloaisanpham= ?";
    public final String GET_DELETELOAISANPHAM = "DELETE FROM loaisanpham WHERE maloaisanpham = ?";
    public final String GET_MALSP = "SELECT maloaisanpham from loaisanpham where tenloaisanpham = ?";

    @Override
    public List<LoaiSanPham> getALL() {
        getConnect();
        try {
            List<LoaiSanPham> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(GET_LOAISANPHAM);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new LoaiSanPham(rs.getInt(1), rs.getString(2)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getTenLoaiKhachHang(String maLoaiSanPham) {
        String check = "";
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_TENLOAISANPHAM);
            ps.setString(1, maLoaiSanPham);
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

    public int generateNewCustomerId() {
        List<LoaiSanPham> addkh = getALL();
        List<Integer> saveMLSP = new ArrayList<Integer>();
        for (LoaiSanPham kh : addkh) {
            saveMLSP.add(kh.getMaLoaiSanPham());
        }

        for (int i = 0; i < saveMLSP.size() - 1; i++) {
            if (saveMLSP.get(i + 1) - saveMLSP.get(i) != 1) {
                return saveMLSP.get(i) + 1;
            }
        }
        return saveMLSP.size() + 1;
    }

    @Override
    public void Add(LoaiSanPham LSP) {
        try {
            int makhachhang = generateNewCustomerId();
            PreparedStatement ps = con.prepareStatement(GET_ADDLOAISANPHAM);
            ps.setInt(1, makhachhang);
            ps.setString(2, LSP.getTenLoaiSanPham());
            ps.executeUpdate();
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Update(LoaiSanPham LSP) {
        getConnect();
        try {
            PreparedStatement ps = con.prepareStatement(GET_UPDATELOAISANPHAM);
            ps.setString(1, LSP.getTenLoaiSanPham());
            ps.setInt(2, LSP.getMaLoaiSanPham());
            ps.executeUpdate();

            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int Delete(LoaiSanPham LSP) {
        getConnect();
        int row;
        try {
            PreparedStatement ps = con.prepareStatement(GET_DELETELOAISANPHAM);
            ps.setInt(1, LSP.getMaLoaiSanPham());
            row = ps.executeUpdate();
            getClose();
            return row;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    
    public int getMaLoaiSanPham(String s) {
        int check = 0;
        try {
            getConnect();

            PreparedStatement ps = con.prepareStatement(GET_MALSP);
            ps.setString(1, s);
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
