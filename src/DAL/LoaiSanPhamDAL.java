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
    
    public int generateNewCustomerId() {
        List<LoaiSanPham> addkh = getALLLoaiSanPham();
        List<Integer> saveMLSP = new ArrayList<Integer>();
        for(LoaiSanPham kh : addkh){
            saveMLSP.add(kh.getMaLoaiSanPham());
        }
        
        for (int i = 1; i < saveMLSP.size() - 1; i++) {
            if (saveMLSP.get(i + 1) - saveMLSP.get(i) != 1 ) {
                return saveMLSP.get(i) + 1;               
            }
        }  
        return saveMLSP.size() + 1;
    }
    
    @Override
    public void AddLSP(String tenLoaiSanPHam) {                  
        
        List<LoaiSanPham> addLSP = getALLLoaiSanPham();
        
        try{
                int makhachhang = generateNewCustomerId();
                PreparedStatement ps = con.prepareStatement(GET_ADDLOAISANPHAM);
                ps.setInt(1, makhachhang);
                ps.setString(2, tenLoaiSanPHam);
                ps.executeUpdate();               
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void UpdateLSP(int maLoaiSanPham, String tenLoaiSanPHam) {
        getConnect();
        try {
            PreparedStatement ps = con.prepareStatement(GET_UPDATELOAISANPHAM);
            ps.setString(1, tenLoaiSanPHam);
            ps.setInt(2, maLoaiSanPham);
            ps.executeUpdate();

            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public int deleteLSP(int maLoaiSanPham) {
        getConnect();
        int row;
        try {
            PreparedStatement ps = con.prepareStatement(GET_DELETELOAISANPHAM);
            ps.setInt(1, maLoaiSanPham);
            row = ps.executeUpdate();
            getClose();
            return row;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    @Override
    public int getMaLoaiSanPham(String s) {
        int check = 0;
        try {
            getConnect();

            PreparedStatement ps = con.prepareStatement(GET_MALSP);
            ps.setString(1, s);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null && rs.next()) { 
                
                check = rs.getInt(1);
                
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
}
