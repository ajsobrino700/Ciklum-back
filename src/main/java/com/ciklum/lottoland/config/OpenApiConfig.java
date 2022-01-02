package com.ciklum.lottoland.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

	
    @Bean
    public OpenAPI customOpenAPI() {
    	
        Contact contact = new Contact();
        contact.setEmail("ajsobrino700@gmail.com");
        contact.setName("Ciklum");
        contact.setUrl("https://www.lotoland.com/");

        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .version("1.0.0")
                        .title("Paper, Rock, Scissors game")
                        .description("App for game the clasic paper, rock or Scissors game.")
                        .contact(contact)
                );
    }
	
}
