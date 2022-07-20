
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    
    private final String USER="root";
    private final String URL="jdbc:mysql://localhost:3306/nuevaBaseDatos";
    protected Connection conexion;
    
    
    public void conectar () throws ClassNotFoundException, SQLException{
        
        
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conexion=DriverManager.getConnection(URL, USER,"");
                
            
       
    
    }
    
    public void  cerrar() throws SQLException{
    
        if (conexion!=null) {
         
                if (!conexion.isClosed()) {
                    conexion.close();
                    
                }
           
               
           
            
        }
    
    }
    
    
}
