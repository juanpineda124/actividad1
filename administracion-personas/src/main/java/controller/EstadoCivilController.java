package controller;


import data.EstadoCivilDao;
import domain.EstadoCivil;
import java.sql.SQLException;
import java.util.List;

public class EstadoCivilController {
   private EstadoCivilDao estadoCivilDao;
   
   public EstadoCivilController(){
       
       estadoCivilDao = new EstadoCivilDao();
   }
   
   public List<EstadoCivil> obtenerEstadoCivil() throws SQLException{
       return estadoCivilDao.obtenerEstadoCivil();
   }  
}
