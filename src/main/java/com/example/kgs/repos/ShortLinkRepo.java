package com.example.kgs.repos;

import com.example.kgs.model.ShortLink;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShortLinkRepo extends MongoRepository<ShortLink, Boolean> {


}
