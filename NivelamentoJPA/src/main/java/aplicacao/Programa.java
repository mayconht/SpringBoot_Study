package aplicacao;

import dominio.Pessoa;

public class Programa {
    public static void main (String[] args){
        Pessoa p1 = new Pessoa(1, "Maycon Santos", "maycondss@live.com");
        Pessoa p2 = new Pessoa(2, "Maycon Santos2", "maycondss2@live.com");
        Pessoa p3 = new Pessoa(3, "Maycon Santos3", "maycondss3@live.com");

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}
