package com.msa.app.lch.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class TestService {

    private final RestTemplate restTemplate;

    private static final String CIRCUIT_INSTANCES = "lch"; //application.yml 인스턴스명

    @CircuitBreaker(name = CIRCUIT_INSTANCES, fallbackMethod = "getLchMsaSupportFallBack")
    public String getLchMsaSupport(String param) {
        String url = "http://localhost:8000/lch-msa-support/" +param;
        return restTemplate.getForObject(url, String.class);
    }

    public String getLchMsaSupportFallBack(Throwable t) {
        return " == > getLchMsaSupportFallBack : " + t.getClass();
    }
}
