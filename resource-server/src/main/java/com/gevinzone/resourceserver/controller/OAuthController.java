package com.gevinzone.resourceserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oauth")
public class OAuthController {
    @Autowired
    private OAuth2RestTemplate oAuth2RestTemplate;

    @GetMapping("/callback")
    public OAuth2AccessToken getToken(@RequestParam("code") String code) {
        oAuth2RestTemplate.getOAuth2ClientContext().getAccessTokenRequest().setAuthorizationCode(code);
        oAuth2RestTemplate.getOAuth2ClientContext().getAccessTokenRequest().setPreservedState("http://127.0.0.1:8091/oauth/callback");
        return oAuth2RestTemplate.getAccessToken();
    }

}
