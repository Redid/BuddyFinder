package com.tai.repository;

import com.tai.model.Offer;
import com.tai.model.Timer;
import com.tai.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by izabella on 23.04.16.
 */
public interface OfferRepository extends MongoRepository<Offer, String> {
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

    @Query("{ $and: [ {$or : [{ $where: '?0 == null' } , { preferredAge: ?0 }] }, {$or : [{ $where: '?1 == null' } , { preferredSex: ?1 }] } ]}")
    List<Offer> findByParams(String age, String sex);

}
