/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Entity.NhanVien;
import java.util.List;

/**
 *
 * @author hieun
 */
public interface Interface_NhanVien {
    public final String GET_ALLNHANVIEN = "select * from nhanvien";
    public final String GET_UPDATENHANVIEN = " UPDATE NhanVien SET tennhanvien = ?, gioitinh = ?, ngaysinh =  ?, diachi = ?, sdt = ?, tendangnhap = ?, matkhau = ?, chucvu = ?  WHERE manhanvien= ?";
    public final String GET_DELETENHANVIEN = "DELETE FROM NhanVien WHERE manhanvien = ?";
    public final String GET_ADDNV = "INSERT INTO NhanVien VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public final String GET_CHECKNV = "select manhanvien from nhanvien where manhanvien = ?";
    public final String GET_MnsTnv = "select manhanvien,tennhanvien from nhanvien where tendangnhap = ?";
    public List<NhanVien> getMnsTnv(String tenDangNhap);
    public List<NhanVien> getALLNhanvien();
    public void UpdateNV(String manv, String tennv, String gioitinh, String ngaysinh, String diachi, String sdt, String tendn, String matkhau, String chucvu);
    public int deleteNV(String maNV);
    public void Them(String manv, String tennv, String gioitinh, String ngaysinh, String diachi, String sdt, String tendn, String matkhau, String chucvu);
}
