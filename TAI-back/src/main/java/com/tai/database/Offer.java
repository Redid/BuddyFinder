package com.tai.database;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by izabella on 23.04.16.
 */
@Document(collection = "Offer")
public class Offer  extends AbstractModel {
    private String type;
    @DBRef
    private User user;
    private Date when;
    private String where;
    private String anotherInfo;

    public Offer(){
    }


    public Date getWhen() {
        return when;
    }

    public void setWhen(Date when) {
        this.when = when;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getAnotherInfo() {
        return anotherInfo;
    }

    public void setAnotherInfo(String anotherInfo) {
        this.anotherInfo = anotherInfo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User userId) {
        this.user = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
