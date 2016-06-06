package br.com.augustoccesar.querybuilder.query.table;

/**
 * Created by augustoccesar on 6/6/16.
 */
public enum Engine {
    INNO_DB("InnoDB");

    private String value;

    Engine(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
