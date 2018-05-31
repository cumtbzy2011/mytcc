/*
 * This file is generated by jOOQ.
*/
package com.bian.order.jooq.tables.pojos;


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
public class Participant implements Serializable {

    private static final long serialVersionUID = -1106207741;

    private ULong     id;
    private Timestamp createTime;
    private ULong     tOrderId;
    private String    partId;
    private String    partType;

    public Participant() {}

    public Participant(Participant value) {
        this.id = value.id;
        this.createTime = value.createTime;
        this.tOrderId = value.tOrderId;
        this.partId = value.partId;
        this.partType = value.partType;
    }

    public Participant(
        ULong     id,
        Timestamp createTime,
        ULong     tOrderId,
        String    partId,
        String    partType
    ) {
        this.id = id;
        this.createTime = createTime;
        this.tOrderId = tOrderId;
        this.partId = partId;
        this.partType = partType;
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

    public ULong getTOrderId() {
        return this.tOrderId;
    }

    public void setTOrderId(ULong tOrderId) {
        this.tOrderId = tOrderId;
    }

    public String getPartId() {
        return this.partId;
    }

    public void setPartId(String partId) {
        this.partId = partId;
    }

    public String getPartType() {
        return this.partType;
    }

    public void setPartType(String partType) {
        this.partType = partType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Participant (");

        sb.append(id);
        sb.append(", ").append(createTime);
        sb.append(", ").append(tOrderId);
        sb.append(", ").append(partId);
        sb.append(", ").append(partType);

        sb.append(")");
        return sb.toString();
    }
}
