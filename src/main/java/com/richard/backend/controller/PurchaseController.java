package com.richard.backend.controller;

import com.richard.backend.exception.UserNotFoundException;
import com.richard.backend.model.Purchase;
import com.richard.backend.model.Stock;
import com.richard.backend.repository.PurchaseRepository;
import com.richard.backend.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
public class PurchaseController {
    @Autowired
    private PurchaseRepository purchaseRepository;

    @PostMapping("/purchase_item")
    Purchase newPurchase(@RequestBody Purchase newPurchase){
        return purchaseRepository.save(newPurchase);
    }

    @GetMapping("/purchase_items")
    List<Purchase> getAllPurchase(){
        return purchaseRepository.findAll();
    }

    @GetMapping("/purchase_item/{id}")
    Purchase getPurchaseById(@PathVariable Long id){
        return purchaseRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }

    @PutMapping("/purchase_item/{id}")
    Purchase updatePurchase(@RequestBody Purchase newPurchase, @PathVariable Long id){
        return purchaseRepository.findById(id)
                .map(purchase -> {
                    purchase.setItem_id(newPurchase.getItem_id());
                    purchase.setUser_id(newPurchase.getUser_id());
                    purchase.setDate(newPurchase.getDate());
                    return purchaseRepository.save(purchase);
                }).orElseThrow(()->new UserNotFoundException(id));
    }

    @DeleteMapping("/purchase_item/{id}")
    String deletePurchase(@PathVariable Long id){
        if(!purchaseRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        purchaseRepository.deleteById(id);
        return "Purchase Item with id " + id + " has been deleted.";
    }
}
