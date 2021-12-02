package com.gevinzone.resourceserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.OAuth2ClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;


@Configuration
public class AppConfig {
    @Autowired
    private OAuth2ClientProperties oAuth2ClientProperties;
    @Value("${security.oauth2.client.access-token-uri}")
    private String accessTokenUri;

    @Bean
    public OAuth2RestTemplate oAuth2RestTemplate() {
        AuthorizationCodeResourceDetails resourceDetails = new AuthorizationCodeResourceDetails();
        resourceDetails.setClientId(oAuth2ClientProperties.getClientId());
        resourceDetails.setClientSecret(oAuth2ClientProperties.getClientSecret());
        resourceDetails.setAccessTokenUri(accessTokenUri);

        OAuth2RestTemplate template = new OAuth2RestTemplate(resourceDetails);
        template.setAccessTokenProvider(new AuthorizationCodeAccessTokenProvider());
        return template;
    }
}
