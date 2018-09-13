package com.in28minutes.restfulservices.restapi.controller.hellowold;

import com.in28minutes.restfulservices.restapi.model.helloworld.HelloWorld;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController
{
    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    public String getHelloWorldMessage()
    {
        return "Hello World";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hello-world-bean")
    public HelloWorld getHelloWorld()
    {
        return new HelloWorld("Hello World");
    }

    @GetMapping(path = "/hello-world/{name}")
    public HelloWorld getHelloWorld(@PathVariable String name)
    {
        return new HelloWorld("Hello World" + name);
    }

}
