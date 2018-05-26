/*
 * This file is generated by jOOQ.
*/
package com.bian.product.order.jooq.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.Generated;


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
public class Order implements Serializable {

    private static final long serialVersionUID = -1839689551;

    private Integer   id;
    private Timestamp createtime;

    public Order() {}

    public Order(Order value) {
        this.id = value.id;
        this.createtime = value.createtime;
    }

    public Order(
        Integer   id,
        Timestamp createtime
    ) {
        this.id = id;
        this.createtime = createtime;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Order (");

        sb.append(id);
        sb.append(", ").append(createtime);

        sb.append(")");
        return sb.toString();
    }
}