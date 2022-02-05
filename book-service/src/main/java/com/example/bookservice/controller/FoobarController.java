package com.example.bookservice.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Foobar")
@RestController
@RequestMapping("/book-service")
public class FoobarController {

    @Operation(summary = "foobar")
    @GetMapping("/foobar")
//    @Retry(name = "default", fallbackMethod = "fallbackMethod")
//    @CircuitBreaker(name = "default", fallbackMethod = "fallbackMethod")
//    @RateLimiter(name = "default")
    @Bulkhead(name = "default")
    public String getFoobar() {
        return "foobar";
    }

    public String fallbackMethod(Exception e) {
        return "fallback foobar";
    }

}
