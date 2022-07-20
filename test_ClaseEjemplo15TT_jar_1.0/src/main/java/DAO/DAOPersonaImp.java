
package DAO;

import Interfaces.DAOPersona;
import clases.Persona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DAOPersonaImp extends Conexion implements DAOPersona{

    private final String REGISTRO="INSERT INTO persona(nombre,apellido,email,telefono) VALUES(?,?,?,?)";
    private final String MODIFICAR="UPDATE persona SET telefono=? WHERE nombre=?";
    private final String ELIMINAR="DELETE FROM persona WHERE nombre=?";
    private final String RECUPERAR ="SELECT * FROM persona";

    @Override
    public void registrar(List<Persona> lista) throws ClassNotFoundException, SQLException {
       
        this.conectar();
        PreparedStatement accion=this.conexion.prepareStatement(REGISTRO);
        
        for (Persona persona : lista) {
            
                accion.setString(1,persona.getNombre());
                accion.setString(2,persona.getApellido());
                accion.setString(3,persona.getEmail());
                accion.setString(4,persona.getTelefono());
                accion.executeUpdate();
            
        }
        
        System.out.println("Se actulizaron los registros");
        accion.close();
        this.cerrar();
    }

    
    @Override
    public void modificar(Persona per) throws ClassNotFoundException, SQLException {
        
        this.conectar();
        PreparedStatement accion=this.conexion.prepareStatement(MODIFICAR);
        accion.setString(1, per.getTelefono());
        accion.setString(2, per.getNombre());
        accion.executeUpdate();
        
        accion.close();
        this.cerrar();
        System.out.println("Se modifico correctamente  el registro");
        
        
    }

    @Override
    public void eliminar(Persona per) throws ClassNotFoundException, SQLException {
        
        this.conectar();
        PreparedStatement accion=this.conexion.prepareStatement(ELIMINAR);
        
        accion.setString(1, per.getNombre());
        accion.executeUpdate();
        System.out.println("Se elimino la persona ingresada");
        accion.close();
        this.cerrar();
    }

    @Override
    public List<Persona> recuperar() throws ClassNotFoundException, SQLException {
        
        List<Persona> lista=new ArrayList<>();
        this.conectar();
        Statement accion=this.conexion.createStatement();
        ResultSet resultado=accion.executeQuery(RECUPERAR);
        
        while(resultado.next()){
        
            lista.add(
                    new Persona(
                            resultado.getInt(1),
                            resultado.getString(2),
                            resultado.getString(3),
                            resultado.getString(4),
                            resultado.getString(5))
            );
        
        }
        
        
        lista.forEach(System.out::println);
        return lista;
        
    }
    
    
    
}
//