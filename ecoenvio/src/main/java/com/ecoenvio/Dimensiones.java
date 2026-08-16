package com.ecoenvio;

public class Dimensiones {

    private double alto;
    private double ancho;
    private double largo;

    public Dimensiones(double alto, double ancho, double largo) {
        this.alto = alto;
        this.ancho = ancho;
        this.largo = largo;
    }

    public double calcularVolumen() {
        return alto * ancho * largo;
    }
}