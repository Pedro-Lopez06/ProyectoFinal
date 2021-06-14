/*
Modelo ususario para interactuar la vista y el controlador
a traves de sus metodos getters y setters
 */
package modelo;


public class ModeloUsuario {
    //Atributos
    String Usuario, Passwors, Nombre, Tipo;

    public ModeloUsuario() {//Constructor vacio
    }
    
    //Constructor
    public ModeloUsuario(String Usuario, String Passwors, String Nombre, String Tipo) {
        this.Usuario = Usuario;
        this.Passwors = Passwors;
        this.Nombre = Nombre;
        this.Tipo = Tipo;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPasswors() {
        return Passwors;
    }

    public void setPasswors(String Passwors) {
        this.Passwors = Passwors;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    
    
}

