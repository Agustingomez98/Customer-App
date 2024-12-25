package com.groupassist.customerapp.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Customer Api",
                description = "Proyecto para la gestion de clientes (CRUD)",
                version = "1.0.0",
                contact = @Contact(
                        name = "Franco Agustín Gómez",
                        url= "https://agustindevelop-landingpage.netlify.app/",
                        email = "agustingomez220598@gmail.com"
                )))
public class SwaggerConfig {}