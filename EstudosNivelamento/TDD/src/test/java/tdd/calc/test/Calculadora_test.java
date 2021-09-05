package tdd.calc.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Calculadora_test {

    @Test
    public void deveriaSomarDoisValoresPassados() throws Exception {
        Calculadora calc = new Calculadora();
        int soma = calc.soma(1,2);

        assertEquals(3, soma);
    }
}

