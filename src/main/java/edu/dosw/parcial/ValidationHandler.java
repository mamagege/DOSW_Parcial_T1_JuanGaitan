package edu.dosw.parcial;

abstract class ValidationHandler {
    protected ValidationHandler next;

    public ValidationHandler setNext(ValidationHandler next) {
        this.next = next;
        return next;
    }

    protected boolean proceed(TurnoRequest request) {
        return next == null || next.handle(request);
    }

    public abstract boolean handle(TurnoRequest request);
}
