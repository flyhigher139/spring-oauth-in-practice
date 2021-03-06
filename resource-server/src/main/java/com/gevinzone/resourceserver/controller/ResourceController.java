package com.gevinzone.resourceserver.controller;

import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;


@RestController
@RequestMapping("/resources")
public class ResourceController {
    @GetMapping(value = "/demo", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getDemoResource() {
        return "{\"hello\": \"world\"}";
    }

    @GetMapping(value = "/demo2", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getDemoResource2() {
        return "{\"hello\": \"world\"}";
    }

    @GetMapping(value = "/username")
    public String currentUserName(Principal principal) {
        return principal.getName();
    }

    @GetMapping(value = "/username2")
    public String currentUserName(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();

        return principal.getName();
    }

    @GetMapping(value = "/username3")
    public String currentUserName() {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();

        return  authentication.getName();
    }
}
