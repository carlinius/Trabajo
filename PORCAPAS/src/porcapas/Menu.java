
package porcapas;

import baseDatos.BaseDatos;
import java.util.List;
import java.util.Scanner;
import modelo.Matricula;


public class Menu 
{
    private BaseDatos bd= null;
    int opcion;
    Scanner lectura = new Scanner (System.in);
    
    public Menu()
    {
        bd = new BaseDatos();
    }
    public void verMenu()
    {
        System.out.println("[ 1 ] Registrar Matricula");
        System.out.println("[ 2 ] Ver Matriculas");
        System.out.println("[ 3 ] Actualizar Matricula");
        System.out.println("[ 4 ] Eliminar Matricula");
        
       
        System.out.println("Ingrese una Opcion: ");
        int opcion = lectura.nextInt();
        
        //String nombre = lectura.next();
       
        switch(opcion)
        {
            case 1:registrarMatricula();
                break;
            case 2:verMatriculas();
                break;
            case 3:actualizarMatricula();
                break;
            case 4:eliminarMatricula();
                break;
        }
    }
    
    void registrarMatricula()
    {
        System.out.println("------REGISTRAR NUEVA MATRICULA--------: ");
        
        System.out.println("Ingrese el Numero de Matricula");
        String numeroMatricula = lectura.next();
        
        System.out.println("Ingrese el nombre");
        String nombre = lectura.next();
        
        System.out.println("Ingrese el Apellido");
        String apellido = lectura.next();
        
        System.out.println("Ingrese el Numero Registro Civil");
        String registroCivil = lectura.next();
        
        System.out.println("Ingrese el sexo");
        String sexo = lectura.next();
        
        System.out.println("Ingrese la fecha Nacimiento  [dia/mes/anio]");
        String fechaNacimiento = lectura.next();
        
        System.out.println("Ingrese la fecha de Ingreso Guarderia  [dia/mes/anio]");
        String fechaIngresoGuarderia = lectura.next();
        
        System.out.println("Ingrese el grado");
        String grado = lectura.next();
        
        String query =" INSERT INTO `matriculas`(`numeroMatricula`, `nombre`, `apellido`, `registroCivil`, `sexo`, `fechaNacimiento`, `fechaIngresoGuarderia`, `grado`) "+
        " VALUES('"+numeroMatricula+"','"+nombre+"','"+apellido+"','"+registroCivil+"','"+sexo+"','"+fechaNacimiento+"','"+fechaIngresoGuarderia+"','"+grado+"')";
         
        bd.EJECUTE_QUERY(query);
    }
    
    void verMatriculas()
    {
         System.out.println("------LISTADO DE  MATRICULAS--------: ");
      List<Matricula> lista = bd.listaMatriculas();
      
        for (int i = 0; i < lista.size(); i++) {
            Matricula get = lista.get(i);
            System.out.println("--------------------------------------------");
            System.out.println("|No Matricula | "+get.getNumeroMatricula() +"\n" +
                               "|Nombre       | "+get.getNombre()+"\n" +
                               "|Apellido     | "+get.getNumeroRegistroCivil()+"\n" +
                               "|RegistroCivil| "+get.getSexo()+"\n" +
                               "|sexo         | "+get.getFechaNacimiento()+"\n" +
                               "|fechaNacimiento|"+get.getFechaIngreso()+"\n" +
                               "|Grado        | "+get.getGrado());
            System.out.println("--------------------------------------------");
        }
    
    }
    
    void actualizarMatricula()
    {
        System.out.println("------ACTUALIZAR MATRICULA--------: ");
        List<Matricula> lista = bd.listaMatriculas();
        System.out.println("------ELIMINAR MATRICULA--------: ");
        System.out.println("Ingrese El numero de matricula a Actualizar");
        String numeroMatricula = lectura.next();
        
        for (int i = 0; i < lista.size(); i++) 
        {
            Matricula get = lista.get(i);
            if (get.getNumeroMatricula().equals(numeroMatricula))
                    {
                System.out.println("Ingrese el nombre");
                String nombre = "'"+lectura.next()+"'";

                System.out.println("Ingrese el Apellido");
                String apellido ="'"+ lectura.next()+"'";

                System.out.println("Ingrese el Numero Registro Civil");
                String registroCivil = "'"+lectura.next()+"'";

                System.out.println("Ingrese el sexo");
                String sexo = "'"+lectura.next()+"'";

                System.out.println("Ingrese la fecha Nacimiento  [dia/mes/anio]");
                String fechaNacimiento = "'"+lectura.next()+"'";

                System.out.println("Ingrese la fecha de Ingreso Guarderia  [dia/mes/anio]");
                String fechaIngresoGuarderia = "'"+lectura.next()+"'";

                System.out.println("Ingrese el grado");
                String grado = "'"+lectura.next()+"'";
                
                String query = "UPDATE  `matriculas` SET `numeroMatricula` = "+numeroMatricula + ",`nombre`= "+nombre
                        +",`apellido` = " +apellido + ",`registroCivil` = "+ registroCivil
                        +",`sexo`  = " +sexo+",`fechaNacimiento` ="+ fechaNacimiento + ",`fechaIngresoGuarderia`="+fechaIngresoGuarderia
                        +",`grado` = " +grado + "where "+ numeroMatricula;
                
                
                bd.EJECUTE_QUERY(query);
                
                System.out.println("SE ACTUALIZO LA MATRICULA");
            }
            else
            {
                 System.out.println("NO SE PUDO ACTUALIZAR LA MATRICULA");
            }
        }
    }
    
    void eliminarMatricula()
    {
        List<Matricula> lista = bd.listaMatriculas();
        System.out.println("------ELIMINAR MATRICULA--------: ");
        System.out.println("Ingrese El numero de matricula a Eliminar");
        String numeroMatricula = lectura.next();
        
        for (int i = 0; i < lista.size(); i++) 
        {
            Matricula get = lista.get(i);
            if (get.getNumeroMatricula().equals(numeroMatricula))
            {
                String query = "DELETE FROM `matriculas` WHERE `numeroMatricula` = "+numeroMatricula;
                bd.EJECUTE_QUERY(query);
                System.out.println("SE ELIMINO LA MATRICULA");
            }
            else{
                 System.out.println("NO SE PUDO ELIMINAR LA MATRICULA");
            }
        }
       

    }
    
}



