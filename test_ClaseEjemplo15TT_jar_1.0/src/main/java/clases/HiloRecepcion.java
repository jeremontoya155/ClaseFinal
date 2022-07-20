
package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class HiloRecepcion extends Thread {
    
    private String url,user;
    private final String query="SELECT * FROM persona";

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
    
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion=DriverManager.getConnection(url, user,"");
            Statement accion=conexion.createStatement();
            ResultSet resultado=accion.executeQuery(query);
            
            while(resultado.next()){
                System.out.println("------------------------");
                System.out.println("ID:"+resultado.getInt(1));
                System.out.println("Nombre:"+resultado.getString(2));
                System.out.println("Apellido:"+resultado.getString(3));
                System.out.println("Email:"+resultado.getString(4));
                System.out.println("Telefono:"+resultado.getString(5));
                System.out.println("------------------------");
                
            }
            
            resultado.close();
            accion.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Error conexion");
            ex.printStackTrace(System.out);
        } catch (SQLException ex) {
            
            System.out.println("Error en app");
            ex.printStackTrace(System.out);
            
        }
        
        
    }
    
    
    
    
    
    
}
