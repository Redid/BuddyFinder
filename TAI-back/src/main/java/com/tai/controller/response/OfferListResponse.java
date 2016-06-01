package com.tai.controller.response;

import com.tai.model.Offer;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class OfferListResponse {
    private List<Offer> offers;
    private int count;
}
