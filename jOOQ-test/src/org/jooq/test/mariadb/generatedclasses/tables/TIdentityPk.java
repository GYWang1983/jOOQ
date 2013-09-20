/**
 * This class is generated by jOOQ
 */
package org.jooq.test.mariadb.generatedclasses.tables;

/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TIdentityPk extends org.jooq.impl.TableImpl<org.jooq.test.mariadb.generatedclasses.tables.records.TIdentityPkRecord> {

	private static final long serialVersionUID = 1624150632;

	/**
	 * The singleton instance of <code>test.t_identity_pk</code>
	 */
	public static final org.jooq.test.mariadb.generatedclasses.tables.TIdentityPk T_IDENTITY_PK = new org.jooq.test.mariadb.generatedclasses.tables.TIdentityPk();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.jooq.test.mariadb.generatedclasses.tables.records.TIdentityPkRecord> getRecordType() {
		return org.jooq.test.mariadb.generatedclasses.tables.records.TIdentityPkRecord.class;
	}

	/**
	 * The column <code>test.t_identity_pk.id</code>. 
	 */
	public static final org.jooq.TableField<org.jooq.test.mariadb.generatedclasses.tables.records.TIdentityPkRecord, java.lang.Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), T_IDENTITY_PK);

	/**
	 * The column <code>test.t_identity_pk.val</code>. 
	 */
	public static final org.jooq.TableField<org.jooq.test.mariadb.generatedclasses.tables.records.TIdentityPkRecord, java.lang.Integer> VAL = createField("val", org.jooq.impl.SQLDataType.INTEGER, T_IDENTITY_PK);

	/**
	 * No further instances allowed
	 */
	private TIdentityPk() {
		super("t_identity_pk", org.jooq.test.mariadb.generatedclasses.Test.TEST);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<org.jooq.test.mariadb.generatedclasses.tables.records.TIdentityPkRecord, java.lang.Integer> getIdentity() {
		return org.jooq.test.mariadb.generatedclasses.Keys.IDENTITY_T_IDENTITY_PK;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<org.jooq.test.mariadb.generatedclasses.tables.records.TIdentityPkRecord> getPrimaryKey() {
		return org.jooq.test.mariadb.generatedclasses.Keys.KEY_T_IDENTITY_PK_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<org.jooq.test.mariadb.generatedclasses.tables.records.TIdentityPkRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<org.jooq.test.mariadb.generatedclasses.tables.records.TIdentityPkRecord>>asList(org.jooq.test.mariadb.generatedclasses.Keys.KEY_T_IDENTITY_PK_PRIMARY);
	}
}
