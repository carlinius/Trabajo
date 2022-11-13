
<%@page import="java.util.Iterator"%>
<%@page import="Principal.MatriculaDAO"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Matricula"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="./css/stylos.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div>
        <h1>Listado de Matriculas</h1>
        <a class="nuevo" href="Controlador?accion=add">Nueva Matricula</a>
        <table  border="1">
            <thead>
                <tr>
                    <th>No matricula</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Numero Registro Civil</th>
                    <th>Sexo</th>
                    <th>Fecha Nacimiento</th>
                    <th>Fecha Ingreso Guarderia</th>
                    <th>Grado</th>
                </tr>
            </thead>
            <% 
                MatriculaDAO dao = new MatriculaDAO();
                List<Matricula> lista = dao.listaMatriculas();
                Iterator<Matricula> iter = lista.iterator();
                Matricula m = null;
                while (iter.hasNext()) 
                {                        
                    m = iter.next();
                
            %>
            <tbody>
                
                <tr>
                    <td><%= m.getNumeroMatricula()%></td>
                    <td><%= m.getNombre()%></td>
                    <td><%= m.getApellido()%></td>
                    <td><%= m.getNumeroRegistroCivil()%></td>
                    <td><%= m.getSexo()%></td>
                    <td><%= m.getFechaNacimiento()%></td>
                    <td><%= m.getFechaIngreso()%></td>
                    <td><%= m.getGrado()%></td>
                    <td>
                        <a class="editar" href="Controlador?accion=editar&id=<%= m.getNumeroMatricula()%>">Editar</a>
                        <a class="eliminar" href="Controlador?accion=eliminar&id=<%= m.getNumeroMatricula()%>">Eliminar</a>
                    </td>
                    
                </tr>
                <%}%>
            </tbody>
            
        </table>
            </div>
    </body>
</html>
