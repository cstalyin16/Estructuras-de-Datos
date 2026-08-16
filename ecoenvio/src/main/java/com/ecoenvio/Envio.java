package com.ecoenvio;

public class Envio {

    private String idEnvio;
    private double pesoKg;
    private double distanciaKm;
    private String metodoPago;

    private Dimensiones dimensiones;
    private Cliente cliente;

    public Envio(
            String idEnvio,
            double pesoKg,
            double distanciaKm,
            String metodoPago,
            Dimensiones dimensiones,
            Cliente cliente) {

        this.idEnvio = idEnvio;
        this.pesoKg = pesoKg;
        this.distanciaKm = distanciaKm;
        this.metodoPago = metodoPago;
        this.dimensiones = dimensiones;
        this.cliente = cliente;
    }
}