package edu.dosw.parcial;

import java.util.HashMap;
import java.util.Map;

class TimeAvailableHandler extends ValidationHandler {
    private static final int MAX_CLIENTES_POR_FRANJA = 3;
    private static final Map<String, Integer> OCUPACION = new HashMap<>();

    @Override
    public boolean handle(TurnoRequest request) {
        String franja = request.getTimeSlot();
        int ocupados = OCUPACION.getOrDefault(franja, 0);

        if (ocupados >= MAX_CLIENTES_POR_FRANJA) {
            System.out.println("  [RECHAZADO] Franja horaria llena");
            return false;
        }

        OCUPACION.put(franja, ocupados + 1);
        System.out.println("  [OK] Franja disponible");
        return proceed(request);
    }
}
