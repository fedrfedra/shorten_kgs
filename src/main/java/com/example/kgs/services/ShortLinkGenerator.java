package com.example.kgs.services;


import com.example.kgs.model.ShortLink;
import com.example.kgs.repos.ShortLinkRepo;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShortLinkGenerator {


    @Autowired
    ShortLinkRepo repo;

    //todo find end chars somehow
    private char[] endChars;

    @Transactional
    public String generateStrings() {
        char[] pw = new char[4];
        for (pw[0] = endChars[0]; pw[0] <= endChars[0] + 3; pw[0]++)
            for (pw[1] = endChars[1]; pw[1] <= endChars[1] + 3; pw[1]++)
                for (pw[2] = endChars[2]; pw[2] <= endChars[2] + 3; pw[2]++)
                    for (pw[3] = endChars[3]; pw[3] <= endChars[3] + 3; pw[3]++) {
                        endChars = pw;
                        String s = new String(pw);
                        ShortLink shortLink = ShortLink.builder().shortLink(s).used(false).build();
                        repo.save(shortLink);
                    }
        return "generated";

    }
}
