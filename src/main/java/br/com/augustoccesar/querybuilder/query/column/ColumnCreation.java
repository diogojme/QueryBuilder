package br.com.augustoccesar.querybuilder.query.column;

/**
 * Created by augustoccesar on 6/6/16.
 */
public class ColumnCreation {
    private String columnName;
    private ColumnType columnType;
    private Integer columnSize;
    private boolean nullable = true;
    private boolean unique = false;

    // Constructors

    public ColumnCreation(String columnName, ColumnType columnType) {
        this.columnName = columnName;
        this.columnType = columnType;
    }

    public ColumnCreation(String columnName, ColumnType columnType, Integer columnSize) {
        this.columnName = columnName;
        this.columnType = columnType;
        this.columnSize = columnSize;
    }

    // Getters and Setters

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public ColumnType getColumnType() {
        return columnType;
    }

    public void setColumnType(ColumnType columnType) {
        this.columnType = columnType;
    }

    public Integer getColumnSize() {
        return columnSize;
    }

    public ColumnCreation setColumnSize(Integer columnSize) {
        this.columnSize = columnSize;
        return this;
    }

    public boolean isNullable() {
        return nullable;
    }

    public ColumnCreation setNullable(boolean nullable) {
        this.nullable = nullable;
        return this;
    }

    public boolean isUnique() {
        return unique;
    }

    public ColumnCreation setUnique(boolean unique) {
        this.unique = unique;
        return this;
    }
}
