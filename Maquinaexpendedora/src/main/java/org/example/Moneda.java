package org.example;

abstract class Moneda implements Comparable<Moneda> {
    private static int registro = 1000;
    private int serie;

    public Moneda() {
        this.serie=registro++;
    }
    public int getSerie() {
        return serie;
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