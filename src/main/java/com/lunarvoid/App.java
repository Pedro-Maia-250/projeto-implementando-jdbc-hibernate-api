//hibernate

package com.lunarvoid;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lunarvoid.entities.Forma;
import com.lunarvoid.entities.Circulo;
import com.lunarvoid.entities.Quadrado;
import com.lunarvoid.entities.Retangulo;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java-jpa");
        EntityManager em = emf.createEntityManager();
        try{

            em.getTransaction().begin();

            em.persist(new Circulo(5.3));
            em.persist(new Quadrado(2.4));
            em.persist(new Retangulo(2.6, 2.3));

            em.getTransaction().commit();

            List<Forma> formas = new ArrayList<>();

            formas.addAll(em.createQuery("From Circulo",Circulo.class).getResultList());
            formas.addAll(em.createQuery("From Quadrado",Quadrado.class).getResultList());
            formas.addAll(em.createQuery("From Retangulo",Retangulo.class).getResultList());

            for (Forma forma : formas) {
                System.out.println(forma);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            if (em != null && em.isOpen()) em.close();
            if (emf != null && emf.isOpen()) emf.close();
            com.mysql.cj.jdbc.AbandonedConnectionCleanupThread.checkedShutdown();
        }
    }
}
