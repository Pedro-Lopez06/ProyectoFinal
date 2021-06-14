/*
Entidad modelo para la entidad cliente
 */
package modelo;

/**
 *
 * @author Emmanuel Ruiz
 */
public class ModeloCliente {
    private int Codigo;
    private String Nombre, Direccion, Ciudad, Edad, Correo, FechaIngreso, Telefono;

    public ModeloCliente() { //Constructor Vacio
    }

    public ModeloCliente(int Codigo, String Nombre, String Direccion, String Ciudad, String Edad, String Correo, String FechaIngreso, String Telefono) {
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Ciudad = Ciudad;
        this.Edad = Edad;
        this.Correo = Correo;
        this.FechaIngreso = FechaIngreso;
        this.Telefono = Telefono;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String Edad) {
        this.Edad = Edad;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getFechaIngreso() {
        return FechaIngreso;
    }

    public void setFechaIngreso(String FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
    
    
}
