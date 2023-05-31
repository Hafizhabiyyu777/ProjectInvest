package com.investree.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;


@Data
@Table(name="users")
public class Users implements Serializable {

    @Id
    @GeneratedValue
    @NonNull
    private UUID id;

    @Column(name = "username", length = 50)
    private String username;

    @Column(name = "password",length = 30)
    private String password;

    @Column(name = "is_active")
    private Boolean is_active;

    @OneToOne(mappedBy = "users")
    private UserDetail userDetail;

    @JsonIgnore
    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Transaksi> transaksi;

}
