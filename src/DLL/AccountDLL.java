/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DAL.TaiKhoanDAL;
import Entity.NhanVien;

/**
 *
 * @author Aki
 */
public class AccountDLL {
    TaiKhoanDAL acc= new TaiKhoanDAL();
    public String getLogin(String u, String p)
    {
        return acc.getLogin(u, p);
    }
}
