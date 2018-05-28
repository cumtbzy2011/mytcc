/*
 * This file is generated by jOOQ.
*/
package com.bian.product.jooq.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.types.UInteger;
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
public class Product implements Serializable {

    private static final long serialVersionUID = -370931161;

    private ULong     id;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Timestamp deleteTime;
    private String    name;
    private UInteger  stock;
    private UInteger  price;

    public Product() {}

    public Product(Product value) {
        this.id = value.id;
        this.createTime = value.createTime;
        this.updateTime = value.updateTime;
        this.deleteTime = value.deleteTime;
        this.name = value.name;
        this.stock = value.stock;
        this.price = value.price;
    }

    public Product(
        ULong     id,
        Timestamp createTime,
        Timestamp updateTime,
        Timestamp deleteTime,
        String    name,
        UInteger  stock,
        UInteger  price
    ) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deleteTime = deleteTime;
        this.name = name;
        this.stock = stock;
        this.price = price;
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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UInteger getStock() {
        return this.stock;
    }

    public void setStock(UInteger stock) {
        this.stock = stock;
    }

    public UInteger getPrice() {
        return this.price;
    }

    public void setPrice(UInteger price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Product (");

        sb.append(id);
        sb.append(", ").append(createTime);
        sb.append(", ").append(updateTime);
        sb.append(", ").append(deleteTime);
        sb.append(", ").append(name);
        sb.append(", ").append(stock);
        sb.append(", ").append(price);

        sb.append(")");
        return sb.toString();
    }
}