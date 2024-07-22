package fr.it4innov.myasso.association.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Christus
 * @date 21/07/2024
 */
@Component
@ConfigurationProperties(prefix = "aws")
@PropertySource("classpath:application-aws.properties")
public class AWSConfig {
    public String accessKey;
    public String secretKey;
    public String s3Bucket;
}
