package edu.dosw.parcial;

import java.util.Map;

final class ServiceCatalog {

    static final class Service {
        private final String code;
        private final String name;
        private final double price;
        private final String specialty;

        Service(String code, String name, double price, String specialty) {
            this.code = code;
            this.name = name;
            this.price = price;
            this.specialty = specialty;
        }

        String getCode() { return code; }
        String getName() { return name; }
        double getPrice() { return price; }
        String getSpecialty() { return specialty; }
    }

    private static final Map<String, Service> SERVICES = Map.of(
            "SER-001", new Service("SER-001", "Corte clásico", 25000, "CORTE"),
            "SER-002", new Service("SER-002", "Corte + barba", 38000, "CORTE_BARBA"),
            "SER-003", new Service("SER-003", "Diseño de cejas", 15000, "CEJAS"),
            "SER-004", new Service("SER-004", "Afeitado con navaja", 20000, "BARBA"),
            "SER-005", new Service("SER-005", "Tratamiento capilar", 45000, "CAPILAR")
    );

    private ServiceCatalog() {}

    static boolean isValid(String code) {
        return SERVICES.containsKey(code);
    }

    static Service get(String code) {
        return SERVICES.get(code);
    }
}
