/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Entity.KhachHang;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author hieun
 */
public class KhachHangDAL extends DataAcessHelper{
    private final String GET_ALLKHACHHANG = "select * from khachhang";
    
    public List<KhachHang> getALLKhachHang(){
        getConnect();
        try{
            List<KhachHang> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(GET_ALLKHACHHANG); 
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new KhachHang(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            return list;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
