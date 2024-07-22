package fr.it4innov.myasso.association.config;

import fr.it4innov.myasso.association.service.MembreService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.ClientHttpRequestFactories;
import org.springframework.boot.web.client.ClientHttpRequestFactorySettings;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpRequestValues;
import org.springframework.web.service.invoker.HttpServiceArgumentResolver;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.time.Duration;

/**
 * @author Christus
 * @date 16/07/2024
 */

@Configuration
public class RestClientConfig {

    @Value("${myasso.membre-service}")
    private String membreServiceUrl;
   // @LoadBalanced
    @Bean
    RestClient.Builder restClientBuilder() {
        return RestClient.builder();
    }
    @Bean
    public RestClient membreServiceRestClient(/*@LoadBalanced*/ RestClient.Builder restClientBuilder) {
        return this.createRestClient(restClientBuilder, membreServiceUrl);
    }

    @Bean
    public MembreService membreService(RestClient membreServiceRestClient) {
        return httpServiceProxyFactory(membreServiceRestClient).createClient(MembreService.class);
    }
    private RestClient createRestClient(/*@LoadBalanced*/ RestClient.Builder restClientBuilder, String baseUrl) {
        ClientHttpRequestFactorySettings requestFactorySettings = ClientHttpRequestFactorySettings.DEFAULTS
                .withConnectTimeout(Duration.ofSeconds(30))
                .withReadTimeout(Duration.ofSeconds(30));

        return restClientBuilder
                .requestFactory(ClientHttpRequestFactories.get(requestFactorySettings))
                .baseUrl(baseUrl)
                .build();
    }
    private HttpServiceProxyFactory httpServiceProxyFactory(RestClient restClient){

        return HttpServiceProxyFactory
                .builderFor(RestClientAdapter.create(restClient))
                .build();
    }
}

/*class CustomHttpServiceArgumentResolver implements HttpServiceArgumentResolver{

    @Override
    public boolean resolve(Object argument, MethodParameter parameter, HttpRequestValues.Builder requestValues) {
        return true;
    }
}*/
