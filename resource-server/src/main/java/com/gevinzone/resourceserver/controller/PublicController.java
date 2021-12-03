package com.gevinzone.resourceserver.controller;

import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RequestMapping("/public")
@RestController
public class PublicController {
    @GetMapping(value = "/demo", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getDemoResource() {
        return "{\"hello\": \"world\"}";
    }

    @GetMapping(value = "/username", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getUsernameIfToken(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();

        return principal == null ? "anonymous" : principal.getName();
    }

    @GetMapping(value = "/username2", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getUsername2IfToken() {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();

        return "anonymousUser".equals(authentication.getName()) ? "anonymous" : authentication.getName();
    }
}
