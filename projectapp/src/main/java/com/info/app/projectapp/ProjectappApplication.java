package com.info.app.projectapp;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Proyectos API REST",
				description = "Esta es la documentacion de la API REST de proyectos, para el info 2024",
				version = "v1",
				contact = @Contact(
						name = "Ian Fernandez",
						email = "ianf@gmail.com",
						url = "https://campus-informatorio.chaco.gob.ar/"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://campus-informatorio.chaco.gob.ar/"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Proyecto para el info 2024",
				url = "https://campus-informatorio.chaco.gob.ar/"
		)
)
public class ProjectappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectappApplication.class, args);
	}

}
