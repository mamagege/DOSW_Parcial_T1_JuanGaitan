package edu.dosw.parcial;

class CatalogValidationHandler extends ValidationHandler {
    @Override
    public boolean handle(TurnoRequest request) {
        if (!ServiceCatalog.isValid(request.getServiceCode())) {
            System.out.println("  [RECHAZADO] Servicio no existe en el catálogo");
            return false;
        }
        System.out.println("  [OK] Servicio en catálogo");
        return proceed(request);
    }
}
