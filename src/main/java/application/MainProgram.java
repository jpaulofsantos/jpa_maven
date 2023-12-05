package application;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainProgram {
    public static void main(String[] args) {

        /*Pessoa pessoa = new Pessoa(null, "JP", "jp@gmail.com");
        Pessoa pessoa1 = new Pessoa(null, "JP2", "jp2@gmail.com");
        Pessoa pessoa2 = new Pessoa(null, "JP3", "jp3@gmail.com");*/

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemplo-jpa"); //comunicação com o banco de dados (arquivo persistence.xml)
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        /*entityManager.getTransaction().begin();
        //entityManager.persist(pessoa1); //gravando no banco
        entityManager.persist(pessoa);
        entityManager.persist(pessoa2);
        entityManager.getTransaction().commit();*/

        Pessoa p = entityManager.find(Pessoa.class, 2); //buscando pelo ID;
        System.out.println(p.toString());

        entityManager.getTransaction().begin();
        entityManager.remove(p);
        entityManager.getTransaction().commit();


        System.out.println("Pronto!");

        entityManager.close();
        entityManagerFactory.close();


    }
}
