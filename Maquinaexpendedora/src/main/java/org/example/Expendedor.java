package org.example;

class Expendedor {

    private Deposito<Producto> depositoCoca;
    private Deposito<Producto> depositoSprite;
    private Deposito<Producto> depositoFanta;
    private Deposito<Producto> depositoSnickers;
    private Deposito<Producto> depositoSuper8;
    private Deposito<Moneda> depositoVuelto;

    public Expendedor(int numProductos) {
        depositoCoca = new Deposito<>();
        depositoSprite = new Deposito<>();
        depositoFanta = new Deposito<>();
        depositoSnickers = new Deposito<>();
        depositoSuper8 = new Deposito<>();
        depositoVuelto = new Deposito<>();

        for (int i = 0; i < numProductos; i++) {
            depositoCoca.add(new CocaCola());
            depositoSprite.add((new Sprite()));
            depositoFanta.add(new Fanta());
            depositoSnickers.add(new Snickers());
            depositoSuper8.add(new Super8());
        }

    }

    public Producto comprarProducto(Moneda moneda, TipoProducto tipo)
            throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException {

        if(moneda == null){
            throw new PagoIncorrectoException("Pago Incorrecto");
        }

        int precio = tipo.getPrecio();

        if(moneda.getValor() < precio){
            depositoVuelto.add(moneda);
            throw new PagoInsuficienteException("Pago insuficiente");
        }

        Deposito<Producto> elegido = null;

        switch (tipo) {
            case COCACOLA:
                elegido = depositoCoca;
                break;
            case SPRITE:
                elegido = depositoSprite;
                break;
            case FANTA:
                elegido = depositoFanta;
                break;
            case SNICKERS:
                elegido = depositoSnickers;
                break;
            case SUPER8:
                elegido = depositoSuper8;
                break;
        }

        Producto p = elegido.get();

        if (p == null) {
            depositoVuelto.add(moneda);
            throw new NoHayProductoException("No hay producto");
        }


        int diferencia = moneda.getValor() - precio;
        while (diferencia >= 100) {
            depositoVuelto.add(new Moneda100());
            diferencia -= 100;
        }

        return p;
    }
    public Moneda getVuelto() {
        return depositoVuelto.get();
    }
}