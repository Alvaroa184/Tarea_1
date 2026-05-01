package org.example;

abstract class Moneda implements Comparable<Moneda> {    public Moneda() {
    }
    public Moneda getSerie() {
        return this;
    }
    public abstract int getValor();
    @Override
    public int compareTo(Moneda otra) {
        return this.getValor() - otra.getValor();
    }

    @Override
    public String toString() {
        return "Moneda[serie=" + getSerie() + ", valor=" + getValor() + "]";
    }
}