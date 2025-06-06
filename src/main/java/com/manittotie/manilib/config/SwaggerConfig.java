package com.manittotie.manilib.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        Info info = new Info()
                .title("manitotti API")
                .version("1.0")
                .description("마니또 매칭 서비스");

        Server server = new Server();
        server.setUrl("https://mini2team.lion.it.kr");

        Server server1 = new Server();
        server1.setUrl("http://localhost:8080");

        List<Server> serverList = new ArrayList<>();
        serverList.add(server);
        serverList.add(server1);

        return new OpenAPI()
                .info(info)
                .servers(serverList)
                .addSecurityItem(new SecurityRequirement().addList("Bearer Authentication"))
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes("Bearer Authentication", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")));
    }
}
