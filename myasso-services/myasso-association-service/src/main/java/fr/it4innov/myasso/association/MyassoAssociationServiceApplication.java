package fr.it4innov.myasso.association;

import fr.it4innov.myasso.association.config.AWSConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AWSConfig.class)
public class MyassoAssociationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyassoAssociationServiceApplication.class, args);
    }

}
