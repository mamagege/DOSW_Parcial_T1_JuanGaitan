package edu.dosw.parcial;

import java.util.List;

public final class BarberRegistry {

    private static final List<Barbero> BARBEROS = List.of(
            new Barbero("Miguel",
                    List.of("CORTE", "CORTE_BARBA"),
                    List.of("Lunes", "Martes", "Miércoles", "Jueves"),
                    10, 17),
            new Barbero("Laura",
                    List.of("CAPILAR", "CEJAS"),
                    List.of("Lunes", "Martes", "Miércoles", "Jueves", "Viernes"),
                    10, 17),
            new Barbero("Andres",
                    List.of("CORTE", "BARBA"),
                    List.of("Martes", "Jueves", "Sábado", "Domingo"),
                    10, 14)
    );

    private BarberRegistry() {}
    static Barbero findAvailable(String specialty, String day, int hour24) {
        for (Barbero barbero : BARBEROS) {
            if (barbero.isAvailableFor(specialty, day, hour24)) {
                return barbero;
            }
        }
        return null;
    }
}
