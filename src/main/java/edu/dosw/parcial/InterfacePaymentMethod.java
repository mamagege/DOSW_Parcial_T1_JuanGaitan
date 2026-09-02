package edu.dosw.parcial;

import java.util.Map;

interface InterfacePaymentMethod {
    NormalizedResponse processPayment(String payerName, double amount, Map<String, String> metadata);
}
