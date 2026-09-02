package edu.dosw.parcial;

class BarberAvailableHandler extends ValidationHandler {
    @Override
    public boolean handle(TurnoRequest request) {
        ServiceCatalog.Service service = ServiceCatalog.get(request.getServiceCode());

        if (service != null) {
            String day = TimeSlotUtil.extractDay(request.getTimeSlot());
            int hour = TimeSlotUtil.extractHour24(request.getTimeSlot());

            Barbero asignado = BarberRegistry.findAvailable(service.getSpecialty(), day, hour);
            if (asignado == null) {
                System.out.println("  [RECHAZADO] Ningún barbero disponible para ese servicio en esa franja");
                return false;
            }

            request.setAssignedBarber(asignado.getName());
            System.out.println("  [OK] Barbero asignado: " + asignado.getName());
        }

        return proceed(request);
    }
}
