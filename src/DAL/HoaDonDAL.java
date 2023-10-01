/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;
import java.util.Date;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Entity.HoaDon;
import java.util.ArrayList;
/**
 *
 * @author hieun
 */
public class HoaDonDAL extends DataAcessHelper {
    private final String GET_ALLHOADON = "select * from hoadon";
    
    public List<HoaDon> getALLHoaDon(){
        getConnect();
        try{
            List<HoaDon> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(GET_ALLHOADON); 
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new HoaDon(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getDate(4), rs.getInt(5)));
            }
            return list;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
