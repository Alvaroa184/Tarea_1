package org.example;

public abstract class Producto {

    private TipoProducto tipo;

    public Producto(TipoProducto tipo) {
        this.tipo = tipo;
    }

    public abstract String getSabor();

    public int getPrecio() {
        return tipo.getPrecio();
    }

    public TipoProducto getTipo() {
        return tipo;
    }
}