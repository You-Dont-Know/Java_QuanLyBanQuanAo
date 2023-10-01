/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class DataAcessHelper {
    protected Connection con;
    public void getConnect()
    {
        try
        {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");         
            String connectionurl= "jdbc:sqlserver://DESKTOP-PKGEMFS\\HIEUNE:1433; databaseName=SHOPQUANAO; encrypt=false" ;
            con=DriverManager.getConnection(connectionurl,"sa","123456");
        }
           catch(Exception ex)
            {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null,"Không thể kết nối tới CSDL");
            }   
    }
    public void getClose()
    {
        try {
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thể đóng kết nối tới CSDL");
        }
    }
}
