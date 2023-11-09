package controller;


import data.SexoDao;
import domain.Sexo;
import java.sql.SQLException;
import java.util.List;

public class SexoController {
      private SexoDao sexoDao;
   
   public SexoController(){
       
       sexoDao = new SexoDao();
   }
   
   public List<Sexo> obtenerSexo() throws SQLException{
       return sexoDao.obtenerSexo();
   }
}
