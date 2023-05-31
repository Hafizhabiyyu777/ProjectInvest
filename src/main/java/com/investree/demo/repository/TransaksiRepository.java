package com.investree.demo.repository;

import com.investree.demo.model.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransaksiRepository extends JpaRepository<Transaksi, UUID> {
    @Query("select c from Transaksi c")
    public List<Transaksi> getList();
}