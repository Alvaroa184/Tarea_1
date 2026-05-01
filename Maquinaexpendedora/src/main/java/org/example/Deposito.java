package org.example;

import java.util.ArrayList;

public class Deposito<T> {
    private ArrayList<T> lista;

    public Deposito() {
        lista = new ArrayList<T>();
    }
    public void add(T elemento) {
        lista.add(elemento);
    }
    public T get() {
        if (lista.size() != 0) {
            return lista.remove(0);
        } else {
            return null;
        }
    }
}