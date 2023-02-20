package org.sid.billingservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class Authentication {
    @Value("${keycloak.auth-server-url}")
    private String keycloakAddress;
    @Autowired
    RestTemplate restTemplate;
    public String getAccessToken()
    {
        MultiValueMap<String,String> credentials=new LinkedMultiValueMap<>();
        credentials.add("client_id","ecom-app");
        credentials.add("username","admin");
        credentials.add("password","admin");
        credentials.add("grant_type","password");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(credentials, headers);
        KeycloakResponse response =
                restTemplate.exchange(keycloakAddress+"/realms/my-ecom-realm/protocol/openid-connect/token",
                        HttpMethod.POST,
                        entity,
                        KeycloakResponse.class).getBody();
        return response.getAccess_token();
    }
}