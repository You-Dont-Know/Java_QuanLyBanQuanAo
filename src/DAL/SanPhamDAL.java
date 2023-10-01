/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Entity.SanPham;
import java.util.ArrayList;
/**
 *
 * @author hieun
 */
public class SanPhamDAL extends DataAcessHelper {
    private final String GET_ALLSANPHAM = "select * from sanpham";
    
    public List<SanPham> getALLSanPham(){
        getConnect();
        try{
            List<SanPham> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(GET_ALLSANPHAM); 
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                list.add(new SanPham(rs.getString(1),
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getInt(7)));
            }
            return list;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
