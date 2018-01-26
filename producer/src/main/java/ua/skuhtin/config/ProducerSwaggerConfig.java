package ua.skuhtin.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ProducerSwaggerConfig extends SwaggerConfig {
    @Override
    protected String getModuleName() {
        return "producer swagger";
    }
}
