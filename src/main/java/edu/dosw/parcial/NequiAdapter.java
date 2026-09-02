package edu.dosw.parcial;

import java.util.Map;
import java.util.Random;

class NequiAdapter implements InterfacePaymentMethod {
    private static final Random RANDOM = new Random();

    @Override
    public NormalizedResponse processPayment(String payerName, double amount, Map<String, String> metadata) {
        String phone = metadata.getOrDefault("phone", "");
        boolean successful = phone.endsWith("65");

        String paymentId = "NQ-" + (1000 + RANDOM.nextInt(9000));
        String status = successful ? "APROBADO" : "RECHAZADO";
        String msg = successful ? "Pago Nequi exitoso" : "Fallo en validación Nequi";
        return new NormalizedResponse(paymentId, status, msg);
    }
}
