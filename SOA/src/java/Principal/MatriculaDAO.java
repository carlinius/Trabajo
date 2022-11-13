
package Principal;
import BaseDatos.BaseDatos;
import java.util.ArrayList;
import java.util.List;
import modelo.Matricula;

public class MatriculaDAO 
{
    BaseDatos bd = new BaseDatos();
    Matricula matricula = new Matricula();
    public MatriculaDAO()
    {
        bd = new BaseDatos();
    }
    
    public List<Matricula> listaMatriculas()
    {
         ArrayList<Matricula> list = (ArrayList<Matricula>) bd.SELECT_MATRICULAS();
         return list;
    }
    
    public boolean add(Matricula nueva)
    {
       
       boolean correct = bd.INSERT_MATRICULA(nueva);
        return correct;
    }
    
    public boolean actualizarMatricula(Matricula nueva)
    {
        boolean correct =bd.UPDATE_MATRICULA(nueva);
        return correct;
    }
    
    public Matricula selecionarUnaMatricula(String numeroMatricula)
    {
        ArrayList<Matricula> list =(ArrayList<Matricula>) listaMatriculas();
        for (int i = 0; i < list.size(); i++) {
            Matricula get = list.get(i);
            if (get.getNumeroMatricula().equals(numeroMatricula)) 
            {
            return get;    
            }
            
        }
        return null;   
    }
    
    public boolean eliminarMatricula(Matricula nueva)
    {
        boolean correct = bd.DELETE_MATRICULA(nueva.getNumeroMatricula());
        return correct;
        
    }
}
