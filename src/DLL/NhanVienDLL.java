/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DLL;

import DAL.NhanVienDAL;
import Entity.NhanVien;
import java.util.List;

/**
 *
 * @author hieun
 */
public class NhanVienDLL {

    NhanVienDAL nvdal = new NhanVienDAL();
    public List<NhanVien> getALLNhanvien() {
        return nvdal.getALLNhanvien();
    }
    public void UpdateNV(String manv, String tennv, String gioitinh, String ngaysinh, String diachi, String sdt, String tendn, String matkhau, String chucvu) {
        nvdal.UpdateNV(manv, tennv, gioitinh, ngaysinh, diachi, sdt, tendn, matkhau, chucvu);
    }
    
    public int deleteNV(String maNV){
        return nvdal.deleteNV(maNV);
    }
    
    public void Them(String manv, String tennv, String gioitinh, String ngaysinh, String diachi, String sdt, String tendn, String matkhau, String chucvu){
        nvdal.Them(manv, tennv, gioitinh, ngaysinh, diachi, sdt, tendn, matkhau, chucvu);
    }
    
    public List<NhanVien> getMnsTnv(String tenDangNhap){
        return nvdal.getMnsTnv(tenDangNhap);
    }
}
