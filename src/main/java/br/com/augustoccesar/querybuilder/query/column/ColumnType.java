package br.com.augustoccesar.querybuilder.query.column;

import br.com.augustoccesar.querybuilder.Configuration;
import br.com.augustoccesar.querybuilder.exceptions.InvalidColumnType;

/**
 * Created by augustoccesar on 6/6/16.
 */
public enum ColumnType {
    VARCHAR(1),
    TINYINT(2),
    BOOLEAN(3),
    SMALLINT(4),
    MEDIUMINT(5),
    INT(6),
    BIGINT(7);

    private int id;
    private String value;

    ColumnType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getValue() throws InvalidColumnType {
        Configuration configuration = Configuration.getInstance();
        if (configuration.getDatabase().getValue().equals(Configuration.Database.MYSQL.getValue())) {
            switch (this.id) {
                case 1:
                    return " VARCHAR ";
                case 2:
                    return " TINYINT ";
                case 3:
                    return " BOOLEAN ";
                case 4:
                    return " SMALLINT ";
                case 5:
                    return " MEDIUMINT ";
                case 6:
                    return " INT ";
                case 7:
                    return " BIGINT ";
                default:
                    throw new InvalidColumnType("Invalid column type.");
            }
        } else if (configuration.getDatabase().getValue().equals(Configuration.Database.SQLITE.getValue())) {
            switch (this.id) {
                case 1:
                    return " TEXT ";
                case 2:
                    return " INTEGER ";
                case 3:
                    return " BOOLEAN ";
                case 4:
                    return " INTEGER ";
                case 5:
                    return " INTEGER ";
                case 6:
                    return " INTEGER ";
                case 7:
                    return " INTEGER ";
                default:
                    throw new InvalidColumnType("Invalid column type.");
            }
        } else {
            return null;
        }
    }

    public Integer getDefaultSize() throws InvalidColumnType {
        Configuration configuration = Configuration.getInstance();
        if (configuration.getDatabase().getValue().equals(Configuration.Database.MYSQL.getValue())) {
            switch (this.id) {
                case 1:
                    return 255;
                case 2:
                    return null;
                case 3:
                    return null;
                case 4:
                    return null;
                case 5:
                    return null;
                case 6:
                    return null;
                case 7:
                    return null;
                default:
                    throw new InvalidColumnType("Invalid column type.");
            }
        } else if (configuration.getDatabase().getValue().equals(Configuration.Database.SQLITE.getValue())) {
            switch (this.id) {
                case 1:
                    return null;
                case 2:
                    return null;
                case 3:
                    return null;
                case 4:
                    return null;
                case 5:
                    return null;
                case 6:
                    return null;
                case 7:
                    return null;
                default:
                    throw new InvalidColumnType("Invalid column type.");
            }
        } else {
            return null;
        }
    }
}
