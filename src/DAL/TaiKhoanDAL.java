/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.NhanVien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Interface.Interface_TaiKhoan;
/**
 *
 * @author Aki
 */
public class TaiKhoanDAL extends DataAcessHelper implements Interface_TaiKhoan{

    @Override
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

}
