package com.example.kgs.dao;

import com.example.kgs.model.ShortLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShortLinkDAO {

    @Autowired
    MongoTemplate mongoTemplate;

    public String getShortLink(){
        Query query = new Query();
        query.addCriteria(Criteria.where("used").is(false));
        List<ShortLink> shortLinks = mongoTemplate.find(query, ShortLink.class);
        return shortLinks.get(0).getShortLink();
    }

}
