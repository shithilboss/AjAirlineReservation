/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.ac.seu.my.airlinereservationsys.util;


import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author shithilboss
 */
public class SessionFactorySingleton {
   private static SessionFactory sessionFactory;
    private static final SessionFactorySingleton INSTANCE = new SessionFactorySingleton();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private SessionFactorySingleton() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
