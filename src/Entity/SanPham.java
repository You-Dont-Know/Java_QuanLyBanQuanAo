/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author hieun
 */
public class SanPham {
    private String maSanPham;
    private String tenSanPham;
    private int maLoaiSanPham;
    private float giaNhap; 
    private float giaBan;
    private String moTaSanPham;
    private String size;
    private Date ngaySanXuat;
    private int soLuong;
    public SanPham(){
        
    }

    public SanPham(String maSanPham, String tenSanPham, int maLoaiSanPham, float giaNhap, float giaBan, String moTaSanPham, String size, Date ngaySanXuat, int soLuong) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.maLoaiSanPham = maLoaiSanPham;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.moTaSanPham = moTaSanPham;
        this.size = size;
        this.ngaySanXuat = ngaySanXuat;
        this.soLuong = soLuong;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getMaLoaiSanPham() {
        return maLoaiSanPham;
    }

    public void setMaLoaiSanPham(int maLoaiSanPham) {
        this.maLoaiSanPham = maLoaiSanPham;
    }

    public float getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(float giaNhap) {
        this.giaNhap = giaNhap;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public String getMoTaSanPham() {
        return moTaSanPham;
    }

    public void setMoTaSanPham(String moTaSanPham) {
        this.moTaSanPham = moTaSanPham;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
  
    public String getNgaySanXuat() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        return df.format(ngaySanXuat);
    }
    
    public void setNgaySanXuat(Date ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }

  
}
