package com.example.demo.client;

import com.example.demo.client.entity.Contact;
import com.example.demo.client.entity.ContactList;
import com.example.demo.client.entity.UnisenderResponseEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class UnisendClientImpl implements UnisendClient {

    private enum Methods {

        SET_HOOK("setHook"),
        GET_LISTS("getLists"),
        CREATE_LIST("createList"),
        DELETE_LIST("deleteLis"),
        UPDATE_LIST("updateList");

        String value;

        Methods(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }

    }

    private final static String BASE_URL = "https://api.unisender.com/ru/api/";

    private ObjectMapper mapper = new ObjectMapper();


    @Override
    public List<ContactList> getAllLists(String apiKey) throws IOException {


        String getListurl = BASE_URL.concat(Methods.GET_LISTS.value);

        String url = UriComponentsBuilder.fromUriString(getListurl)
                .queryParam("api_key", apiKey)
                .build()
                .toUriString();

        String entityResponse = getEntityResponse(url);

        UnisenderResponseEntity<List<ContactList>> lists
                = getMapper().readValue(entityResponse, new TypeReference<UnisenderResponseEntity<List<ContactList>>>() {
        });

        if (!StringUtils.isEmpty(lists.getError())) {

        }
        return lists.getResult();
    }


    @Override
    public ContactList createList(String newListName, String apiKey) throws IOException {

        String createListUrl = BASE_URL.concat(Methods.CREATE_LIST.getValue());
        String url = UriComponentsBuilder.fromUriString(createListUrl)
                .queryParam("api_key", apiKey)
                .queryParam("title", newListName)
                .build()
                .toUriString();
        String entityResponse = getEntityResponse(url);

        UnisenderResponseEntity<Object> createdList
                = getMapper().readValue(entityResponse, new TypeReference<UnisenderResponseEntity<Object>>() {
        });

        if (StringUtils.isEmpty(createdList.getError())) {

            JsonNode jsonNode = getMapper().readValue(entityResponse, JsonNode.class);
            if (jsonNode.has("result")) {
                JsonNode result = jsonNode.get("result");
                if (result.has("id")) {
                    JsonNode id = result.get("id");
                    ContactList list = new ContactList();
                    list.setTitle(newListName);
                    Long listId = Long.valueOf(id.toString());
                    return list;
                }
            }
        }
        return null;
    }

    @Override
    public boolean deleteList(Long listId, String apiKey) throws IOException {

        String deleteUrl = BASE_URL.concat(Methods.DELETE_LIST.getValue());

        String url = UriComponentsBuilder.fromUriString(deleteUrl)
                .queryParam("api_key", apiKey)
                .queryParam("list_id", listId)
                .build()
                .toUriString();

        String entityResponse = getEntityResponse(url);

        UnisenderResponseEntity entity
                = getMapper().readValue(entityResponse, new TypeReference<UnisenderResponseEntity>() {
        });

        if (StringUtils.isEmpty(entity.getError())) {
            return true;
        }
        return false;
    }

    @Override
    public ContactList updateList(Long listId, String title, String apiKey) throws IOException {

        String updateUtl = BASE_URL.concat(Methods.UPDATE_LIST.getValue());

        String url = UriComponentsBuilder.fromUriString(updateUtl)
                .queryParam("api_key", apiKey)
                .queryParam("list_id", listId)
                .queryParam("title", title)
                .build()
                .toUriString();

        String entityResponse = getEntityResponse(url);

        UnisenderResponseEntity<ContactList> entity
                = getMapper().readValue(entityResponse, new TypeReference<ContactList>() {
        });

        if (StringUtils.isEmpty(entity.getError())) {
            ContactList contactList = new ContactList();
            contactList.setTitle(title);
            contactList.setId(listId);
            return contactList;
        }
        return null;

    }

    @Override
    public List<Contact> exportContacts(Long listId, Map<String, String> fields, String apiKey) {


        return null;
    }

    @Override
    public boolean excludeContact(List<Long> listIds, Contact contact, String apikey) {
        return false;
    }

    @Override
    public Contact subscribeContact(Contact contact, String apiKey) {
        return null;
    }

    public void setHook(String url, String apiKey){

        String path = BASE_URL.concat(Methods.SET_HOOK.getValue());

        String uriString = UriComponentsBuilder.fromUriString(path)
                .queryParam("events[user_info]", "*")
                .queryParam("api_key", apiKey)
                .queryParam("hook_url", url)
                .queryParam("event_format","json_post")
                .build()
                .toUriString();
        String entityResponse = getEntityResponse(uriString);

        System.out.println(entityResponse);


    }


    private String getEntityResponse(String url){

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        return forEntity.getBody();

    }





    private ObjectMapper getMapper() {
        return mapper;
    }
}
