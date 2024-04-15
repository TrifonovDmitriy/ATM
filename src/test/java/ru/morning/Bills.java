package ru.morning;

public enum Bills {
    TWENTY(20,3),
    FIFTY(50,2),
    HUNDRED(100,1),
    ;
    private final int nominal;
    private final int priority;

    Bills(int nominal, int priority) {
        this.nominal = nominal;
        this.priority = priority;
    }

    public int getNominal() {
        return nominal;
    }

    public int getPriority() {
        return priority;
    }
}
