package com.tai.database;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tai.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component
public class ReadForOffer {

    @Autowired
    MongoTemplate mongoTemplate;

	@Autowired
	OfferRepository offerRepository;


	public Iterable<Offer> searchAll(){
		return offerRepository.findAll();
    }


	//public User searchOfferOwner(Offer offer){return offerRepository.findOwner(offer);}

	public List<Offer> searchAllByType(String type){
		return offerRepository.findByType(type);
	}
	public Offer searchOneByType(String type){
		return offerRepository.findOneByType(type);
	}

	public List<Offer> searchAllByWhere(String where){ return offerRepository.findByWhere(where);}
	public Offer searchOneByWhere(String where){ return offerRepository.findOneByWhere(where);}


	public List<Offer> searchAllByWhen(Date when){ return  offerRepository.findByWhen(when);}
	public Offer searchOneByWhen(Date when){return  offerRepository.findOneByWhen(when);}

	public Offer searchById(String id){
        return offerRepository.findOne(id);
	}

	public List<Offer> searchAllBySex(String sex){ return offerRepository.findByPrefferedSex(sex);}
	public Offer searchOneBySex(String sex){ return offerRepository.findOneByPrefferedSex(sex);}

	public List<Offer> searchAllByAge(String age){ return offerRepository.findByPreffereAge(age);}
	public Offer searchOneByAge(String age){ return offerRepository.findOneByPrefferedAge(age);}

	public List<Offer> searchAllByUser(User user){ return  offerRepository.findByUser(user);}
	public Offer searchOneByUser(User user){return  offerRepository.findOneByUser(user);}

}
