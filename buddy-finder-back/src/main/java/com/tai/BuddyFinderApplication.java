package com.tai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import com.github.ulisesbocchio.jar.resources.JarResourceLoader;

@SpringBootApplication()
public class BuddyFinderApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BuddyFinderApplication.class).resourceLoader(new JarResourceLoader());
	}

	public static void main(String[] args) {
		SpringApplication.run(BuddyFinderApplication.class, args);
	}
}
