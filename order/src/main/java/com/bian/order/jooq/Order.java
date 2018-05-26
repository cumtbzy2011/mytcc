/*
 * This file is generated by jOOQ.
*/
package com.bian.order.jooq;


import com.bian.order.jooq.tables.Conflict;
import com.bian.order.jooq.tables.Participant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


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
public class Order extends SchemaImpl {

    private static final long serialVersionUID = -1385992099;

    /**
     * The reference instance of <code>order</code>
     */
    public static final Order ORDER = new Order();

    /**
     * The table <code>order.conflict</code>.
     */
    public final Conflict CONFLICT = com.bian.order.jooq.tables.Conflict.CONFLICT;

    /**
     * The table <code>order.order</code>.
     */
    public final com.bian.order.jooq.tables.Order ORDER_ = com.bian.order.jooq.tables.Order.ORDER_;

    /**
     * The table <code>order.participant</code>.
     */
    public final Participant PARTICIPANT = com.bian.order.jooq.tables.Participant.PARTICIPANT;

    /**
     * No further instances allowed
     */
    private Order() {
        super("order", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            Conflict.CONFLICT,
            com.bian.order.jooq.tables.Order.ORDER_,
            Participant.PARTICIPANT);
    }
}