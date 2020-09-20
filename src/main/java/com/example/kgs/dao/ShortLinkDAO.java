package com.example.kgs.dao;

import com.example.kgs.model.ShortLink;
import com.example.kgs.services.ShortLinkGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Repository
public class ShortLinkDAO {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    ShortLinkGenerator generator;


    @Transactional
    public String getShortLink() {
        Query query = new Query();
        query.addCriteria(Criteria.where("used").is(false));

        Update update = new Update();
        update.set("used", true);

        ShortLink shortLink = mongoTemplate.findAndModify(query, update, ShortLink.class);
        if (shortLink != null) {
            //todo add optional
            return shortLink.getShortLink();
        } else {
            generator.generateStrings();
            return Objects.requireNonNull(mongoTemplate.findAndModify(query, update, ShortLink.class)).getShortLink();
        }

    }

    @Transactional
    public String postShortLink(String shortLink) {
        Query query = new Query();
        query.addCriteria(Criteria.where("shortLink").is(shortLink));

        List<ShortLink> shortLinks = mongoTemplate.find(query, ShortLink.class);
        if (shortLinks.size() == 0) {
            generator.addSpecificLink(shortLink);
            return shortLink;
        } else {
            //todo generator can fail but it still returns shortlink
            return shortLinks.get(0).getUsed() ?
                    getShortLink()
                    :
                    shortLink;
        }
    }

}
