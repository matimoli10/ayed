/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

/**
 *
 * @author PC
 */
public class estudiante {
    private String nombre;
    private String apellido;
    private int comision;
    private String email;
    private String direccion;

    public estudiante(String nombre, String apellido, int comision, String email, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.comision = comision;
        this.email = email;
        this.direccion = direccion;
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

    public int getComision() {
        return comision;
    }

    public void setComision(int comision) {
        this.comision = comision;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String tusdatos() {
        return "\nnombre: " + getNombre() + "\napellido: " + getApellido() + "\ncomision: " + getComision() + "\nemail: " + getEmail()+ "\ndireccion: " + getDireccion()+"\n";
    }

    public String toString() {
        return "el estudiante: " + "\n  nombre: " + nombre + "\n  apellido: " + apellido + "\n  comision: " + comision + "\n  email: " + email + "\n  direccion: " + direccion +"\n";
    }

    public boolean equalsEstudiantes(estudiante o) {
        boolean es = false;
        if(this.nombre == o.getNombre()){
            if(this.apellido == o.getApellido()){
               if(this.getEmail() == o .getEmail()){
                   if(this.getDireccion() == o.getDireccion()){
                       es = true;
                   }
               }
            }
        }
        return es;
    }
    
}
