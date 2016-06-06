package br.com.augustoccesar.querybuilder.query.builders;

import br.com.augustoccesar.querybuilder.query.Configuration;
import br.com.augustoccesar.querybuilder.query.QueryBuilder;
import br.com.augustoccesar.querybuilder.query.column.ColumnCreation;
import br.com.augustoccesar.querybuilder.query.table.Engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by augustoccesar on 6/6/16.
 */
public class TableCreationBuilder implements QueryBuilder {
    private String tableName;
    private String primaryKey;
    private List<ColumnCreation> columnCreations;
    private Engine engine;

    public TableCreationBuilder tableName(String tableName) {
        this.tableName = tableName;
        return this;
    }

    public TableCreationBuilder column(ColumnCreation columnCreation) {
        if (this.columnCreations == null)
            this.columnCreations = new ArrayList<>();
        this.columnCreations.add(columnCreation);
        return this;
    }

    public TableCreationBuilder columns(ColumnCreation... columnCreations) {
        if (this.columnCreations == null)
            this.columnCreations = new ArrayList<>();
        Collections.addAll(this.columnCreations, columnCreations);
        return this;
    }

    public TableCreationBuilder primaryKey(String columnName) {
        this.primaryKey = columnName;
        return this;
    }

    public TableCreationBuilder engine(Engine engine) {
        this.engine = engine;
        return this;
    }

    @Override
    public String build() {
        StringBuilder stringBuilder = new StringBuilder();
        ListIterator columnCreationIterator = this.columnCreations.listIterator();

        if (engine == null)
            this.engine = Engine.INNO_DB;

        if (Configuration.getInstance().getDatabase().equals(Configuration.Database.MYSQL)) {
            stringBuilder.append("CREATE TABLE ").append(this.tableName);
            stringBuilder.append(" ( ");

            while (columnCreationIterator.hasNext()) {
                ColumnCreation columnCreation = (ColumnCreation) columnCreationIterator.next();
                stringBuilder.append(columnCreation.getColumnName()).append(" ");
                stringBuilder.append(columnCreation.getColumnType().getValue()).append(" ");
                if (!columnCreation.isNullable()) {
                    stringBuilder.append(" NOT NULL ");
                }
                if (columnCreation.isUnique()) {
                    stringBuilder.append(" UNIQUE ");
                }
                if (columnCreationIterator.hasNext()) {
                    stringBuilder.append(" , ");
                }
            }
            if (primaryKey != null) {
                stringBuilder.append(" , ").append(String.format(" PRIMARY KEY ('%s') ", primaryKey));
            }
            stringBuilder.append(" ) ");
            stringBuilder.append(" ENGINE = ").append(this.engine.getValue());
            stringBuilder.append(" ; ");
        }

        return stringBuilder.toString().trim().replaceAll(" +", " ");
    }
}
