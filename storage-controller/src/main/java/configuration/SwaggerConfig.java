package configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
            .group("OpenAPI")
            .pathsToMatch("/storage/**")
            .build();
    }

    @Bean
    public OpenAPI metaData() {
        return new OpenAPI()
            .info(new Info().title("STORAGE API")
                .description("\"Storage REST webservices\"")
                .license(new License().name("starychonak"))
                .version(getClass().getPackage().getImplementationVersion()));
    }

}
