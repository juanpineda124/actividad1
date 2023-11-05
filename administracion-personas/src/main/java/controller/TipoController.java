package controller;


import data.TipoDao;
import domain.Tipo;
import java.sql.SQLException;
import java.util.List;


public class TipoController {
    private TipoDao tipoDao;
   
   public TipoController(){
       
       tipoDao = new TipoDao();
   }
   
   public List<Tipo> obtenerTipoIdentificacion() throws SQLException{
       return tipoDao.obtenerTipoIdentificacion();
   }
}
