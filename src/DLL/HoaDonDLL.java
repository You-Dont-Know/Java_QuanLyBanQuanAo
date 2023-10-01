/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DLL;

import DAL.HoaDonDAL;
import Entity.HoaDon;
import java.util.List;
/**
 *
 * @author hieun
 */
public class HoaDonDLL {
    HoaDonDAL hddal = new HoaDonDAL();
    public List<HoaDon> getALLHoaDon(){
        return hddal.getALLHoaDon();
    }
}
