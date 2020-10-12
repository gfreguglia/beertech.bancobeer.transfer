package br.com.beertechtalents.lupulo.pocmq.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class ContaCorrenteAdapter {

    final RestTemplate restTemplate = new RestTemplate();

    public void call(String body) {

        HttpHeaders header = new HttpHeaders();

        header.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<String> resquestBody = new HttpEntity(body, header);

        restTemplate.postForObject("http://localhost:8080/contacorrente", resquestBody, String.class);
    }
}
