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

    public double calcularCostoTotal() {

        if (pesoKg <= 0) {
            throw new IllegalArgumentException("El peso debe ser mayor a 0");
        }

        if (distanciaKm <= 0) {
            throw new IllegalArgumentException("La distancia debe ser mayor a 0");
        }

        if (dimensiones.getAlto() <= 0
                || dimensiones.getAncho() <= 0
                || dimensiones.getLargo() <= 0) {

            throw new IllegalArgumentException(
                    "Las dimensiones deben ser mayores a 0");
        }

        if (!metodoPago.equals("EFECTIVO")
                && !metodoPago.equals("TARJETA")
                && !metodoPago.equals("TRANSFERENCIA")) {

            throw new IllegalArgumentException(
                    "Método de pago no válido");
        }

        if (!cliente.getTipoMembresia().equals("REGULAR")
                && !cliente.getTipoMembresia().equals("PREMIUM")
                && !cliente.getTipoMembresia().equals("VIP")) {

            throw new IllegalArgumentException(
                    "Tipo de membresía no válido");
        }

        double costo;

        if (pesoKg <= 5) {
            costo = 5.00 + (0.50 * distanciaKm);
        } else if (pesoKg <= 20) {
            costo = 10.00 + (0.80 * distanciaKm);
        } else {
            costo = 20.00 + (1.20 * distanciaKm);
        }

        // Recargo por volumen
        double volumen = dimensiones.calcularVolumen();

        if (volumen > 50000) {
            costo = costo + 15.00;
        }

        // Descuento por membresía
        if (cliente.getTipoMembresia().equals("PREMIUM")) {
            costo = costo * 0.90;
        } else if (cliente.getTipoMembresia().equals("VIP")) {
            costo = costo * 0.80;
        }

        // Ajuste por método de pago
        if (metodoPago.equals("TRANSFERENCIA")) {
            costo = costo * 0.95;
        } else if (metodoPago.equals("TARJETA")) {
            costo = costo * 1.03;
        }

        return costo;
    }
}