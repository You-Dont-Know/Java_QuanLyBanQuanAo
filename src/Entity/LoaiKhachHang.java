/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author hieun
 */
public class LoaiKhachHang {
    private int maloaikhachhang;
    private String tenloaikhachhang;
    private String GhiChu;

    public LoaiKhachHang(int maloaikhachhang, String tenloaikhachhang, String GhiChu) {
        this.maloaikhachhang = maloaikhachhang;
        this.tenloaikhachhang = tenloaikhachhang;
        this.GhiChu = GhiChu;
    }

    public int getMaloaikhachhang() {
        return maloaikhachhang;
    }

    public void setMaloaikhachhang(int maloaikhachhang) {
        this.maloaikhachhang = maloaikhachhang;
    }

    public String getTenloaikhachhang() {
        return tenloaikhachhang;
    }

    public void setTenloaikhachhang(String tenloaikhachhang) {
        this.tenloaikhachhang = tenloaikhachhang;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }
    
    
}
