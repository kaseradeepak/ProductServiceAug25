package com.scaler.productserviceaug25.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//RestController - host Rest HTTP APIs.
@RestController // This annotation indicates that this class is a Spring MVC controller
@RequestMapping("/sample") // endpoint - /sample
public class SampleController {
    @GetMapping("/hello/{name}/{times}")
    public String sayHello(@PathVariable("name") String name,
                           @PathVariable("times") int x) {
        String s = "";

        for (int i = 0; i < x; i++) {
            s += "Hello " + name + "! <br>";
        }

        return s;
    }

    @GetMapping("/hi")
    public String sayHi() {
        return "Hi Scaler!";
    }
}

/*
amazon.in/orders => OrderController
/orders => OrderController => @RequestMapping("/orders")

createOrder
updateOrder
deleteOrder
cancelOrder

amazon.in/payments => PaymentController
/payments => PaymentController

amazon.in/products => ProductController
/products => ProductController

amazon.in/users => UserController

amazon.in/search

localhost:8080/sample/hello => sampleController.sayHello();
localhost:8080/sample/hi -> sampleController.sayHi();
 */
