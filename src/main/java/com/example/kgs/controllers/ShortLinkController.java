package com.example.kgs.controllers;


import com.example.kgs.services.ShortLinkGenerator;
import com.example.kgs.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class ShortLinkController {

    @Autowired
    ShortLinkGenerator generator;

    @Autowired
    DBService dbService;

    @GetMapping("get_short_link")
    public String getShortLink() {
        return dbService.getShortLink();
    }

    @GetMapping("generate")
    public String generate() {
        return generator.generateStrings();
    }
    @PostMapping("post_short_link")
    public String postShortLink(@RequestBody String shortLink) {
        return dbService.postShortLink(shortLink);
    }

}
