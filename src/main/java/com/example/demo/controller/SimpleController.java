package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SimpleController {


    @RequestMapping("/")
    public ResponseEntity<String> registre(){


        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

}
