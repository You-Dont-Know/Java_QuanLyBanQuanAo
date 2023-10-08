/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author hieun
 */
public class KhachHang {
    private int maKH;
    private String tenKhach;
    private String diaChi;
    private String gioiTinh;
    private String sdt;
    private int maloaikhachhang;

    public KhachHang(int maKH, String tenKhach, String diaChi, String gioiTinh, String sdt, int maloaikhachhang) {
        this.maKH = maKH;
        this.tenKhach = tenKhach;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.maloaikhachhang = maloaikhachhang;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getTenKhach() {
        return tenKhach;
    }

    public void setTenKhach(String tenKhach) {
        this.tenKhach = tenKhach;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getMaloaikhachhang() {
        return maloaikhachhang;
    }

    public void setMaloaikhachhang(int maloaikhachhang) {
        this.maloaikhachhang = maloaikhachhang;
    }

    
    
    
}
