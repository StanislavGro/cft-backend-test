package ru.cft.electronicstore.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Electronic Store")
                                .description("Shop selling computers and accessories")
                                .contact(
                                        new Contact()
                                                .email("stansialv.skii2000@mail.ru")
                                                .name("Stanislav Grokhotov [JINT] (ER-48527)")
                                )
                );
    }
}
