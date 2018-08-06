package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
public class DemoApplicationTests {


	private final static String API_KEY = "6pwfb3cq97imew9aaj7jagrs8sg7k1mrkqzwarqo";

	private final static String baseUrl = "https://api.unisender.com/ru/api/getLists";



	@Test
	public void contextLoads() {



	}


	public static void main(String[] args) {


	}

}
