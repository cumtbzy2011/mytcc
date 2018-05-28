/*
 * This file is generated by jOOQ.
*/
package com.bian.user.jooq.tables;


import com.bian.user.jooq.Indexes;
import com.bian.user.jooq.Keys;
import com.bian.user.jooq.tables.records.UserRecord;

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
public class User extends TableImpl<UserRecord> {

    private static final long serialVersionUID = -433800811;

    /**
     * The reference instance of <code>user.user</code>
     */
    public static final User USER_ = new User();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserRecord> getRecordType() {
        return UserRecord.class;
    }

    /**
     * The column <code>user.user.id</code>.
     */
    public final TableField<UserRecord, ULong> ID = createField("id", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false).identity(true), this, "");

    /**
     * The column <code>user.user.create_time</code>.
     */
    public final TableField<UserRecord, Timestamp> CREATE_TIME = createField("create_time", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>user.user.update_time</code>.
     */
    public final TableField<UserRecord, Timestamp> UPDATE_TIME = createField("update_time", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>user.user.delete_time</code>.
     */
    public final TableField<UserRecord, Timestamp> DELETE_TIME = createField("delete_time", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.inline("1970-01-01 00:00:00", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>user.user.mobile</code>. 手机号
     */
    public final TableField<UserRecord, String> MOBILE = createField("mobile", org.jooq.impl.SQLDataType.VARCHAR(20).nullable(false), this, "手机号");

    /**
     * The column <code>user.user.login_pwd</code>. 登录密码
     */
    public final TableField<UserRecord, String> LOGIN_PWD = createField("login_pwd", org.jooq.impl.SQLDataType.VARCHAR(128).nullable(false), this, "登录密码");

    /**
     * The column <code>user.user.pwd_salt</code>. 密码盐
     */
    public final TableField<UserRecord, String> PWD_SALT = createField("pwd_salt", org.jooq.impl.SQLDataType.VARCHAR(128).nullable(false), this, "密码盐");

    /**
     * The column <code>user.user.balance</code>. 余额, 单位分
     */
    public final TableField<UserRecord, Long> BALANCE = createField("balance", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("100000000", org.jooq.impl.SQLDataType.BIGINT)), this, "余额, 单位分");

    /**
     * Create a <code>user.user</code> table reference
     */
    public User() {
        this(DSL.name("user"), null);
    }

    /**
     * Create an aliased <code>user.user</code> table reference
     */
    public User(String alias) {
        this(DSL.name(alias), USER_);
    }

    /**
     * Create an aliased <code>user.user</code> table reference
     */
    public User(Name alias) {
        this(alias, USER_);
    }

    private User(Name alias, Table<UserRecord> aliased) {
        this(alias, aliased, null);
    }

    private User(Name alias, Table<UserRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return com.bian.user.jooq.User.USER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.USER_PRIMARY, Indexes.USER_UNI_USER_MOBILE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<UserRecord, ULong> getIdentity() {
        return Keys.IDENTITY_USER_;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<UserRecord> getPrimaryKey() {
        return Keys.KEY_USER_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<UserRecord>> getKeys() {
        return Arrays.<UniqueKey<UserRecord>>asList(Keys.KEY_USER_PRIMARY, Keys.KEY_USER_UNI_USER_MOBILE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User as(String alias) {
        return new User(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User as(Name alias) {
        return new User(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public User rename(String name) {
        return new User(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public User rename(Name name) {
        return new User(name, null);
    }
}