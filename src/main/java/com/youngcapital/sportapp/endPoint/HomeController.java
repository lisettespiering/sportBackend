package com.youngcapital.sportapp.endPoint;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class HomeController
{
    @GetMapping(path="/")
    public String homeInit() {
        return "home";
    }
}