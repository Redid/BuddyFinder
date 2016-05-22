package com.tai.repository;

import com.tai.model.Offer;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by izabella on 23.04.16.
 */
public interface OfferRepository extends CrudRepository<Offer, String> {
    Offer findOneByType(String type);

    List<Offer> findByType(String type);

    Offer findOneByUserId(String userId);

    List<Offer> findByUserId(String userId);

    Offer findOneByWhere(String where);

    List<Offer> findByWhere(String where);

    Offer findOneByWhen(Date when);

    List<Offer> findByWhen(Date when);


}
