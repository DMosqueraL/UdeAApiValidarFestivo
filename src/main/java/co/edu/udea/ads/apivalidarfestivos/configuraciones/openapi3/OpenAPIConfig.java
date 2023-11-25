package co.edu.udea.ads.apivalidarfestivos.configuraciones.openapi3;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI myOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API RESTfull Festivos en Colombia")
                        .version("1.0")
                        .description("API Festivos en Colombia")
                        .contact(new Contact()
                                .name("Doris Mosquera Lozano")
                                .email("doris.mosqueral@edu.edu.co"))
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License()
                                .name("Apache License")
                                .url("http://www.apache.org/licenses/")));
    }
}
