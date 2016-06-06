package br.com.augustoccesar.querybuilder;

import br.com.augustoccesar.querybuilder.exceptions.DatabaseSourceNotDefined;

/**
 * Created by augustoccesar on 6/6/16.
 */
public class Configuration {
    private static Configuration configuration;
    private Database database;

    private Configuration() {

    }

    public static Configuration getInstance() {
        if (configuration == null)
            configuration = new Configuration();
        return configuration;
    }

    public Database getDatabase() {
        if (database == null)
            try {
                throw new DatabaseSourceNotDefined("No database source type defined on configuration.");
            } catch (DatabaseSourceNotDefined databaseSourceNotDefined) {
                databaseSourceNotDefined.printStackTrace();
            }
        return database;
    }

    public Configuration setDatabase(Database database) {
        this.database = database;
        return this;
    }

    public enum Database {
        MYSQL("MYSQL"),
        SQLITE("SQLITE");

        private String value;

        Database(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
