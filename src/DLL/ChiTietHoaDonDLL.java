/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DLL;

import DAL.ChiTietHoaDonDAL;
import Entity.ChiTietHoaDon;
import java.util.List;

/**
 *
 * @author hieun
 */
public class ChiTietHoaDonDLL {
    ChiTietHoaDonDAL cchddal = new ChiTietHoaDonDAL();
    public List<ChiTietHoaDon> getALLChiTietHoaDon(){
        return cchddal.getALLChiTietHoaDon();
    }
}
