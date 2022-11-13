
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
    
    public List<Matricula> listaMatriculas()
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
    
}
