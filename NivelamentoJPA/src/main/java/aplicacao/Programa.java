package aplicacao;

import dominio.Pessoa;
import org.hibernate.internal.build.AllowSysOut;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Programa {
    public static void main(String[] args) {

        //Conexão com banco de dados, contexto e configurações do XML
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("nivelamento-jpa");
        EntityManager em = emf.createEntityManager();

//        Pessoa p1 = new Pessoa(null, "Maycon Santos", "maycondss@live.com");
//        Pessoa p2 = new Pessoa(null, "Maycon Santos2", "maycondss2@live.com");
//        Pessoa p3 = new Pessoa(null, "Maycon Santos3", "maycondss3@live.com");

//        em.persist(p1);
//        em.persist(p2);
//        em.persist(p3);

        //Confirmação de persistencia do banco.

        //Busca no banco.
        Pessoa p = em.find(Pessoa.class, 2);
        System.out.println(p);

        em.remove(p);

        //Transações sao usadas em tudo exceto search.
        em.getTransaction().begin();
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
