package com.investree.demo.repository;

import com.investree.demo.model.UserDetail;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserDetailRepository extends PagingAndSortingRepository<UserDetail, UUID> {

}
