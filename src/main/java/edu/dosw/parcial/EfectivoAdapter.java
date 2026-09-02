package edu.dosw.parcial;

import java.util.Map;
import java.util.Random;

class EfectivoAdapter implements InterfacePaymentMethod {
    private static final Random RANDOM = new Random();

    @Override
    public NormalizedResponse processPayment(String payerName, double amount, Map<String, String> metadata) {
        boolean aprobado = amount >= 10000;

        String paymentId = "EFE-" + (1000 + RANDOM.nextInt(9000));
        String status = aprobado ? "APROBADO" : "RECHAZADO";
        String msg = aprobado ? "Pago en efectivo recibido" : "Monto insuficiente en efectivo";
        return new NormalizedResponse(paymentId, status, msg);
    }
}
