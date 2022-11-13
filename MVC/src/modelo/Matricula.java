
package modelo;

public class Matricula 
{

    String numeroMatricula;
    String nombre;
    String apellido;
    String numeroRegistroCivil;
    String sexo;
    String fechaNacimiento;
    String fechaIngreso;
    String grado;
    
    public Matricula()
    {}
    
    public Matricula(String numeroMatricula, String nombre, String apellido, String numeroRegistroCivil, String sexo, String fechaNacimiento, String fechaIngreso, String grado) {
        this.numeroMatricula = numeroMatricula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroRegistroCivil = numeroRegistroCivil;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
        this.grado = grado;
    }
    
    
    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumeroRegistroCivil() {
        return numeroRegistroCivil;
    }

    public void setNumeroRegistroCivil(String numeroRegistroCivil) {
        this.numeroRegistroCivil = numeroRegistroCivil;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

}
