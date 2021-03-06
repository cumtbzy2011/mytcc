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
public class Conflict implements Serializable {

    private static final long serialVersionUID = -1071938261;

    private ULong     id;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Timestamp deleteTime;
    private String    errorDetail;
    private ULong     tOrderId;

    public Conflict() {}

    public Conflict(Conflict value) {
        this.id = value.id;
        this.createTime = value.createTime;
        this.updateTime = value.updateTime;
        this.deleteTime = value.deleteTime;
        this.errorDetail = value.errorDetail;
        this.tOrderId = value.tOrderId;
    }

    public Conflict(
        ULong     id,
        Timestamp createTime,
        Timestamp updateTime,
        Timestamp deleteTime,
        String    errorDetail,
        ULong     tOrderId
    ) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deleteTime = deleteTime;
        this.errorDetail = errorDetail;
        this.tOrderId = tOrderId;
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

    public String getErrorDetail() {
        return this.errorDetail;
    }

    public void setErrorDetail(String errorDetail) {
        this.errorDetail = errorDetail;
    }

    public ULong getTOrderId() {
        return this.tOrderId;
    }

    public void setTOrderId(ULong tOrderId) {
        this.tOrderId = tOrderId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Conflict (");

        sb.append(id);
        sb.append(", ").append(createTime);
        sb.append(", ").append(updateTime);
        sb.append(", ").append(deleteTime);
        sb.append(", ").append(errorDetail);
        sb.append(", ").append(tOrderId);

        sb.append(")");
        return sb.toString();
    }
}
