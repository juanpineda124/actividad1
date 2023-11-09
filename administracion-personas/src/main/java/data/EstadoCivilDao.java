package data;


import domain.EstadoCivil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.ConnectionUtil;

public class EstadoCivilDao {
     private static final String GET_ESTADICIVIL = "select * from estados_Civiles"; 
    
    public List<EstadoCivil> obtenerEstadoCivil() throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<EstadoCivil> estados = new ArrayList<>();

        try {

            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_ESTADICIVIL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                EstadoCivil estado = new EstadoCivil();
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
