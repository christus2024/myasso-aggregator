package fr.it4innov.myasso.association.config.web;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Component
public class SwaggerConfig {

    private final String moduleName;

    private final String apiVersion;
    private final String dateBuild;
    private final String javaVersion;

    public SwaggerConfig(
            @Value("${spring.application.name}") String moduleName,
            @Value("${myasso.appliation.version}") String apiVersion,
            @Value("${myasso.application.lastbuild}")String dateBuild,
            @Value("${myasso.java.version}")String javaVersion
    ) {
        this.moduleName = moduleName;
        this.apiVersion = apiVersion;
        this.dateBuild = dateBuild;
        this.javaVersion = javaVersion;
    }

    @Bean
    public OpenAPI customOpenAPI() {
        final String securitySchemeName = "bearerAuth";
        final String apiTitle = String.format("%s API", StringUtils.capitalize(moduleName));
        Map<String, Object> properties = new HashMap<>();
        properties.put("Build time", dateBuild);
        properties.put("Java version", javaVersion);
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                .components(
                        new Components()
                                .addSecuritySchemes(securitySchemeName,
                                        new SecurityScheme()
                                                .name(securitySchemeName)
                                                .type(SecurityScheme.Type.HTTP)
                                                .scheme("bearer")
                                                .bearerFormat("JWT")
                                )
                )
                .info(new Info()
                        .title(apiTitle)
                        .version(apiVersion)
                        .extensions(properties));
    }
}
