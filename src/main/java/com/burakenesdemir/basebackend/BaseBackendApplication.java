package com.burakenesdemir.basebackend;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(servers = {@Server(url = "http://localhost:8080")},
		info = @Info(title = "Base Backend API", version = "v1", description = "Base Backend Developer Guide"))
public class BaseBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(BaseBackendApplication.class, args);
	}

}
