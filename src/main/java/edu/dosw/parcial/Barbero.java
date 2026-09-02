package edu.dosw.parcial;

import java.util.List;

public class Barbero {
    private final String name;
    private final List<String> specialties;
    private final List<String> days;
    private final int startHour; // hora de inicio, formato 24h
    private final int endHour;   // hora de fin (exclusiva), formato 24h

    Barbero(String name, List<String> specialties, List<String> days, int startHour, int endHour) {
        this.name = name;
        this.specialties = specialties;
        this.days = days;
        this.startHour = startHour;
        this.endHour = endHour;
    }

    String getName() { return name; }

    boolean isAvailableFor(String specialty, String day, int hour24) {
        return specialties.contains(specialty)
                && days.contains(day)
                && hour24 >= startHour
                && hour24 < endHour;
    }
}
