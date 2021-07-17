package utils;

import models.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;
    private HibernateSessionFactoryUtil() {}
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {

                //hiberpostgres.cfg.xml - Postgre
                //hibermaria.cfg.xml - MariaDB
                Configuration configuration = new Configuration().configure("hiberpostgres.cfg.xml"); //hiberpostgres.cfg.xml
               configuration.addAnnotatedClass(Producer.class);
               configuration.addAnnotatedClass(ImageGallary.class);
               configuration.addAnnotatedClass(Product.class);
               configuration.addAnnotatedClass(Basket.class);
               configuration.addAnnotatedClass(Order.class);
               configuration.addAnnotatedClass(CustomerAccount.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                System.out.println("Exception!" + e);
            }
        }
        return sessionFactory;
    }
}
