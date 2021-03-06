/*
 * This file is generated by jOOQ.
*/
package com.bian.user.jooq.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.Generated;

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
public class User implements Serializable {

    private static final long serialVersionUID = -1118856739;

    private ULong     id;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Timestamp deleteTime;
    private String    mobile;
    private String    loginPwd;
    private String    pwdSalt;
    private Long      balance;

    public User() {}

    public User(User value) {
        this.id = value.id;
        this.createTime = value.createTime;
        this.updateTime = value.updateTime;
        this.deleteTime = value.deleteTime;
        this.mobile = value.mobile;
        this.loginPwd = value.loginPwd;
        this.pwdSalt = value.pwdSalt;
        this.balance = value.balance;
    }

    public User(
        ULong     id,
        Timestamp createTime,
        Timestamp updateTime,
        Timestamp deleteTime,
        String    mobile,
        String    loginPwd,
        String    pwdSalt,
        Long      balance
    ) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deleteTime = deleteTime;
        this.mobile = mobile;
        this.loginPwd = loginPwd;
        this.pwdSalt = pwdSalt;
        this.balance = balance;
    }

    public ULong getId() {
        return this.id;
    }

    public void setId(ULong id) {
        this.id = id;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Timestamp getDeleteTime() {
        return this.deleteTime;
    }

    public void setDeleteTime(Timestamp deleteTime) {
        this.deleteTime = deleteTime;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLoginPwd() {
        return this.loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getPwdSalt() {
        return this.pwdSalt;
    }

    public void setPwdSalt(String pwdSalt) {
        this.pwdSalt = pwdSalt;
    }

    public Long getBalance() {
        return this.balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("User (");

        sb.append(id);
        sb.append(", ").append(createTime);
        sb.append(", ").append(updateTime);
        sb.append(", ").append(deleteTime);
        sb.append(", ").append(mobile);
        sb.append(", ").append(loginPwd);
        sb.append(", ").append(pwdSalt);
        sb.append(", ").append(balance);

        sb.append(")");
        return sb.toString();
    }
}
