/*
 * This file is generated by jOOQ.
*/
package com.bian.product.jooq.tables;


import com.bian.product.jooq.Indexes;
import com.bian.product.jooq.Keys;
import com.bian.product.jooq.Product;
import com.bian.product.jooq.tables.records.ProductstocktccRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.jooq.types.UByte;
import org.jooq.types.UInteger;
import org.jooq.types.ULong;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Productstocktcc extends TableImpl<ProductstocktccRecord> {

    private static final long serialVersionUID = 2034786318;

    /**
     * The reference instance of <code>product.productstocktcc</code>
     */
    public static final Productstocktcc PRODUCTSTOCKTCC = new Productstocktcc();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ProductstocktccRecord> getRecordType() {
        return ProductstocktccRecord.class;
    }

    /**
     * The column <code>product.productstocktcc.id</code>.
     */
    public final TableField<ProductstocktccRecord, ULong> ID = createField("id", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false).identity(true), this, "");

    /**
     * The column <code>product.productstocktcc.create_time</code>.
     */
    public final TableField<ProductstocktccRecord, Timestamp> CREATE_TIME = createField("create_time", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>product.productstocktcc.update_time</code>.
     */
    public final TableField<ProductstocktccRecord, Timestamp> UPDATE_TIME = createField("update_time", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>product.productstocktcc.delete_time</code>.
     */
    public final TableField<ProductstocktccRecord, Timestamp> DELETE_TIME = createField("delete_time", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.inline("1970-01-01 00:00:00", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>product.productstocktcc.expire_time</code>.
     */
    public final TableField<ProductstocktccRecord, Timestamp> EXPIRE_TIME = createField("expire_time", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.inline("1970-01-01 00:00:00", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>product.productstocktcc.stock</code>. 预留资源数量
     */
    public final TableField<ProductstocktccRecord, UInteger> STOCK = createField("stock", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "预留资源数量");

    /**
     * The column <code>product.productstocktcc.status</code>. 0为try, 1为confirm完成
     */
    public final TableField<ProductstocktccRecord, UByte> STATUS = createField("status", org.jooq.impl.SQLDataType.TINYINTUNSIGNED.nullable(false), this, "0为try, 1为confirm完成");

    /**
     * The column <code>product.productstocktcc.t_product_id</code>.
     */
    public final TableField<ProductstocktccRecord, ULong> T_PRODUCT_ID = createField("t_product_id", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * Create a <code>product.productstocktcc</code> table reference
     */
    public Productstocktcc() {
        this(DSL.name("productstocktcc"), null);
    }

    /**
     * Create an aliased <code>product.productstocktcc</code> table reference
     */
    public Productstocktcc(String alias) {
        this(DSL.name(alias), PRODUCTSTOCKTCC);
    }

    /**
     * Create an aliased <code>product.productstocktcc</code> table reference
     */
    public Productstocktcc(Name alias) {
        this(alias, PRODUCTSTOCKTCC);
    }

    private Productstocktcc(Name alias, Table<ProductstocktccRecord> aliased) {
        this(alias, aliased, null);
    }

    private Productstocktcc(Name alias, Table<ProductstocktccRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Product.PRODUCT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.PRODUCTSTOCKTCC_FK_T_PRODUCT_TCC_STATUS_EXPTIME, Indexes.PRODUCTSTOCKTCC_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<ProductstocktccRecord, ULong> getIdentity() {
        return Keys.IDENTITY_PRODUCTSTOCKTCC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ProductstocktccRecord> getPrimaryKey() {
        return Keys.KEY_PRODUCTSTOCKTCC_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ProductstocktccRecord>> getKeys() {
        return Arrays.<UniqueKey<ProductstocktccRecord>>asList(Keys.KEY_PRODUCTSTOCKTCC_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Productstocktcc as(String alias) {
        return new Productstocktcc(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Productstocktcc as(Name alias) {
        return new Productstocktcc(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Productstocktcc rename(String name) {
        return new Productstocktcc(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Productstocktcc rename(Name name) {
        return new Productstocktcc(name, null);
    }
}
