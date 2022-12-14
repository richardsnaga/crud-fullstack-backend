package com.richard.backend.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "email", nullable = false)
    private String email;

//    @OneToMany(mappedBy = "user")
//    List<Purchase_Item> purchase_items;


    public Long getId() {
        return id;
    }

//    public List<Purchase_Item> getPurchase_items() {
//        return purchase_items;
//    }
//
//    public void setPurchase_items(List<Purchase_Item> purchase_items) {
//        this.purchase_items = purchase_items;
//    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
