/*
 * This file is generated by jOOQ.
*/
package com.bian.order.jooq;


import com.bian.order.jooq.tables.Conflict;
import com.bian.order.jooq.tables.Order;
import com.bian.order.jooq.tables.Participant;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in order
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>order.conflict</code>.
     */
    public static final Conflict CONFLICT = com.bian.order.jooq.tables.Conflict.CONFLICT;

    /**
     * The table <code>order.order</code>.
     */
    public static final Order ORDER_ = com.bian.order.jooq.tables.Order.ORDER_;

    /**
     * The table <code>order.participant</code>.
     */
    public static final Participant PARTICIPANT = com.bian.order.jooq.tables.Participant.PARTICIPANT;
}
