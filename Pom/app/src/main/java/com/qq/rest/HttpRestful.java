package com.qq.rest;


import org.springframework.web.client.RestTemplate;

/**
 * Created by qq on 15-5-15.
 */
public class HttpRestful {

    private static RestTemplate restTemplate = new RestTemplate();

    public static String getString(String url) {

        return restTemplate.getForObject(url, String.class);

    }
}

