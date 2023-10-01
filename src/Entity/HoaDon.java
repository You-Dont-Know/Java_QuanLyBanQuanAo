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
public class HoaDon {

    private String soHD;
    private String maNhanVien;
    private String nhanVienLap;
    private Date ngayLap;
    private int maKH;

    public HoaDon(String soHD, String maNhanVien, String nhanVienLap, Date ngayLap, int maKH) {
        this.soHD = soHD;
        this.maNhanVien = maNhanVien;
        this.nhanVienLap = nhanVienLap;
        this.ngayLap = ngayLap;
        this.maKH = maKH;
    }

    
    public String getSoHD() {
        return soHD;
    }

    public void setSoHD(String soHD) {
        this.soHD = soHD;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getNhanVienLap() {
        return nhanVienLap;
    }

    public void setNhanVienLap(String nhanVienLap) {
        this.nhanVienLap = nhanVienLap;
    }

    public String getNgayLap() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        return df.format(ngayLap);
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

}
