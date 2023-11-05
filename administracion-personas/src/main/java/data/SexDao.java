package data;


import domain.Sex;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.ConnectionUtil;

public class SexDao {
    private static final String GET_SEXO = "select * from sexo"; 
    
    public List<Sex> obtenerSexo() throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Sex> sexs = new ArrayList<>();

        try {

            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_SEXO);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Sex sexo = new Sex();
                sexo.setId(resultSet.getInt("id"));
                sexo.setNombre(resultSet.getString("nombre"));
                sexs.add(sexo);
            }

            return sexs;
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
