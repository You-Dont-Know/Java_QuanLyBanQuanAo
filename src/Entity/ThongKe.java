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
public class ThongKe {
    private Date NgayLap;
    private String soHD;
    private int TongSoHD;
    private float TongTien;
    private String MaNhanVien;
    private String NhanvienLapHoaDon;
    private String SanPham;
    private float dongia;
    private int soluong;
    
    private int TongSoSanPham;  
    

    public ThongKe(Date NgayLap, int TongSoSanPham, float TongTien, String MaNhanVien, String NhanvienLapHoaDon) {
        this.NgayLap = NgayLap;
        this.TongSoSanPham = TongSoSanPham;
        this.TongTien = TongTien;
        this.MaNhanVien = MaNhanVien;
        this.NhanvienLapHoaDon = NhanvienLapHoaDon;
    }

    public ThongKe(Date NgayLap, String soHD, int TongSoHD, float TongTien, String MaNhanVien, String NhanvienLapHoaDon, String SanPham, float dongia, int soluong) {
        this.NgayLap = NgayLap;
        this.soHD = soHD;
        this.TongSoHD = TongSoHD;
        this.TongTien = TongTien;
        this.MaNhanVien = MaNhanVien;
        this.NhanvienLapHoaDon = NhanvienLapHoaDon;
        this.SanPham = SanPham;
        this.dongia = dongia;
        this.soluong = soluong;
    }

    public String getSoHD() {
        return soHD;
    }

    public void setSoHD(String soHD) {
        this.soHD = soHD;
    }

    public int getTongSoHD() {
        return TongSoHD;
    }

    public void setTongSoHD(int TongSoHD) {
        this.TongSoHD = TongSoHD;
    }

    public String getSanPham() {
        return SanPham;
    }

    public void setSanPham(String SanPham) {
        this.SanPham = SanPham;
    }

    public float getDongia() {
        return dongia;
    }

    public void setDongia(float dongia) {
        this.dongia = dongia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
    
    

    public String getNgayLap() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        return df.format(NgayLap);
    }

    public void setNgayLap(Date NgayLap) {
        this.NgayLap = NgayLap;
    }

    public int getTongSoSanPham() {
        return TongSoSanPham;
    }

    public void setTongSoSanPham(int TongSoSanPham) {
        this.TongSoSanPham = TongSoSanPham;
    }

    public float getTongTien() {
        return TongTien;
    }

    public void setTongTien(float TongTien) {
        this.TongTien = TongTien;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getNhanvienLapHoaDon() {
        return NhanvienLapHoaDon;
    }

    public void setNhanvienLapHoaDon(String NhanvienLapHoaDon) {
        this.NhanvienLapHoaDon = NhanvienLapHoaDon;
    }
    
    
}
