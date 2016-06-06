package br.com.augustoccesar.querybuilder.modelreader.annotations;

import br.com.augustoccesar.querybuilder.query.column.ColumnType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by augustoccesar on 6/6/16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Column {
    String name();

    ColumnType type();

    int size() default -1;

    boolean primaryKey() default false;

    boolean nullable() default true;

    boolean unique() default false;
}
