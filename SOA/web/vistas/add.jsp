

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h1>Registrar Matricula<h1/>
                <form action="Controlador">
                    NoMatricula<br>
                    <input type="text" name="txt_numeroMatricula" /><br>
                    Nombre<br>
                    <input type="text" name="txt_nombre" /><br>
                    Apellido<br>
                    <input type="text" name="txt_apellido" /><br>
                    Registro Civil<br>
                    <input type="text" name="txt_registroCivil" /><br>
                    Sexo<br>
                    <input type="text" name="txt_sexo" /><br>
                   Fecha Nacimiento<br>
                    <input type="text" name="txt_fechaNacimiento" /><br>
                    Fecha Ingreso<br>
                    <input type="text" name="txt_fechaIngreso" /><br>
                    Grado<br>
                    <input type="text" name="txt_grado" /><br>
                    <input type="submit" name="accion"  value="Agregar"/><br>
                    
                <form/>
        </div> 
        
    </body>
    
</html>
