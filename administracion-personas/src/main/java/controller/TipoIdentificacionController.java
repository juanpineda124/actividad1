package controller;


import data.TiposIdentificacionDao;
import domain.TipoIdentificacion;
import java.sql.SQLException;
import java.util.List;


public class TipoIdentificacionController {
    private TiposIdentificacionDao tipoIdentificacionDao;
   
   public TipoIdentificacionController(){
       
       tipoIdentificacionDao = new TiposIdentificacionDao();
   }
   
   public List<TipoIdentificacion> obtenerTipoIdentificacion() throws SQLException{
       return tipoIdentificacionDao.obtenerTipoIdentificacion();
   }
}
