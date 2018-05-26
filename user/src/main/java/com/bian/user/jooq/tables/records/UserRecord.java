/*
 * This file is generated by jOOQ.
*/
package com.bian.user.jooq.tables.records;


import com.bian.user.jooq.tables.User;

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
public class UserRecord extends UpdatableRecordImpl<UserRecord> implements Record8<ULong, Timestamp, Timestamp, Timestamp, String, String, String, Long> {

    private static final long serialVersionUID = 628574313;

    /**
     * Setter for <code>user.user.id</code>.
     */
    public void setId(ULong value) {
        set(0, value);
    }

    /**
     * Getter for <code>user.user.id</code>.
     */
    public ULong getId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>user.user.create_time</code>.
     */
    public void setCreateTime(Timestamp value) {
        set(1, value);
    }

    /**
     * Getter for <code>user.user.create_time</code>.
     */
    public Timestamp getCreateTime() {
        return (Timestamp) get(1);
    }

    /**
     * Setter for <code>user.user.update_time</code>.
     */
    public void setUpdateTime(Timestamp value) {
        set(2, value);
    }

    /**
     * Getter for <code>user.user.update_time</code>.
     */
    public Timestamp getUpdateTime() {
        return (Timestamp) get(2);
    }

    /**
     * Setter for <code>user.user.delete_time</code>.
     */
    public void setDeleteTime(Timestamp value) {
        set(3, value);
    }

    /**
     * Getter for <code>user.user.delete_time</code>.
     */
    public Timestamp getDeleteTime() {
        return (Timestamp) get(3);
    }

    /**
     * Setter for <code>user.user.mobile</code>. 手机号
     */
    public void setMobile(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>user.user.mobile</code>. 手机号
     */
    public String getMobile() {
        return (String) get(4);
    }

    /**
     * Setter for <code>user.user.login_pwd</code>. 登录密码
     */
    public void setLoginPwd(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>user.user.login_pwd</code>. 登录密码
     */
    public String getLoginPwd() {
        return (String) get(5);
    }

    /**
     * Setter for <code>user.user.pwd_salt</code>. 密码盐
     */
    public void setPwdSalt(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>user.user.pwd_salt</code>. 密码盐
     */
    public String getPwdSalt() {
        return (String) get(6);
    }

    /**
     * Setter for <code>user.user.balance</code>. 余额, 单位分
     */
    public void setBalance(Long value) {
        set(7, value);
    }

    /**
     * Getter for <code>user.user.balance</code>. 余额, 单位分
     */
    public Long getBalance() {
        return (Long) get(7);
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
    public Row8<ULong, Timestamp, Timestamp, Timestamp, String, String, String, Long> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<ULong, Timestamp, Timestamp, Timestamp, String, String, String, Long> valuesRow() {
        return (Row8) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field1() {
        return User.USER_.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field2() {
        return User.USER_.CREATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field3() {
        return User.USER_.UPDATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field4() {
        return User.USER_.DELETE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return User.USER_.MOBILE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return User.USER_.LOGIN_PWD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return User.USER_.PWD_SALT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field8() {
        return User.USER_.BALANCE;
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
    public String component5() {
        return getMobile();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getLoginPwd();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getPwdSalt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component8() {
        return getBalance();
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
    public String value5() {
        return getMobile();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getLoginPwd();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getPwdSalt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value8() {
        return getBalance();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value1(ULong value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value2(Timestamp value) {
        setCreateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value3(Timestamp value) {
        setUpdateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value4(Timestamp value) {
        setDeleteTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value5(String value) {
        setMobile(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value6(String value) {
        setLoginPwd(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value7(String value) {
        setPwdSalt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value8(Long value) {
        setBalance(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord values(ULong value1, Timestamp value2, Timestamp value3, Timestamp value4, String value5, String value6, String value7, Long value8) {
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
     * Create a detached UserRecord
     */
    public UserRecord() {
        super(User.USER_);
    }

    /**
     * Create a detached, initialised UserRecord
     */
    public UserRecord(ULong id, Timestamp createTime, Timestamp updateTime, Timestamp deleteTime, String mobile, String loginPwd, String pwdSalt, Long balance) {
        super(User.USER_);

        set(0, id);
        set(1, createTime);
        set(2, updateTime);
        set(3, deleteTime);
        set(4, mobile);
        set(5, loginPwd);
        set(6, pwdSalt);
        set(7, balance);
    }
}
