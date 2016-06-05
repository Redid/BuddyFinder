package com.tai.model;

import com.tai.service.AbstractModel;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by izabella on 23.04.16.
 */
@Document(collection = "Offer")
@Data
public class Offer  extends AbstractModel {
    private String type;
    @DBRef
    private User user;
    @DBRef
    private List<Timer> when;
    private String where;
    private String anotherInfo;
    private String preferredSex;
    private String preferredAge;

    public Offer(){
        this.when = new ArrayList<>();
    }

    public void addWhen(Timer when){
        this.when.add(when);
    }
}
