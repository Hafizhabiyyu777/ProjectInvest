package com.investree.demo.model.oauth;

//import org.springframework.security.oauth2.provider.ClientDetails;
import jdk.javadoc.internal.doclets.formats.html.markup.HtmlAttr;
import lombok.Data;
import org.springframework.security.*;
import org.springframework.security.core.GrantedAuthority;

import javax.management.relation.Role;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "oauth_client")
public class Client  {
    @Id
    @GeneratedValue()
    private UUID id;

    private String clientId;

    private String clientSecret;

    private String scopes;

    private String grantTypes;

    private String redirectUris;

    private boolean approved;

    @Column(name = "access_token_expired")
    private Integer accessTokenValiditySeconds;

    @Column(name = "refresh_token_expired")
    private Integer refreshTokenValiditySeconds;

    @ManyToMany(targetEntity = Role.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "oauth_client_role",
            joinColumns = {
                    @JoinColumn(name = "client_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id")
            }
    )
    private Set<GrantedAuthority> authorities = new HashSet<>();


}
