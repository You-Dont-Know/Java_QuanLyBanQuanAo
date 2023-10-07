/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

/**
 *
 * @author hieun
 */
public interface Interface_TaiKhoan {
    public final String GET_LOGIN = "select * from nhanvien where tendangnhap=? and matkhau=?";
    public String getLogin(String u, String p);
}
