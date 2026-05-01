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

    public Producto comprarProducto(Moneda moneda, TipoProducto tipo) {

        //Agregar Excepciones(Revision)//

        int precio = tipo.getPrecio();
        int diferencia = moneda.getValor() - precio;
        while (diferencia >= 100) {
            depositoVuelto.add(new Moneda100());
            diferencia -= 100;
        }

        return null; //Temporal, agregando las excepciones retornara el producto comprado//
    }
    public Moneda getVuelto() {
        return depositoVuelto.get();
    }
}