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
import java.util.ArrayList;
/**
 *
 * @author hieun
 */
public class NhanVienDAL extends DataAcessHelper {
    private final String GET_ALLNHANVIEN = "select * from nhanvien";
    
    public List<NhanVien> getALLNhanvien(){
        getConnect();
        try{
            List<NhanVien> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(GET_ALLNHANVIEN); 
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7),
                        rs.getString(8), rs.getString(9)));
            }
            return list;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
