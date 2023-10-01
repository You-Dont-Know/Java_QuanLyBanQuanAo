/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DLL;

import Entity.SanPham;
import java.util.List;
import DAL.SanPhamDAL;
/**
 *
 * @author hieun
 */
public class SanPhamDLL {
    SanPhamDAL spdal = new SanPhamDAL();
    public List<SanPham> getALLSanPham(){
        return spdal.getALLSanPham();
    }
}
