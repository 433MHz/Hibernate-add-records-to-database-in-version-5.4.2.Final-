package pl.krystian;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Konfiguracja {
    private static SessionFactory sessionFactory;

            protected static void setUp(){
                final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                        .configure()
                        .build();
                try {
                    sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
                }
                catch (Exception e) {
                    StandardServiceRegistryBuilder.destroy( registry );
                }
            }

            public static void dodaj(String login, String haslo){
                Event event = new Event();

                Session session = sessionFactory.openSession();
                session.beginTransaction();
                event.setLogin(login);
                event.setPassword(haslo);

                session.save(event);


                session.getTransaction().commit();
                session.close();
            }
}
