package controller;


import data.EstadoDao;
import domain.Estado;
import java.sql.SQLException;
import java.util.List;

public class EstadoController {
   private EstadoDao estadoDao;
   
   public EstadoController(){
       
       estadoDao = new EstadoDao();
   }
   
   public List<Estado> obtenerEstadoCivil() throws SQLException{
       return estadoDao.obtenerEstadoCivil();
   }  
}
