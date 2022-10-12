package com.huntercodexs.oauth2applicationclientdemo.service;

import com.huntercodexs.oauth2applicationclientdemo.client.SampleClient;
import com.huntercodexs.oauth2applicationclientdemo.model.OperatorEntity;
import com.huntercodexs.oauth2applicationclientdemo.repository.OperatorRepository;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Service
public class SampleService {

    @Autowired
    SampleClient sampleClient;
    
    @Autowired
    OperatorRepository operatorRepository;

    public ResponseEntity<?> token(HttpServletRequest headers) {
        OperatorEntity operator = operatorRepository.findByAccessCode(headers.getHeader("Authorization"));

        String username = operator.getUsername();
        String password = operator.getPassword();
        String grant_type = operator.getGrantType();
        String urlToken = operator.getUrlGetToken();
        String basic_auth = operator.getAuthorization();
        String credentials = "?username="+username+"&password="+password+"&grant_type="+grant_type;

        JSONObject response = sampleClient.getToken(urlToken, credentials, basic_auth).getBody();

        operator.setToken(Objects.requireNonNull(response).getAsString("access_token"));
        operator.setStatus(0);
        operatorRepository.save(operator);

        return ResponseEntity.ok().body(response);
    }

    public ResponseEntity<?> check(HttpServletRequest headers) {
        OperatorEntity operator = operatorRepository.findByAccessCodeAndToken(headers.getHeader("Authorization"), headers.getHeader("token"));

        if (operator == null) {
            throw new RuntimeException("Authorization not found !");
        }

        String token = operator.getToken();
        String urlCheckToken = operator.getUrlCheckToken();
        String basic_auth = operator.getAuthorization();
        String body = "?token="+token;

        JSONObject response = sampleClient.checkToken(token, urlCheckToken, basic_auth, body).getBody();

        operator.setStatus(1);
        operatorRepository.save(operator);

        if (!Objects.requireNonNull(response).getAsString("active").equals("true")) {
            throw new RuntimeException("Invalid Expired Token !");
        }

        return ResponseEntity.ok().body(response);
    }
}
