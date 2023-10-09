/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Aki
 */
public class NhanVien {
    private String maNhanVien;
    private String tenNhanVien;
    private String gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String sdt;
    private String tenDangNhap;
    private String matKhau;
    private String chucVu;

    public NhanVien(){};

    public NhanVien(String maNhanVien, String tenNhanVien) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
    }
      
    
    public NhanVien(String maNhanVien, String tenNhanVien, String gioiTinh, Date ngaySinh, String diaChi, String sdt, String tenDangNhap, String matKhau, String chucVu) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.chucVu = chucVu;
    }
    
    
    
    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        return df.format(ngaySinh);
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
    

    
    
}
