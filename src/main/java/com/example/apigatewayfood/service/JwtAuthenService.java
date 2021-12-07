package com.example.apigatewayfood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JwtAuthenService {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${app.url.authen}")
    private String URL;

    public Boolean validateToken(String token) {
        return restTemplate.postForObject(URL + "/validateToken", token, Boolean.class);
    }

    public String getClaims(String token) {
        return restTemplate.postForObject(URL + "/getClaims", token, String.class);
    }
}
