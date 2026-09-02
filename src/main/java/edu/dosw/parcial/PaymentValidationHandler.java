package edu.dosw.parcial;

import java.util.Map;
import java.util.function.Supplier;

class PaymentValidationHandler extends ValidationHandler {

    // Agregar una pasarela nueva = una línea aquí, sin tocar el resto de la clase (OCP).
    private static final Map<String, Supplier<InterfacePaymentMethod>> GATEWAYS = Map.of(
            "NEQUI", NequiAdapter::new,
            "PSE", PseAdapter::new,
            "STRIPE", StripeAdapter::new,
            "EFECTIVO", EfectivoAdapter::new
    );

    @Override
    public boolean handle(TurnoRequest request) {
        Supplier<InterfacePaymentMethod> factory = GATEWAYS.get(request.getPaymentMethod().toUpperCase());
        if (factory == null) {
            System.out.println("  [RECHAZADO] Pasarela de pago inactiva o no soportada");
            return false;
        }

        System.out.println("  [OK] Pasarela " + request.getPaymentMethod() + " activa");

        InterfacePaymentMethod gateway = factory.get();
        NormalizedResponse response = gateway.processPayment(
                request.getClientName(), request.getAmount(), request.getPaymentMetadata());

        System.out.println("  PAGO: " + response.paymentId() + " - " + response.status());

        if ("RECHAZADO".equals(response.status())) {
            System.out.println("  TURNO NO CONFIRMADO");
            return false;
        }

        System.out.println("  TURNO CONFIRMADO");
        System.out.println("  Total: " + (int) request.getAmount() + "$");
        return true;
    }
}
