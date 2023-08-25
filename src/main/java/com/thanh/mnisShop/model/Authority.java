package com.thanh.mnisShop.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Authorities", uniqueConstraints = { @UniqueConstraint(columnNames = { "Username", "Roleid" }) })
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "Username", referencedColumnName = "Username")
    @JsonIgnoreProperties(value = {"applications","hibernateLazyInitializer"})
    private Account account;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "roleid", referencedColumnName = "Id")
    @JsonIgnoreProperties(value = {"applications","hibernateLazyInitializer"})
    private Role role;
}
