package com.example.demo.client;

import com.example.demo.client.entity.Contact;
import com.example.demo.client.entity.ContactList;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface UnisendClient {

    List<ContactList> getAllLists(String apiKey) throws IOException;

    ContactList createList(String newListName,String apiKey) throws IOException;

    boolean deleteList(Long id, String apiKey) throws IOException;

    ContactList updateList(Long id, String title, String apiKey) throws IOException;

    List<Contact> exportContacts(Long listId, Map<String,String> fields, String apiKey);

    boolean excludeContact(List<Long> listIds, Contact contact, String apikey);

    Contact subscribeContact(Contact contact , String apiKey);









}
