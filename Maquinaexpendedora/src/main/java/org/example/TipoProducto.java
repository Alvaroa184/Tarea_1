package org.example;

public enum TipoProducto {
    COCACOLA(1100),
    SPRITE(900),
    FANTA(1000),
    SNICKERS(500),
    SUPER8(300);

    private int precio;

    TipoProducto(int precio) {
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }
}
