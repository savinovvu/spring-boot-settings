package ru.inbox.savinov_vu.webrest;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import ru.inbox.savinov_vu.web.User;



// spring data rest configuration
@Configuration
public class RestRepositoryConfig extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
//        include id property in response

        config.exposeIdsFor(User.class);

//        cors support
        config.getCorsRegistry()
                .addMapping("/api/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(false)
                .maxAge(3600);


    }


}
