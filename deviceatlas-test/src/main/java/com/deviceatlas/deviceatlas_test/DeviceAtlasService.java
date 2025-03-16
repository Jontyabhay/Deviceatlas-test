package com.deviceatlas.deviceatlas_test;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Value;
import java.util.List;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class DeviceAtlasService {

    private final RestTemplate restTemplate;

    private static final Logger logger = LoggerFactory.getLogger(DeviceAtlasService.class); // Define logger


    public DeviceAtlasService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<String> processUserAgents() {
        List<String> userAgents = List.of(
            "Mozilla/5.0 (Linux; Android 7.0; Pixel C Build/NRD90M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/52.0.2743.98 Safari/537.36",
            "Mozilla/5.0 (Linux; Android 10; MAR-LX1A) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Mobile Safari/537.36",
            "Mozilla/5.0 (iPhone; CPU iPhone OS 12_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/12.0 Mobile/15E148 Safari/604.1",
            "Mozilla/5.0 (Linux; Android 4.4.3; KFTHWI Build/KTU84M) AppleWebKit/537.36 (KHTML, like Gecko) Silk/47.1.79 like Chrome/47.0.2526.80 Safari/537.36",
            "Mozilla/5.0 (iPad; CPU OS 18_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) CriOS/112.0.5615.46 Mobile/15E148 Safari/604.1",
            "Mozilla/5.0 (Linux; Android 12; Redmi Note 9 Pro) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Mobile Safari/537.36",
            "Mozilla/5.0 (Linux; Android 12; SM-X906C Build/QP1A.190711.020; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/80.0.3987.119 Mobile Safari/537.36",
            "Dalvik/2.1.0 (Linux; U; Android 10; ACTAB1021 Build/QP1A.190711.020)",
            "Mozilla/5.0 (Linux; Android 13; SM-A515U) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Mobile Safari/537.36",
            "Mozilla/5.0 (Linux; Android 5.0.2; LG-V410/V41020c Build/LRX22G) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/34.0.1847.118 Safari/537.36"
        );

        List<String> responses = new ArrayList<>();
        for (String userAgent : userAgents) {
            try {
                String url = UriComponentsBuilder.fromHttpUrl("https://region0.deviceatlascloud.com/v1/detect/properties?licencekey=e6ce0b9455cab0e494be4587d016c7c2&useragent={value}")
                        .buildAndExpand(userAgent)
                        .toUriString();
                String response = restTemplate.getForObject(url, String.class);
                responses.add(response);
            } catch (Exception e) {
                logger.error("Error while calling DeviceAtlas API for UserAgent: {}", userAgent, e);
            }
        }
        System.out.println(responses);  // Print all responses
        return responses;  // Return all responses
    }
}
