/*
 * Modelo para entidad de Proveedores
 */
package modelo;

/**
 *
 * @author Pedro López
 */
public class ModeloProveedor {
    private int codigo;
    private String Nombre;
    private String Empresa;
    private String Telefono;
    private String Correo;
    private String Direccion;
    private String RFC;
    private String Cel;
    
    public ModeloProveedor(){
        
    }

    public ModeloProveedor(int codigo, String Nombre, String Empresa, String telefono, String correo, String Direccion, String RFC, String cel) {
        this.codigo = codigo;
        this.Nombre = Nombre;
        this.Empresa = Empresa;
        this.Telefono = telefono;
        this.Correo = correo;
        this.Direccion = Direccion;
        this.RFC = RFC;
        this.Cel = cel;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(String Empresa) {
        this.Empresa = Empresa;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        this.Telefono = telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        this.Correo = correo;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getCel() {
        return Cel;
    }

    public void setCel(String cel) {
        this.Cel = cel;
    }
    
}
