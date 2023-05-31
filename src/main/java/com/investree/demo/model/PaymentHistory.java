package com.investree.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@Table(name = "payment_history")
public class PaymentHistory implements Serializable {

    @Id
    @GeneratedValue
    @NotNull
    private UUID id;

    @Column(name = "pembayaran_ke")
    private Integer pembayaran_ke;

    @Column(name = "jumlah")
    private Double jumlah;

    @Column(name = "bukti_pembayaran", length = 100)
    private String bukti_pembayaran;

    @JsonIgnore
    @OneToMany(mappedBy = "PaymentHistory", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Transaksi> transaksi;

}
