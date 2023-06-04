package com.investree.demo.repository.oauth;

import com.investree.demo.model.oauth.Client;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface ClientRepository extends PagingAndSortingRepository {
    Client findOneByClientId(String clientId);
}
