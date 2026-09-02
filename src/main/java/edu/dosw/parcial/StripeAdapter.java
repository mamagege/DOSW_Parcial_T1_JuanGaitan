package edu.dosw.parcial;

import java.util.Map;
import java.util.Random;

class StripeAdapter implements InterfacePaymentMethod {
    private static final Random RANDOM = new Random();

    @Override
    public NormalizedResponse processPayment(String payerName, double amount, Map<String, String> metadata) {
        String cvv = metadata.getOrDefault("cvv", "");
        boolean paid = "555".equals(cvv);

        String paymentId = "STR-" + (1000 + RANDOM.nextInt(9000));
        String status = paid ? "APROBADO" : "RECHAZADO";
        String msg = paid ? "Cargo Stripe exitoso" : "Cargo Stripe rechazado";
        return new NormalizedResponse(paymentId, status, msg);
    }
}
