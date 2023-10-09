/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;
import Entity.ThongKe;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Interface.Interface_ThongKe;
/**
 *
 * @author hieun
 */
public class ThongKeDAL extends DataAcessHelper implements Interface_ThongKe{
   
    @Override
    public List<ThongKe> getALLThongke() {
        getConnect();
        try {
            List<ThongKe> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(GET_TABLEALLTHONGKE);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ThongKe(rs.getDate(1), rs.getInt(2), rs.getFloat(3), rs.getString(4), rs.getString(5)));
            }
            getClose();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<ThongKe> getALLThongkeByDate(String Date1, String Date2) {
        getConnect();
        try {
            List<ThongKe> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(GET_TABLETHONGKE);
            ps.setString(1, Date1);
            ps.setString(2, Date2);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ThongKe(rs.getDate(1), rs.getInt(2), rs.getFloat(3), rs.getString(4), rs.getString(5)));
            }
            getClose();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public List<ThongKe> getALLThongkeByName(String Name) {
        getConnect();
        try {
            List<ThongKe> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(GET_TABLETHONGKEBYNAME);
            ps.setString(1, Name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ThongKe(rs.getDate(1), 
                        rs.getString(2), 
                        rs.getInt(3), 
                        rs.getFloat(4), 
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7), 
                        rs.getFloat(8), 
                        rs.getInt(9)));
            }
            getClose();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    } 
}
