package com.iudigital.presentacion;

import controller.FuncionarioController;
import domain.Funcionario;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

public class AdministracionFuncionarios {
    
    public static void crearFuncionario(FuncionarioController funcionarioController) {
        try {
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Digite el tipo de documento de identidad");
            Short tipoIdentificacion = sc.nextShort();
            sc.nextLine();
            System.out.println("El tipo de identificacion es: " + tipoIdentificacion);
            System.out.println("______________________________________________________________________");
            
            System.out.println("Digite el numero de identificacion");
            String numeroIdentificacion = sc.nextLine();
            System.out.println("El numero de identificaion es: " + numeroIdentificacion);
            System.out.println("______________________________________________________________________");
            
            System.out.println("Digite los nombres del funcionario");
            String nombres = sc.nextLine();
            System.out.println("Los nombres son: " + nombres);
            System.out.println("______________________________________________________________________");
            
            System.out.println("Digite los apellidos del funcionario");
            String apellidos = sc.nextLine();
            System.out.println("Los apellidos son: " + apellidos);
            System.out.println("______________________________________________________________________");
            
            System.out.println("Digite el estado civil");
            Short estadoCivil_id = sc.nextShort();
            System.out.println("El estado civil es: " + estadoCivil_id);
            System.out.println("______________________________________________________________________");
            
            System.out.println("Digite el sexo del funcionario");
            Short sexo_id = sc.nextShort();
            sc.nextLine();
            System.out.println("El sexo es: " + sexo_id);
            System.out.println("______________________________________________________________________");
      
            
            System.out.println("Digite la direccion de recidencia");
            String direccion = sc.nextLine();
            System.out.println("La direccion de residencia es: " + direccion);
            System.out.println("______________________________________________________________________");
            
            System.out.println("Digite el numero de telefono de contacto");
            String telefono = sc.nextLine();
            System.out.println("El numero de telefono es: " + telefono);
            System.out.println("______________________________________________________________________");
            
            System.out.println("Digite la fecha de nacimiento");
            String fechaNacimiento = sc.nextLine();
            System.out.println("La fecha de nacimiento es: " + fechaNacimiento);
            System.out.println("______________________________________________________________________");
            
            Funcionario funcionario = new Funcionario();
            funcionario.setTipoIdentificacion_id(tipoIdentificacion);
            funcionario.setNumeroIdentificacion(numeroIdentificacion);
            funcionario.setNombres(nombres);
            funcionario.setApellidos(apellidos);
            funcionario.setEstadoCivil_id(estadoCivil_id);
            funcionario.setSexo_id(sexo_id);
            funcionario.setDireccion(direccion);
            funcionario.setTelefono(telefono);
            funcionario.setFechaNacimiento(fechaNacimiento);
            
            funcionarioController.crearFuncionario(funcionario);
            System.out.println("El funcionario se creo con exito");
            System.out.println("______________________________________________________________________");
            System.out.println("");
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
   }

    public static void main(String[] args) throws SQLException {
    
            FuncionarioController funcionarioController = new FuncionarioController();
            crearFuncionario(funcionarioController);
    }
}
