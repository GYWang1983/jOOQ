package org.jooq.util.jpa;

import static org.jooq.tools.StringUtils.defaultString;
import static org.jooq.util.h2.information_schema.tables.Columns.COLUMNS;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.jooq.Record;
import org.jooq.util.ColumnDefinition;
import org.jooq.util.DataTypeDefinition;
import org.jooq.util.DefaultColumnDefinition;
import org.jooq.util.DefaultDataTypeDefinition;
import org.jooq.util.SchemaDefinition;
import org.jooq.util.h2.H2TableDefinition;
import org.jooq.util.h2.information_schema.tables.Columns;

public class JPATableDefinition extends H2TableDefinition {

	public JPATableDefinition(SchemaDefinition schema, String name, String comment) {
		super(schema, name, comment);
	}

	
	@Override
    public List<ColumnDefinition> getElements0() throws SQLException {
        List<ColumnDefinition> result = new ArrayList<ColumnDefinition>();

        for (Record record : create().select(
                Columns.COLUMN_NAME,
                Columns.ORDINAL_POSITION,
                Columns.TYPE_NAME,
                Columns.CHARACTER_MAXIMUM_LENGTH,
                Columns.NUMERIC_PRECISION,
                Columns.NUMERIC_SCALE,
                Columns.IS_NULLABLE,
                Columns.COLUMN_DEFAULT,
                Columns.REMARKS,
                Columns.SEQUENCE_NAME)
            .from(COLUMNS)
            .where(Columns.TABLE_SCHEMA.equal(getSchema().getName()))
            .and(Columns.TABLE_NAME.equal(getName()))
            .orderBy(Columns.ORDINAL_POSITION)
            .fetch()) {

            DataTypeDefinition type = new DefaultDataTypeDefinition(
                getDatabase(),
                getSchema(),
                record.get(Columns.TYPE_NAME));

            ColumnDefinition column = new DefaultColumnDefinition(
            	getDatabase().getTable(getSchema(), getName()),
                record.get(Columns.COLUMN_NAME),
                record.get(Columns.ORDINAL_POSITION),
                type,

                // [#5331] AUTO_INCREMENT (MySQL style)
                null != record.get(Columns.SEQUENCE_NAME)

                // [#5331] DEFAULT nextval('sequence') (PostgreSQL style)
             || defaultString(record.get(Columns.COLUMN_DEFAULT)).trim().toLowerCase().startsWith("nextval"),
                record.get(Columns.REMARKS));

            result.add(column);
        }

        return result;
    }
}
