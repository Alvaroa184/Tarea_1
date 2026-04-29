package org.example;

public abstract class Dulce extends Producto {

    public Dulce(TipoProducto tipo) {
        super(tipo);
    }

    public String getSabor() {
        return getTipo().name();
    }
}