/*
 * This file is generated by jOOQ.
*/
package com.bian.product.jooq.tables.records;


import com.bian.product.jooq.tables.Productstocktcc;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;
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
public class ProductstocktccRecord extends UpdatableRecordImpl<ProductstocktccRecord> implements Record8<ULong, Timestamp, Timestamp, Timestamp, Timestamp, UInteger, UByte, ULong> {

    private static final long serialVersionUID = -1464808884;

    /**
     * Setter for <code>product.productstocktcc.id</code>.
     */
    public void setId(ULong value) {
        set(0, value);
    }

    /**
     * Getter for <code>product.productstocktcc.id</code>.
     */
    public ULong getId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>product.productstocktcc.create_time</code>.
     */
    public void setCreateTime(Timestamp value) {
        set(1, value);
    }

    /**
     * Getter for <code>product.productstocktcc.create_time</code>.
     */
    public Timestamp getCreateTime() {
        return (Timestamp) get(1);
    }

    /**
     * Setter for <code>product.productstocktcc.update_time</code>.
     */
    public void setUpdateTime(Timestamp value) {
        set(2, value);
    }

    /**
     * Getter for <code>product.productstocktcc.update_time</code>.
     */
    public Timestamp getUpdateTime() {
        return (Timestamp) get(2);
    }

    /**
     * Setter for <code>product.productstocktcc.delete_time</code>.
     */
    public void setDeleteTime(Timestamp value) {
        set(3, value);
    }

    /**
     * Getter for <code>product.productstocktcc.delete_time</code>.
     */
    public Timestamp getDeleteTime() {
        return (Timestamp) get(3);
    }

    /**
     * Setter for <code>product.productstocktcc.expire_time</code>.
     */
    public void setExpireTime(Timestamp value) {
        set(4, value);
    }

    /**
     * Getter for <code>product.productstocktcc.expire_time</code>.
     */
    public Timestamp getExpireTime() {
        return (Timestamp) get(4);
    }

    /**
     * Setter for <code>product.productstocktcc.stock</code>. 预留资源数量
     */
    public void setStock(UInteger value) {
        set(5, value);
    }

    /**
     * Getter for <code>product.productstocktcc.stock</code>. 预留资源数量
     */
    public UInteger getStock() {
        return (UInteger) get(5);
    }

    /**
     * Setter for <code>product.productstocktcc.status</code>. 0为try, 1为confirm完成
     */
    public void setStatus(UByte value) {
        set(6, value);
    }

    /**
     * Getter for <code>product.productstocktcc.status</code>. 0为try, 1为confirm完成
     */
    public UByte getStatus() {
        return (UByte) get(6);
    }

    /**
     * Setter for <code>product.productstocktcc.t_product_id</code>.
     */
    public void setTProductId(ULong value) {
        set(7, value);
    }

    /**
     * Getter for <code>product.productstocktcc.t_product_id</code>.
     */
    public ULong getTProductId() {
        return (ULong) get(7);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<ULong> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<ULong, Timestamp, Timestamp, Timestamp, Timestamp, UInteger, UByte, ULong> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<ULong, Timestamp, Timestamp, Timestamp, Timestamp, UInteger, UByte, ULong> valuesRow() {
        return (Row8) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field1() {
        return Productstocktcc.PRODUCTSTOCKTCC.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field2() {
        return Productstocktcc.PRODUCTSTOCKTCC.CREATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field3() {
        return Productstocktcc.PRODUCTSTOCKTCC.UPDATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field4() {
        return Productstocktcc.PRODUCTSTOCKTCC.DELETE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field5() {
        return Productstocktcc.PRODUCTSTOCKTCC.EXPIRE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field6() {
        return Productstocktcc.PRODUCTSTOCKTCC.STOCK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UByte> field7() {
        return Productstocktcc.PRODUCTSTOCKTCC.STATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field8() {
        return Productstocktcc.PRODUCTSTOCKTCC.T_PRODUCT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component2() {
        return getCreateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component3() {
        return getUpdateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component4() {
        return getDeleteTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component5() {
        return getExpireTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger component6() {
        return getStock();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UByte component7() {
        return getStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component8() {
        return getTProductId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value2() {
        return getCreateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value3() {
        return getUpdateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value4() {
        return getDeleteTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value5() {
        return getExpireTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger value6() {
        return getStock();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UByte value7() {
        return getStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value8() {
        return getTProductId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductstocktccRecord value1(ULong value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductstocktccRecord value2(Timestamp value) {
        setCreateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductstocktccRecord value3(Timestamp value) {
        setUpdateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductstocktccRecord value4(Timestamp value) {
        setDeleteTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductstocktccRecord value5(Timestamp value) {
        setExpireTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductstocktccRecord value6(UInteger value) {
        setStock(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductstocktccRecord value7(UByte value) {
        setStatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductstocktccRecord value8(ULong value) {
        setTProductId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductstocktccRecord values(ULong value1, Timestamp value2, Timestamp value3, Timestamp value4, Timestamp value5, UInteger value6, UByte value7, ULong value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ProductstocktccRecord
     */
    public ProductstocktccRecord() {
        super(Productstocktcc.PRODUCTSTOCKTCC);
    }

    /**
     * Create a detached, initialised ProductstocktccRecord
     */
    public ProductstocktccRecord(ULong id, Timestamp createTime, Timestamp updateTime, Timestamp deleteTime, Timestamp expireTime, UInteger stock, UByte status, ULong tProductId) {
        super(Productstocktcc.PRODUCTSTOCKTCC);

        set(0, id);
        set(1, createTime);
        set(2, updateTime);
        set(3, deleteTime);
        set(4, expireTime);
        set(5, stock);
        set(6, status);
        set(7, tProductId);
    }
}
