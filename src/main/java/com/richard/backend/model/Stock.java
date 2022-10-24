package com.richard.backend.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "stock")
public class Stock {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "quantity", nullable = false)
    private Long quantity;
    @Column(name = "price", nullable = false)
    private Double price;

//    @OneToMany(mappedBy = "stock")
//    List<Purchase_Item> purchase_items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public List<Purchase_Item> getPurchase_items() {
//        return purchase_items;
//    }
//
//    public void setPurchase_items(List<Purchase_Item> purchase_items) {
//        this.purchase_items = purchase_items;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
