/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author jony_
 */

public class ModeloArticulo {
    private int codigo;
    private String Descripcion;
    private String Marca;
    private String Color;
    private int PrecioProveedor;
    private int PrecioPublico;
    private String Stock;

    public ModeloArticulo() {
    }

    public ModeloArticulo(int codigo, String Descripcion, String Marca, String Color, int PrecioProveedor, int PrecioPublico, String Stock) {
        this.codigo = codigo;
        this.Descripcion = Descripcion;
        this.Marca = Marca;
        this.Color = Color;
        this.PrecioProveedor = PrecioProveedor;
        this.PrecioPublico = PrecioPublico;
        this.Stock = Stock;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public int getPrecioProveedor() {
        return PrecioProveedor;
    }

    public void setPrecioProveedor(int PrecioProveedor) {
        this.PrecioProveedor = PrecioProveedor;
    }

    public int getPrecioPublico() {
        return PrecioPublico;
    }

    public void setPrecioPublico(int PrecioPublico) {
        this.PrecioPublico = PrecioPublico;
    }

    public String getStock() {
        return Stock;
    }

    public void setStock(String Stock) {
        this.Stock = Stock;
    }
    
    
}