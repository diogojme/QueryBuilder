package br.com.augustoccesar.querybuilder.query.column;

import br.com.augustoccesar.querybuilder.query.Configuration;

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

    public String getValue() {
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
                    return null;
            }
        } else {
            return null;
        }
    }
}
