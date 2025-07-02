package com.MyProject.Gateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    @RequestMapping("/authSupport")
    public Mono<String> authenticationSupport(){
        return Mono.just("An error occurred, please try again later.");
    }

}
