package com.tai.controller.request;

import com.tai.model.Timer;
import lombok.Data;

import java.util.List;

@Data
public class EditOfferRequest {
    private List<Timer> when;
    private String where;
    private String anotherInfo;
    private String preferredSex;
    private String preferredAge;
}
