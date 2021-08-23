package app;

import com.estudo.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
//        Pessoa p1 = new Pessoa(null, "Maycon Douglas", "email@1.com.br");
//        Pessoa p2 = new Pessoa(null, "Paulo Coimbra", "email@2.com.br");
//        Pessoa p3 = new Pessoa(null, "Luis Almeida", "email@3.com.br");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa"); //O nome vem do PersistenceXML
        EntityManager em = emf.createEntityManager();


//        em.getTransaction().begin();
//        em.persist(p1);// Insert
//        em.persist(p2);// Insert
//        em.persist(p3);// Insert
//        em.getTransaction().commit();

        Pessoa p = em.find(Pessoa.class, 8); // Select
        System.out.println(p);

        em.getTransaction().begin();
        em.remove(p); // Remove (Mas apenas objetos monitorados / select ou create)
        em.getTransaction().commit();




        em.close();
        emf.close();
    }
}
