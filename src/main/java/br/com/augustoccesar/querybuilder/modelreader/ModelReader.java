package br.com.augustoccesar.querybuilder.modelreader;

import br.com.augustoccesar.querybuilder.modelreader.annotations.Column;
import br.com.augustoccesar.querybuilder.modelreader.annotations.Table;
import br.com.augustoccesar.querybuilder.query.builders.TableCreationBuilder;
import br.com.augustoccesar.querybuilder.query.column.ColumnCreation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by augustoccesar on 6/6/16.
 */
public class ModelReader {
    public String generateCreationSql(Class clazz) {
        String tableName = null;
        String primaryKey = null;
        List<ColumnCreation> columnCreations = new ArrayList<>();

        for (Annotation annotation : clazz.getDeclaredAnnotations()) {
            if (annotation instanceof Table) {
                Table tableAnnotation = (Table) annotation;
                tableName = tableAnnotation.name();
            }
        }

        for (Field field : clazz.getDeclaredFields()) {
            for (Annotation annotation : field.getDeclaredAnnotations()) {
                if (annotation instanceof Column) {
                    Column columnAnnotation = (Column) annotation;
                    ColumnCreation column = new ColumnCreation(columnAnnotation.name(), columnAnnotation.type());
                    column.setNullable(columnAnnotation.nullable());
                    column.setUnique(columnAnnotation.nullable());
                    if (columnAnnotation.size() != -1) {
                        column.setColumnSize(columnAnnotation.size());
                    }
                    if (columnAnnotation.primaryKey()) {
                        primaryKey = columnAnnotation.name();
                    }
                    columnCreations.add(column);
                }
            }
        }

        return new TableCreationBuilder(tableName, primaryKey, columnCreations, null).build();
    }
}
