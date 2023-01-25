package com.farmagrup.farmaciasfamiliares;

public class promotions_datos {

    private String producto;
    private String descripcion;
    private int imagen;

    public promotions_datos(String producto, String descripcion, int imagen) {
        this.producto = producto;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
