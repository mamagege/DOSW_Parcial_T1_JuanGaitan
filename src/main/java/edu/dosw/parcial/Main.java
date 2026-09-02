package edu.dosw.parcial;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        System.setOut(new PrintStream(System.out, true));

        ValidationHandler chain = new TimeAvailableHandler();
        chain.setNext(new BarberAvailableHandler())
                .setNext(new ClientValidationHandler())
                .setNext(new CatalogValidationHandler())
                .setNext(new PaymentValidationHandler());

        System.out.println("ESCENARIO #1: Turno Aprobado con Nequi");
        TurnoRequest turno1 = new TurnoRequest(
                "TURNO #001", "Carlos Ruiz", "carlos@gmail.com", "3208872165",
                "SER-002", "Martes 10:00 AM", "Sin preferencia",
                "NEQUI", Map.of("phone", "3208872165"), 38000
        );
        System.out.println("Procesando " + turno1.getTurnoId());
        chain.handle(turno1);

        System.out.println("\nESCENARIO #2: Rechazo en datos del cliente");
        TurnoRequest turno2 = new TurnoRequest(
                "TURNO #002", "Ana Lopez", "ana@gmail.com", "312345",
                "SER-005", "Lunes 10:00 AM", "Sin preferencia",
                "PSE", Map.of(), 45000
        );
        System.out.println("Procesando " + turno2.getTurnoId());
        chain.handle(turno2);

        System.out.println("\nESCENARIO #3: Pago con PSE Bancolombia");
        TurnoRequest turno3 = new TurnoRequest(
                "TURNO #003", "Julián Mesa", "julian@gmail.com", "3112145678",
                "SER-001", "Sábado 1:00 PM", "Sin preferencia",
                "PSE", Map.of("bank", "BANCOLOMBIA", "accountNumber", "123456789"), 45000
        );
        System.out.println("Procesando " + turno3.getTurnoId());
        chain.handle(turno3);
    }
}
