package com.goit.hibernate_util;

import com.goit.clients.Client;
import com.goit.planets.Planet;
import com.goit.tickets.Ticket;

import lombok.Getter;
import org.flywaydb.core.Flyway;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DatabaseUtil {
    private static final DatabaseUtil INSTANCE;

    @Getter
    private SessionFactory sessionFactory;

    static {
        INSTANCE = new DatabaseUtil();
    }

    private DatabaseUtil() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();
        migrateDatabase();
    }

    public static DatabaseUtil getInstance() {
        return INSTANCE;
    }

    public void close() {
        sessionFactory.close();
    }
    private void migrateDatabase() {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:h2:~/test", null, null)
                .locations("classpath:db.migration")
                .load();
        flyway.migrate();
    }
}
