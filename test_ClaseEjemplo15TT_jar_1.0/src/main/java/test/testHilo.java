
package test;

import DAO.DAOPersonaImp;
import clases.HiloEnvio;
import clases.HiloRecepcion;
import clases.Persona;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class testHilo {
    
    public static void main(String[] args) {
        
        
        List<Persona> personas=new ArrayList<>();
        personas.add(new Persona("asd","asd","asd","asd"));        
        personas.add(new Persona("asb","asd","asd","asd"));
        personas.add(new Persona("asc","asd","asd","asd"));
        personas.add(new Persona("Martin Jesus","Gallardo","asd","asd"));
        

        
        
//        HiloEnvio he=new HiloEnvio();
//        HiloRecepcion hr=new HiloRecepcion();
//        
//        he.setLista(personas);
//        he.setUrl("jdbc:mysql://localhost:3306/nuevaBaseDatos");
//        he.setUser("root");
//        //he.start();
//        
//        hr.setUrl("jdbc:mysql://localhost:3306/nuevaBaseDatos");
//        hr.setUser("root");
        //hr.start();
        
        int a=10;
        String aPrima=String.valueOf(a);
        
        System.out.println(aPrima.equals("10"));
        
        
        DAOPersonaImp  personaDAO=new DAOPersonaImp();
        
//        try {
//            
//            //personaDAO.registrar(personas);
//            //List<Persona> recuperada=personaDAO.recuperar();
//            personaDAO.eliminar(new Persona("Martin Jesus","","",""));
//            //personaDAO.modificar(new Persona("Javier","asd","asd","35121254"));            
//        } catch (ClassNotFoundException ex) {
//            System.out.println("Error en la descarga");
//            ex.printStackTrace(System.out);
//        } catch (SQLException ex) {
//            System.out.println("Error en la app");
//            ex.printStackTrace(System.out);
//        }
        
    }
    
}
