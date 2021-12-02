package com.gevinzone.resourceserver.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resources")
public class ResourceController {
    @GetMapping(value = "/demo", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getDemoResource() {
        return "{\"hello\": \"world\"}";
    }
}
