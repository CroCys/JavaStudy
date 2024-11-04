package Hibernate.config;

import Hibernate.entity.Car;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration config = new Configuration();

            // Настройки Hibernate через Properties
            Properties props = new Properties();
            props.put(Environment.JAKARTA_JDBC_DRIVER, "org.postgresql.Driver");
            props.put(Environment.JAKARTA_JDBC_URL, "jdbc:postgresql://localhost:5432/mydatabase");
            props.put(Environment.JAKARTA_JDBC_USER, "vadim");
            props.put(Environment.JAKARTA_JDBC_PASSWORD, "7894");

            // Конфигурация пула соединений
            props.put(Environment.C3P0_MIN_SIZE, "5");
            props.put(Environment.C3P0_MAX_SIZE, "20");

            // Включение SQL-логирования
            props.put(Environment.SHOW_SQL, "true");

            // Автоматическое создание/обновление схемы базы данных
            props.put(Environment.HBM2DDL_AUTO, "update");

            config.setProperties(props);

            // Добавление классов-сущностей
            config.addAnnotatedClass(Car.class);

            sessionFactory = config.buildSessionFactory();
        }
        return sessionFactory;
    }
}
