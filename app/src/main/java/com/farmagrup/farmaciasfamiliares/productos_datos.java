package com.farmagrup.farmaciasfamiliares;

public class productos_datos {
    private String precio, nombre;
    private int imagen;

    public productos_datos(String precio, String nombre, int imagen) {
        this.precio = precio;
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}

