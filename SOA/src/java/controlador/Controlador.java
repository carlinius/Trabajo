
package controlador;

import Principal.MatriculaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Matricula;


public class Controlador extends HttpServlet {

    String listar ="vistas/listar.jsp";
    String add="vistas/add.jsp";
    String edit="vistas/edit.jsp";
    
    Matricula matricula = new Matricula();
    MatriculaDAO matriculaDAO = new MatriculaDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso ="";
        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("listar")) 
        {
             acceso = listar;
        }
        else if(action.equalsIgnoreCase("add")) 
        {
            acceso = add;
        }
        else if(action.equalsIgnoreCase("Agregar")) 
        {
            String numeroMatricula = request.getParameter("txt_numeroMatricula");
            String nombre = request.getParameter("txt_nombre");
            String apellido = request.getParameter("txt_apellido");
            String registroCivil = request.getParameter("txt_registroCivil");
            String sexo = request.getParameter("txt_sexo");
            String fechaNacimiento = request.getParameter("txt_fechaNacimiento");
            String fechaIngreso = request.getParameter("txt_fechaIngreso");
            String grado = request.getParameter("txt_grado");
           
            matricula = new Matricula();
            matricula.setNumeroMatricula(numeroMatricula);
            matricula.setNombre(nombre);
            matricula.setApellido(apellido);
            matricula.setNumeroRegistroCivil(registroCivil);
            matricula.setSexo(sexo);
            matricula.setFechaNacimiento(fechaNacimiento);
            matricula.setFechaIngreso(fechaIngreso);
            matricula.setGrado(grado);
            
            matriculaDAO.add(matricula);
            acceso =listar;
        }else if(action.equalsIgnoreCase("editar"))
        {
            request.setAttribute("idMatricula",request.getParameter("id"));
            acceso = edit;
        }else if (action.equalsIgnoreCase("Actualizar")) 
        {
            String numeroMatricula = request.getParameter("txt_numeroMatricula");
            String nombre = request.getParameter("txt_nombre");
            String apellido = request.getParameter("txt_apellido");
            String registroCivil = request.getParameter("txt_registroCivil");
            String sexo = request.getParameter("txt_sexo");
            String fechaNacimiento = request.getParameter("txt_fechaNacimiento");
            String fechaIngreso = request.getParameter("txt_fechaIngreso");
            String grado = request.getParameter("txt_grado");
           
            matricula = new Matricula();
            matricula.setNumeroMatricula(numeroMatricula);
            matricula.setNombre(nombre);
            matricula.setApellido(apellido);
            matricula.setNumeroRegistroCivil(registroCivil);
            matricula.setSexo(sexo);
            matricula.setFechaNacimiento(fechaNacimiento);
            matricula.setFechaIngreso(fechaIngreso);
            matricula.setGrado(grado);
            
            matriculaDAO.actualizarMatricula(matricula);
            acceso =listar;
        }
        else if (action.equalsIgnoreCase("eliminar")) 
        {
            String id = request.getParameter("id");
            Matricula m = matriculaDAO.selecionarUnaMatricula(id);
            
            matriculaDAO.eliminarMatricula(m);
            
            
        }
        
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
