<%-- 
    Document   : edit
    Created on : 8/11/2022, 04:01:12 PM
    Author     : LIVE
--%>

<%@page import="modelo.Matricula"%>
<%@page import="Principal.MatriculaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <%
                MatriculaDAO dao = new MatriculaDAO();
                String id =(String) request.getAttribute("idMatricula");
                Matricula m = (Matricula) dao.selecionarUnaMatricula(id);
            %>
        <h1>Actualizar  Matricula<h1/>
                <form action="Controlador">
                    NoMatricula<br>
                    <input type="text" name="txt_numeroMatricula" value="<% m.getNumeroMatricula();%>" /><br>
                    Nombre<br>
                    <input type="text" name="txt_nombre" value="<% m.getNombre();%>"/><br>
                    Apellido<br>
                    <input type="text" name="txt_apellido" value="<% m.getApellido();%>" /><br>
                    Registro Civil<br>
                    <input type="text" name="txt_registroCivil" value="<% m.getNumeroRegistroCivil();%>"/><br>
                    Sexo<br>
                    <input type="text" name="txt_sexo" value="<% m.getSexo();%>"/><br>
                   Fecha Nacimiento<br>
                    <input type="text" name="txt_fechaNacimiento" value="<% m.getFechaNacimiento();%>"/><br>
                    Fecha Ingreso<br>
                    <input type="text" name="txt_fechaIngreso" value="<% m.getFechaIngreso();%>"/><br>
                    Grado<br>
                    <input type="text" name="txt_grado" value=""/><br>
                    <input type="submit" name="accion"  value="Actualizar"/><br>
                <form/>
        </div>
    </body>
</html>
