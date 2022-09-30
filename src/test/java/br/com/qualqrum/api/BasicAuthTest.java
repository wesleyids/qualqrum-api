package br.com.qualqrum.api;

import java.util.Base64;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@RunWith(MockitoJUnitRunner.class)
public class BasicAuthTest {

    private String user = "wesley@inacio.com";
    private String password = "123";

    @Ignore
    @Test
    public void test() {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        String encoding = Base64.getEncoder().encodeToString((user + ":" + password).getBytes());
        headers.add(HttpHeaders.AUTHORIZATION, "Basic " + encoding);

        HttpEntity<String> request = new HttpEntity<String>(headers);
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8082/", request,
                String.class);
        System.out.println(response.getBody());
    }
}
