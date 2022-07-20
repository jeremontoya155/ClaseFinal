
package Interfaces;

import clases.Persona;
import java.sql.SQLException;
import java.util.List;


public interface DAOPersona {
    
    public void registrar(List<Persona> lista) throws ClassNotFoundException,SQLException;
    public void modificar(Persona per) throws ClassNotFoundException,SQLException;
    public void eliminar(Persona per) throws ClassNotFoundException,SQLException;
    public List<Persona> recuperar() throws ClassNotFoundException,SQLException;
    
    
    
    
}
