package edu.dosw.parcial;

class ClientValidationHandler extends ValidationHandler {
    @Override
    public boolean handle(TurnoRequest request) {
        if (request.getClientName() == null || request.getClientName().isBlank()) {
            System.out.println("  [RECHAZADO] Nombre inválido");
            return false;
        }
        if (request.getPhone() == null || request.getPhone().length() != 10) {
            System.out.println("  [RECHAZADO] Telefono invalido");
            System.out.println("  Error: teléfono debe tener 10 dígitos");
            return false;
        }
        if (request.getEmail() == null || !request.getEmail().endsWith("@gmail.com")) {
            System.out.println("  [RECHAZADO] Correo inválido");
            return false;
        }
        System.out.println("  [OK] Datos del cliente válidos");
        return proceed(request);
    }
}
