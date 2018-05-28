/*
 * This file is generated by jOOQ.
*/
package com.bian.user.jooq.tables.records;


import com.bian.user.jooq.tables.Userbalancetcc;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;
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
public class UserbalancetccRecord extends UpdatableRecordImpl<UserbalancetccRecord> implements Record8<ULong, Timestamp, Timestamp, Timestamp, Timestamp, Long, Byte, ULong> {

    private static final long serialVersionUID = 611992674;

    /**
     * Setter for <code>user.userbalancetcc.id</code>.
     */
    public void setId(ULong value) {
        set(0, value);
    }

    /**
     * Getter for <code>user.userbalancetcc.id</code>.
     */
    public ULong getId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>user.userbalancetcc.create_time</code>.
     */
    public void setCreateTime(Timestamp value) {
        set(1, value);
    }

    /**
     * Getter for <code>user.userbalancetcc.create_time</code>.
     */
    public Timestamp getCreateTime() {
        return (Timestamp) get(1);
    }

    /**
     * Setter for <code>user.userbalancetcc.update_time</code>.
     */
    public void setUpdateTime(Timestamp value) {
        set(2, value);
    }

    /**
     * Getter for <code>user.userbalancetcc.update_time</code>.
     */
    public Timestamp getUpdateTime() {
        return (Timestamp) get(2);
    }

    /**
     * Setter for <code>user.userbalancetcc.delete_time</code>.
     */
    public void setDeleteTime(Timestamp value) {
        set(3, value);
    }

    /**
     * Getter for <code>user.userbalancetcc.delete_time</code>.
     */
    public Timestamp getDeleteTime() {
        return (Timestamp) get(3);
    }

    /**
     * Setter for <code>user.userbalancetcc.expire_time</code>.
     */
    public void setExpireTime(Timestamp value) {
        set(4, value);
    }

    /**
     * Getter for <code>user.userbalancetcc.expire_time</code>.
     */
    public Timestamp getExpireTime() {
        return (Timestamp) get(4);
    }

    /**
     * Setter for <code>user.userbalancetcc.amount</code>. 预留资源金额
     */
    public void setAmount(Long value) {
        set(5, value);
    }

    /**
     * Getter for <code>user.userbalancetcc.amount</code>. 预留资源金额
     */
    public Long getAmount() {
        return (Long) get(5);
    }

    /**
     * Setter for <code>user.userbalancetcc.status</code>. 0为try, 1为confirm完成
     */
    public void setStatus(Byte value) {
        set(6, value);
    }

    /**
     * Getter for <code>user.userbalancetcc.status</code>. 0为try, 1为confirm完成
     */
    public Byte getStatus() {
        return (Byte) get(6);
    }

    /**
     * Setter for <code>user.userbalancetcc.t_user_id</code>.
     */
    public void setTUserId(ULong value) {
        set(7, value);
    }

    /**
     * Getter for <code>user.userbalancetcc.t_user_id</code>.
     */
    public ULong getTUserId() {
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
    public Row8<ULong, Timestamp, Timestamp, Timestamp, Timestamp, Long, Byte, ULong> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<ULong, Timestamp, Timestamp, Timestamp, Timestamp, Long, Byte, ULong> valuesRow() {
        return (Row8) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field1() {
        return Userbalancetcc.USERBALANCETCC.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field2() {
        return Userbalancetcc.USERBALANCETCC.CREATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field3() {
        return Userbalancetcc.USERBALANCETCC.UPDATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field4() {
        return Userbalancetcc.USERBALANCETCC.DELETE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field5() {
        return Userbalancetcc.USERBALANCETCC.EXPIRE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field6() {
        return Userbalancetcc.USERBALANCETCC.AMOUNT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field7() {
        return Userbalancetcc.USERBALANCETCC.STATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field8() {
        return Userbalancetcc.USERBALANCETCC.T_USER_ID;
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
    public Long component6() {
        return getAmount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte component7() {
        return getStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component8() {
        return getTUserId();
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
    public Long value6() {
        return getAmount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value7() {
        return getStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value8() {
        return getTUserId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserbalancetccRecord value1(ULong value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserbalancetccRecord value2(Timestamp value) {
        setCreateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserbalancetccRecord value3(Timestamp value) {
        setUpdateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserbalancetccRecord value4(Timestamp value) {
        setDeleteTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserbalancetccRecord value5(Timestamp value) {
        setExpireTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserbalancetccRecord value6(Long value) {
        setAmount(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserbalancetccRecord value7(Byte value) {
        setStatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserbalancetccRecord value8(ULong value) {
        setTUserId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserbalancetccRecord values(ULong value1, Timestamp value2, Timestamp value3, Timestamp value4, Timestamp value5, Long value6, Byte value7, ULong value8) {
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
     * Create a detached UserbalancetccRecord
     */
    public UserbalancetccRecord() {
        super(Userbalancetcc.USERBALANCETCC);
    }

    /**
     * Create a detached, initialised UserbalancetccRecord
     */
    public UserbalancetccRecord(ULong id, Timestamp createTime, Timestamp updateTime, Timestamp deleteTime, Timestamp expireTime, Long amount, Byte status, ULong tUserId) {
        super(Userbalancetcc.USERBALANCETCC);

        set(0, id);
        set(1, createTime);
        set(2, updateTime);
        set(3, deleteTime);
        set(4, expireTime);
        set(5, amount);
        set(6, status);
        set(7, tUserId);
    }
}