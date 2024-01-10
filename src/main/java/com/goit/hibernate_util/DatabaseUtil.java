package com.goit.hibernate_util;

import com.goit.db_migration.DatabaseMigration;
import com.goit.table_entities.clients.Client;
import com.goit.table_entities.planets.Planet;
import com.goit.table_entities.tickets.Ticket;

import lombok.Getter;
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
        DatabaseMigration.migrateDatabase();
    }

    public static DatabaseUtil getInstance() {
        return INSTANCE;
    }

    public void close() {
        sessionFactory.close();
    }
}
