/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;
import Entity.LoaiKhachHang;
import static Interface.Interface_HoaDon.GET_ALLHOADON;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Interface.Interface_LoaiKhachHang;
/**
 *
 * @author hieun
 */
public class LoaiKhachHangDAL extends DataAcessHelper implements Interface_LoaiKhachHang{
    
    @Override
    public List<LoaiKhachHang> getALLLoaiKhachHang(){
        getConnect();
        try{
            List<LoaiKhachHang> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(GET_LOAIKHACHHANG); 
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new LoaiKhachHang(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
            return list;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public String getTenLoaiKhachHang(String maloaikhachhang){           
        String check ="";
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_TENLOAIKHACHHANG);
            ps.setString(1, maloaikhachhang);
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
