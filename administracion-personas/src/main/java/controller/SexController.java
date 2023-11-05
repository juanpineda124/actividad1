package controller;


import data.SexDao;
import domain.Sex;
import java.sql.SQLException;
import java.util.List;

public class SexController {
      private SexDao sexDao;
   
   public SexController(){
       
       sexDao = new SexDao();
   }
   
   public List<Sex> obtenerSexo() throws SQLException{
       return sexDao.obtenerSexo();
   }
}
