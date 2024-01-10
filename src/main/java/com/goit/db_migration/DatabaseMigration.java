package com.goit.db_migration;

import org.flywaydb.core.Flyway;

public class DatabaseMigration {
    public static void migrateDatabase() {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:h2:~/test", null, null)
                .locations("classpath:db.migration")
                .load();
        flyway.migrate();
    }
}
