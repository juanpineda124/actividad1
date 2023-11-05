package data;

import domain.Tipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.ConnectionUtil;


public class TipoDao {
    private static final String GET_TIPOIDENTIFICACION = "select * from tipoIdentificacion"; 
    
    public List<Tipo> obtenerTipoIdentificacion() throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Tipo> tipos = new ArrayList<>();

        try {

            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_TIPOIDENTIFICACION);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Tipo tipo = new Tipo();
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
