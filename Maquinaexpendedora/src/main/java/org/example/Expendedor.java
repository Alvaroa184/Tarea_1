package org.example;

class Expendedor {
    public static final int COCA=1;
    public static final int SPRITE =2;

    private Deposito depositococa;
    private Deposito depositosprite;
    private Deposito depositomonvu;
    private int precioBebidas;

    public Expendedor(int numBebidas, int precioBebidas) {
        depositococa = new Deposito();
        depositosprite = new Deposito();
        depositomonvu = new Deposito();

        for (int i = 0; i < numBebidas; i++) {
            CocaCola cocaCola = new CocaCola(100 + i);
            depositococa.addBebida(cocaCola);

            Sprite sprite = new Sprite(200 + i);
            depositosprite.addBebida(sprite);
        }

        this.precioBebidas = precioBebidas;
    }

    public Bebida comprarBebida(Moneda moneda, int cual) {
        if (moneda == null) {
            return null;
        }
        Deposito depositoElegido = null;
        if (cual == COCA) {
            depositoElegido = depositococa;
        } else if (cual == SPRITE) {
            depositoElegido = depositosprite;
        } else {
            depositomonvu.addMoneda(moneda);
            return null;
        }
        if (moneda.getValor() < precioBebidas) {
            depositomonvu.addMoneda(moneda);
            return null;
        }
        Bebida b = depositoElegido.getBebida();

        if (b == null) {
            depositomonvu.addMoneda(moneda);
            return null;
        }
        int diferencia = moneda.getValor() - precioBebidas;
        while (diferencia >= 100) {
            depositomonvu.addMoneda(new Moneda100());
            diferencia -= 100;
        }
        return b;
    }
    public Moneda getVuelto() {
        return depositomonvu.getMoneda();
    }
}