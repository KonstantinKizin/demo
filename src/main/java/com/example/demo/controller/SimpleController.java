package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SimpleController {


    @RequestMapping("/")
    public ResponseEntity<String> registre(){


        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }


    @RequestMapping(value = "/1234",method = RequestMethod.POST)
    public ResponseEntity handle(@RequestBody String params){

        System.out.println(params);

        return new ResponseEntity(HttpStatus.OK);
    }



    @RequestMapping(value = "/1234",method = RequestMethod.GET)
    public ResponseEntity handleGet(@RequestBody String params){

        System.out.println(params);

        return new ResponseEntity(HttpStatus.OK);
    }





}
