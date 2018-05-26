/*
 * This file is generated by jOOQ.
*/
package com.bian.order.jooq;


import com.bian.order.jooq.tables.Conflict;
import com.bian.order.jooq.tables.Order;
import com.bian.order.jooq.tables.Participant;
import com.bian.order.jooq.tables.records.ConflictRecord;
import com.bian.order.jooq.tables.records.OrderRecord;
import com.bian.order.jooq.tables.records.ParticipantRecord;

import javax.annotation.Generated;

import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;
import org.jooq.types.ULong;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>order</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<ConflictRecord, ULong> IDENTITY_CONFLICT = Identities0.IDENTITY_CONFLICT;
    public static final Identity<OrderRecord, ULong> IDENTITY_ORDER_ = Identities0.IDENTITY_ORDER_;
    public static final Identity<ParticipantRecord, ULong> IDENTITY_PARTICIPANT = Identities0.IDENTITY_PARTICIPANT;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<ConflictRecord> KEY_CONFLICT_PRIMARY = UniqueKeys0.KEY_CONFLICT_PRIMARY;
    public static final UniqueKey<OrderRecord> KEY_ORDER_PRIMARY = UniqueKeys0.KEY_ORDER_PRIMARY;
    public static final UniqueKey<ParticipantRecord> KEY_PARTICIPANT_PRIMARY = UniqueKeys0.KEY_PARTICIPANT_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<ConflictRecord, ULong> IDENTITY_CONFLICT = Internal.createIdentity(Conflict.CONFLICT, Conflict.CONFLICT.ID);
        public static Identity<OrderRecord, ULong> IDENTITY_ORDER_ = Internal.createIdentity(Order.ORDER_, Order.ORDER_.ID);
        public static Identity<ParticipantRecord, ULong> IDENTITY_PARTICIPANT = Internal.createIdentity(Participant.PARTICIPANT, Participant.PARTICIPANT.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<ConflictRecord> KEY_CONFLICT_PRIMARY = Internal.createUniqueKey(Conflict.CONFLICT, "KEY_conflict_PRIMARY", Conflict.CONFLICT.ID);
        public static final UniqueKey<OrderRecord> KEY_ORDER_PRIMARY = Internal.createUniqueKey(Order.ORDER_, "KEY_order_PRIMARY", Order.ORDER_.ID);
        public static final UniqueKey<ParticipantRecord> KEY_PARTICIPANT_PRIMARY = Internal.createUniqueKey(Participant.PARTICIPANT, "KEY_participant_PRIMARY", Participant.PARTICIPANT.ID);
    }
}