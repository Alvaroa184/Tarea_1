package org.example;

public abstract class Bebida extends Producto {

    public Bebida(TipoProducto tipo) {
        super(tipo);
    }

    public String getSabor() {
        return getTipo().name();
    }
}