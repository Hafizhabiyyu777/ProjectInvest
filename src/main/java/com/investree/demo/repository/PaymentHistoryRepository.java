package com.investree.demo.repository;

import com.investree.demo.model.PaymentHistory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PaymentHistoryRepository extends PagingAndSortingRepository<PaymentHistory, UUID> {
    @Query("select c from PaymentHistory c")
    public List<PaymentHistory> getList();

    @Query("Select c from PaymentHistory c Where c.id = :id")
    public PaymentHistory getbyID(@Param("id") UUID id);

}
