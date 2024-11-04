package Hibernate;

import Hibernate.config.HibernateUtil;
import Hibernate.entity.Car;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateApp {
    public static void main(String[] args) {
        HibernateApp app = new HibernateApp();
        app.firstConfigOption();
        app.secondConfigOption();
        app.thirdConfigOption();
    }

    // Конфигурация и запуск через Hibernate|HibernateUtil
    public void firstConfigOption() {
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            Car car = new Car();
            car.setModel("Porsche");
            session.persist(car);

            session.getTransaction().commit();
            session.close();
        }
    }

    // Конфигурация и запуск через Hibernate|hibernate.cfg.xml
    public void secondConfigOption() {
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            Car car = new Car();
            car.setModel("Mercedes");
            session.persist(car);

            session.getTransaction().commit();
            session.close();
        }
    }

    // Конфигурация и запуск через JPA|persistence.xml
    public void thirdConfigOption() {
        try (EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("carPersistenceUnit")) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            Car car = new Car();
            car.setModel("BMW");

            entityManager.persist(car);
            entityManager.getTransaction().commit();
            entityManager.close();
        }
    }
}
