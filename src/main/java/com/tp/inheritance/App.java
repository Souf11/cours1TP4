package com.tp.inheritance;

import com.tp.inheritance.model.joined.Developpeur;
import com.tp.inheritance.model.joined.Employe;
import com.tp.inheritance.model.joined.Manager;
import com.tp.inheritance.model.singletable.Moto;
import com.tp.inheritance.model.singletable.Vehicule;
import com.tp.inheritance.model.singletable.Voiture;
import com.tp.inheritance.model.tableperclass.Electronique;
import com.tp.inheritance.model.tableperclass.Livre;
import com.tp.inheritance.model.tableperclass.Produit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-inheritance");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Voiture voiture = new Voiture("Peugeot 308", 5);
        Moto moto = new Moto("Honda CB500", false);
        em.persist(voiture);
        em.persist(moto);

        Developpeur dev = new Developpeur("Thomas", "Java");
        Manager manager = new Manager("Sarah", 2);
        em.persist(dev);
        em.persist(manager);

        Livre livre = new Livre("1984", "George Orwell");
        Electronique electronique = new Electronique("Tablette", 12);
        em.persist(livre);
        em.persist(electronique);

        em.getTransaction().commit();

        System.out.println("--- Liste des vehicules ---");
        em.createQuery("SELECT v FROM Vehicule v", Vehicule.class)
                .getResultList()
                .forEach(v -> System.out.println(v.getClass().getSimpleName() + " : " + v.getMarque()));

        System.out.println("--- Liste des employes ---");
        em.createQuery("SELECT e FROM Employe e", Employe.class)
                .getResultList()
                .forEach(e -> System.out.println(e.getClass().getSimpleName() + " : " + e.getNom()));

        System.out.println("--- Liste des produits ---");
        em.createQuery("SELECT p FROM Produit p", Produit.class)
                .getResultList()
                .forEach(p -> System.out.println(p.getClass().getSimpleName() + " : " + p.getNom()));

        em.close();
        emf.close();
    }
}
