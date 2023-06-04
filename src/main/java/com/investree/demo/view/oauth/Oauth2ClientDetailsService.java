package com.investree.demo.view.oauth;

import com.investree.demo.repository.oauth.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service
public class Oauth2ClientDetailsService  {
    @Autowired
    private ClientRepository clientRepository;

    @CacheEvict("oauth_client_id")
    public void clearCache(String s) {
        System.out.println("ini cache  oauth_client_id=  "+s);
    }


}
