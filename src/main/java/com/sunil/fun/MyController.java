package com.sunil.fun;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

  public MyController() {
    System.out.println("I'm started");
  }
//  @ApiOperation(value = "Says Hello", response = Object.class)
  @GetMapping("/hello")
  @ResponseStatus(code = HttpStatus.OK)
  public String sayHello() {
    return "hello world!";
  }
}
