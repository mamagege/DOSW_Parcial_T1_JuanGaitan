package edu.dosw.parcial;

import java.util.Map;

class TurnoRequest {
    private final String turnoId;
    private final String clientName;
    private final String email;
    private final String phone;
    private final String serviceCode;
    private final String timeSlot;
    private final String paymentMethod;
    private final Map<String, String> paymentMetadata;
    private final double amount;


    private String assignedBarber;

    public TurnoRequest(String turnoId, String clientName, String email, String phone,
                        String serviceCode, String timeSlot, String barberPreference,
                        String paymentMethod, Map<String, String> paymentMetadata, double amount) {
        this.turnoId = turnoId; this.clientName = clientName; this.email = email;
        this.phone = phone; this.serviceCode = serviceCode; this.timeSlot = timeSlot;
        this.paymentMethod = paymentMethod;
        this.paymentMetadata = paymentMetadata; this.amount = amount;
    }

    public String getTurnoId() { return turnoId; }
    public String getClientName() { return clientName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getServiceCode() { return serviceCode; }
    public String getTimeSlot() { return timeSlot; } // faltaba: BarberAvailableHandler la necesita
    public String getPaymentMethod() { return paymentMethod; }
    public Map<String, String> getPaymentMetadata() { return paymentMetadata; }
    public double getAmount() { return amount; }

    public String getAssignedBarber() { return assignedBarber; }
    public void setAssignedBarber(String assignedBarber) { this.assignedBarber = assignedBarber; }
}
