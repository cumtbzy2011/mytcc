/*
 * This file is generated by jOOQ.
*/
package com.bian.user.jooq;


import com.bian.user.jooq.tables.User;
import com.bian.user.jooq.tables.Userbalancetcc;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>user</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index USER_PRIMARY = Indexes0.USER_PRIMARY;
    public static final Index USER_UNI_USER_MOBILE = Indexes0.USER_UNI_USER_MOBILE;
    public static final Index USERBALANCETCC_FK_T_USER_TCC_STATUS_EXPTIME = Indexes0.USERBALANCETCC_FK_T_USER_TCC_STATUS_EXPTIME;
    public static final Index USERBALANCETCC_PRIMARY = Indexes0.USERBALANCETCC_PRIMARY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index USER_PRIMARY = Internal.createIndex("PRIMARY", User.USER_, new OrderField[] { User.USER_.ID }, true);
        public static Index USER_UNI_USER_MOBILE = Internal.createIndex("uni_user_mobile", User.USER_, new OrderField[] { User.USER_.MOBILE }, true);
        public static Index USERBALANCETCC_FK_T_USER_TCC_STATUS_EXPTIME = Internal.createIndex("fk_t_user_tcc_status_exptime", Userbalancetcc.USERBALANCETCC, new OrderField[] { Userbalancetcc.USERBALANCETCC.STATUS, Userbalancetcc.USERBALANCETCC.EXPIRE_TIME }, false);
        public static Index USERBALANCETCC_PRIMARY = Internal.createIndex("PRIMARY", Userbalancetcc.USERBALANCETCC, new OrderField[] { Userbalancetcc.USERBALANCETCC.ID }, true);
    }
}
