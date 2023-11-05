package data;


import domain.Estado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.ConnectionUtil;

public class EstadoDao {
     private static final String GET_ESTADICIVIL = "select * from estadoCivil"; 
    
    public List<Estado> obtenerEstadoCivil() throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Estado> estados = new ArrayList<>();

        try {

            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_ESTADICIVIL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Estado estado = new Estado();
                estado.setId(resultSet.getInt("id"));
                estado.setNombre(resultSet.getString("nombre"));
                estados.add(estado);
            }

            return estados;
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
