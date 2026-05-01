package org.example;

class Comprador {
    private int vuelto;
    private String sonido;

    public Comprador(Moneda m, TipoProducto tipo, Expendedor exp)
            throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException {

        Producto p = exp.comprarProducto(m, tipo);

        if (p != null) {
            sonido = p.getSabor();
        }

        Moneda vueltomoneda;
        while ((vueltomoneda = exp.getVuelto()) != null) {
            vuelto += vueltomoneda.getValor();
        }
    }
    public int cuantoVuelto() {
        return vuelto;
    }
    public String queBebiste() {
        return sonido;
    }
}
