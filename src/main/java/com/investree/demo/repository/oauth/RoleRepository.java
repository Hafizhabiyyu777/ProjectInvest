package com.investree.demo.repository.oauth;

import com.investree.demo.model.oauth.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.UUID;

public interface RoleRepository extends PagingAndSortingRepository<Role, UUID> {
    Role findOneByName(String name);

    List<Role> findByNameIn(String[] names);

}
