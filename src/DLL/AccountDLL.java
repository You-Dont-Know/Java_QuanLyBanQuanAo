/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DAL.AccountDAL;
import Entity.NhanVien;

/**
 *
 * @author Aki
 */
public class AccountDLL {
    AccountDAL acc= new AccountDAL();
    public boolean getLogin(String u, String p)
    {
        return acc.getLogin(u, p);
    }
//    public boolean UpdateData(NhanVien acc1){
//        return acc.UpdateData(acc1);
//    }
//    public boolean CheckData(String u,String m){
//        return acc.getCheck(u, m);
//    }
//    public boolean UpdatePass(NhanVien acc2){
//        return acc.UpdatePass(acc2);
//    }
}
