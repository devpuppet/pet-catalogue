package com.kkukielka.petcatalogueweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
//		"com.kkukielka.petcatalogueweb.bootstrap",
//		"com.kkukielka.petcatalogueweb.controller",
//		"com.kkukielka.petcatalogueweb.service"
		"com.kkukielka.petcatalogueweb"
})
@EnableJpaRepositories("com.kkukielka.petcataloguemodel")
@EntityScan("com.kkukielka.petcataloguemodel.model")
public class PetcatalogueApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetcatalogueApplication.class, args);
	}

}
