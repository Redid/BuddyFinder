package com.tai.repository;

import com.tai.model.Offer;
import com.tai.model.Timer;
import com.tai.model.User;
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

    Offer findOneByWhen(Timer timer);

    List<Offer> findByWhen(Timer timer);

    Offer findOneByPreferredSex(String sex);

    List<Offer> findByPreferredSex(String sex);

    Offer findOneByPreferredAge(String age);

    List<Offer> findByPreferredAge(String age);

    Offer findOneByUser(User user);

    List<Offer> findByUser(User user);

}
