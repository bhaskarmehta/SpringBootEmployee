package com.spring22;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Hello {

    @GetMapping("/hello")
   public String HelloWorld(){
      return "Hello World";
   } 
}
