
package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;



public class HiloEnvio extends Thread{
    
    private List<Persona> lista;
    private String url,user;
    private final String query="INSERT INTO persona(nombre,apellido,email,telefono) VALUES(?,?,?,?)";

    public List<Persona> getLista() {
        return lista;
    }

    public void setLista(List<Persona> lista) {
        this.lista = lista;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    
    
    
    @Override
    public void run() {
        if ((this.user.isEmpty())&&(this.url.isEmpty())) {
            
            System.out.println("Debe cargar previamente el url   y el usuario");
            
        }else{
        
            try {
            int actualizacion;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion=DriverManager.getConnection(url,user,"");
            PreparedStatement accion=conexion.prepareStatement(query);
            for (Persona persona : lista) {
                
                accion.setString(1,persona.getNombre());
                accion.setString(2,persona.getApellido());
                accion.setString(3,persona.getEmail());
                accion.setString(4,persona.getTelefono());
                actualizacion=accion.executeUpdate();
                System.out.println(actualizacion);
                
                
            }
            
            
            accion.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            
            System.out.println("Error en la conexion");
            ex.printStackTrace(System.out);
        } catch (SQLException ex) {
            System.out.println("Error de app");
            ex.printStackTrace(System.out);
        }
        
        }
        
        
        
        
    }
    
    
    
}
