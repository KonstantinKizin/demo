package com.example.demo;

import com.example.demo.client.UnisendClient;
import com.example.demo.client.UnisendClientImpl;
import com.example.demo.client.WebHookEventByUser;
import com.example.demo.client.WebhookEventRequest;
import com.example.demo.client.entity.ContactList;
import com.example.demo.client.entity.UnisenderResponseEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
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
import java.util.List;

public class ClientTest {

    private final static String API_KEY = "6pwfb3cq97imew9aaj7jagrs8sg7k1mrkqzwarqo";

    private final static String baseUrl = "https://api.unisender.com/ru/api/getLists";

    private final static String setHookbaseUrl   = "https://api.unisender.com/ru/api/setHook";

    private final static String ngrokUrl = "http://3a8ec74f.ngrok.io";

    private final static String LIST_HOOKS = "https://api.unisender.com/ru/api/listHooks";

    private ObjectMapper mapper = new ObjectMapper();


    private UnisendClientImpl client = new UnisendClientImpl();




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

        String url = "http://1cdaaa0a.ngrok.io/1234";
        client.setHook(url,API_KEY);
    }



    @Test
    public void webHookParseTest() throws IOException {

        String json = "{\"auth\":\"3419eecfd99f6a13764e26882e5d6f47\",\"events_by_user\":[{\"login\":\"d3vtest@yandex.ru\",\"events\":[{\"event_name\":\"user_info\",\"event_time\":\"2018-08-06 21:56:14\",\"event_data\":{\"phone\":\"+375296571934\",\"timezone\":\"America\\/Danmarkshavn\",\"country\":\"PER\"}}]}]}";


        JsonNode jsonNode = mapper.readValue(json, JsonNode.class);

        JsonNode auth = jsonNode.get("auth");

        System.out.println(auth);

        WebhookEventRequest webhookEventRequest = new WebhookEventRequest();

        webhookEventRequest.setAuth(auth.toString());

        JsonNode eventsByUser = jsonNode.get("events_by_user");



        System.out.println(eventsByUser);



    }
}
