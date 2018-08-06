package com.example.demo;

import com.example.demo.client.UnisendClient;
import com.example.demo.client.UnisendClientImpl;
import com.example.demo.client.entity.ContactList;
import com.example.demo.client.entity.UnisenderResponseEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;

public class ClientTest {

    private final static String API_KEY = "6pwfb3cq97imew9aaj7jagrs8sg7k1mrkqzwarqo";

    private final static String baseUrl = "https://api.unisender.com/ru/api/getLists";

    private final static String setHookbaseUrl   = "https://api.unisender.com/ru/api/setHook";

    private final static String ngrokUrl = "http://3a8ec74f.ngrok.io";

    private final static String LIST_HOOKS = "https://api.unisender.com/ru/api/listHooks";

    private ObjectMapper mapper = new ObjectMapper();


    private UnisendClient client = new UnisendClientImpl();




    @Test
    public void test(){

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String url = UriComponentsBuilder.fromUriString(baseUrl)
                .queryParam("api_key","SSD")
               /* .queryParam("hook_url",ngrokUrl)
                .queryParam("event_format","json_post")
                .queryParam("events[user_info]","*")*/
                .build()
                .toUriString();

     /*   UnisenderResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);

        System.out.println(forEntity.getBody());*/

    }


    @Test
    public void urlTest(){


        String url = "http://google.com";

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("x","XObject")
                .queryParam("y","YObject");
        UriComponents build = builder.build();

        System.out.println(build);
    }


    @Test
    public void contactListtest() throws IOException {


        ContactList finaly = client.createList("FINALY", API_KEY);

        System.out.println(finaly);
    }
}
