package com.example.psicoweb.Configuration;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("API DE PARCIAL SEGUNDO CORTE")
                        .version("1.0")
                        .description("Documetacion de la api del proyecto")
                        .contact(new Contact()
                                .name("Omar Rodriguez")
                                .email("omar.rodriguez-pu@uniminuto.edu.co")));
    }

}