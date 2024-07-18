package com.digitalholics.paymentservice;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PaymentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceApplication.class, args);
    }

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Physia - Payment Service")
                        .version("1.0")
                        .description("Physia Payment Service, made with java and springboot, applying domain-driven architecture approach.")
                        .termsOfService("https://github.com/DigitAlholics-Zeal-Tech-Hackathon")
                        .license(new License()
                                .name("Apache 2.0 License")
                                .url("https://github.com/DigitAlholics-Zeal-Tech-Hackathon"))
                        .contact(new Contact()
                                .url("https://github.com/DigitAlholics-Zeal-Tech-Hackathon")
                                .name("DigitAlholics.studio")))
                .components(new Components()
                        .addSecuritySchemes("bearer-jwt", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                                .in(SecurityScheme.In.HEADER)
                                .name("Authorization")
                        )
                ).addSecurityItem(new SecurityRequirement().addList("bearer-jwt"));

    }
}
