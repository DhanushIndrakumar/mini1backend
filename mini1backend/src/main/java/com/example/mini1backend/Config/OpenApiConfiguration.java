package com.example.mini1backend.Config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(  //setting various properties
        info=@Info(
                contact=@Contact(
                        name="Dhanush",
                        email="dhanushindrakumar123@gmail.com"
                ),
                description="Open Api documentation",
                title="User Management System",
                version="1.0",
                termsOfService = "Terms of service"

        ),
        servers={
                @Server(
                        description="Dev",
                        url="http://localhost:8082"
                ),
                @Server(
                        description="Test",
                        url="http://localhost:8082"
                )
        }
//        security = {
//                @SecurityRequirement(name="bearerAuth")
//        }


)

public class OpenApiConfiguration {
}
