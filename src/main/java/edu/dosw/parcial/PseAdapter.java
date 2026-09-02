package edu.dosw.parcial;

import java.util.Map;
import java.util.Random;

class PseAdapter implements InterfacePaymentMethod {
    private static final Random RANDOM = new Random();

    @Override
    public NormalizedResponse processPayment(String payerName, double amount, Map<String, String> metadata) {
        String bank = metadata.getOrDefault("bank", "").toUpperCase();
        String accountNumber = metadata.getOrDefault("accountNumber", "0");
        int firstDigit = accountNumber.isEmpty() ? 0 : Character.getNumericValue(accountNumber.charAt(0));

        String status;
        String msg;
        if ("BANCOLOMBIA".equals(bank)) {
            status = "PENDING"; // código 10, solo Bancolombia
            msg = "Transacción PSE en proceso (Bancolombia)";
        } else if (firstDigit >= 1 && firstDigit <= 3) {
            status = "APROBADO"; // código 0
            msg = "Transacción PSE aprobada";
        } else {
            status = "RECHAZADO"; // código 1
            msg = "Transacción PSE rechazada";
        }
        return new NormalizedResponse("PSE-" + (1000 + RANDOM.nextInt(9000)), status, msg);
    }
}
