package edu.dosw.parcial;

import java.util.Objects;

public class NormalizedResponse {
    private final String paymentId;
    private final String status;
    private final String message;

    public NormalizedResponse(String paymentId, String status, String message) {
        this.paymentId = paymentId;
        this.status = status;
        this.message = message;
    }

    public String paymentId() { return paymentId; }
    public String status() { return status; }
    public String message() { return message; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NormalizedResponse that = (NormalizedResponse) o;
        return Objects.equals(paymentId, that.paymentId)
                && Objects.equals(status, that.status)
                && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, status, message);
    }

    @Override
    public String toString() {
        return "NormalizedResponse{paymentId='" + paymentId + "', status='" + status
                + "', message='" + message + "'}";
    }
}
