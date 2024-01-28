package com.grv.customanotation;

import com.grv.kafkabinderexample.customanotation.SendNotification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2")
public class RestTestController {

    @SendNotification(eventName = "v2Event")
    @GetMapping("/test")
    public String getTestS(){
        return "donnnnnnn";
    }
}
