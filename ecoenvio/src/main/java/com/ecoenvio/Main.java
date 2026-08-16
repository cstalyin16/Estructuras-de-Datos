package com.ecoenvio;

public class Main {

    public static void main(String[] args) {

        Dimensiones dimensiones = new Dimensiones(20, 20, 20);

        Cliente cliente = new Cliente(
                "Juan",
                "PREMIUM");

        Envio envio = new Envio(
                "ENV-001",
                4,
                10,
                "TRANSFERENCIA",
                dimensiones,
                cliente);

        double costoTotal = envio.calcularCostoTotal();

        System.out.printf("Costo total del envío: $%.2f%n", costoTotal);
    }
}