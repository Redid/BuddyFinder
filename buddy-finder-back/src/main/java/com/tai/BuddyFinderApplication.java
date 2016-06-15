package com.tai;

import com.github.ulisesbocchio.jar.resources.JarResourceLoader;
import com.tai.model.Offer;
import com.tai.model.User;
import com.tai.repository.OfferRepository;
import com.tai.repository.UserRepository;
import com.tai.service.DataGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class BuddyFinderApplication extends SpringBootServletInitializer implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    OfferRepository offerRepository;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BuddyFinderApplication.class).resourceLoader(new JarResourceLoader());
	}

	public static void main(String[] args) {
		SpringApplication.run(BuddyFinderApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
        userRepository.deleteAll();
        offerRepository.deleteAll();

		DataGenerator generator = new DataGenerator();
		generator.generate();
        for(User u: generator.getUsersList()){
            userRepository.save(u);
        }

        for(Offer o: generator.getOffersList()){
            offerRepository.save(o);
        }
	}
}
