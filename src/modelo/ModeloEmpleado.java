/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Ryzen
 */
public class ModeloEmpleado {
    private int Codigo;
    private String Nombre;
    private String Direccion;
    private String Entrada;
    private String Salida;
    private String Telefono;
    private float Sueldo;

    public ModeloEmpleado() {
    }

    public ModeloEmpleado(int Codigo, String Nombre, String Direccion, String Entrada, String Salida, String Telefono, float Sueldo) {
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Entrada = Entrada;
        this.Salida = Salida;
        this.Telefono = Telefono;
        this.Sueldo = Sueldo;
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

    public String getEntrada() {
        return Entrada;
    }

    public void setEntrada(String Entrada) {
        this.Entrada = Entrada;
    }

    public String getSalida() {
        return Salida;
    }

    public void setSalida(String Salida) {
        this.Salida = Salida;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public float getSueldo() {
        return Sueldo;
    }

    public void setSueldo(float Sueldo) {
        this.Sueldo = Sueldo;
    }
}

