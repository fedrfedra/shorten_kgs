package com.example.kgs.controllers;


import com.example.kgs.services.ShortLinkGenerator;
import com.example.kgs.services.ShortLinkGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/")
public class ShortLinkController {

    @Autowired
    ShortLinkGenerator generator;

    @Autowired
    ShortLinkGetter shortLinkGetter;

    @GetMapping("get_short_link")
    public String getShortLink() {
        return shortLinkGetter.getShortLink();
    }

    @GetMapping("generate")
    public String generate() {
        return generator.generateStrings();
    }

}
