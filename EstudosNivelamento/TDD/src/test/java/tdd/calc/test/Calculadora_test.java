package tdd.calc.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Calculadora_test {

    @Test
    public void deveriaSomarDoisValoresPassados() throws Exception {
        int valA = 1;
        int valB = 2;
        int soma = 0;

        assertEquals(3, soma);

    }
}

