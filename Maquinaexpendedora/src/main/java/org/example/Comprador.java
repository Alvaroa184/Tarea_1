package org.example;

class Comprador {
    private int vuelto;
    private String sonido;

    public Comprador(Moneda m, int cualBebida, Expendedor exp) {
        Bebida b = exp.comprarBebida(m, cualBebida);

        if (b != null) {
            sonido = b.beber();
        } else {
            sonido = null;
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
