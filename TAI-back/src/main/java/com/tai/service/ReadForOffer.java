package com.tai.service;

import java.util.List;

import com.tai.model.Offer;
import com.tai.model.Timer;
import com.tai.model.User;
import com.tai.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
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


	public List<Offer> searchAllByWhen(Timer timer){ return  offerRepository.findByWhen(timer);}
	public Offer searchOneByWhen(Timer timer){return  offerRepository.findOneByWhen(timer);}

	public Offer searchById(String id){
        return offerRepository.findOne(id);
	}

	public List<Offer> searchAllBySex(String sex){ return offerRepository.findByPreferredSex(sex);}
	public Offer searchOneBySex(String sex){ return offerRepository.findOneByPreferredSex(sex);}

	public List<Offer> searchAllByAge(String age){ return offerRepository.findByPreferredAge(age);}
	public Offer searchOneByAge(String age){ return offerRepository.findOneByPreferredAge(age);}

	public List<Offer> searchAllByUser(User user){ return  offerRepository.findByUser(user);}
	public Offer searchOneByUser(User user){return  offerRepository.findOneByUser(user);}

	public void deleteOffer(String offerID){
		offerRepository.delete(offerID);
	}
}
