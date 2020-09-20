package com.example.kgs.services;


import com.example.kgs.dao.ShortLinkDAO;
import com.example.kgs.model.ShortLink;
import com.example.kgs.repos.ShortLinkRepo;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {

    @Autowired
    ShortLinkDAO shortLinkDAO;

    @Autowired
    Faker faker;

    public String getShortLink() {
        return shortLinkDAO.getShortLink();
    }

    public String postShortLink(String shortLink){
        return shortLinkDAO.postShortLink(shortLink);
    }
}
