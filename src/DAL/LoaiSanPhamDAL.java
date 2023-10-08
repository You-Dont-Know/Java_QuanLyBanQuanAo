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
import Interface.Interface_LoaiSanPham;
/**
 *
 * @author hieun
 */
public class LoaiSanPhamDAL extends DataAcessHelper implements Interface_LoaiSanPham{
    
    @Override
    public List<LoaiSanPham> getALLLoaiSanPham(){
        getConnect();
        try{
            List<LoaiSanPham> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(GET_LOAISANPHAM); 
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new LoaiSanPham(rs.getInt(1), rs.getString(2)));
            }
            return list;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public String getTenLoaiKhachHang(String maLoaiSanPham){           
        String check ="";
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
}
