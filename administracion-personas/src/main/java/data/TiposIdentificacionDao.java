package data;

import domain.TipoIdentificacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.ConnectionUtil;


public class TiposIdentificacionDao {
    private static final String GET_TIPOIDENTIFICACION = "select * from tipos_Identificaciones"; 
    
    public List<TipoIdentificacion> obtenerTipoIdentificacion() throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<TipoIdentificacion> tipos = new ArrayList<>();

        try {

            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_TIPOIDENTIFICACION);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                TipoIdentificacion tipo = new TipoIdentificacion();
                tipo.setId(resultSet.getInt("id"));
                tipo.setNombre(resultSet.getString("nombre"));
                tipos.add(tipo);
            }

            return tipos;
        } finally {
            if (connection != null){
                connection.close();
            }
            
            if(preparedStatement != null){
                preparedStatement.close();
            }
            
            if(resultSet != null){
                resultSet.close();
            }
        }
    }
}
