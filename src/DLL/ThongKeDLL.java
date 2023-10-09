/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DLL;

import DAL.ThongKeDAL;
import Entity.ThongKe;
import java.util.List;

/**
 *
 * @author hieun
 */
public class ThongKeDLL {
    ThongKeDAL tkdal = new ThongKeDAL();
    
    public List<ThongKe> getALLThongke(){
        return tkdal.getALLThongke();
    }
    
    public List<ThongKe> getALLThongkeByDate(String Date1, String Date2){
        return tkdal.getALLThongkeByDate(Date1, Date2);
    }
    
    public List<ThongKe> getALLThongkeByName(String Name){
        return tkdal.getALLThongkeByName(Name);
    }
}
