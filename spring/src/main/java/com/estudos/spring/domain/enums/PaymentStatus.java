package com.estudos.spring.domain.enums;

public enum PaymentStatus {
    PENDING(1, "Pending"),
    PAID(2, "Paid"),
    CANCELED(3, "Canceled");

    private int cod;
    private String description;

    PaymentStatus(int cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public static PaymentStatus toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }
        for (PaymentStatus x : PaymentStatus.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Invalid Payment Status Code: " + cod);
    }

    public int getCod() {
        return cod;
    }

    public String getDescription() {
        return description;
    }
}
