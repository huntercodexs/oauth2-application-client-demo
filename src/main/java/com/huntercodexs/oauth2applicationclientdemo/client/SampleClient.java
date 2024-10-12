package com.huntercodexs.oauth2applicationclientdemo.client;

import net.minidev.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SampleClient {

    private final RestTemplate restTemplate = new RestTemplate();

    private HttpHeaders httpRequestHeaders(String key, String type) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        if (type.equals("basic")) {
            httpHeaders.set("Authorization", "Basic " + key.replaceFirst("Basic ", ""));
        } else if (type.equals("bearer")) {
            httpHeaders.set("Authorization", "Bearer " + key.replaceFirst("Bearer ", ""));
        }
        return httpHeaders;
    }

    public ResponseEntity<JSONObject> getToken(String urlGetToken, String credentials, String auth) {
        HttpEntity<String> httpEntity = new HttpEntity<>(credentials, httpRequestHeaders(auth, "basic"));
        return restTemplate.postForEntity(urlGetToken + credentials, httpEntity, JSONObject.class);
    }

    public ResponseEntity<JSONObject> checkToken(String token, String urlCheckToken, String auth, String body) {
        HttpEntity<String> httpEntity = new HttpEntity<>(body, httpRequestHeaders(auth, "basic"));
        return restTemplate.postForEntity(urlCheckToken+"?token="+token, httpEntity, JSONObject.class);
    }
}
