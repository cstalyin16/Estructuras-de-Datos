package com.ecoenvio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class EnvioTest {

    @Test
    public void calcularCostoEnvioLivianoRegularEfectivo() {

        Dimensiones dimensiones = new Dimensiones(20, 20, 20);
        Cliente cliente = new Cliente("Juan", "REGULAR");

        Envio envio = new Envio(
                "ENV-001",
                4,
                10,
                "EFECTIVO",
                dimensiones,
                cliente);

        double resultado = envio.calcularCostoTotal();

        assertEquals(10.00, resultado, 0.001);
    }

    @Test
    public void aplicarRecargoPorVolumen() {

        Dimensiones dimensiones = new Dimensiones(50, 50, 50);
        Cliente cliente = new Cliente("Ana", "REGULAR");

        Envio envio = new Envio(
                "ENV-002",
                4,
                10,
                "EFECTIVO",
                dimensiones,
                cliente);

        double resultado = envio.calcularCostoTotal();

        assertEquals(25.00, resultado, 0.001);
    }

    @Test
    public void aplicarDescuentoPremium() {

        Dimensiones dimensiones = new Dimensiones(20, 20, 20);
        Cliente cliente = new Cliente("Luis", "PREMIUM");

        Envio envio = new Envio(
                "ENV-003",
                4,
                10,
                "EFECTIVO",
                dimensiones,
                cliente);

        double resultado = envio.calcularCostoTotal();

        assertEquals(9.00, resultado, 0.001);
    }

    @Test
    public void aplicarDescuentoVip() {

        Dimensiones dimensiones = new Dimensiones(20, 20, 20);
        Cliente cliente = new Cliente("Maria", "VIP");

        Envio envio = new Envio(
                "ENV-004",
                4,
                10,
                "EFECTIVO",
                dimensiones,
                cliente);

        double resultado = envio.calcularCostoTotal();

        assertEquals(8.00, resultado, 0.001);
    }

    @Test
    public void aplicarDescuentoTransferencia() {

        Dimensiones dimensiones = new Dimensiones(20, 20, 20);
        Cliente cliente = new Cliente("Pedro", "REGULAR");

        Envio envio = new Envio(
                "ENV-005",
                4,
                10,
                "TRANSFERENCIA",
                dimensiones,
                cliente);

        double resultado = envio.calcularCostoTotal();

        assertEquals(9.50, resultado, 0.001);
    }

    @Test
    public void aplicarRecargoTarjeta() {

        Dimensiones dimensiones = new Dimensiones(20, 20, 20);
        Cliente cliente = new Cliente("Carlos", "REGULAR");

        Envio envio = new Envio(
                "ENV-006",
                4,
                10,
                "TARJETA",
                dimensiones,
                cliente);

        double resultado = envio.calcularCostoTotal();

        assertEquals(10.30, resultado, 0.001);
    }

    @Test
    public void lanzarErrorPesoNegativo() {

        Dimensiones dimensiones = new Dimensiones(20, 20, 20);
        Cliente cliente = new Cliente("Juan", "REGULAR");

        Envio envio = new Envio(
                "ENV-007",
                -5,
                10,
                "EFECTIVO",
                dimensiones,
                cliente);

        assertThrows(
                IllegalArgumentException.class,
                () -> envio.calcularCostoTotal());
    }

    @Test
    public void lanzarErrorDistanciaNegativa() {

        Dimensiones dimensiones = new Dimensiones(20, 20, 20);
        Cliente cliente = new Cliente("Juan", "REGULAR");

        Envio envio = new Envio(
                "ENV-008",
                4,
                -10,
                "EFECTIVO",
                dimensiones,
                cliente);

        assertThrows(
                IllegalArgumentException.class,
                () -> envio.calcularCostoTotal());
    }

    @Test
    public void lanzarErrorMetodoPagoInvalido() {

        Dimensiones dimensiones = new Dimensiones(20, 20, 20);
        Cliente cliente = new Cliente("Juan", "REGULAR");

        Envio envio = new Envio(
                "ENV-009",
                4,
                10,
                "CHEQUE",
                dimensiones,
                cliente);

        assertThrows(
                IllegalArgumentException.class,
                () -> envio.calcularCostoTotal());
    }
}