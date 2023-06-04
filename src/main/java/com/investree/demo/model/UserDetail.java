package com.investree.demo.model;


import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
//@Table (name ="UserDetail")
public class UserDetail implements Serializable {

    @Id
    @GeneratedValue
    @NotNull
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_users", referencedColumnName = "id")
    private Users users;

    @Column(name = "nama", length = 45)
    private String nama;

    @Column(name = "alamat", length = 100)
    private String alamat;


}
