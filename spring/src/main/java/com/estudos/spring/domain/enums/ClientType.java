package com.estudos.spring.domain.enums;

//Estudar Melhor os Enum Type.
public enum ClientType {
    NATURALPERSON(1, "Natural Person"),
    COMPANY(2, "Legal Person");

    private final int cod;
    private final String description;

    ClientType(int cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    //Validação do tipo cliente (proteção de codigo)
    public static ClientType toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }
        for (ClientType x : ClientType.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id Invalido:  " + cod);
    }

    public int getCod() {
        return cod;
    }

    public String getDescription() {
        return description;
    }
}

