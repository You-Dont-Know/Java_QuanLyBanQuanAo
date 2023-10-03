/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.NhanVien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Aki
 */
public class TaiKhoanDAL extends DataAcessHelper {

    private final String GET_LOGIN = "select * from nhanvien where tendangnhap=? and matkhau=?";

//     private final String UPDATE_DATA="Update Account set Username=?,Password=?,maxacnhan=? where AccID=?";
//     private final String CHECK_DATA="select * from Account where Username=? and maxacnhan=?";
//     private final String UPDATE_PASS="Update Account set Password=? where AccID=?";
    public String getLogin(String u, String p) {
        String check ="";
        try {
            getConnect();

            PreparedStatement ps = con.prepareStatement(GET_LOGIN);
            ps.setString(1, u);
            ps.setString(2, p);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null && rs.next()) { 
                
                check = rs.getString(9);
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
//     public boolean UpdateData(NhanVien acc)
//    {
//        boolean check = false;
//        try{
//            getConnect();
//            PreparedStatement ps = con.prepareStatement(UPDATE_DATA);
//            //
//            ps.setString(1, acc.getTenDangNhap());
//            ps.setString(2, acc.getMatKhau());
//    
//    
//            ps.setString(4, acc.getMaNhanVien());
//            int rs=ps.executeUpdate();
//            if(rs>0){
//                check=true;
//            }
//            getClose();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return check;
//    }
//      public boolean getCheck(String u, String p)
//    { boolean check = false;
//        try {
//            getConnect();
//            PreparedStatement ps=con.prepareStatement(CHECK_DATA);
//            ps.setString(1, u);
//            ps.setString(2, p);
//            ResultSet rs=ps.executeQuery();
//            if(rs!=null && rs.next())
//            {
//                check=true;
//            }
//            getClose();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return check;
//    }
//       public boolean UpdatePass(NhanVien acc)
//    {
//        boolean check = false;
//        try{
//            getConnect();
//            PreparedStatement ps = con.prepareStatement(UPDATE_PASS);
//            //
//           
//            ps.setString(1, acc.getMatKhau());
//    
//      
//           
//            ps.setString(2, acc.getMaNhanVien());
//            int rs=ps.executeUpdate();
//            if(rs>0){
//                check=true;
//            }
//            getClose();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return check;
//    }

}
