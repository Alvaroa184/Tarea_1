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

    public Producto comprarProducto(Moneda moneda, TipoProducto tipo) throws PagoIncorrectoException, NoHayProductoException, PagoInsuficienteException {


        int precio = tipo.getPrecio();

        if (moneda==null){
            throw new PagoIncorrectoException ("No hay monedas");
        }
        if (moneda.getValor()<precio){
            depositoVuelto.add(moneda);
            throw new PagoInsuficienteException("No hay suficiente dinero");
        }
        Producto producto=null;
        if (tipo==TipoProducto.COCACOLA){
            producto = depositoCoca.get();
        }
        else if (tipo==TipoProducto.SPRITE){
            producto = depositoSprite.get();
        }
        else if (tipo==TipoProducto.SNICKERS){
            producto = depositoSnickers.get();
        }
        else if (tipo==TipoProducto.SUPER8){
            producto = depositoSuper8.get();
        }
        else if (tipo== TipoProducto.FANTA){
            producto = depositoFanta.get();
        }
        if (producto==null){
            depositoVuelto.add(moneda);
            throw new NoHayProductoException("No hay producto actualmente");
        }

        int diferencia = moneda.getValor() - precio;
        while (diferencia >= 100) {
            depositoVuelto.add(new Moneda100());
            diferencia -= 100;
        }

        return producto;
    }
    public Moneda getVuelto() {
        return depositoVuelto.get();
    }
}