package com.investree.demo.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.naming.Name;
import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
//@Table(name = "Transaksi")
public class Transaksi implements Serializable {

    @Id
    @GeneratedValue
    @NotNull
    private UUID id;

    @ManyToOne()
    @JoinColumn(name = "id_peminjam")
    private Users peminjam;

    @ManyToOne()
    @JoinColumn(name = "id_meminjam")
    private Users meminjam;

    @Column(name = "tenor")
    private Integer tenor;

    @Column(name = "total_pinjaman")
    private Double total_pinjaman;

    @Column(name = "bunga_persen")
    private Double bunga_persen;

    @Column(name = "status", length = 20)
    private String status;
}
