package com.example.kgs.controllers;


import com.example.kgs.services.ShortLinkGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShortLinkController {

    @Autowired
    ShortLinkGetter shortLinkGetter;

    @GetMapping("/get_short_link")
    public String getShortLink(){
        return shortLinkGetter.getShortLink().toString();
    }

}
