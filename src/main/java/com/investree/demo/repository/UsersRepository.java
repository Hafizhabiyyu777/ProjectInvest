package com.investree.demo.repository;

import com.investree.demo.model.Users;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;


import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Repository
public interface UsersRepository extends CrudRepository<Users, UUID> {
    @Query("select c from Users c")
     public List<Users> getList();

    @Transactional
    @Modifying
    @Query("select c from Users c Where c.id = :id")
    public Users getbyID(@Param("id") UUID id);
//    public Users getbyID(UUID id);
}
