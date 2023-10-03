/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author hieun
 */
public class ChiTietHoaDon {
    private String soHD;
    private String maSanPham;
    private String sanPham;
    private float donGia;
    private int soLuong;
    private float tongTien;

    public ChiTietHoaDon(String maSanPham, String sanPham, float donGia, int soLuong, float tongTien) {
        this.maSanPham = maSanPham;
        this.sanPham = sanPham;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
    }

    public ChiTietHoaDon(String soHD, String maSanPham, String sanPham, float donGia, int soLuong, float tongTien) {
        this.soHD = soHD;
        this.maSanPham = maSanPham;
        this.sanPham = sanPham;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
    }    
    
    public String getSoHD() {
        return soHD;
    }

    public void setSoHD(String soHD) {
        this.soHD = soHD;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getSanPham() {
        return sanPham;
    }

    public void setSanPham(String sanPham) {
        this.sanPham = sanPham;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }
    
    
}
