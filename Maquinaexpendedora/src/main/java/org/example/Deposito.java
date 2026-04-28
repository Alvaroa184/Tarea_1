package org.example;

import java.util.ArrayList;

class Deposito {
    private ArrayList<Bebida> lista;
    private ArrayList<Moneda> lista2;

    public Deposito() {
        lista = new ArrayList<Bebida>();
        lista2 = new ArrayList<Moneda>();
    }
    public void addBebida(Bebida b) {
        lista.add(b);
    }
    public Bebida getBebida() {
        if (lista.size() != 0) {
            return lista.remove(0);
        } else {
            return null;
        }
    }
    public void addMoneda(Moneda m) {
        lista2.add(m);
    }

    public Moneda getMoneda() {
        if (lista2.size() != 0) {
            return lista2.remove(0);
        }
        return null;
    }
}