package data;

import domain.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.ConnectionUtil;

public class FuncionarioDao {

    private static final String GET_FUNCIONARIOS = "select * from funcionarios";

    private static final String CREATE_FUNCIONARIO = "INSERT INTO funcionarios "
            + "(tipo_identificacion_id, numero_identificacion, nombres, apellidos, estado_civil_id, sexo_id, direccion, telefono, fecha_nacimiento) "
            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String GET_FUNCIONARIO_BY_ID = "selec * from funcionarios where id = ?";

    private static final String UPDATE_FUNCIONARIO =  "update funcionarios set tipo_identificacion_id = ?,"
           + "numero_identificacion = ?, nombres = ?, apellidos = ?, estado_Civil_id = ?, sexo_id = ?," 
           + "direccion = ?, telefono = ?, fecha_nacimiento = ? where id = ?";
    
    private static final String DELETE_FUNCIONARIO = "delete from funcionarios where id = ? ";

    public List<Funcionario> obtenerFuncionarios() throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Funcionario> funcionarios = new ArrayList<>();

        try {

            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIOS);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Funcionario funcionario = new Funcionario();
                funcionario.setId(resultSet.getInt("id"));
                funcionario.setTipoIdentificacion_id(resultSet.getShort("tipo_identificacion_id"));
                funcionario.setNumeroIdentificacion(resultSet.getString("numero_identificacion"));
                funcionario.setNombres(resultSet.getString("nombres"));
                funcionario.setApellidos(resultSet.getString("apellidos"));
                funcionario.setEstadoCivil_id(resultSet.getShort("estado_civil_id"));
                funcionario.setSexo_id(resultSet.getShort("sexo_id"));
                funcionario.setDireccion(resultSet.getString("direccion"));
                funcionario.setTelefono(resultSet.getString("telefono"));
                funcionario.setFechaNacimiento(resultSet.getString("fecha_nacimiento"));
                funcionarios.add(funcionario);
            }

            return funcionarios;
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
    
     public void crearFuncionario(Funcionario funcionario) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(CREATE_FUNCIONARIO);
            preparedStatement.setShort(1, funcionario.getTipoIdentificacion_id());
            preparedStatement.setString(2, funcionario.getNumeroIdentificacion());
            preparedStatement.setString(3, funcionario.getNombres());
            preparedStatement.setString(4, funcionario.getApellidos());
            preparedStatement.setShort(5, funcionario.getEstadoCivil_id());
            preparedStatement.setShort(6, funcionario.getSexo_id());
            preparedStatement.setString(7, funcionario.getDireccion());
            preparedStatement.setString(8, funcionario.getTelefono());
            preparedStatement.setString(9, funcionario.getFechaNacimiento());
            preparedStatement.executeUpdate();
     
        } finally {
            if (connection != null){
                connection.close();
            }
            
            if(preparedStatement != null){
                preparedStatement.close();
            }
        }
    }
    
    public Funcionario obtenerFuncionario(int id) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Funcionario funcionario = null;

        try {

            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIO_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            
            
            if (resultSet.next()) {

                funcionario = new Funcionario();
                funcionario.setId(resultSet.getInt("id"));
                funcionario.setTipoIdentificacion_id(resultSet.getShort("tipo_identificacion"));
                funcionario.setNumeroIdentificacion(resultSet.getString("numero_identificacion"));
                funcionario.setNombres(resultSet.getString("nombres"));
                funcionario.setApellidos(resultSet.getString("apellidos"));
                funcionario.setEstadoCivil_id(resultSet.getShort("estado_civil"));
                funcionario.setSexo_id(resultSet.getShort("sexo"));
                funcionario.setDireccion(resultSet.getString("direccion"));
                funcionario.setTelefono(resultSet.getString("telefono"));
                funcionario.setFechaNacimiento(resultSet.getString("fecha_nacimiento"));
            }

            return funcionario;
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
    
    public void actualizarFuncionario(int id, Funcionario funcionario) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_FUNCIONARIO);
            preparedStatement.setShort(1, funcionario.getTipoIdentificacion_id());
            preparedStatement.setString(2, funcionario.getNumeroIdentificacion());
            preparedStatement.setString(3, funcionario.getNombres());
            preparedStatement.setString(4, funcionario.getApellidos());
            preparedStatement.setShort(5, funcionario.getEstadoCivil_id());
            preparedStatement.setShort(6, funcionario.getSexo_id());
            preparedStatement.setString(7, funcionario.getDireccion());
            preparedStatement.setString(8, funcionario.getTelefono());
            preparedStatement.setString(9, funcionario.getFechaNacimiento());
            preparedStatement.setInt(10, funcionario.getId());
            preparedStatement.executeUpdate();
     
        } finally {
            if (connection != null){
                connection.close();
            }
            
            if(preparedStatement != null){
                preparedStatement.close();
            }
        }
    }
     
    public void eliminarFuncionario(int id) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_FUNCIONARIO);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            
        } finally {
            if (connection != null){
                connection.close();
            }
            
            if(preparedStatement != null){
                preparedStatement.close();
            }
        }
    }  
}
 