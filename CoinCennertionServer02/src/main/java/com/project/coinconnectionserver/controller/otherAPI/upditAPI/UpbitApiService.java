package com.project.coinconnectionserver.controller.otherAPI.upditAPI;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UpbitApiService {
    private static final String UPBIT_API_URL = "https://api.upbit.com/v1/ticker?markets=%s-%s";

    private final ObjectMapper objectMapper;

    public UpbitApiService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public CandleData[] getCandle(String coinName) {
        String apiUrl = String.format(UPBIT_API_URL, "KRW", coinName);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("accept", "application/json");

        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, String.class);

        String responseBody = response.getBody();
//        System.out.println("Response from Upbit API: " + responseBody); // Print the response body

        try {
            // Deserialize the JSON response into an array of CandleData objects
            return objectMapper.readValue(responseBody, CandleData[].class);
        } catch (Exception e) {
            System.err.println("Error deserializing JSON response: " + e.getMessage());
            return null;
        }
    }
}
