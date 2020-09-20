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

    //todo find end chars somehow otherwise when restarted problems will occur
    private char[] endChars;

    @Transactional
    public String generateStrings() {
        char[] pw = new char[4];
        for (pw[0] = 'A'; pw[0] <= 'C'; pw[0]++)
            for (pw[1] = 'A'; pw[1] <= 'C'; pw[1]++)
                for (pw[2] = 'A'; pw[2] <= 'C'; pw[2]++)
                    for (pw[3] = 'A'; pw[3] <= 'C'; pw[3]++) {
                        endChars = pw;
                        String s = new String(pw);
                        ShortLink shortLink = ShortLink.builder().shortLink(s).used(false).build();
                        repo.save(shortLink);
                    }
        return "generated";
    }

    @Transactional
    public void addSpecificLink(String shortLinkString){
        ShortLink shortLink = ShortLink.builder().shortLink(shortLinkString).used(true).build();
        repo.save(shortLink);
    }
}
