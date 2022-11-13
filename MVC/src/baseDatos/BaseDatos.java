
package baseDatos;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Matricula;


public class BaseDatos 
{
    private static Connection connection;
    
    private static final  String driver ="com.mysql.jdbc.Driver";
    private static final  String user = "root";
    private static final  String pass = "";
    private static final  String url="jdbc:mysql://localhost:3306/actividad";
    
    Statement instruccion = null;
    ResultSet resultados = null;
    ResultSetMetaData  metaData = null;
    
    public BaseDatos()
    {
     connection = null;
        try {
            Class.forName(driver);
            connection = (Connection) DriverManager.getConnection(url,user,pass);
            if (connection!=null) 
            {
                System.out.println("conexion establecida");  
            }
        } catch (Exception e) {
        }
    }
    
    public void EJECUTE_QUERY(String query) 
    {
        try 
        {
            instruccion = connection.createStatement();
            java.sql.PreparedStatement pst = connection.prepareStatement(query);
            int deletedRows = pst.executeUpdate();
            System.out.println("--SE EJECUTO- CORRECTAMENTE-");

        } catch (SQLException e)
        {
            System.out.println("ERROR EJECUTE_QUERY -> " + e);
        }

    }
    
    public List<Matricula> SELECT_MATRICULAS()
    {
        
       List<Matricula> lista = new ArrayList<>();
       String query = "SELECT * FROM matriculas";

        try {
            
        
      // create the java statement
      Statement st = connection.createStatement();
      
      // execute the query, and get a java resultset
      ResultSet rs = st.executeQuery(query);
      
      // iterate through the java resultset
      while (rs.next())
      {
        String numeroMatricula = rs.getInt("numeroMatricula") + "";
        String nombre = rs.getString("nombre");
        String apellido = rs.getString("apellido");
        String registroCivil = rs.getString("registroCivil");
        String sexo = rs.getString("sexo");
        String fechaNacimiento = rs.getString("fechaNacimiento");
        String fechaIngresoGuarderia = rs.getString("fechaIngresoGuarderia");
        String grado = rs.getString("grado");
        
        Matricula m = new Matricula(numeroMatricula,nombre,apellido,registroCivil,sexo,fechaNacimiento,fechaIngresoGuarderia,grado);
        lista.add(m);
      }
      
      } catch (Exception e) 
      {
          System.out.println("ERROR AL TRAER LAS MATRICULAS");
      }
      return lista;
      
    }
    
    public boolean INSERT_MATRICULA(Matricula nuevo)
    {
        String query =" INSERT INTO `matriculas`(`numeroMatricula`, `nombre`, `apellido`, `registroCivil`, `sexo`, `fechaNacimiento`, `fechaIngresoGuarderia`, `grado`) "+
        " VALUES('"+nuevo.getNumeroMatricula()+"','"+
                nuevo.getNombre()+"','"+
                nuevo.getApellido()+"','"+
                nuevo.getNumeroRegistroCivil()+"','"+
                nuevo.getSexo()+"','"+
                nuevo.getFechaNacimiento()+"','"+
                nuevo.getFechaIngreso()+"','"+
                nuevo.getGrado()+"')";
         
        return EJECUTE_QUERY2(query);
    }
    
    public boolean DELETE_MATRICULA(String numeroMatricula)
    {
        String query ="DELETE FROM matriculas  WHERE `numeroMatricula` = "+ numeroMatricula+ ";";
        return EJECUTE_QUERY2(query);
    }
    
    public boolean UPDATE_MATRICULA(Matricula nuevo)
    {
        String SET   = "`nombre` = " +"'"+ nuevo.getNombre()+"'," + "\n" 
                          +"`apellido` = " +"'"+ nuevo.getApellido()+"',"+ "\n" 
                          +"`registroCivil` = " +"'"+ nuevo.getNumeroRegistroCivil()+"',"+ "\n" 
                          +"`sexo` = " +"'"+ nuevo.getSexo()+"',"+ "\n" 
                          +"`fechaNacimiento` ="+"'"+ nuevo.getFechaNacimiento()+"',"+ "\n" 
                          +"`fechaIngresoGuarderia` = "+"'" +nuevo.getFechaIngreso() +"', "+ "\n"
                          +"`grado` = "+"'" +nuevo.getGrado() +"'"+ "\n"
                          ;

            
        String id = "numeroMatricula = " + nuevo.getNumeroMatricula();
        String query = "UPDATE " +"MATRICULAS"+" SET "+ SET +" WHERE "+ id;
             
                
         return EJECUTE_QUERY2(query);
    }
   
    boolean EJECUTE_QUERY2(String query) 
    {
        try 
        {
            instruccion = connection.createStatement();
            java.sql.PreparedStatement pst = connection.prepareStatement(query);
            
            int deletedRows = pst.executeUpdate();
            System.out.println("--SE EJECUTO- CORRECTAMENTE-");
            
            

        } catch (SQLException e)
        {
            System.out.println("ERROR EJECUTE_QUERY -> " + e);
           
            return  true;
            
        }
        
        return false;
    }
}
